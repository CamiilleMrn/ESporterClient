package types;

import java.awt.Image;
import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;

public class EcurieInfo implements Infos, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3925659840033195163L;
	private String nom;
	private Blob logo;
	private String diminutif;
	private ArrayList<EquipeInfo> equipes;
	private ArrayList<Titre> palmares;
	private int id;
	
	public EcurieInfo(String nom, Blob logo, String diminutif, int id) {
		this.nom = nom;
		this.logo = logo;
		this.diminutif = diminutif;
		this.id = id;
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


	public ArrayList<EquipeInfo> getEquipes() {
		return equipes;
	}

	public ArrayList<Titre> getPalmares() {
		return palmares;
	}
	
	
	
	

}
