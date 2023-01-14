package types;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class TypesMatch implements Types, Serializable, Comparable<TypesMatch> {

	@Override
	public int hashCode() {
		return Objects.hash(idPool, idTournament, team1, team2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypesMatch other = (TypesMatch) obj;
		return idPool == other.idPool && idTournament == other.idTournament && team1 == other.team1
				&& team2 == other.team2;
	}

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
	private int idTournament;
	private int idPool;
	
	public TypesMatch(Timestamp date, int team1, int team2, int winner, int team1Score, int team2Score, int idTournament, int idPool) {
		this.date = date;
		this.team1 = team1;
		this.team2 = team2;
		this.winner = winner;
		this.team1Score = team1Score;
		this.team2Score = team2Score;
		this.idPool = idPool;
		this.idTournament = idTournament;
	}
	
	private void setWinner(int winner) {
		this.winner = winner;
	}
	
	public void setPoint(int team1Score, int team2Score) {
		if(team1Score>team2Score) {
			setWinner(team1);
		} else if (team1Score<team2Score) {
			setWinner(team2);
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
	
	public int getIdPool() {
		return idPool;
	}
	
	public int getIdTournament() {
		return idTournament;
	}
	
	public boolean isPlayed() {
		if ((winner== team1 || winner==team2) && team1!=team2)
			return true;
		return false;
		
	}

	@Override
	public int compareTo(TypesMatch o) {
		return getDate().compareTo(o.getDate());
	}
	
	
}
