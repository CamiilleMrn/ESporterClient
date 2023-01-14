package types;



import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class TypesPlayer implements Types, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5395040179600585232L;
	private int id;
	private String name;
	private String firstName;
	private TypesImage image;
	private Timestamp birthDate;
	private Timestamp contractStartDate;
	private Timestamp contractEndDate;
	private int nationality;
	private int idTeam;
	private int idStable;
	private String username;
	
	

	public TypesPlayer(int id, String name, String firstName, TypesImage image, Timestamp birthDate, Timestamp contractStartDate,
			Timestamp contractEndDate, int nationality, int idTeam, int idStable, String username) {
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.image = image;
		this.birthDate = birthDate;
		this.contractStartDate = contractStartDate;
		this.contractEndDate = contractEndDate;
		this.nationality = nationality;
		this.idTeam = idTeam;
		this.idStable = idStable;
		this.username = username;
		

	}
	
	public int getIdTeam() {
		return idTeam;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public int getIdStable() {
		return idStable;
	}


	public int getId() {
		return id;
	}



	public String getName() {
		return name;
	}



	public String getFirstName() {
		return firstName;
	}


	public TypesImage getImage() {
		return image;
	}

	
	public Timestamp getBirthDate() {
		return birthDate;
	}



	public Timestamp getContractEndDate() {
		return contractEndDate;
	}
	public Timestamp getContractStartDate() {
		return contractStartDate;
	}



	public int getNationality() {
		return nationality;
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
		TypesPlayer other = (TypesPlayer) obj;
		return id == other.id;
	}

	
}
