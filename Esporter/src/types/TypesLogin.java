package types;

import java.io.Serializable;

public class TypesLogin implements Types, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9145321140869048776L;
	private String password;
	private String username;
	
	public TypesLogin(String user, String pass) {
		this.password = pass;
		this.username = user;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}

}
