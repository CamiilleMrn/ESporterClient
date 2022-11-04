package types;

import java.io.Serializable;
import java.sql.Date;

public class Rencontre implements Infos, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 587283429050587122L;
	private Date date;
	private int pointEquipe1;
	private int pointEquipe2;
	private EquipeInfo gagnant;
	private EquipeInfo equipe1;
	private EquipeInfo equipe2;
	
	public Rencontre(Date date, EquipeInfo equipe1, EquipeInfo equipe2) {
		this.date = date;
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
	}
	
	public void setGagnant(EquipeInfo gagnant) {
		this.gagnant = gagnant;
	}
	
	public void setPoint(int pointEquipe1, int pointEquipe2) {
		this.pointEquipe1 = pointEquipe1;
		this.pointEquipe2 = pointEquipe2;
	}

	public Date getDate() {
		return date;
	}

	public int getPointEquipe1() {
		return pointEquipe1;
	}

	public int getPointEquipe2() {
		return pointEquipe2;
	}

	public EquipeInfo getGagnant() {
		return gagnant;
	}

	public EquipeInfo getEquipe1() {
		return equipe1;
	}

	public EquipeInfo getEquipe2() {
		return equipe2;
	}
	
	public boolean matchJoué() {
		if (gagnant==null)
			return false;
		return true;
		
	}
	
	
}
