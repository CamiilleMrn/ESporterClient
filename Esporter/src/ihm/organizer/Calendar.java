package ihm.organizer;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

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

import ihm.component.DatePicker;
import ihm.visitor.RendererVisitorCalendar;
import ihm.MasterFrame;
import ihm.component.ComboBoxRendererArrow;
import ihm.component.DataJPanel;
import types.TypesGame;
import types.TypesFame;
import types.TypesTournament;

import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

public class Calendar extends DataJPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 824169066451626109L;
	private JTextField txtDate;
	private JTextField txtCalendar;
	private JPanel panelTournaments;
	private JLabel lblNoTournament = new JLabel();
	private Date dateFilter =null;
	private TypesGame gameFilter = null;

	
	private void createListTournament(Date date, TypesGame game) {
        // create List model
		panelTournaments.removeAll();
		dateFilter = date;
		gameFilter = game;
		ArrayList<TypesTournament> tournamentFiltered = MasterFrame.getInstance().getUser().getData().listFilteredTournament(date, game);
		System.out.println(tournamentFiltered.isEmpty());
		if(tournamentFiltered.isEmpty() || tournamentFiltered == null ) {
			System.out.println("isEmpty");
			lblNoTournament.setText("Il n'existe aucun tournoi correspondant aux critères recherchés");
			lblNoTournament.setForeground(MasterFrame.COLOR_TEXT);
			lblNoTournament.setFont(new Font("Cambria", Font.PLAIN , 20));
			panelTournaments.add(lblNoTournament);
		} else {
			for (TypesTournament t : tournamentFiltered) {
				panelTournaments.add(new RendererOrganizerCalendar(t));
			}

		}
		        
        panelTournaments.setLayout(new GridLayout(0, 1));

		
		//HashMap<Integer, TournoiInfo> map = Data.getCalendrier();

	
	}	
	/**
	 * Create the application.
	 * @param tournoi 
	 */
	public Calendar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		panelTournaments = new JPanel();
		panelTournaments.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		setLayout(new BorderLayout(0, 0));
		JPanel panelRoot = new JPanel();
		panelRoot.setLayout(new BorderLayout());
		add(panelRoot, BorderLayout.CENTER);
		JPanel panelTitle = new JPanel();
		panelTitle.setPreferredSize(new Dimension(5, 70));
		panelTitle.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelTitle.setBorder(null);
		panelRoot.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		add(panelTitle, BorderLayout.NORTH);
		
		txtCalendar = new JTextField();
		txtCalendar.setHorizontalAlignment(SwingConstants.CENTER);
		txtCalendar.setPreferredSize(new Dimension(5, 50));
		txtCalendar.setEditable(false);
		txtCalendar.setForeground(MasterFrame.COLOR_TEXT);
		txtCalendar.setBorder(new EmptyBorder(20, 0, 0, 0));
		txtCalendar.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		txtCalendar.setText("Calendrier des tournois");
		txtCalendar.setFont(new Font("Cambria", Font.BOLD, 40));
		panelTitle.add(txtCalendar);
		txtCalendar.setColumns(20);
		
		createListTournament(null, null);
		JScrollPane scrollPaneCalendar = new JScrollPane(panelTournaments);
		scrollPaneCalendar.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		scrollPaneCalendar.setBorder(new EmptyBorder(50, 100, 50, 100));
		panelRoot.add(scrollPaneCalendar, BorderLayout.CENTER);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(100, 100, 0, 100));
		panel.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelRoot.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 3, 200, 0));
		
		JPanel panelDateFilter = new JPanel();
		panel.add(panelDateFilter);
		panelDateFilter.setLayout(new BorderLayout(0, 0));
		
		txtDate = new JTextField("Selectionnez une date");
		txtDate.setEditable(false);
		txtDate.setForeground(MasterFrame.COLOR_TEXT);
		txtDate.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		txtDate.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), new EmptyBorder(0, 10, 0, 0)));
		txtDate.setFont(new Font("Cambria", Font.PLAIN, 15));
		
		txtDate.setColumns(10);
		
		txtDate.getDocument().addDocumentListener(new DocumentListener() {


			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				System.out.println("ok1");
				createListTournament(Date.valueOf(txtDate.getText()), gameFilter);
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
		panelDateFilter.add(txtDate, BorderLayout.CENTER);
		
		JButton btnMoreDate = new JButton(" ... ");
		btnMoreDate.setBackground(MasterFrame.COLOR_MASTER);
		btnMoreDate.setForeground(MasterFrame.COLOR_TEXT);
		btnMoreDate.setFont(new Font("Cambria", Font.PLAIN, 15));
		btnMoreDate.setBorder(null);
		btnMoreDate.addActionListener(new ActionListener() {
				//performed action
				public void actionPerformed(ActionEvent arg0) 
				{
					//create frame new object  f
					final JFrame f = new JFrame();
					//set text which is collected by date picker i.e. set date 
					txtDate.setText(new DatePicker(f).setPickedDate());
				}
			});
		panelDateFilter.add(btnMoreDate, BorderLayout.EAST);

		
		JPanel panelGameFilter = new JPanel();
		panelGameFilter.setBorder(null);
		panel.add(panelGameFilter);
		panelGameFilter.setLayout(new BorderLayout(0, 0));
		
		JComboBox<TypesGame> comboBoxFilterGame = new JComboBox<>(TypesGame.values());
		comboBoxFilterGame.setUI((ComboBoxUI) ComboBoxRendererArrow.createUI(comboBoxFilterGame));
		comboBoxFilterGame.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		comboBoxFilterGame.setFont(new Font("Cambria", Font.PLAIN, 15));
		comboBoxFilterGame.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		comboBoxFilterGame.setForeground(MasterFrame.COLOR_TEXT);
		
		comboBoxFilterGame.addItemListener(new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if(e.getStateChange() == ItemEvent.SELECTED) {
	                gameFilter = (TypesGame) comboBoxFilterGame.getSelectedItem();
	                createListTournament(dateFilter,gameFilter);
	            }
	        }
	    });
		
		((JTextField) comboBoxFilterGame.getEditor().getEditorComponent()).getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				createListTournament(dateFilter,gameFilter);
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
		
		panelGameFilter.add(comboBoxFilterGame);
		
		
		JPanel panelAddTournament = new JPanel();
		panelAddTournament.setBorder(null);
		panel.add(panelAddTournament);
		panelAddTournament.setLayout(new BorderLayout(0, 0));
		panelAddTournament.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);

		
		JButton btnAddTournament = new JButton("Creer un tournois");
		btnAddTournament.setBackground(MasterFrame.COLOR_MASTER);
		btnAddTournament.setFont(new Font("Cambria", Font.PLAIN, 15));
		btnAddTournament.setForeground(MasterFrame.COLOR_TEXT_MENU);
		btnAddTournament.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MasterFrame.getInstance().setPanel(ihm.organizer.CreateTournament.class,null);
			}
		});
		panelAddTournament.add(btnAddTournament);
		
		

	}
	@Override
	public void dataUpdate() {
		createListTournament(dateFilter, gameFilter);
		
	}

}

