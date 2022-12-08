package types;

import java.io.Serializable;
import java.sql.Date;

public class TypesMatch implements Types, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 587283429050587122L;
	private Date date;
	private int pointTeam1;
	private int pointTeam2;
	private TypesTeam winner;
	private TypesTeam team1;
	private TypesTeam team2;
	
	public TypesMatch(Date date, TypesTeam equipe1, TypesTeam equipe2) {
		this.date = date;
		this.team1 = equipe1;
		this.team2 = equipe2;
	}
	
	public void setWinner(TypesTeam winner) {
		this.winner = winner;
	}
	
	public void setPoint(int pointEquipe1, int pointEquipe2) {
		this.pointTeam1 = pointEquipe1;
		this.pointTeam2 = pointEquipe2;
	}

	public Date getDate() {
		return date;
	}

	public int getPointTeam1() {
		return pointTeam1;
	}

	public int getPointTeam2() {
		return pointTeam2;
	}

	public TypesTeam getWinner() {
		return winner;
	}

	public TypesTeam getTeam1() {
		return team1;
	}

	public TypesTeam getTeam2() {
		return team2;
	}
	
	public boolean isPlayed() {
		if (winner==null)
			return false;
		return true;
		
	}
	
	
}
