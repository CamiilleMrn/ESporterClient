package ihm.ecurie;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.plaf.ComboBoxUI;

import ihm.MasterFrame;
import ihm.component.ComboBoxRendererArrow;
import ihm.component.ComboBoxRendererCell;
import ihm.component.ComboBoxRendererEditor;
import ihm.component.EcurieInfoTeamRenderer;
import ihm.ecurie.gestionEquipe.AjouterEquipe;
import types.EcurieInfo;
import types.EquipeInfo;
import types.Jeu;

import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;

public class GestionEquipe extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2160024974466737852L;
	private JTextField txtGestionDesquipes;
	private JLabel ifEmptyTeam = new JLabel();
	private JPanel pan;
	
	private void createListTeam() {
		int self = ((EcurieInfo)MasterFrame.getInstance().getUser().getInfo()).getId();
		EcurieInfo ecurie = MasterFrame.getInstance().getUser().getData().getEcuries().get(self);
		HashMap<Integer,EquipeInfo> liste = ecurie.getEquipes();
		if(liste.isEmpty()) {
			ifEmptyTeam.setText("Cette écurie n'a pas d'équipe");
			ifEmptyTeam.setForeground(MasterFrame.COULEUR_TEXTE);
			ifEmptyTeam.setFont(new Font("Cambria", Font.PLAIN , 20));
			pan.add(ifEmptyTeam);
		}else {
			for(HashMap.Entry<Integer, EquipeInfo> set : liste.entrySet()) {
				if(set.getValue().getEcurie() == ecurie) {
					pan.add(new EcurieTeamRenderer(set.getValue()));
				}
			}
		}
	}
	
	/**
	 * Create the application.
	 */
	public GestionEquipe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		

		JPanel panelContainerHeader = new JPanel();
		add(panelContainerHeader, BorderLayout.NORTH);
		panelContainerHeader.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel.add(panel_1);
		panelContainerHeader.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 3, 200, 0));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JComboBox<Jeu> comboBox = new JComboBox<>(Jeu.values());
		comboBox.setUI((ComboBoxUI) ComboBoxRendererArrow.createUI(comboBox));
		
		panel_3.add(comboBox);
	
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel.add(panel_4);

		
		JButton AjouterUneEquipe = new JButton("Ajouter une \u00E9quipe");
		AjouterUneEquipe.setBackground(MasterFrame.COULEUR_MASTER);
		AjouterUneEquipe.setForeground(MasterFrame.COULEUR_TEXTE);

		AjouterUneEquipe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		AjouterUneEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MasterFrame.getInstance().setPanel(AjouterEquipe.class, (Jeu)comboBox.getSelectedItem());
				MasterFrame.getInstance().getMain().setVisible(true);
			}
		});

		
		panel_4.add(AjouterUneEquipe);
		
		JPanel panel_5 = new JPanel();
		panelContainerHeader.add(panel_5, BorderLayout.CENTER);
		panel_5.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		txtGestionDesquipes = new JTextField();
		txtGestionDesquipes.setBorder(null);
		txtGestionDesquipes.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		txtGestionDesquipes.setForeground(MasterFrame.COULEUR_TEXTE);
		txtGestionDesquipes.setEditable(false);
		txtGestionDesquipes.setHorizontalAlignment(SwingConstants.CENTER);
		txtGestionDesquipes.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtGestionDesquipes.setText("GESTION DES ÉQUIPES");
		panel_5.add(txtGestionDesquipes);
		txtGestionDesquipes.setColumns(15);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_6.getLayout();
		flowLayout.setVgap(15);
		panel_6.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_6.setBorder(null);
		panelContainerHeader.add(panel_6, BorderLayout.NORTH);
		
		JPanel panelContainerScrollPane = new JPanel();
		panelContainerScrollPane.setBackground(Color.PINK);
		add(panelContainerScrollPane, BorderLayout.CENTER);
		
		pan = new JPanel();
		createListTeam();
		panelContainerScrollPane.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPaneListTeam = new JScrollPane(pan);
		pan.setLayout(new GridLayout(1, 0, 0, 0));
		scrollPaneListTeam.setAlignmentY(Component.TOP_ALIGNMENT);
		scrollPaneListTeam.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		scrollPaneListTeam.setBorder(new EmptyBorder(50, 100, 50, 100));
		panelContainerScrollPane.add(scrollPaneListTeam);
		
		
		
	}

}

