package types;



import java.io.Serializable;
import java.sql.Date;
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
	private Date birthDate;
	private Date contractStartDate;
	private Date contractEndDate;
	private int nationality;
	private int idTeam;
	private int idStable;
	
	

	public TypesPlayer(int id, String name, String firstName, TypesImage image, Date birthDate, Date contractStartDate,
			Date contractEndDate, int nationality, int idTeam, int idStable) {
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
		

	}
	
	public int getIdTeam() {
		return idTeam;
	}
	
	public void setId(int id) {
		this.id = id;
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

	
	public Date getBirthDate() {
		return birthDate;
	}



	public Date getContractEndDate() {
		return contractEndDate;
	}
	public Date getContractStartDate() {
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
