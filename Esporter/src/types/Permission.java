package types;

import java.io.Serializable;

public enum Permission implements Infos, Serializable{

	ORGANISATEUR, JOUEUR, ECURIE, ARBITRE, VISITEUR;
}
