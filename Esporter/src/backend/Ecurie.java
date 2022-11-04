package backend;

import ihm.MasterFrame;
import types.EquipeInfo;
import types.Titre;
import types.exception.InvalidPermission;

public class Ecurie {

	public static void ajouterEquipe(EquipeInfo e) throws InvalidPermission {
		MasterFrame.getInstance().getUser().ajouterEquipe(e);
	}
	
	public static void ajouterTitre(Titre t) {
		
	}
}
