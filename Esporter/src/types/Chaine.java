package types;

import java.io.Serializable;

public class Chaine implements Infos, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1833799595313493767L;
	private String chaine;
	
	public Chaine(String chaine) {
		this.chaine = chaine;
	}
	
	public String getEntier() {
		return chaine;
	}
}
