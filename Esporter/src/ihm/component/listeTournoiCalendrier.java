package ihm.component;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import data.Data;
import ihm.visiteur.TournoisRendererVisiteurs;
import types.Jeu;
import types.Renomme;
import types.TournoiInfo;

import java.awt.Color;
import java.awt.GridLayout;

public class listeTournoiCalendrier<E extends JPanel> extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7830200743260845900L;
	private ArrayList<JPanel> list = new ArrayList<>();
	public listeTournoiCalendrier(Class<E> p, HashMap<Integer, TournoiInfo> map) {
		setLayout(new GridLayout(map.size(), 1));
		TournoiInfo h = new TournoiInfo(Date.valueOf("2022-11-09"), "TestTournois 1", Renomme.LOCAL, new ArrayList<Jeu>() , 0);
		add(new TournoisRendererVisiteurs(h));
		
		//HashMap<Integer, TournoiInfo> map = Data.getCalendrier();

		Iterator<TournoiInfo> ite = map.values().iterator();
		while (ite.hasNext()) {
			TournoiInfo t = ite.next();
			try {
				JPanel pan = (JPanel) p.getConstructors()[0].newInstance(t);
				pan =new JPanel();
				pan.setBounds(0, 0, 500, 100);
				pan.setBackground(Color.red);
				
				list.add(pan);
				add(pan);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		setVisible(true);
		repaint();
		revalidate();
	
	}
}
