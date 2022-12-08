package types;

import java.io.Serializable;
import java.sql.Date;

public class TypesTitle implements Types, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6312894568148141572L;
	private String name;
	private Date date;
	public TypesTitle(String name, Date date) {
		this.name = name;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public Date getObtentionDate() {
		return date;
	}
	
	
}
