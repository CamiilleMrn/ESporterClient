package utilisateur;

import types.Permission;
import types.TournoiInfo;
import types.exception.InvalidPermission;

public class Organisateur extends User{

	public Organisateur(Permission permission) throws InvalidPermission{
		super(permission);
		if (permission != Permission.ORGANISATEUR) {
			throw new InvalidPermission("Vous ne possedez pas les permissions pour faire ceci");
		}

	}
	
	@Override
	public int makeConnection() {
		return -1;
	}
	
	public int AjouterTournoi(TournoiInfo tournoi)  {
		return -1;
	}
	
	
}
