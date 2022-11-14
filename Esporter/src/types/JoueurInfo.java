package types;



import java.awt.image.BufferedImage;
import java.io.IOException;
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
	private Blob photoBlob;
	private Date dateNaissance;
	private Date dateDebutContrat;
	private Date dateFinContrat;
	private int nationalite;
	private int id_equipe;
	private BufferedImage photo;
	
	

	public JoueurInfo(int id, String nom, String prenom, Blob photoBlob, Date dateNaissance, Date dateDebutContrat,
			Date dateFinContrat, int nationalite, int id_equipe) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.photoBlob = photoBlob;
		this.dateNaissance = dateNaissance;
		this.dateDebutContrat = dateDebutContrat;
		this.dateFinContrat = dateFinContrat;
		this.nationalite = nationalite;
		this.id_equipe = id_equipe;
		
		//this.photo = ImageIO.read(photoBlob.getBinaryStream());
		this.photo=null;
	}
	
	public int getId_equipe() {
		return id_equipe;
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



	public Blob getPhoto() {
		return photoBlob;
	}
	
	public BufferedImage getPhotoTraite() {
		return photo;
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
