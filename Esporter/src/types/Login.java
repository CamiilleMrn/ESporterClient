package types;

import java.io.Serializable;

public class Login implements Infos, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9145321140869048776L;
	private String mdp;
	private String username;
	
	public Login(String user, String pass) {
		this.mdp = pass;
		this.username = user;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return mdp;
	}

}
