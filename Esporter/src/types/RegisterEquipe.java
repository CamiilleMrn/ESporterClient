package types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class RegisterEquipe implements Infos, Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6327249599056710232L;
	private Jeu jeu;
	private int idEcurie;
	private ArrayList<registerJoueur> joueurs;
	
	
	public RegisterEquipe(Jeu jeu, int idEcurie, ArrayList<registerJoueur> joueurs) {
		this.jeu = jeu;
		this.idEcurie = idEcurie;
		this.joueurs = joueurs;
	}


	public Jeu getJeu() {
		return jeu;
	}


	public int getIdEcurie() {
		return idEcurie;
	}


	public ArrayList<registerJoueur> getJoueurs() {
		return joueurs;
	}
	
}
