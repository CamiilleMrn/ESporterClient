package utilisateur;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;

import ihm.MasterFrame;
import ihm.TypeMenu;
import socket.Response;
import types.EquipeInfo;
import types.Infos;
import types.Permission;
import types.WaitingFor;
import types.exception.InvalidPermission;

public class User {
	
	private volatile Permission permission;
	private CommunicationServer com;
	private Thread t;
	private Infos info;
	private WaitingFor waiting;

	public User() throws UnknownHostException, IOException {
		this.permission = Permission.VISITEUR;
		this.com = new CommunicationServer(this);
		this.waiting = new WaitingFor();
		this.t = new Thread(com);
		t.start();
		
	}
	
	public CommunicationServer getCom() {
		return com;
	}
	
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	
	public Permission getPermission() {
		return permission;
	}
	
	public void login(String username, String mdp) {
		com.sendLogin(username, mdp);
		waiting.waitFor(Response.LOGIN);
		switch(permission) {
		case ARBITRE:
			MasterFrame.getInstance().setMenu(TypeMenu.Arbitres);
			break;
		case ECURIE:
			MasterFrame.getInstance().setMenu(TypeMenu.Ecuries);
			break;
		case JOUEUR:
			MasterFrame.getInstance().setMenu(TypeMenu.Joueurs);
			break;
		case ORGANISATEUR:
			MasterFrame.getInstance().setMenu(TypeMenu.Organisateurs);
			break;
		case VISITEUR:
			MasterFrame.getInstance().setMenu(TypeMenu.Visiteurs);
			break;
		default:
			break;
		
		}
		
		
	}
	
	public WaitingFor getWaiting() {
		return waiting;
	}
	
	public Infos getInfo() {
		return info;
	}
	
	public void setInfo(Infos info) {
		this.info = info;
	}
	
	
	public int voirInfosEcurie() {
		return -1;
	}
	
	public void inscriptionTournoi(int id) throws InvalidPermission{
		if (permission!=Permission.JOUEUR) {
			throw new InvalidPermission("Vous n'avez pas la permission de faire cette action");
		}
		com.inscriptionTournoi(id);
	}
	
	public void ajouterEquipe(EquipeInfo e) throws InvalidPermission{
		if (permission!=Permission.JOUEUR) {
			throw new InvalidPermission("Vous n'avez pas la permission de faire cette action");
		}
		com.ajouterEquipe(e);
	}

}
