package types;


import java.awt.Image;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class JoueurInfo implements Infos, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5395040179600585232L;
	private int id;
	private String nom;
	private String prenom;
	private Image photo;
	private Date dateNaissance;
	private Date dateDebutContrat;
	private Date dateFinContrat;
	private String nationalite;
	
	

	public JoueurInfo(int id, String nom, String prenom, Image photo, Date dateNaissance, Date dateDebutContrat,
			Date dateFinContrat, String nationalite) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.photo = photo;
		this.dateNaissance = dateNaissance;
		this.dateDebutContrat = dateDebutContrat;
		this.dateFinContrat = dateFinContrat;
		this.nationalite = nationalite;
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



	public String getNationalite() {
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
