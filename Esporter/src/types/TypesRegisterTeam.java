package types;

import java.io.Serializable;
import java.util.ArrayList;

public class TypesRegisterTeam implements Types, Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6327249599056710232L;
	private TypesGame game;
	private int idStable;
	private ArrayList<TypesRegisterPlayer> players;
	
	
	public TypesRegisterTeam(TypesGame game, int idEcurie, ArrayList<TypesRegisterPlayer> players) {
		this.game = game;
		this.idStable = idEcurie;
		this.players = players;
	}


	public TypesGame getGame() {
		return game;
	}


	public int getIdStable() {
		return idStable;
	}


	public ArrayList<TypesRegisterPlayer> getPlayers() {
		return players;
	}
	
}
