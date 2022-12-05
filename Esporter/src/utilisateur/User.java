package utilisateur;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;

import data.Data;
import ihm.MasterFrame;
import ihm.TypeMenu;
import socket.Response;
import types.EquipeInfo;
import types.Infos;
import types.JoueurInfo;
import types.Permission;
import types.RegisterEquipe;
import types.TournoiInfo;
import types.WaitingFor;
import types.exception.ErrorLogin;
import types.exception.InvalidPermission;

public class User {
	
	private volatile Permission permission;
	private CommunicationServer com;
	private Thread t;
	private Infos info;
	private WaitingFor waiting;
	private static volatile Data data;

	public User() throws UnknownHostException, IOException {
		this.permission = Permission.VISITEUR;
		this.com = new CommunicationServer(this);
		this.waiting = new WaitingFor();
		this.t = new Thread(com);
		t.setDaemon(true);
		t.start();
		com.initializeApp();
		waiting.waitFor(Response.UPDATE_ALL);
		
	}
	
	public Data getData() {
		return data;
	}
	
	public void setData(Data data) {
		User.data = data;
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
	
	public void login(String username, String mdp) throws ErrorLogin {
		com.sendLogin(username, mdp);
		Response[] r = {Response.LOGIN, Response.ERROR_LOGIN};
		waiting.waitFor(r);
		switch (waiting.getActualState()) {
		case ERROR_LOGIN:
			throw new ErrorLogin("Erreur de login");
		case LOGIN:
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
			break;
		default:
			break;
		}
	}
	
	public void logout() {
		setInfo(null);
		setPermission(Permission.VISITEUR);
		com.logout();
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
	
	public void desinscriptionTournoi(int idTournoi, int idJeu) throws InvalidPermission{
		if (permission != Permission.JOUEUR) {
			throw new InvalidPermission("Vous n'avez pas la permission de faire cette action");
		}
		com.desincriptionTournoi(idTournoi, idJeu);
	}
	
	public void ajouterEquipe(RegisterEquipe equipe){
		if (permission!=Permission.ECURIE) {
			MasterFrame.getInstance().error(new InvalidPermission("Vous n'avez pas la permission de faire cette action"));
		} else {
			com.ajouterEquipe(equipe);
		}
	}
	
	public void supprimerTournoi(TournoiInfo tournoi) {
		
	}
	
	public void ajouterTournoi(TournoiInfo t) throws InvalidPermission {
		if (permission!=Permission.ORGANISATEUR) {
			throw new InvalidPermission("Vous n'avez pas la permission de faire cette action");
		}
		com.ajouterTournoi(t);
	}

}
