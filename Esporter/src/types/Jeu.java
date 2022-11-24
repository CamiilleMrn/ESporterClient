package types;

import java.io.Serializable;

public enum Jeu implements Infos, Serializable {

	LEAGUE_OF_LEGEND("League of legend", null, 5), COUNTER_STRIKE("Counter strike", null, 5), ROCKET_LEAGUE("Rocket League", null, 3);
	
	
	private String nom;
	private Image logo;
	private int joueurMax;
	
	private Jeu(String nom, Image logo, int joueurMax) {
		this.nom = nom;
		this.logo = logo;
		this.joueurMax = joueurMax;
	}

	public String getNom() {
		return nom;
	}

	public Image getLogo() {
		return logo;
	}

	public int getJoueurMax() {
		return joueurMax;
	}
	
	public static Jeu intToJeu(int i) throws IllegalArgumentException{
		if (i>Jeu.values().length) {
			throw new IllegalArgumentException();
		}
		return Jeu.values()[i-1];
	}
	
	

}
