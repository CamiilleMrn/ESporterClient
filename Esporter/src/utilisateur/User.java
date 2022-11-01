package utilisateur;

import java.sql.Connection;

import types.Permission;

public abstract class User {
	
	private Permission permission;
	private Connection connexion;
	//Maybe a changer ? Multi access database impossible.
	
	//Methode commune a tout les utilisateurs
	public User(Permission permission) {
		this.permission = permission;
	}
	
	public Permission getPermission() {
		return permission;
	}
	
	public Connection getConnexion() {
		return connexion;
	}
	
	public void setConnexion(Connection connexion) {
		this.connexion = connexion;
	}
	
	public abstract int makeConnection();
	public void removeConnection() {
		this.connexion = null;
	}
	
	public int voirInfosEcurie() {
		return -1;
	}

}
