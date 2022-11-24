package types;

import java.io.Serializable;

public class registerJoueur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5974897413172620415L;
	private JoueurInfo joueur;
	private Login login;
	
	public JoueurInfo getJoueur() {
		return joueur;
	}
	public Login getLogin() {
		return login;
	}
	
	public registerJoueur(JoueurInfo joueur, Login login) {
		this.joueur = joueur;
		this.login = login;
	}
	
	
}
