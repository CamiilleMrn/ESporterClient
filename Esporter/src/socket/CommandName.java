package socket;

import java.io.Serializable;

public enum CommandName implements Serializable{

	ADD_TOURNAMENT, ADD_TEAM, MODIFY_TEAM, REGISTER_TOURNAMENT, UNREGISTER_TOURNAMENT, CALENDAR, STABLE, LOGIN, LOGOUT, INIT;
}
