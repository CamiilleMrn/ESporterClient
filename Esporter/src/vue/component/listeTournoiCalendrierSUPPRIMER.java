package vue.component;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import data.Data;
import types.TypesGame;
import types.TypesFame;
import types.TypesTournament;
import vue.visitor.RendererVisitorCalendar;

import java.awt.Color;
import java.awt.GridLayout;

public class listeTournoiCalendrierSUPPRIMER<E extends JPanel> extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7830200743260845900L;

	private ArrayList<JPanel> list = new ArrayList<>();

	public listeTournoiCalendrierSUPPRIMER(Class<E> p, HashMap<Integer, TypesTournament> map) {
		setLayout(new GridLayout(map.size(), 1));
		TypesTournament h = new TypesTournament(Date.valueOf("2022-11-09"), "TestTournois 1", TypesFame.LOCAL,
				TypesGame.COUNTER_STRIKE, 0);
		add(new RendererVisitorCalendar(h));

		// HashMap<Integer, TournoiInfo> map = Data.getCalendrier();

		Iterator<TypesTournament> ite = map.values().iterator();
		while (ite.hasNext()) {
			TypesTournament t = ite.next();
			try {
				JPanel pan = (JPanel) p.getConstructors()[0].newInstance(t);
				pan = new JPanel();
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
