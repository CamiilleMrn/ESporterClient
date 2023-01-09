package types;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class TypesMatch implements Types, Serializable, Comparable<TypesMatch> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 587283429050587122L;
	private Timestamp date;
	private int team1Score;
	private int team2Score;
	private int winner;
	private int team1;
	private int team2;
	
	public TypesMatch(Timestamp date, int team1, int team2, int winner, int team1Score, int team2Score ) {
		this.date = date;
		this.team1 = team1;
		this.team2 = team2;
		this.winner = winner;
		this.team1Score = team1Score;
		this.team2Score = team2Score;
	}
	
	private void setWinner(int winner) {
		this.winner = winner;
	}
	
	public void setPoint(int team1Score, int team2Score) {
		if(team1Score>team2Score) {
			setWinner(team1Score);
		} else if (team1Score<team2Score) {
			setWinner(team2Score);
		} else {
			return;
		}
		this.team1Score = team1Score;
		this.team2Score = team2Score;
	}

	public Timestamp getDate() {
		return date;
	}

	public int getTeam1Score() {
		return team1Score;
	}

	public int getTeam2Score() {
		return team2Score;
	}

	public int getWinner() {
		return winner;
	}

	public int getTeam1() {
		return team1;
	}

	public int getTeam2() {
		return team2;
	}
	
	public boolean isPlayed() {
		if (winner!= team1 && winner!=team2)
			return false;
		return true;
		
	}

	@Override
	public int compareTo(TypesMatch o) {
		return getDate().compareTo(o.getDate());
	}
	
	
}
