package types;

public enum TypesFame {
LOCAL, NATIONAL, INTERNATIONAL;
	
	
	public static TypesFame intToRenommee(int i) {
		switch(i) {
		case 1:return LOCAL;
		case 2:return NATIONAL;
		case 3:return INTERNATIONAL;
		}
		return null;

	}

}

