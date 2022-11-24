package types;

public class registerJoueur {

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
