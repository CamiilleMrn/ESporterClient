package utilisateur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.SwingUtilities;

import data.Data;
import ihm.MasterFrame;
import socket.Command;
import socket.CommandName;
import socket.Response;
import socket.ResponseObject;
import types.EcurieInfo;
import types.Entier;
import types.EquipeInfo;
import types.InfoID;
import types.Infos;
import types.JoueurInfo;
import types.Login;
import types.Permission;
import types.RegisterEquipe;
import types.TournoiInfo;
import types.exception.InvalidPermission;

public class CommunicationServer implements Runnable{
	
	private User user;
	private Socket s;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private int reconnection = 1;
	private int reconnectionTime = 1;
	private boolean run=true;
	
	public CommunicationServer(User user) throws UnknownHostException, IOException {
		this.user = user;
		connect();
	}
	
	private void connect() throws UnknownHostException, IOException{

		System.out.println("Tentative de connexion");
		
		try {
			s = new Socket("127.0.0.1",80);
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(s.getInputStream());
		} catch (IOException e) {
			reconnect();
		}
		
		System.out.println("Done");
	}
	
	private void reconnect() throws IOException,UnknownHostException {
		reconnection++;
		if (reconnection>5) {
			run=false;
			throw new IOException("Impossible de joindre le serveur");
		}
		reconnectionTime*=2;
		String s = "Reconnecting N�"+reconnection+" in "+reconnectionTime+"s....";
		System.out.println(s);
		try {
			Thread.sleep(reconnectionTime*1000);
		} catch (InterruptedException e) {
		}
		try {
			connect();
			reconnection=1;
			reconnectionTime=1;
		} catch (IOException e2) {
			reconnect();
			
		}
	}
	
	@Override
	public void run() {
		while (run) {
			try {
				traiterReponse((ResponseObject)in.readObject());
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				try {
					reconnect();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	
	public void sendLogin(String username, String mdp) {
		HashMap<InfoID, Infos> m = new HashMap<>();
		m.put(InfoID.login, new Login(username, mdp));
		Command c = new Command(CommandName.LOGIN, m);
		send(c);
	}
	
	public void inscriptionTournoi(int idTournoi) {
		HashMap<InfoID, Infos> m = new HashMap<>();
		m.put(InfoID.Tournoi, new Entier(idTournoi));
		m.put(InfoID.Joueur, new Entier(((JoueurInfo)user.getInfo()).getId()));
		Command c = new Command(CommandName.INSCRIPTION_TOURNOI, m);
		send(c);
	}
	
	public void ajouterEquipe(RegisterEquipe equipe) {
		HashMap<InfoID, Infos> m = new HashMap<>();
		m.put(InfoID.Equipe, equipe);
		Command c = new Command(CommandName.AJOUTER_EQUIPE, m);
		send(c);
	}
	
	public void ajouterTournoi(TournoiInfo t) {
		HashMap<InfoID, Infos> m = new HashMap<>();
		m.put(InfoID.Tournoi, t);
		Command c = new Command(CommandName.AJOUTER_TOURNOI, m);
		send(c);
	}
	
	public void logout() {
		Command c = new Command(CommandName.LOGOUT, null);
		send(c);
	}
	
	public void receiveLogin(ResponseObject r) {
		Permission perm = Permission.VISITEUR;
		if (r.getInfo().containsKey(InfoID.Permission)) {
			perm = (Permission) r.getInfoByID(InfoID.Permission);
		}
		setPermission(perm);
		if (r.getInfo().containsKey(InfoID.Ecurie)) {
			user.setInfo(r.getInfoByID(InfoID.Ecurie));

		}
		if (r.getInfo().containsKey(InfoID.Joueur)) {
			user.setInfo(r.getInfoByID(InfoID.Joueur));
		}
	}
	
	public void send (Command c) {
		try {
			out.writeObject(c);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public void initializeApp() {
		Command c = new Command(CommandName.INIT, null);
		send(c);
	}
	
	
	public void setPermission(Permission perms) {
		user.setPermission(perms);
	}
	
	public void traiterReponse(ResponseObject r) {
		System.out.println(r.getName());
		switch(r.getName()) {
		case ERROR_LOGIN:
			user.getWaiting().setActualState(Response.ERROR_LOGIN);
			break;
		case ERROR_PERMISSION:
			MasterFrame.getInstance().getError().setState(new InvalidPermission(), false);
			System.out.println("ERREUR PERMISSION");
			user.getWaiting().setActualState(Response.ERROR_PERMISSION);
			break;
		case LOGIN:
			receiveLogin(r);
			user.getWaiting().setActualState(r.getName());
			break;
		case UPDATE_CALENDRIER:
			break;
		case UPDATE_ECURIE:
			break;
		case UPDATE_EQUIPE:
			EquipeInfo equipe = (EquipeInfo)r.getInfoByID(InfoID.Equipe);
			user.getData().getEcuries().get(equipe.getEcurie().getId()).getEquipes().put(equipe.getId(), equipe);
			MasterFrame.getInstance().dataUpdate();
		case UPDATE_TOURNOI:
			TournoiInfo tournoi = (TournoiInfo)r.getInfoByID(InfoID.Tournoi);
			user.getData().getCalendrier().put(tournoi.getId(), tournoi);
			MasterFrame.getInstance().dataUpdate();
			System.out.println("Data update...");
			break;
		case UPDATE_ALL:
			user.setData((Data)r.getInfo().get(InfoID.all));
			user.getWaiting().setActualState(Response.UPDATE_ALL);
			
			break;
		case Error:
			MasterFrame.getInstance().getError().setState(new Exception("Vous etes deja inscrit"), false);
			System.out.println("ERREUR");
			break;
			
		default:
			break;
		
		
		}
		user.getWaiting().setActualState(r.getName());
	}


	
}
