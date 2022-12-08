package types;

import java.io.Serializable;

public class TypesRegisterPlayer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5974897413172620415L;
	private TypesPlayer player;
	private TypesLogin login;
	
	public TypesPlayer getPlayer() {
		return player;
	}
	
	public TypesLogin getLogin() {
		return login;
	}
	
	public TypesRegisterPlayer(TypesPlayer player, TypesLogin login) {
		this.player = player;
		this.login = login;
	}
	
	
}
