package types;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ihm.MasterFrame;
import types.exception.InvalidPermission;
import types.exception.TournoiPlein;

public class TournoiInfo implements Infos, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2465967083363947302L;
	private Date dateInscription;
	private String nom;
	private Renomme renomme;
	private List<Jeu> jeux;
	private int id;
	private ArrayList<Poule> poule;
	private ArrayList<EquipeInfo> inscris;
	
	public TournoiInfo(Date dateInscription, String nom, Renomme renomme, ArrayList<Jeu> jeux, int id) {
		this.dateInscription = dateInscription;
		this.nom = nom;
		this.renomme = renomme;
		this.jeux = jeux;
		this.id = id;
	}


	public Date getDateInscription() {
		return dateInscription;
	}

	public String getNom() {
		return nom;
	}

	public Renomme getRenomme() {
		return renomme;
	}

	public List<Jeu> getJeux() {
		return jeux;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateInscription, id, jeux, nom, renomme);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TournoiInfo other = (TournoiInfo) obj;
		return id == other.id;
	}
	
	public ArrayList<EquipeInfo> getInscris() {
		return inscris;
	}
	
	public ArrayList<Poule> getPoule() {
		return poule;
	}
	
	
	
	
	
	
	

}
