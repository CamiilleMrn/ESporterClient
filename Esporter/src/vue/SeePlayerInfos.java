package vue;

import javax.swing.JPanel;

import types.TypesTeam;
import vue.component.DataJPanel;
import vue.component.SeePlayerInfosRenderer;
import types.TypesPlayer;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;

import controleur.Controler;

public class SeePlayerInfos extends DataJPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TypesTeam team;
	private JPanel pan;

	/**
	 * Create the application.
	 * @param ecurie 
	 */
	
	private void createListPlayer() {
		pan.removeAll();
		HashMap<Integer,TypesPlayer> liste = Controler.getInstance().getData().getStables().get(team.getStable().getId()).getTeams().get(team.getId()).getPlayers();
		for(Entry<Integer, TypesPlayer> set : liste.entrySet()) {
			pan.add(new SeePlayerInfosRenderer(set.getValue()));
		}	
	}
	
	public SeePlayerInfos(TypesTeam equipe) {
		this.team = equipe;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel_ContainerTree = new JPanel();
		panel_ContainerTree.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		add(panel_ContainerTree);
		
		JPanel panel = new JPanel();
		panel.setForeground(MasterFrame.COLOR_TEXT);
		panel.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		add(panel);
		panel_ContainerTree.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_Tree = new JPanel();
		panel_Tree.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		FlowLayout fl_panel_Tree = (FlowLayout) panel_Tree.getLayout();
		fl_panel_Tree.setAlignment(FlowLayout.LEFT);
		panel_ContainerTree.add(panel_Tree);
		
		JButton btn_ecurieTree = new JButton("Ecuries /");
		btn_ecurieTree.setBorder(null);
		btn_ecurieTree.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		btn_ecurieTree.setForeground(MasterFrame.COLOR_MASTER);
		btn_ecurieTree.setFont(new Font("Cambria", Font.PLAIN, 20));
		btn_ecurieTree.addActionListener(Controler.getInstance());
		btn_ecurieTree.setActionCommand("PLAYER_INFO_STABLE");
		panel_Tree.add(btn_ecurieTree);
		JButton btn_voirInfoTree = new JButton(team.getStable().getName() +"/");
		btn_voirInfoTree.setBorder(null);
		btn_voirInfoTree.setForeground(MasterFrame.COLOR_MASTER);
		btn_voirInfoTree.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		btn_voirInfoTree.setForeground(MasterFrame.COLOR_MASTER);
		btn_voirInfoTree.setFont(new Font("Cambria", Font.PLAIN, 20));
		btn_voirInfoTree.addActionListener(Controler.getInstance());
		btn_voirInfoTree.setActionCommand("PLAYER_INFO_TEAM");
		panel_Tree.add(btn_voirInfoTree);
		
		JLabel lbl_equipeTree = new JLabel("Composition Equipe");
		lbl_equipeTree.setForeground(MasterFrame.COLOR_TEXT);
		lbl_equipeTree.setFont(new Font("Cambria", Font.PLAIN, 20));
		panel_Tree.add(lbl_equipeTree);
		
		JLabel lblNewLabel = new JLabel(team.getStable().getNickname() +" " + team.getGame() + " joueurs");
		lblNewLabel.setForeground(MasterFrame.COLOR_TEXT);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 40));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		pan = new JPanel();
		createListPlayer();
		JScrollPane scrollPane = new JScrollPane(pan);
		scrollPane.setBorder(null);
		pan.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_1.add(scrollPane, BorderLayout.NORTH);
		
		
	}

	@Override
	public void dataUpdate() {
		createListPlayer();
		this.revalidate();
		this.repaint();
	}
	
	public TypesTeam getTeam() {
		return team;
	}
}
