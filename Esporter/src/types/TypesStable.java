package types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class TypesStable implements Types, Serializable,  Comparable<TypesStable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3925659840033195163L;
	private String name;
	private types.TypesImage logo;
	private String nickname;
	private HashMap<Integer,TypesTeam> teams;
	private ArrayList<TypesTitle> titles;
	private int id;
	
	public TypesStable(String name, TypesImage logo, String nickname, int id) {
		this.name = name;
		this.logo = logo;
		this.nickname = nickname;
		this.id = id;
		this.teams = new HashMap<>();
		this.titles = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setTitles(ArrayList<TypesTitle> titles) {
		this.titles = titles;
	}
	
	public types.TypesImage getLogo() {
		return logo;
	}

	public String getNickname() {
		return nickname;
	}


	public HashMap<Integer, TypesTeam> getTeams() {
		return teams;
	}
	
	public ArrayList<TypesTitle> getTitles() {
		return titles;
	}
	
	public void addTeam(TypesTeam e) {
		this.teams.put(e.getId(), e);
	}
	
	public void ajouterJoueur(TypesPlayer j) throws IllegalArgumentException {
		if (this.teams.get(j.getIdTeam())==null) {
			throw new IllegalArgumentException();
		}
		this.teams.get(j.getIdTeam()).addPlayer(j);
	}
	
	@Override
	public int compareTo(TypesStable o) {
		return this.getName().compareTo(o.getName());
	}
	
	
	

}
