package types;


import java.awt.Image;

public class JoueurInfo {
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
