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
import javax.swing.plaf.ComboBoxUI;

import ihm.arbitre.TournoisRendererArbitre;
import ihm.component.DataJPanel;
import ihm.component.DatePicker;
import ihm.component.MainComboBoxUI;
import ihm.ecurie.TournoisRendererEcurie;
import ihm.joueur.TournoisRendererJoueur;
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
	
	private JPanel createListTournament() {
		HashMap<Integer, TournoiInfo> map = MasterFrame.getInstance().getUser().getData().getCalendrier();
        
        
        pan.setLayout(new GridLayout(0, 1));

		
		//HashMap<Integer, TournoiInfo> map = Data.getCalendrier();

		Iterator<TournoiInfo> ite = map.values().iterator();
		while (ite.hasNext()) {
			
			TournoiInfo t = ite.next();
			System.out.println(t);
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
		return pan;
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
		txtCalendrierDesTournois.setBorder(new EmptyBorder(20, 0, 0, 0));
		txtCalendrierDesTournois.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		txtCalendrierDesTournois.setText("Calendrier des tournois");
		txtCalendrierDesTournois.setFont(new Font("Tahoma", Font.BOLD, 20));
		dummy.add(txtCalendrierDesTournois);
		txtCalendrierDesTournois.setColumns(20);
		
		pan = new JPanel();
		createListTournament();
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
		TexteDate.setEnabled(false);
		TexteDate.setForeground(Color.WHITE);
		TexteDate.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		TexteDate.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), new EmptyBorder(0, 10, 0, 0)));
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

	@Override
	public void dataUpdate() {
		pan.removeAll();
		createListTournament();
		revalidate();
		validate();
	}

}
