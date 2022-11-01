package utilisateur;


import types.JoueurInfo;
import types.Permission;
import types.TournoiInfo;
import types.exception.InvalidPermission;

public class Joueur extends User{

	private JoueurInfo info;

	public Joueur(Permission permission, JoueurInfo info) throws InvalidPermission{
		super(permission);
		if (permission != Permission.JOUEUR) {
			throw new InvalidPermission("Vous ne possedez pas les permissions pour faire ceci");
		}
		this.info = info;
	}
	
	public JoueurInfo getInfo() {
		return info;
	}

	
	@Override
	public int makeConnection() {
		return -1;
	}
	
	public int inscriptionTournoi(TournoiInfo tournoi)  {
		return -1;
	}
	
	
}
