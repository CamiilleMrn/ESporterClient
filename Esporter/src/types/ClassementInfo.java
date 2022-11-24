package types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.SortedSet;

public class ClassementInfo implements Infos, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1122216096852324306L;
	private Jeu jeu;
	private HashMap<EcurieInfo, Integer> ecuries;
	
	
	public ClassementInfo(Jeu jeu) {
		this.jeu = jeu;
		this.ecuries = new HashMap<>();
	}
	
	public void setEcuries(HashMap<EcurieInfo, Integer> ecuries) {
		this.ecuries = ecuries;
	}
	
	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}
	
	public HashMap<EcurieInfo, Integer> getEcuries() {
		return ecuries;
	}
	
	public Jeu getJeu() {
		return jeu;
	}
	
	public HashMap<Integer, ArrayList<EcurieInfo>> getClassement() {
		LinkedList<EcurieInfo> liste = new LinkedList<>(ecuries.keySet());
		Comparator<EcurieInfo> compareFromScore = new Comparator<EcurieInfo>() {

			@Override
			public int compare(EcurieInfo o1, EcurieInfo o2) {
				if (ecuries.get(o1)-ecuries.get(o2)!=0) {
					if (ecuries.get(o1)>ecuries.get(o2)) {
						return -1;
					}
					return 1;
				} 
				
				return o1.getNom().compareTo(o2.getNom());
			}
			
		};
		HashMap<Integer, ArrayList<EcurieInfo>> classement = new HashMap<>();
		Collections.sort(liste, compareFromScore);
		int rang =1;
		int rangAvant =0;
		for (EcurieInfo e : liste) {
			if (classement.get(rangAvant) != null) {
				if (ecuries.get(e) == ecuries.get(classement.get(rangAvant).get(0))) {
					classement.get(rangAvant).add(e);
				} else {
					classement.put(rang, new ArrayList<>());
					classement.get(rang).add(e);
					rang++;rangAvant++;
				}
			} else {
				classement.put(rang, new ArrayList<>());
				classement.get(rang).add(e);
				rang++;rangAvant++;
			}
		}
		return classement;
	}

}
