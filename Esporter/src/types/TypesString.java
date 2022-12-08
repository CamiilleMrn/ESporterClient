package types;

import java.io.Serializable;

public class TypesString implements Types, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1833799595313493767L;
	private String string;
	
	public TypesString(String string) {
		this.string = string;
	}
	
	public String getEntier() {
		return string;
	}
}
