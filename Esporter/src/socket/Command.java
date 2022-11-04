package socket;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import types.EcurieInfo;
import types.EquipeInfo;
import types.InfoID;
import types.Infos;
import types.JoueurInfo;
import types.TournoiInfo;

public class Command implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8562553476003862463L;
	private CommandName name;
	private Map<InfoID,Infos> info = new HashMap<>();
	
	
	
	public Command(CommandName name, Map<InfoID,Infos> info) {
		this.name = name;
		this.info = info;
	}
	
	public CommandName getName() {
		return name;
	}

	
	public Map<InfoID, Infos> getInfo() {
		return info;
	}
	
	public Infos getInfoByID(InfoID id) {
		if (this.info.get(id)==null) {
			return null;
		}
		return this.info.get(id);
	}
	
	public String toString() {
		String output = "[MAP";
		for (InfoID key : info.keySet()) {
	        output+=(key + "=" + info.get(key) + ", ");
	    }
		return output;
	}
	
}