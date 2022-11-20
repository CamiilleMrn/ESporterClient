package types;

import java.awt.Image;
import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashMap;

public class EcurieInfo implements Infos, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3925659840033195163L;
	private String nom;
	private Blob logo;
	private String diminutif;
	private HashMap<Integer,EquipeInfo> equipes;
	private ArrayList<Titre> palmares;
	private int id;
	
	public EcurieInfo(String nom, Blob logo, String diminutif, int id) {
		this.nom = nom;
		this.logo = logo;
		this.diminutif = diminutif;
		this.id = id;
		this.equipes = new HashMap<>();
		this.palmares = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public Blob getLogo() {
		return logo;
	}

	public String getDiminutif() {
		return diminutif;
	}


	public HashMap<Integer, EquipeInfo> getEquipes() {
		return equipes;
	}
	
	public ArrayList<Titre> getPalmares() {
		return palmares;
	}
	
	public void ajouterEquipe(EquipeInfo e) {
		this.equipes.put(e.getId(), e);
	}
	
	public void ajouterJoueur(JoueurInfo j) throws IllegalArgumentException {
		if (this.equipes.get(j.getId_equipe())==null) {
			throw new IllegalArgumentException();
		}
		this.equipes.get(j.getId_equipe()).ajouterJoueur(j);
	}
	
	
	

}
