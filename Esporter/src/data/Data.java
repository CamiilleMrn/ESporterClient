package data;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import types.ClassementInfo;
import types.EcurieInfo;
import types.Infos;
import types.Jeu;
import types.TournoiInfo;

public class Data implements Serializable, Infos {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6632461413087395187L;
	private volatile HashMap<Integer, EcurieInfo> ecuries = new HashMap<>();
	private volatile HashMap<Integer, TournoiInfo> calendrier = new HashMap<>();
	private volatile HashMap<Integer, ClassementInfo> classements = new HashMap<>();
	
	public HashMap<Integer, TournoiInfo> getCalendrier() {
		return calendrier;
	}
	
	public HashMap<Integer, ClassementInfo> getClassements() {
		return classements;
	}
	
	public HashMap<Integer, EcurieInfo> getEcuries() {
		return ecuries;
	}
	
	
	public void setCalendrier(HashMap<Integer, TournoiInfo> calendrier) {
		this.calendrier = calendrier;
	}
	
	public void setClassements(HashMap<Integer, ClassementInfo> classements) {
		this.classements = classements;
	}
	
	public void setEcuries(HashMap<Integer, EcurieInfo> ecuries) {
		this.ecuries = ecuries;
	}
	
	public ArrayList<EcurieInfo> getListEcurie() {
		Collection<EcurieInfo> values = this.ecuries.values();
		ArrayList<EcurieInfo> listOfValues = new ArrayList<>(values);
		Collections.sort(listOfValues);
		return listOfValues;
	}
	
	public ArrayList<TournoiInfo> listeTournoiTrie() {
		Collection<TournoiInfo> values = this.calendrier.values();
		ArrayList<TournoiInfo>  listOfVTournoiInfos = new ArrayList<>(values);
		Collections.sort(listOfVTournoiInfos);
		return listOfVTournoiInfos;
	}
	
	public ArrayList<TournoiInfo> TournoiFiltreDate(ArrayList<TournoiInfo> listOfVTournoiInfos, Date date) {
		Collections.sort(listOfVTournoiInfos);
		ArrayList<TournoiInfo> trieFiltre = new ArrayList<>();
		for (TournoiInfo tournoi : listOfVTournoiInfos) {
			if (tournoi.getDateInscription().compareTo(date)==0) {
				trieFiltre.add(tournoi);
			}
		}
		return trieFiltre;
	}
	
	public ArrayList<TournoiInfo> TournoiFiltreJeu(Jeu jeu) {
		Collection<TournoiInfo> values = this.calendrier.values();
		ArrayList<TournoiInfo>  listOfVTournoiInfos = new ArrayList<>(values);
		Collections.sort(listOfVTournoiInfos);
		ArrayList<TournoiInfo> trieFiltre = new ArrayList<>();
		for (TournoiInfo tournoi : listOfVTournoiInfos) {
			if (tournoi.getJeux().compareTo(jeu)==0) {
				trieFiltre.add(tournoi);
			}
		}
		return trieFiltre;
	}
	
}
