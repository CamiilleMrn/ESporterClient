package types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

public class TypesRanking implements Types, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1122216096852324306L;
	private TypesGame game;
	private HashMap<TypesStable, Integer> stables;
	
	
	public TypesRanking(TypesGame game) {
		this.game = game;
		this.stables = new HashMap<>();
	}
	
	public void setEcuries(HashMap<TypesStable, Integer> stables) {
		this.stables = stables;
	}
	
	public void setGame(TypesGame game) {
		this.game = game;
	}
	
	public HashMap<TypesStable, Integer> getStables() {
		return stables;
	}
	
	public TypesGame getGame() {
		return game;
	}
	
	public HashMap<Integer, ArrayList<TypesStable>> getRanking() {
		LinkedList<TypesStable> list = new LinkedList<>(stables.keySet());
		Comparator<TypesStable> compareFromScore = new Comparator<TypesStable>() {

			@Override
			public int compare(TypesStable o1, TypesStable o2) {
				if (stables.get(o1)-stables.get(o2)!=0) {
					if (stables.get(o1)>stables.get(o2)) {
						return -1;
					}
					return 1;
				} 
				
				return o1.getName().compareTo(o2.getName());
			}
			
		};
		HashMap<Integer, ArrayList<TypesStable>> ranking = new HashMap<>();
		Collections.sort(list, compareFromScore);
		int rank =1;
		int previousRank =0;
		for (TypesStable e : list) {
			if (ranking.get(previousRank) != null) {
				if (stables.get(e) == stables.get(ranking.get(previousRank).get(0))) {
					ranking.get(previousRank).add(e);
				} else {
					ranking.put(rank, new ArrayList<>());
					ranking.get(rank).add(e);
					rank++;previousRank++;
				}
			} else {
				ranking.put(rank, new ArrayList<>());
				ranking.get(rank).add(e);
				rank++;previousRank++;
			}
		}
		return ranking;
	}

}
