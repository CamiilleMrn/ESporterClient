package model.socket;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import types.TypesID;
import types.Types;

public class Command implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8562553476003862463L;
	private CommandName name;
	private Map<TypesID,Types> info = new HashMap<>();
	
	
	
	public Command(CommandName name, Map<TypesID,Types> info) {
		this.name = name;
		this.info = info;
	}
	
	public CommandName getName() {
		return name;
	}

	
	public Map<TypesID, Types> getInfo() {
		return info;
	}
	
	public Types getInfoByID(TypesID id) {
		if (this.info.get(id)==null) {
			return null;
		}
		return this.info.get(id);
	}
	
	public String toString() {
		String output = "[MAP";
		for (TypesID key : info.keySet()) {
	        output+=(key + "=" + info.get(key) + ", ");
	    }
		return output;
	}
	
}