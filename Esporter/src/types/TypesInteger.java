package types;

import java.io.Serializable;

public class TypesInteger implements Types, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 311825430751900140L;
	private int integer;
	
	public TypesInteger(int integer) {
		this.integer = integer;
	}
	
	public int getInteger() {
		return integer;
	}
}
