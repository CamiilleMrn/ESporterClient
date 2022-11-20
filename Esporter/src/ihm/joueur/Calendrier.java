package ihm.joueur;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import ihm.MasterFrame;
import ihm.component.DatePicker;
import ihm.component.MainComboBoxUI;
import ihm.visiteur.TournoisRendererVisiteurs;
import types.Jeu;
import types.Renomme;
import types.TournoiInfo;

import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.ComboBoxUI;

public class Calendrier extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5755591667748928351L;
	private JTextField TexteDate;
	private JTextField txtCalendrierDesTournois;
	
	private JPanel createListTournament() {
        // create List model
		HashMap<Integer, TournoiInfo> map = new HashMap<>();
        map.put(1,new TournoiInfo(Date.valueOf("2022-11-09"), "TestTournois 1", Renomme.LOCAL, Jeu.LEAGUE_OF_LEGEND , 0));
        map.put(2,new TournoiInfo(Date.valueOf("2022-11-10"), "TestTournois 2", Renomme.LOCAL, Jeu.LEAGUE_OF_LEGEND , 0));
        map.put(3,new TournoiInfo(Date.valueOf("2022-11-11"), "TestTournois 3", Renomme.LOCAL, Jeu.LEAGUE_OF_LEGEND , 0));
        map.put(4,new TournoiInfo(Date.valueOf("2022-11-12"), "TestTournois 4", Renomme.LOCAL, Jeu.LEAGUE_OF_LEGEND , 0));
        map.put(5,new TournoiInfo(Date.valueOf("2022-11-13"), "TestTournois 5", Renomme.LOCAL, Jeu.LEAGUE_OF_LEGEND , 0));
        
        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(0, 1));

		
		//HashMap<Integer, TournoiInfo> map = Data.getCalendrier();

		Iterator<TournoiInfo> ite = map.values().iterator();
		while (ite.hasNext()) {
			
			TournoiInfo t = ite.next();
			System.out.println(t);
			pan.add(new TournoisRendererVisiteurs(t));
			
		}
		return pan;
	
    }
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Calendrier() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		JPanel root = new JPanel();
		root.setBorder(new EmptyBorder(0, 100, 0, 100));
		root.setLayout(new BorderLayout());
		add(root, BorderLayout.CENTER);
		JPanel titrepanel = new JPanel();
		titrepanel.setPreferredSize(new Dimension(5, 50));
		titrepanel.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		titrepanel.setBorder(null);
		root.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		add(titrepanel, BorderLayout.NORTH);
		
		txtCalendrierDesTournois = new JTextField();
		txtCalendrierDesTournois.setHorizontalAlignment(SwingConstants.CENTER);
		txtCalendrierDesTournois.setPreferredSize(new Dimension(5, 50));
		txtCalendrierDesTournois.setEditable(false);
		txtCalendrierDesTournois.setForeground(MasterFrame.COULEUR_TEXTE);
		txtCalendrierDesTournois.setBorder(null);
		txtCalendrierDesTournois.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		txtCalendrierDesTournois.setText("Calendrier des tournois");
		txtCalendrierDesTournois.setFont(new Font("Tahoma", Font.BOLD, 20));
		titrepanel.add(txtCalendrierDesTournois);
		txtCalendrierDesTournois.setColumns(20);
		
		
		JScrollPane scrollPaneCenter = new JScrollPane(createListTournament());
		scrollPaneCenter.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		scrollPaneCenter.setBorder(new EmptyBorder(50, 100, 50, 100));
		root.add(scrollPaneCenter, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(100, 100, 0, 100));
		panel.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		root.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 3, 200, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		TexteDate = new JTextField("Selectionnez une date");
		TexteDate.setBorder(null);
		TexteDate.setEnabled(false);
		TexteDate.setFont(new Font("Cambria", Font.PLAIN, 15));
		panel_2.add(TexteDate, BorderLayout.CENTER);
		TexteDate.setColumns(10);
		
		JButton BtnDate = new JButton(" ... ");
		BtnDate.setBackground(MasterFrame.COULEUR_MASTER);
		BtnDate.setForeground(MasterFrame.COULEUR_TEXTE);
		BtnDate.setFont(new Font("Cambria", Font.PLAIN, 15));
		BtnDate.setBorder(null);
		BtnDate.addActionListener(new ActionListener() {
				//performed action
				public void actionPerformed(ActionEvent arg0) 
				{
					//create frame new object  f
					final JFrame f = new JFrame();
					//set text which is collected by date picker i.e. set date 
					TexteDate.setText(new DatePicker(f).setPickedDate());
				}
			});
		panel_2.add(BtnDate, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JComboBox<Jeu> FiltrerLesJeux = new JComboBox<>();
		FiltrerLesJeux.setUI((ComboBoxUI) MainComboBoxUI.createUI(FiltrerLesJeux));
		FiltrerLesJeux.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		FiltrerLesJeux.setFont(new Font("Cambria", Font.PLAIN, 15));
		FiltrerLesJeux.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		FiltrerLesJeux.setForeground(MasterFrame.COULEUR_TEXTE);
		
		
		panel_3.add(FiltrerLesJeux);
		
	}

}

