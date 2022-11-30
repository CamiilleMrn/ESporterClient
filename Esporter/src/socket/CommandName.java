package socket;

import java.io.Serializable;

public enum CommandName implements Serializable{

	AJOUTER_TOURNOI, AJOUTER_EQUIPE, INSCRIPTION_TOURNOI, DESINSCRIPTION_TOURNOI, VOIR_CALENDRIER, VOIR_ECURIE, LOGIN, LOGOUT, INIT;
}
