package types;

import java.io.Serializable;
import java.sql.Date;

public class Titre implements Infos, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6312894568148141572L;
	private String nom;
	private Date obtention;
	public Titre(String nom, Date obtention) {
		this.nom = nom;
		this.obtention = obtention;
	}
	public String getNom() {
		return nom;
	}
	public Date getObtention() {
		return obtention;
	}
	
	
}
