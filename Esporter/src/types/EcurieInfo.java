package types;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;

public class EcurieInfo implements Infos, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3925659840033195163L;
	private String nom;
	private Image logo;
	private String diminutif;
	private String nationalite;
	private ArrayList<EquipeInfo> equipes;
	private ArrayList<Titre> palmares;
	private int id;
	
	public EcurieInfo(String nom, Image logo, String diminutif, String nationalite, int id) {
		this.nom = nom;
		this.logo = logo;
		this.diminutif = diminutif;
		this.nationalite = nationalite;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public Image getLogo() {
		return logo;
	}

	public String getDiminutif() {
		return diminutif;
	}

	public String getNationalite() {
		return nationalite;
	}

	public ArrayList<EquipeInfo> getEquipes() {
		return equipes;
	}

	public ArrayList<Titre> getPalmares() {
		return palmares;
	}

	@Override
	public String toString() {
		return "Ecurie [nom=" + nom + ", diminutif=" + diminutif + ", nationalite=" + nationalite + ", id=" + id
				+ "]";
	}
	
	
	
	
	
	

}
