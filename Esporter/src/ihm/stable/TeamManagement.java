package ihm.stable;
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

import ihm.MasterFrame;
import ihm.component.ComboBoxRendererArrow;
import ihm.component.ComboBoxRendererCell;
import ihm.component.ComboBoxRendererEditor;
import ihm.component.DataJPanel;
import ihm.component.RendererStable;
import ihm.component.RendererTeamStableInfo;
import ihm.stable.management.AddTeam;
import types.TypesGame;
import types.TypesStable;
import types.TypesTeam;

import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.HashMap;
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
	
	private void createListTeam() {
		int self = ((TypesStable)MasterFrame.getInstance().getUser().getInfo()).getId();
		 for (TypesTeam value : MasterFrame.getInstance().getUser().getData().getStables().get(self).getTeams().values()) {
		        System.out.println(value);
		    }
		TypesStable ecurie = MasterFrame.getInstance().getUser().getData().getStables().get(self);
		HashMap<Integer,TypesTeam> liste = ecurie.getTeams();
		if(liste.isEmpty()) {
			ifEmptyTeam.setText("Cette écurie n'a pas d'équipe");
			ifEmptyTeam.setForeground(MasterFrame.COULEUR_TEXTE);
			ifEmptyTeam.setFont(new Font("Cambria", Font.PLAIN , 20));
			pan.add(ifEmptyTeam);
		}else {
			 for (TypesTeam value : MasterFrame.getInstance().getUser().getData().getStables().get(self).getTeams().values()) {
			        System.out.println("else : "+value);
			    }
			for(HashMap.Entry<Integer, TypesTeam> set : MasterFrame.getInstance().getUser().getData().getStables().get(self).getTeams().entrySet()) {
				if(set.getValue().getStable().equals(ecurie)) {
					System.out.println("TeamManagment : " + set.getValue());
					pan.add(new RendererTeamStableManagement(set.getValue()));
				}
				System.out.println("team "+set.getValue()+" stable : "+set.getValue().getStable()+" Expected : "+ecurie);
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
		panelButton.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		JPanel panelDummy = new JPanel();
		panelDummy.setBorder(null);
		panelDummy.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelButton.add(panelDummy);
		panelHead.add(panelButton, BorderLayout.SOUTH);
		panelButton.setLayout(new GridLayout(0, 3, 200, 0));
		
		JPanel panelFilter = new JPanel();
		panelButton.add(panelFilter);
		panelFilter.setLayout(new BorderLayout(0, 0));
		
		JComboBox<TypesGame> comboBoxFilterGame = new JComboBox<>(TypesGame.values());
		comboBoxFilterGame.setUI((ComboBoxUI) ComboBoxRendererArrow.createUI(comboBoxFilterGame));
		
		panelFilter.add(comboBoxFilterGame);
	
		JPanel panelAddTeam = new JPanel();
		panelAddTeam.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelButton.add(panelAddTeam);

		
		JButton btnAddTeam = new JButton("Ajouter une \u00E9quipe");
		btnAddTeam.setBackground(MasterFrame.COULEUR_MASTER);
		btnAddTeam.setForeground(MasterFrame.COULEUR_TEXTE);

		btnAddTeam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MasterFrame.getInstance().setPanel(AddTeam.class, (TypesGame)comboBoxFilterGame.getSelectedItem());
				MasterFrame.getInstance().getMain().setVisible(true);
			}
		});

		
		panelAddTeam.add(btnAddTeam);
		
		JPanel panelTitle = new JPanel();
		panelHead.add(panelTitle, BorderLayout.CENTER);
		panelTitle.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		lblTitle = new JLabel();
		lblTitle.setBorder(null);
		lblTitle.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		lblTitle.setForeground(MasterFrame.COULEUR_TEXTE);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitle.setText("GESTION DES ÉQUIPES");
		panelTitle.add(lblTitle);
		
		JPanel panelDummyTop = new JPanel();
		FlowLayout fl_panelDummyTop = (FlowLayout) panelDummyTop.getLayout();
		fl_panelDummyTop.setVgap(15);
		panelDummyTop.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelDummyTop.setBorder(null);
		panelHead.add(panelDummyTop, BorderLayout.NORTH);
		

		JPanel panelContainerScrollPane = new JPanel();
		panelContainerScrollPane.setLayout(new BorderLayout());
		add(panelContainerScrollPane, BorderLayout.CENTER);
		
		pan = new JPanel();
		pan.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		createListTeam();
		JScrollPane scrollPaneListTeam = new JScrollPane(pan);
		pan.setLayout(new GridLayout(0, 1, 0, 0));
		scrollPaneListTeam.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		scrollPaneListTeam.setBorder(new EmptyBorder(50, 100, 50, 100));
		panelContainerScrollPane.add(scrollPaneListTeam);
	}

	@Override
	public void dataUpdate() {
		createListTeam();
	}

}

