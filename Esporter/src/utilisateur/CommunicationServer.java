package utilisateur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;

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
import types.TournoiInfo;

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
		String s = "Reconnecting N°"+reconnection+" in "+reconnectionTime+"s....";
		System.out.println(s);
		try {
			Thread.sleep(reconnectionTime*1000);
		} catch (InterruptedException e) {
		}
		try {
			connect();
		} catch (IOException e2) {
			reconnect();
			
		}
	}
	
	@Override
	public void run() {
		while (run) {
			try {
				traiterReponse((ResponseObject)in.readObject());
			} catch (ClassNotFoundException e) {
			} catch (IOException e) {
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
		System.out.println("Send login");
		send(c);
		System.out.println("Done");
	}
	
	public void inscriptionTournoi(int idTournoi) {
		HashMap<InfoID, Infos> m = new HashMap<>();
		m.put(InfoID.Tournoi, new Entier(idTournoi));
		m.put(InfoID.Joueur, new Entier(((JoueurInfo)user.getInfo()).getId()));
		Command c = new Command(CommandName.INSCRIPTION_TOURNOI, m);
		send(c);
	}
	
	public void ajouterEquipe(EquipeInfo e) {
		HashMap<InfoID, Infos> m = new HashMap<>();
		m.put(InfoID.Ecurie, new Entier(((EcurieInfo)user.getInfo()).getId()));
		m.put(InfoID.Equipe, e);
		Command c = new Command(CommandName.AJOUTER_EQUIPE, m);
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
		System.out.println(user.getInfo());
	}
	
	public void send (Command c) {
		try {
			out.writeObject(c);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	
	public void setPermission(Permission perms) {
		user.setPermission(perms);
	}
	
	public void traiterReponse(ResponseObject r) {
		switch(r.getName()) {
		case ERROR_LOGIN:
			user.getWaiting().setActualState(Response.ERROR_LOGIN);
			break;
		case ERROR_PERMISSION:
			break;
		case LOGIN:
			System.out.println("Receive login auth\n"+r);
			receiveLogin(r);
			System.out.println("Done");
			user.getWaiting().setActualState(r.getName());
			break;
		case UPDATE_CALENDRIER:
			break;
		case UPDATE_ECURIE:
			break;
		case UPDATE_TOURNOI:
			break;
		default:
			break;

		
		}
	}


	
}
