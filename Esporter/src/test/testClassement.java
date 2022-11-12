package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import types.ClassementInfo;
import types.EcurieInfo;
import types.Jeu;

public class testClassement {

	public static void main(String[] args) {
		ClassementInfo cl = new ClassementInfo(Jeu.COUNTER_STRIKE);
		HashMap<EcurieInfo, Integer> e = new HashMap<>();
		EcurieInfo ec1 = new EcurieInfo("OK", null, null, null, 0);
		EcurieInfo ec2 = new EcurieInfo("OK6", null, null, null, 0);
		EcurieInfo ec3 = new EcurieInfo("OK3", null, null, null, 0);
		EcurieInfo ec4 = new EcurieInfo("OK4", null, null, null, 0);
		e.put(ec1, 4);
		e.put(ec2, 7);
		e.put(ec3, 7);
		e.put(ec4, 1);
		cl.setEcuries(e);
		
		HashMap<Integer, ArrayList<EcurieInfo>> classement = cl.getClassement();
		Iterator<Integer> i = classement.keySet().iterator();
		while(i.hasNext()) {
			int nb = i.next();
			for (int a=0;a<classement.get(nb).size();a++) {
				System.out.println("Ecurie : "+classement.get(nb).get(a)+" place number "+nb);
			}
		}
	}
}
