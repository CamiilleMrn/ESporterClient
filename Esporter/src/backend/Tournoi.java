package backend;

import ihm.MasterFrame;
import types.EquipeInfo;
import types.TournoiInfo;
import types.exception.InvalidPermission;
import types.exception.TournoiPlein;

public class Tournoi {

	public static void inscrire(TournoiInfo tournoi) throws TournoiPlein, InvalidPermission{
		if (tournoi.getInscris().size()>=16) {
			throw new TournoiPlein("Le tournoi est plein");
		}
		MasterFrame.getInstance().getUser().inscriptionTournoi(tournoi.getId());
		
	}
}
