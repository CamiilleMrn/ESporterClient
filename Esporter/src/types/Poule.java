package types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Poule implements Infos, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5850691190079571816L;
	private int id;
	private int idTournoi;
	private HashMap<EquipeInfo,Integer> point;
	private ArrayList<Rencontre> rencontre;
	
	
	public Poule(int id, int idTournoi, HashMap<EquipeInfo, Integer> point, ArrayList<Rencontre> rencontre) {
		this.id = id;
		this.idTournoi = idTournoi;
		this.point = point;
		this.rencontre = rencontre;
	}


	public int getId() {
		return id;
	}


	public int getIdTournoi() {
		return idTournoi;
	}


	public HashMap<EquipeInfo, Integer> getPoint() {
		return point;
	}


	public ArrayList<Rencontre> getRencontre() {
		return rencontre;
	}
	
	
	
	
	
}
