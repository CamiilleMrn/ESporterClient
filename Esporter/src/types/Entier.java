package types;

import java.io.Serializable;

public class Entier implements Infos, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 311825430751900140L;
	private int entier;
	
	public Entier(int entier) {
		this.entier = entier;
	}
	
	public int getEntier() {
		return entier;
	}
}
