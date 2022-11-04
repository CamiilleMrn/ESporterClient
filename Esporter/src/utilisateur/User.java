package utilisateur;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;

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
