package ihm.organisateur;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.UIManager;

import ihm.component.DatePicker;
import types.Jeu;

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
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class Calendrier extends JPanel{
	private JList<String> langages;
	private JTextField TexteDate;
	private JList<String> listTournoi;
	public static final Color COULEUR_MASTER = new Color(0,164,210);
	public static final Color COULEUR_MASTER_FOND = Color.DARK_GRAY;
	public static final Color COULEUR_TEXTE = Color.WHITE;
	private JTextField txtCalendrier;
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
		JScrollPane scrollPaneCenter = new JScrollPane();
		add(scrollPaneCenter, BorderLayout.CENTER);
		DefaultListModel<String> model = new DefaultListModel<String>();
		listTournoi = new JList<String>();
		listTournoi.setModel(model);
		scrollPaneCenter.add(listTournoi);
		listTournoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPaneCenter.setViewportView(listTournoi);
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(0, 3, 200, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(COULEUR_MASTER_FOND);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		TexteDate = new JTextField();
		TexteDate.setText("Date du tournoi");
		TexteDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(TexteDate, BorderLayout.CENTER);
		TexteDate.setColumns(10);
		
		JButton TroisPoint = new JButton("...");
		TroisPoint.setBackground(COULEUR_MASTER);
		TroisPoint.setForeground(COULEUR_TEXTE);
		TroisPoint.addActionListener(new ActionListener() {
				//performed action
				public void actionPerformed(ActionEvent arg0) 
				{
					//create frame new object  f
					final JFrame f = new JFrame();
					//set text which is collected by date picker i.e. set date 
					TexteDate.setText(new DatePicker(f).setPickedDate());
				}
			});
		panel_2.add(TroisPoint, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JComboBox FiltrerLesJeux = new JComboBox();
		FiltrerLesJeux.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		panel_3.add(FiltrerLesJeux);
	
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel.setBackground(COULEUR_MASTER_FOND);
		panel_2.setBackground(COULEUR_MASTER_FOND);
		panel_3.setBackground(COULEUR_MASTER_FOND);
		panel_4.setBackground(COULEUR_MASTER_FOND);

		JButton CreerUnTournoi = new JButton("Creer un tournois");
		CreerUnTournoi.setBackground(COULEUR_MASTER);
		CreerUnTournoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CreerUnTournoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		
		panel_4.add(CreerUnTournoi);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.add(panel, BorderLayout.SOUTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(null);
		panel_5.setBackground(COULEUR_MASTER_FOND);
		
		panel_1.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		txtCalendrier = new JTextField();
		txtCalendrier.setBorder(null);
		txtCalendrier.setBackground(COULEUR_MASTER_FOND);
		txtCalendrier.setForeground(COULEUR_TEXTE);
		txtCalendrier.setEditable(false);
		txtCalendrier.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtCalendrier.setText("CALENDRIER");
		txtCalendrier.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(txtCalendrier);
		txtCalendrier.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(null);
		panel_6.setBackground(COULEUR_MASTER_FOND);
		FlowLayout flowLayout = (FlowLayout) panel_6.getLayout();
		flowLayout.setVgap(15);
		panel_1.add(panel_6, BorderLayout.NORTH);
	}

}

