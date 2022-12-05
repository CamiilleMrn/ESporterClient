package types;

public enum Renomme {
	LOCAL("Local"), NATIONAL("National"), INTERNATIONAL("International");
	
	private String nom;
	
	private Renomme(String nom) {
		this.nom = nom;
	}

	public static Renomme intToRenommee(int i) {
		switch(i) {
		case 1:return LOCAL;
		case 2:return NATIONAL;
		case 3:return INTERNATIONAL;
		}
		return null;

	}
	
	public String getNom() {
		return this.nom;
	}

	@Override
	public String toString() {
		return this.getNom();
	}

}

