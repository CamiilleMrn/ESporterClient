package types;

public enum TypesFame {
	
	LOCAL("Local"), NATIONAL("National"), INTERNATIONAL("International");
	
	private String name;
	
	TypesFame(String name) {
		this.name = name;
	}
	
	public static TypesFame intToRenommee(int i) {
		switch(i) {
		case 1:return LOCAL;
		case 2:return NATIONAL;
		case 3:return INTERNATIONAL;
		}
		return null;

	}
	
	public String getNom() {
		return this.name;
	}

	@Override
	public String toString() {
		return this.getNom();
	}

}

