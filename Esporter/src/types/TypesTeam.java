package types;

import java.io.Serializable;
import java.util.HashMap;

public class TypesTeam implements Types, Serializable, Comparable<TypesTeam>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1457773383457961641L;
	private TypesGame game;
	private TypesStable stable;
	private HashMap<Integer,TypesPlayer> players;
	private int id;
	
	
	public TypesTeam(TypesGame game, TypesStable stable, HashMap<Integer,TypesPlayer> players, int id) {
		this.game = game;
		this.stable = stable;
		this.players = players;
		this.id = id;
	}
	
	
	public TypesGame getGame() {
		return game;
	}
	public TypesStable getStable() {
		return stable;
	}
	public HashMap<Integer,TypesPlayer> getPlayers() {
		return players;
	}
	
	public void addPlayer(TypesPlayer joueur) {
		this.players.put(joueur.getId(), joueur);
	}
	
	public void modifyPlayer(TypesPlayer joueur) {
		int i = isPlayerExist(joueur);
		if (i>=0) {
			players.remove(i);
			players.put(joueur.getId(), joueur);
		}
	}
	
	public int isPlayerExist(TypesPlayer joueur) {
		for (int i=0; i<players.size();i++) {
			if (players.get(i).equals(joueur)) {
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypesTeam other = (TypesTeam) obj;
		return this.id == other.getId();
	}
	
	public int getId() {
		return id;
	}

	@Override
	public int compareTo(TypesTeam o) {
		return this.getStable().compareTo(o.getStable());
	}

}
