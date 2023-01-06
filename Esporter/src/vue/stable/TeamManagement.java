package vue.stable;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.plaf.ComboBoxUI;

import controleur.Controler;
import types.TypesGame;
import types.TypesStable;
import types.TypesTeam;
import vue.MasterFrame;
import vue.component.ComboBoxRendererArrow;
import vue.component.ComboBoxRendererCell;
import vue.component.ComboBoxRendererEditor;
import vue.component.DataJPanel;
import vue.component.RendererStable;
import vue.component.RendererTeamStableInfo;
import vue.stable.management.AddTeam;

import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;

public class TeamManagement extends DataJPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2160024974466737852L;
	private JList<String> tournamentList;
	private JLabel lblTitle;
	private AbstractButton ifEmptyTeam;
	private JPanel pan;
	private JComboBox<TypesGame> comboBoxFilterGame;
	private TypesGame filterGame = null;
	private LinkedList<RendererTeamStableManagement> pans;
	
	private void createListTeam(TypesGame game) {
		pan.removeAll();
		pans = new LinkedList<>();
		int self = ((TypesStable)MasterFrame.getInstance().getUser().getInfo()).getId();
		TypesStable ecurie = MasterFrame.getInstance().getUser().getData().getStables().get(self);
		HashMap<Integer,TypesTeam> liste = ecurie.getTeams();
		if(liste.isEmpty()) {
			ifEmptyTeam.setText("Cette écurie n'a pas d'équipe");
			ifEmptyTeam.setForeground(MasterFrame.COLOR_TEXT);
			ifEmptyTeam.setFont(new Font("Cambria", Font.PLAIN , 20));
			pan.add(ifEmptyTeam);
		}else {
			 /*for (TypesTeam value : ecurie.getTeams().values()) {
			        System.out.println("else : "+value);
			    }*/
			int id = 0;
			for(TypesTeam team : liste.values()) {
				if(team.getStable().equals(ecurie)) {
					//System.out.println("TeamManagment : " + set.getValue());
					if(game==null || team.getGame()==game) {
						RendererTeamStableManagement rend = new RendererTeamStableManagement(team,id);
						pan.add(rend);
						pans.add(rend);
						id++;
					}
				}
				//System.out.println("team "+set.getValue()+" stable : "+set.getValue().getStable()+" Expected : "+ecurie);
			}
		}
	}
	
	/**
	 * Create the application.
	 */
	public TeamManagement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		

		JPanel panelHead = new JPanel();
		add(panelHead, BorderLayout.NORTH);
		panelHead.setLayout(new BorderLayout(0, 0));
		
		JPanel panelButton = new JPanel();
		panelButton.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		JPanel panelDummy = new JPanel();
		panelDummy.setBorder(null);
		panelDummy.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelButton.add(panelDummy);
		panelHead.add(panelButton, BorderLayout.SOUTH);
		panelButton.setLayout(new GridLayout(0, 3, 200, 0));
		
		JPanel panelFilter = new JPanel();
		panelButton.add(panelFilter);
		panelFilter.setLayout(new BorderLayout(0, 0));
		
		comboBoxFilterGame = new JComboBox<>(TypesGame.values());
		comboBoxFilterGame.setUI((ComboBoxUI) ComboBoxRendererArrow.createUI(comboBoxFilterGame));
		comboBoxFilterGame.addActionListener(Controler.getInstance());
		comboBoxFilterGame.setActionCommand("STABLE_MANAGEMENT_COMBO");
		panelFilter.add(comboBoxFilterGame);
	
		JPanel panelAddTeam = new JPanel();
		panelAddTeam.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelButton.add(panelAddTeam);

		
		JButton btnAddTeam = new JButton("Ajouter une \u00E9quipe");
		btnAddTeam.setBackground(MasterFrame.COLOR_MASTER);
		btnAddTeam.setForeground(MasterFrame.COLOR_TEXT_MENU);

		btnAddTeam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddTeam.addActionListener(Controler.getInstance());
		btnAddTeam.setActionCommand("STABLE_MANAGEMENT_ADDTEAM");

		
		panelAddTeam.add(btnAddTeam);
		
		JPanel panelTitle = new JPanel();
		panelHead.add(panelTitle, BorderLayout.CENTER);
		panelTitle.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		lblTitle = new JLabel();
		lblTitle.setBorder(null);
		lblTitle.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		lblTitle.setForeground(MasterFrame.COLOR_TEXT);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitle.setText("GESTION DES ÉQUIPES");
		panelTitle.add(lblTitle);
		
		JPanel panelDummyTop = new JPanel();
		FlowLayout fl_panelDummyTop = (FlowLayout) panelDummyTop.getLayout();
		fl_panelDummyTop.setVgap(15);
		panelDummyTop.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelDummyTop.setBorder(null);
		panelHead.add(panelDummyTop, BorderLayout.NORTH);
		

		JPanel panelContainerScrollPane = new JPanel();
		panelContainerScrollPane.setLayout(new BorderLayout());
		add(panelContainerScrollPane, BorderLayout.CENTER);
		
		pan = new JPanel();
		pan.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		createListTeam(filterGame);
		JScrollPane scrollPaneListTeam = new JScrollPane(pan);
		pan.setLayout(new GridLayout(0, 1, 0, 0));
		scrollPaneListTeam.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		scrollPaneListTeam.setBorder(new EmptyBorder(50, 100, 50, 100));
		panelContainerScrollPane.add(scrollPaneListTeam);
	}

	@Override
	public void dataUpdate() {
		createListTeam(filterGame);
	}
	
	public JComboBox<TypesGame> getComboBoxFilterGame() {
		return comboBoxFilterGame;
	}
	
	public void setFilterGame(TypesGame game) {
		System.out.println(game);
		filterGame = game;
		dataUpdate();
		revalidate();
		repaint();
	}
	
	public RendererTeamStableManagement getRenderer(int id) {
		return pans.get(id);
	}

}

