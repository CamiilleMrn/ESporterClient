package types;


import java.awt.Image;
import java.io.Serializable;

public class JoueurInfo implements Infos, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5395040179600585232L;
	private int id;
	private String nom;
	private String prenom;
	private Image photo;
	
	public JoueurInfo(int id, String nom, String prenom, Image photo) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.photo = photo;
	}

	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public Image getPhoto() {
		return photo;
	}
	
	public int getId() {
		return id;
	}
}
