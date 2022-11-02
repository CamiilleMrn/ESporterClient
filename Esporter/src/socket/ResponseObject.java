package socket;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import types.EcurieInfo;
import types.EquipeInfo;
import types.InfoID;
import types.JoueurInfo;
import types.TournoiInfo;
import types.Infos;

public class ResponseObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4180943570637657256L;
	private Response name;
	private Map<InfoID,Infos> info = new HashMap<>();
	private String error;
	
	
	
	public ResponseObject(Response name, Map<InfoID,Infos> info, String error) {
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
	
	public Map<InfoID, Infos> getInfo() {
		return info;
	}
	
	public Infos getInfoByID(InfoID id) {
		if (this.info.get(id)==null) {
			return null;
		}
		return this.info.get(id);
	}
	
}
