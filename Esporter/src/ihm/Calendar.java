package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

import data.Data;
import ihm.component.DataJPanel;
import ihm.component.DatePicker;
import ihm.component.ComboBoxRendererArrow;
import ihm.organizer.RendererOrganizerCalendar;
import ihm.player.RendererPlayerCalendar;
import ihm.referee.RendererRefereeCalendar;
import ihm.stable.RendererStableCalendar;
import ihm.visitor.RendererVisitorCalendar;
import types.TypesGame;
import types.TypesPermission;
import types.TypesFame;
import types.TypesTournament;
import java.awt.Component;
import javax.swing.Box;

public class Calendar extends DataJPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtDate;
	private TypesPermission permission;
	private JPanel panelRoot;
	private JPanel panelContent;
	private Date dateChoisi ;
	private TypesGame jeuChoisi;
	private JLabel ifEmpty = new JLabel();
	private JLabel lblTitle;
	
	private void createListTournament(Date date, TypesGame jeu) {
		panelContent.removeAll();
		dateChoisi = date;
		jeuChoisi = jeu;
		ArrayList<TypesTournament> tournoisfiltreJeu = MasterFrame.getInstance().getUser().getData().listFilteredTournament(date, jeu);
		System.out.println(tournoisfiltreJeu.isEmpty());
		if(tournoisfiltreJeu.isEmpty() || tournoisfiltreJeu == null ) {
			ifEmpty.setText("Il n'existe aucun tournoi correspondant aux critères recherchés");
			ifEmpty.setForeground(MasterFrame.COULEUR_TEXTE);
			ifEmpty.setFont(new Font("Cambria", Font.PLAIN , 20));
			panelContent.add(ifEmpty);
		} else {
			for (TypesTournament t : tournoisfiltreJeu) {
				switch(permission) {
					case VISITOR :
						panelContent.add(new RendererVisitorCalendar(t));
						break;
					case PLAYER :
						panelContent.add(new RendererPlayerCalendar(t));
						break;
					case STABLE :
						panelContent.add(new RendererStableCalendar(t));
						break;
					case REFEREE :
						panelContent.add(new RendererRefereeCalendar(t));
						break;
					case ORGANIZER :
						break;
				}
			}

		}
		
        panelContent.setLayout(new GridLayout(0, 1));
        
	}
	
	public Calendar(TypesPermission permission) {
		this.permission = permission;
		initialize();
	}
	
	public void initialize() {
		setLayout(new BorderLayout(0, 0));
		panelRoot = new JPanel();
		panelRoot.setLayout(new BorderLayout());
		add(panelRoot, BorderLayout.CENTER);
		JPanel dummy = new JPanel();
		dummy.setPreferredSize(new Dimension(5, 70));
		dummy.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		dummy.setBorder(null);
		panelRoot.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		add(dummy, BorderLayout.NORTH);
		dummy.setLayout(new BorderLayout(0, 0));
		
		lblTitle = new JLabel();
		lblTitle.setText("Calendrier des tournois");
		lblTitle.setPreferredSize(new Dimension(5, 50));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Cambria", Font.BOLD, 40));
		lblTitle.setBorder(null);
		lblTitle.setBackground(new Color(96, 96, 96));
		dummy.add(lblTitle);
		
		panelContent = new JPanel();
		panelContent.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		createListTournament(null, null);
		JScrollPane scrollPaneCalendar = new JScrollPane(panelContent);
		scrollPaneCalendar.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		scrollPaneCalendar.setBorder(new EmptyBorder(50, 100, 50, 100));
		panelRoot.add(scrollPaneCalendar, BorderLayout.CENTER);
			
		JPanel panelFilter = new JPanel();
		panelFilter.setBorder(new EmptyBorder(100, 100, 0, 100));
		panelFilter.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelRoot.add(panelFilter, BorderLayout.NORTH);
		panelFilter.setLayout(new GridLayout(0, 3, 200, 0));
		
		JPanel panelFilterDate = new JPanel();
		panelFilter.add(panelFilterDate);
		panelFilterDate.setLayout(new BorderLayout(0, 0));
		
		txtDate = new JTextField("Selectionnez une date");
		txtDate.setEditable(false);
		txtDate.setForeground(Color.WHITE);
		txtDate.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		txtDate.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), new EmptyBorder(0, 10, 0, 0)));
		txtDate.setFont(new Font("Cambria", Font.PLAIN, 15));
		panelFilterDate.add(txtDate, BorderLayout.CENTER);
		txtDate.setColumns(10);
		
		txtDate.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				createListTournament(Date.valueOf(txtDate.getText()),jeuChoisi);
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
		
		JButton btnDate = new JButton(" ... ");
		btnDate.setBackground(MasterFrame.COULEUR_MASTER);
		btnDate.setForeground(MasterFrame.COULEUR_TEXTE);
		btnDate.setFont(new Font("Cambria", Font.PLAIN, 15));
		btnDate.setBorder(null);
		btnDate.addActionListener(new ActionListener() {
				//performed action
				public void actionPerformed(ActionEvent arg0) 
				{
					//create frame new object  f
					final JFrame f = new JFrame();
					//set text which is collected by date picker i.e. set date 
					txtDate.setText(new DatePicker(f).setPickedDate());
				}
			});
		panelFilterDate.add(btnDate, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panelFilter.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_3.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		
		JComboBox<TypesGame> comboBoxFilterGame = new JComboBox<TypesGame>(TypesGame.values());
		comboBoxFilterGame.setUI((ComboBoxUI) ComboBoxRendererArrow.createUI(comboBoxFilterGame));
		comboBoxFilterGame.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		comboBoxFilterGame.setFont(new Font("Cambria", Font.PLAIN, 15));
		comboBoxFilterGame.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		comboBoxFilterGame.setForeground(MasterFrame.COULEUR_TEXTE);
		
		comboBoxFilterGame.addItemListener(new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if(e.getStateChange() == ItemEvent.SELECTED) {
	                jeuChoisi = (TypesGame) comboBoxFilterGame.getSelectedItem();
	                createListTournament(dateChoisi,jeuChoisi);
	            }
	        }
	    });
		
		((JTextField) comboBoxFilterGame.getEditor().getEditorComponent()).getDocument().addDocumentListener(new DocumentListener() {
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
				
			}
			
		});
		
		panel_3.add(comboBoxFilterGame);
		
	}

	@Override
	public void dataUpdate() {
		createListTournament(dateChoisi, jeuChoisi);
	}

}
