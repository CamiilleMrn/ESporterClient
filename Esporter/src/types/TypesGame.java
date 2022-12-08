package types;

import java.io.Serializable;

public enum TypesGame implements Types, Serializable {

	LEAGUE_OF_LEGENDS("League Of Legends", null, 5), COUNTER_STRIKE("Counter Strike", null, 5), ROCKET_LEAGUE("Rocket League", null, 3);
	
	
	private String name;
	private TypesImage logo;
	private int maxPlayer;
	
	private TypesGame(String name, TypesImage logo, int maxPlayer) {
		this.name = name;
		this.logo = logo;
		this.maxPlayer = maxPlayer;
	}

	public String getName() {
		return name;
	}

	public TypesImage getLogo() {
		return logo;
	}

	public int getMaxPlayer() {
		return maxPlayer;
	}
	
	public static TypesGame intToGame(int i) throws IllegalArgumentException{
		if (i>TypesGame.values().length) {
			throw new IllegalArgumentException();
		}
		return TypesGame.values()[i-1];
	}
	
	public static int gameToInt(TypesGame j) throws IllegalArgumentException{
		return j.ordinal()+1;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
	
	

}
