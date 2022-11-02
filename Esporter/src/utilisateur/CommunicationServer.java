package utilisateur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Iterator;

import socket.Command;
import socket.CommandName;
import socket.Response;
import socket.ResponseObject;
import types.EcurieInfo;
import types.InfoID;
import types.Infos;
import types.JoueurInfo;
import types.Permission;

public class CommunicationServer{
	
	private User user;
	private Socket s;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	public CommunicationServer(User user) {
		this.user = user;
		try {
			System.out.println("Tentative de connexion");
		s = new Socket("127.0.0.1",80);
		out = new ObjectOutputStream(s.getOutputStream());
		in = new ObjectInputStream(s.getInputStream());
			System.out.println("Done");
		
		}catch (UnknownHostException e) {

		}catch (Exception e) {}
	}
	
	
	public void login(String username, String mdp) {
		Command c = new Command(CommandName.LOGIN, mdp, username);
		try {
			System.out.println("Send login");
			out.writeObject(c);
			System.out.println("Done");
			System.out.println("Receive object");
			ResponseObject r = (ResponseObject) in.readObject();
			System.out.println("Done");
			switch(r.getName()) {
				case ERROR_LOGIN://ERRORLOGIN
					break;
				case REPONSE:
					Permission perm = Permission.VISITEUR;
					if (r.getInfo().containsKey(InfoID.Permission)) {
						perm = (Permission) r.getInfoByID(InfoID.Permission);
					}
					if (r.getInfo().containsKey(InfoID.Ecurie)) {
						setInfo(perm, r.getInfoByID(InfoID.Ecurie));
					}
					if (r.getInfo().containsKey(InfoID.Joueur)) {
						setInfo(perm, r.getInfoByID(InfoID.Joueur));
					}
					break;
				default:
			}
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void send (Command c) {
		try {
			out.writeObject(c);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public void setInfo(Permission perms, Infos information) {
		user.setPermission(perms);
		switch(perms) {
		case VISITEUR: 
			user.setInfo(null);
			break;
		case JOUEUR: 
			user.setInfo((JoueurInfo)information);
			break;
		case ARBITRE:
			user.setInfo(null);
		case ECURIE: 
			user.setInfo((EcurieInfo)information);
		case ORGANISATEUR: 
			user.setInfo(null);
		default:
			user.setInfo(null);
		}
	}
}
