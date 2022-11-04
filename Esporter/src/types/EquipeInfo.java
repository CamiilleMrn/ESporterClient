package types;

import java.io.Serializable;
import java.util.ArrayList;

public class EquipeInfo implements Infos, Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1457773383457961641L;
	private Jeu jeu;
	private EcurieInfo ecurie;
	private ArrayList<JoueurInfo> joueurs;
	private int id;
	
	
	public EquipeInfo(Jeu jeu, EcurieInfo ecurie, ArrayList<JoueurInfo> joueurs, int id) {
		this.jeu = jeu;
		this.ecurie = ecurie;
		this.joueurs = joueurs;
		this.id = id;
	}
	
	public Jeu getJeu() {
		return jeu;
	}
	public EcurieInfo getEcurie() {
		return ecurie;
	}
	public ArrayList<JoueurInfo> getJoueurs() {
		return joueurs;
	}
	
	public void modifierJoueur(JoueurInfo joueur) {
		int i = joueurExiste(joueur);
		if (i>=0) {
			joueurs.remove(i);
			joueurs.add(joueur);
		}
	}
	
	public int joueurExiste(JoueurInfo joueur) {
		for (int i=0; i<joueurs.size();i++) {
			if (joueurs.get(i).equals(joueur)) {
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
		EquipeInfo other = (EquipeInfo) obj;
		return this.id == other.getId();
	}
	
	public int getId() {
		return id;
	}
	
	

}
