package utilisateur;

import java.net.Socket;

import types.Permission;
import types.TournoiInfo;
import types.exception.InvalidPermission;

public class Organisateur extends User{

	public Organisateur(Permission permission, CommunicationServer com){
		super();

	}
	
	public int AjouterTournoi(TournoiInfo tournoi)  {
		return -1;
	}
	
	
}
