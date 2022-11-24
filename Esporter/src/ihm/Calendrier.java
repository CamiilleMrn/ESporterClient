package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.text.JTextComponent;

import ihm.arbitre.TournoisRendererArbitre;
import ihm.component.DataJPanel;
import ihm.component.DatePicker;
import ihm.component.ComboBoxRendererArrow;
import ihm.ecurie.TournoisRendererEcurie;
import ihm.joueur.TournoisRendererJoueur;
import ihm.organisateur.TournoisRendererOrga;
import ihm.visiteur.TournoisRendererVisiteurs;
import types.Jeu;
import types.Permission;
import types.Renomme;
import types.TournoiInfo;

public class Calendrier extends DataJPanel{
	
	private JTextField TexteDate;
	private JTextField txtCalendrierDesTournois;
	private Permission permission;
	private JPanel root;
	private JPanel pan;
	private Date dateChoisi ;
	private Jeu jeuChoisi;
	
	private void switchUser (TournoiInfo t) {
		switch(permission) {
		case VISITEUR :
			pan.add(new TournoisRendererVisiteurs(t));
			break;
		case JOUEUR :
			pan.add(new TournoisRendererJoueur(t));
			break;
		case ECURIE :
			pan.add(new TournoisRendererEcurie(t));
			break;
		case ARBITRE :
			pan.add(new TournoisRendererArbitre(t));
			break;
		case ORGANISATEUR :
			break;
	}
	}
	
	private void createListTournament(Date date, Jeu jeu) {
		pan.removeAll();
		dateChoisi = date;
		jeuChoisi = jeu;
		ArrayList<TournoiInfo> tournoisfiltreJeu = MasterFrame.getInstance().getUser().getData().TournoiFiltre(date, jeu);
		
		for (TournoiInfo t : tournoisfiltreJeu) {
			switchUser(t);
		}
        pan.setLayout(new GridLayout(0, 1));
        
	}
	
	public Calendrier(Permission permission) {
		this.permission = permission;
		initialize();
	}
	
	public void initialize() {
		setLayout(new BorderLayout(0, 0));
		root = new JPanel();
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
		txtCalendrierDesTournois.setBorder(null);
		txtCalendrierDesTournois.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		txtCalendrierDesTournois.setText("Calendrier des tournois");
		txtCalendrierDesTournois.setFont(new Font("Cambria", Font.BOLD, 40));
		dummy.add(txtCalendrierDesTournois);
		txtCalendrierDesTournois.setColumns(20);
		
		pan = new JPanel();
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
		panel_2.add(TexteDate, BorderLayout.CENTER);
		TexteDate.setColumns(10);
		
		TexteDate.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				createListTournament(Date.valueOf(TexteDate.getText()),jeuChoisi);
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
		
		((JTextField) FiltrerLesJeux.getEditor().getEditorComponent()).getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				createListTournament(dateChoisi,jeuChoisi);
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
				// TODO Auto-generated method stub
				createListTournament(dateChoisi,jeuChoisi);
				revalidate();
			}
			
		});
		
		panel_3.add(FiltrerLesJeux);
		
	}

	@Override
	public void dataUpdate() {
		createListTournament(dateChoisi, jeuChoisi);
	}

}
