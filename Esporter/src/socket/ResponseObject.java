package socket;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import types.TypesStable;
import types.TypesTeam;
import types.TypesID;
import types.TypesPlayer;
import types.TypesTournament;
import types.Types;

public class ResponseObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4180943570637657256L;
	private Response name;
	private Map<TypesID,Types> info = new HashMap<>();
	private String error;
	
	
	
	public ResponseObject(Response name, Map<TypesID,Types> info, String error) {
		this.name = name;
		this.info = info;
		this.error = error;
	}
	
	public Response getName() {
		return name;
	}

	public String getError() {
		return error;
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
