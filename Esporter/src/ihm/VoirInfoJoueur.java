package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ihm.component.DataJPanel;
import ihm.component.EcurieInfoTeamRenderer;
import ihm.component.VoirInfoPlayerRenderer;
import types.TypesTeam;
import types.TypesPlayer;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;

public class VoirInfoJoueur extends DataJPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TypesTeam equipe;
	private JPanel pan;

	/**
	 * Create the application.
	 * @param ecurie 
	 */
	
	private void createListPlayer() {
		HashMap<Integer,TypesPlayer> liste = equipe.getPlayers();
		System.out.println(liste.isEmpty());
		for(Entry<Integer, TypesPlayer> set : liste.entrySet()) {
			System.out.println(set.getValue());
			pan.add(new VoirInfoPlayerRenderer(set.getValue()));
		}	
	}
	
	public VoirInfoJoueur(TypesTeam equipe) {
		this.equipe = equipe;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel_ContainerTree = new JPanel();
		panel_ContainerTree.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		add(panel_ContainerTree);
		
		JPanel panel = new JPanel();
		panel.setForeground(MasterFrame.COULEUR_TEXTE);
		panel.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		add(panel);
		panel_ContainerTree.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_Tree = new JPanel();
		panel_Tree.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		FlowLayout fl_panel_Tree = (FlowLayout) panel_Tree.getLayout();
		fl_panel_Tree.setAlignment(FlowLayout.LEFT);
		panel_ContainerTree.add(panel_Tree);
		
		JButton btn_ecurieTree = new JButton("Ecuries /");
		btn_ecurieTree.setBorder(null);
		btn_ecurieTree.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		btn_ecurieTree.setForeground(MasterFrame.COULEUR_MASTER);
		btn_ecurieTree.setFont(new Font("Cambria", Font.PLAIN, 20));
		btn_ecurieTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MasterFrame.getInstance().setPanel(ihm.Stables.class, null);
			}
		});
		panel_Tree.add(btn_ecurieTree);
		JButton btn_voirInfoTree = new JButton(equipe.getStable().getName() +"/");
		btn_voirInfoTree.setBorder(null);
		btn_voirInfoTree.setForeground(MasterFrame.COULEUR_MASTER);
		btn_voirInfoTree.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		btn_voirInfoTree.setForeground(MasterFrame.COULEUR_MASTER);
		btn_voirInfoTree.setFont(new Font("Cambria", Font.PLAIN, 20));
		btn_voirInfoTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MasterFrame.getInstance().setPanel(ihm.StableInfo.class, equipe.getStable());
			}
		});
		panel_Tree.add(btn_voirInfoTree);
		
		JLabel lbl_equipeTree = new JLabel("Composition Equipe");
		lbl_equipeTree.setForeground(MasterFrame.COULEUR_TEXTE);
		lbl_equipeTree.setFont(new Font("Cambria", Font.PLAIN, 20));
		panel_Tree.add(lbl_equipeTree);
		
		JLabel lblNewLabel = new JLabel(equipe.getStable().getNickname() +" " + equipe.getGame() + " joueurs");
		lblNewLabel.setForeground(MasterFrame.COULEUR_TEXTE);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 40));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		pan = new JPanel();
		createListPlayer();
		JScrollPane scrollPane = new JScrollPane(pan);
		scrollPane.setBorder(null);
		pan.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_1.add(scrollPane, BorderLayout.NORTH);
		
		
	}

	@Override
	public void dataUpdate() {
		createListPlayer();
	}
}
