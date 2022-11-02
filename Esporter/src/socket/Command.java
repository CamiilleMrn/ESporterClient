package socket;

import java.io.Serializable;

import types.EcurieInfo;
import types.EquipeInfo;
import types.JoueurInfo;
import types.TournoiInfo;

public class Command implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8562553476003862463L;
	private CommandName name;
	private EcurieInfo ecurie;
	private EquipeInfo equipe;
	private JoueurInfo joueur;
	private TournoiInfo tournoi;
	private String mdp;
	private String username;
	
	private Command(CommandName name, EcurieInfo ecurie, EquipeInfo equipe, JoueurInfo joueur, TournoiInfo tournoi, String mdp, String username) {
		this.name = name;
		this.ecurie = ecurie;
		this.equipe = equipe;
		this.joueur = joueur;
		this.tournoi = tournoi;
		this.mdp = mdp;
		this.username = username;
	}
	
	public Command (CommandName name, EquipeInfo equipe) {
		this(name, null, equipe, null, null, null, null);
	}
	
	public Command (CommandName name, EcurieInfo ecurie) {
		this(name, ecurie, null, null, null, null, null);
	}
	
	public Command (CommandName name, JoueurInfo joueur) {
		this(name, null, null, joueur, null, null, null);
	}
	
	public Command (CommandName name, TournoiInfo tournoi) {
		this(name, null, null, null, tournoi, null, null);
	}
	
	public Command (CommandName name,JoueurInfo joueur, TournoiInfo tournoi) {
		this(name, null, null, joueur, tournoi, null, null);
	}
	
	public Command (CommandName name, String mdp, String username) {
		this(name, null, null, null, null, mdp, username);
	}

	public CommandName getName() {
		return name;
	}

	public EcurieInfo getEcurie() {
		return ecurie;
	}

	public EquipeInfo getEquipe() {
		return equipe;
	}

	public JoueurInfo getJoueur() {
		return joueur;
	}

	public TournoiInfo getTournoi() {
		return tournoi;
	}
	
	public String getMdp() {
		return mdp;
	}
	
	public String getUsername() {
		return username;
	}
	
	
	
	
}
