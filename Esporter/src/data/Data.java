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
	private static HashMap<Integer, EcurieInfo> ecuries;
	private static HashMap<Integer, TournoiInfo> calendrier;
	private static HashMap<Integer, ClassementInfo> classements;
	
public static HashMap<Integer, TournoiInfo> getCalendrier() {
	return calendrier;
}

public static HashMap<Integer, ClassementInfo> getClassements() {
	return classements;
}

public static HashMap<Integer, EcurieInfo> getEcuries() {
	return ecuries;
}
	
}
