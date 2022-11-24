package ihm.organisateur;
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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.ComboBoxUI;

import ihm.MasterFrame;
import ihm.component.DatePicker;
import ihm.component.ComboBoxRendererArrow;
import ihm.component.DataJPanel;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;

public class Calendrier extends DataJPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 824169066451626109L;
	private JTextField TexteDate;
	private JTextField txtCalendrierDesTournois;
	private JPanel pan;
	private Date dateChoisi =null;
	private Jeu jeuChoisi = null;
	
	private void createListTournament(Date date, Jeu jeu) {
        // create List model
		pan.removeAll();
		dateChoisi = date;
		jeuChoisi = jeu;
		ArrayList<TournoiInfo> tournoisfiltreJeu = MasterFrame.getInstance().getUser().getData().TournoiFiltre(date, jeu);
		
		for (TournoiInfo t : tournoisfiltreJeu) {
			pan.add(new TournoisRendererOrga(t));
		}
        
        pan.setLayout(new GridLayout(0, 1));

		
		//HashMap<Integer, TournoiInfo> map = Data.getCalendrier();

	
	}	
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
		pan = new JPanel();
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
		txtCalendrierDesTournois.setFont(new Font("Cambria", Font.BOLD, 40));
		dummy.add(txtCalendrierDesTournois);
		txtCalendrierDesTournois.setColumns(20);
		
		createListTournament(null, null);
		JScrollPane scrollPaneCenter = new JScrollPane(pan);
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
		TexteDate.setEditable(false);
		TexteDate.setForeground(Color.WHITE);
		TexteDate.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		TexteDate.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), new EmptyBorder(0, 10, 0, 0)));
		TexteDate.setFont(new Font("Cambria", Font.PLAIN, 15));
		
		TexteDate.setColumns(10);
		
		TexteDate.getDocument().addDocumentListener(new DocumentListener() {


			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				System.out.println("ok1");
				createListTournament(Date.valueOf(TexteDate.getText()), jeuChoisi);
				revalidate();
				validate();
				repaint();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}

			});
		panel_2.add(TexteDate, BorderLayout.CENTER);
		
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
		
		JComboBox<Jeu> FiltrerLesJeux = new JComboBox<>(Jeu.values());
		FiltrerLesJeux.setUI((ComboBoxUI) ComboBoxRendererArrow.createUI(FiltrerLesJeux));
		FiltrerLesJeux.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		FiltrerLesJeux.setFont(new Font("Cambria", Font.PLAIN, 15));
		FiltrerLesJeux.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		FiltrerLesJeux.setForeground(MasterFrame.COULEUR_TEXTE);
		
		panel_3.add(FiltrerLesJeux);
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		panel_4.setBackground(MasterFrame.COULEUR_MASTER_FOND);

		
		JButton CreerUnTournoi = new JButton("Creer un tournois");
		CreerUnTournoi.setBackground(MasterFrame.COULEUR_MASTER);
		CreerUnTournoi.setFont(new Font("Cambria", Font.PLAIN, 15));
		CreerUnTournoi.setForeground(MasterFrame.COULEUR_TEXTE);
		CreerUnTournoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_4.add(CreerUnTournoi);
		
		

	}
	@Override
	public void dataUpdate() {
		createListTournament(dateChoisi, jeuChoisi);
		
	}

}

