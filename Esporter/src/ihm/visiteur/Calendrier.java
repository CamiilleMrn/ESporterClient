package ihm.visiteur;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ihm.MasterFrame;
import ihm.component.DatePicker;
import ihm.joueur.TournoisRendererJoueurs;
import types.Jeu;
import types.Renomme;
import types.TournoiInfo;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Calendrier extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3595177930626198886L;
	private JTextField TexteDate;
	private JList<TournoiInfo> listTournoi;
	private JTextField txtCalendrierDesTournois;
	
	private JList<TournoiInfo> createListTournament() {
        // create List model
        DefaultListModel<TournoiInfo> model = new DefaultListModel<>();
        // add item to model
        model.addElement(new TournoiInfo(Date.valueOf("2022-11-09"), "TestTournois 1", Renomme.LOCAL, new ArrayList<Jeu>() , 0));
        model.addElement(new TournoiInfo(Date.valueOf("2022-11-10"), "TestTournois 2", Renomme.LOCAL, new ArrayList<Jeu>() , 0));
        // create JList with model
        JList<TournoiInfo> list = new JList<TournoiInfo>(model);
        list.setCellRenderer(new TournoisRendererVisiteurs());
        return list;
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
		root.setLayout(new BorderLayout());
		add(root, BorderLayout.CENTER);
		JPanel dummy = new JPanel();
		dummy.setPreferredSize(new Dimension(5, 70));
		dummy.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		dummy.setBorder(null);
		root.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		add(dummy, BorderLayout.NORTH);
		
		txtCalendrierDesTournois = new JTextField();
		txtCalendrierDesTournois.setHorizontalAlignment(SwingConstants.CENTER);
		txtCalendrierDesTournois.setPreferredSize(new Dimension(5, 50));
		txtCalendrierDesTournois.setEditable(false);
		txtCalendrierDesTournois.setForeground(MasterFrame.COULEUR_TEXTE);
		txtCalendrierDesTournois.setBorder(new EmptyBorder(20, 0, 0, 0));
		txtCalendrierDesTournois.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		txtCalendrierDesTournois.setText("Calendrier des tournois");
		txtCalendrierDesTournois.setFont(new Font("Tahoma", Font.BOLD, 20));
		dummy.add(txtCalendrierDesTournois);
		txtCalendrierDesTournois.setColumns(20);
		
		
		JScrollPane scrollPaneCenter = new JScrollPane();
		scrollPaneCenter.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		scrollPaneCenter.setBorder(new EmptyBorder(50, 100, 50, 100));
		root.add(scrollPaneCenter, BorderLayout.CENTER);
		DefaultListModel<String> model = new DefaultListModel<String>();
		listTournoi = createListTournament();
		
		scrollPaneCenter.add(listTournoi);
		listTournoi.setFont(new Font("Tahoma", Font.PLAIN, 30));
		listTournoi.setForeground(MasterFrame.COULEUR_TEXTE);
		listTournoi.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		scrollPaneCenter.setViewportView(listTournoi);
		

		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(100, 100, 0, 100));
		panel.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		root.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 3, 200, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		TexteDate = new JTextField("Date du tournoi");
		TexteDate.setBorder(null);
		TexteDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(TexteDate, BorderLayout.CENTER);
		TexteDate.setColumns(10);
		
		JButton BtnDate = new JButton("...");
		BtnDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
		FiltrerLesJeux.setBorder(null);
		FiltrerLesJeux.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		panel_3.add(FiltrerLesJeux);
		
	}

}

