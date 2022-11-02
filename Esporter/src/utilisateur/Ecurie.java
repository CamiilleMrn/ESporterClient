package utilisateur;


import java.net.Socket;

import types.EcurieInfo;
import types.EquipeInfo;
import types.JoueurInfo;
import types.Permission;
import types.exception.InvalidPermission;

public class Ecurie extends User{

	private EcurieInfo info;

	public Ecurie(Permission permission, EcurieInfo info, CommunicationServer com){
		super();
		this.info = info;
	}
	
	public EcurieInfo getInfo() {
		return info;
	}

	
	public int AjouterEquipe(EquipeInfo equipe)  {
		return -1;
	}
	
	public int AjouterJoueur(JoueurInfo joueur)  {
		return -1;
	}
	
	
}
