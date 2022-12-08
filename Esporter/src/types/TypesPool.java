package types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class TypesPool implements Types, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5850691190079571816L;
	private int id;
	private int idTournament;
	private HashMap<TypesTeam,Integer> point;
	private ArrayList<TypesMatch> matchs;
	
	
	public TypesPool(int id, int idTournament, HashMap<TypesTeam, Integer> point, ArrayList<TypesMatch> matchs) {
		this.id = id;
		this.idTournament = idTournament;
		this.point = point;
		this.matchs = matchs;
	}


	public int getId() {
		return id;
	}


	public int getIdTournament() {
		return idTournament;
	}


	public HashMap<TypesTeam, Integer> getPoint() {
		return point;
	}


	public ArrayList<TypesMatch> getMatchs() {
		return matchs;
	}
	
	
	
	
	
}
