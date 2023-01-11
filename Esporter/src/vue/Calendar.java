package vue;

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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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

import controleur.Controler;
import model.data.Data;
import types.TypesGame;
import types.TypesPermission;
import types.TypesFame;
import types.TypesTournament;
import vue.component.ComboBoxRendererArrow;
import vue.component.DataJPanel;
import vue.component.DatePicker;
import vue.component.RendererCalendar;
import vue.organizer.RendererOrganizerCalendar;
import vue.player.RendererPlayerCalendar;
import vue.referee.RendererRefereeCalendar;
import vue.stable.RendererStableCalendar;
import vue.visitor.RendererVisitorCalendar;

import java.awt.Component;
import javax.swing.Box;

public class Calendar extends DataJPanel implements vue.component.Calendar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtDate;
	private TypesPermission permission;
	private JPanel panelRoot;
	private JPanel panelContent;
	private Timestamp chosenDate ;
	private TypesGame game;
	private JLabel ifEmpty = new JLabel();
	private JLabel lblTitle;
	private JComboBox<TypesGame> comboBoxFilterGame;
	private List<RendererCalendar> renderer;
	
	public void createListTournament(Timestamp date, TypesGame jeu) {
		panelContent.removeAll();
		chosenDate = date;
		game = jeu;
		this.renderer = new LinkedList<RendererCalendar>();
		ArrayList<TypesTournament> tournoisfiltreJeu = MasterFrame.getInstance().getUser().getData().listFilteredTournament(date, jeu);
		System.out.println(tournoisfiltreJeu.isEmpty());
		if(tournoisfiltreJeu.isEmpty() || tournoisfiltreJeu == null ) {
			ifEmpty.setText("Il n'existe aucun tournoi correspondant aux critères recherchés");
			ifEmpty.setForeground(MasterFrame.COLOR_TEXT);
			ifEmpty.setFont(new Font("Cambria", Font.PLAIN , 20));
			panelContent.add(ifEmpty);
		} else {
			int id=0;
			for (TypesTournament t : tournoisfiltreJeu) {
				RendererCalendar rend = null;
				switch(permission) {
					case VISITOR :
						rend = new RendererVisitorCalendar(t,id);
						
						break;
					case PLAYER :
						rend = new RendererPlayerCalendar(t,id);

						break;
					case STABLE :
						rend = new RendererStableCalendar(t,id);

						break;
					case REFEREE :
						rend = new RendererRefereeCalendar(t,id);

						break;
					case ORGANIZER :
						break;
				}
				panelContent.add((JPanel) rend);
				renderer.add(rend);
				id++;
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
		dummy.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		dummy.setBorder(null);
		panelRoot.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		add(dummy, BorderLayout.NORTH);
		dummy.setLayout(new BorderLayout(0, 0));
		
		lblTitle = new JLabel();
		lblTitle.setText("Calendrier des tournois");
		lblTitle.setPreferredSize(new Dimension(5, 50));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(MasterFrame.COLOR_TEXT);
		lblTitle.setFont(new Font("Cambria", Font.BOLD, 40));
		lblTitle.setBorder(null);
		lblTitle.setBackground(new Color(96, 96, 96));
		dummy.add(lblTitle);
		
		panelContent = new JPanel();
		panelContent.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		createListTournament(null, null);
		JScrollPane scrollPaneCalendar = new JScrollPane(panelContent);
		scrollPaneCalendar.getVerticalScrollBar().setUnitIncrement(20);
		scrollPaneCalendar.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		scrollPaneCalendar.setBorder(new EmptyBorder(50, 100, 50, 100));
		panelRoot.add(scrollPaneCalendar, BorderLayout.CENTER);
			
		JPanel panelFilter = new JPanel();
		panelFilter.setBorder(new EmptyBorder(100, 100, 0, 100));
		panelFilter.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelRoot.add(panelFilter, BorderLayout.NORTH);
		panelFilter.setLayout(new GridLayout(0, 3, 200, 0));
		
		JPanel panelFilterDate = new JPanel();
		panelFilter.add(panelFilterDate);
		panelFilterDate.setLayout(new BorderLayout(0, 0));
		
		txtDate = new JTextField("Selectionnez une date");
		txtDate.setEditable(false);
		txtDate.setForeground(MasterFrame.COLOR_TEXT);
		txtDate.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		txtDate.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), new EmptyBorder(0, 10, 0, 0)));
		txtDate.setFont(new Font("Cambria", Font.PLAIN, 15));
		panelFilterDate.add(txtDate, BorderLayout.CENTER);
		txtDate.setColumns(10);
		
		
		JButton btnDate = new JButton(" ... ");
		btnDate.setBackground(MasterFrame.COLOR_MASTER);
		btnDate.setForeground(MasterFrame.COLOR_TEXT);
		btnDate.setFont(new Font("Cambria", Font.PLAIN, 15));
		btnDate.setBorder(null);
		btnDate.addActionListener(Controler.getInstance());
		btnDate.setActionCommand("CALENDAR_DATE");
		panelFilterDate.add(btnDate, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panelFilter.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_3.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		
		comboBoxFilterGame = new JComboBox<TypesGame>(TypesGame.values());
		comboBoxFilterGame.setUI((ComboBoxUI) ComboBoxRendererArrow.createUI(comboBoxFilterGame));
		comboBoxFilterGame.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		comboBoxFilterGame.setFont(new Font("Cambria", Font.PLAIN, 15));
		comboBoxFilterGame.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		comboBoxFilterGame.setForeground(MasterFrame.COLOR_TEXT);
		
		comboBoxFilterGame.addActionListener(Controler.getInstance());
		comboBoxFilterGame.setActionCommand("CALENDAR_GAMECOMBO");
		
		panel_3.add(comboBoxFilterGame);
		
	}

	@Override
	public void dataUpdate() {
		createListTournament(chosenDate, game);
	}

	public JTextField getTxtDate() {
		return txtDate;
	}
	
	public TypesGame getGame() {
		return game;
	}
	
	public Timestamp getChosenDate() {
		return chosenDate;
	}
	
	public JComboBox<TypesGame> getComboBoxFilterGame() {
		return comboBoxFilterGame;
	}
	
	public void setGame(TypesGame game) {
		this.game = game;
	}
	
	public void setChosenDate(Timestamp chosenDate) {
		this.chosenDate = chosenDate;
	}
	
	public RendererCalendar getRenderer(int id) {
		return renderer.get(id);
	}
}
