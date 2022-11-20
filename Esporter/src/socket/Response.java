package socket;

import java.io.Serializable;

public enum Response implements Serializable {
	ERROR_LOGIN, ERROR_PERMISSION, LOGIN, UPDATE_TOURNOI, UPDATE_CALENDRIER, UPDATE_ECURIE, UPDATE_ALL;
}
