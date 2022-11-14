package data;

import java.io.Serializable;
import java.util.HashMap;

import types.ClassementInfo;
import types.EcurieInfo;
import types.Infos;
import types.TournoiInfo;

public class Data implements Serializable, Infos {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6632461413087395187L;
	private HashMap<Integer, EcurieInfo> ecuries;
	private HashMap<Integer, TournoiInfo> calendrier;
	private HashMap<Integer, ClassementInfo> classements;
	

	
}
