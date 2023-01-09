package types;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class TypesTitle implements Types, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6312894568148141572L;
	private String name;
	private Timestamp date;
	public TypesTitle(String name, Timestamp date) {
		this.name = name;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public Timestamp getObtentionDate() {
		return date;
	}
	
	
}
