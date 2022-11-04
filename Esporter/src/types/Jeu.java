package types;

import java.awt.Image;
import java.io.Serializable;

public enum Jeu implements Infos, Serializable {

	COUNTER_STRIKE("Counter strike", null, 5), ROCKET_LEAGUE("Rocket League", null, 3), LEAGUE_OF_LEGEND("League of legend", null, 5);
	
	
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
	
	
	
	

}
