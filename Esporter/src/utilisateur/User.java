package utilisateur;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;

import types.Infos;
import types.Permission;

public class User {
	
	private Permission permission;
	private CommunicationServer com;
	private Infos info;

	public User() {
		this.permission = Permission.VISITEUR;
		this.com = new CommunicationServer(this);
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
		com.login(username, mdp);
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

}
