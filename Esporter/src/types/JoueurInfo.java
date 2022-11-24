package types;



import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Objects;

import javax.imageio.ImageIO;

public class JoueurInfo implements Infos, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5395040179600585232L;
	private int id;
	private String nom;
	private String prenom;
	private Image image;
	private Date dateNaissance;
	private Date dateDebutContrat;
	private Date dateFinContrat;
	private int nationalite;
	private int id_equipe;
	private int id_ecurie;
	
	

	public JoueurInfo(int id, String nom, String prenom, Image image, Date dateNaissance, Date dateDebutContrat,
			Date dateFinContrat, int nationalite, int id_equipe, int id_ecurie) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.image = image;
		this.dateNaissance = dateNaissance;
		this.dateDebutContrat = dateDebutContrat;
		this.dateFinContrat = dateFinContrat;
		this.nationalite = nationalite;
		this.id_equipe = id_equipe;
		this.id_ecurie = id_ecurie;
		

	}
	
	public int getId_equipe() {
		return id_equipe;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId_ecurie() {
		return id_ecurie;
	}
	



	public int getId() {
		return id;
	}



	public String getNom() {
		return nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public Image getPhoto() {
		return image;
	}
	



	public Date getDateNaissance() {
		return dateNaissance;
	}



	public Date getDateDebutContrat() {
		return dateDebutContrat;
	}



	public Date getDateFinContrat() {
		return dateFinContrat;
	}



	public int getNationalite() {
		return nationalite;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JoueurInfo other = (JoueurInfo) obj;
		return id == other.id;
	}

	
}
