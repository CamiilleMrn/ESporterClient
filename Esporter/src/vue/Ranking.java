package vue;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controleur.Controler;
import types.TypesGame;
import types.TypesRanking;
import types.TypesStable;
import vue.component.DataJPanel;
import vue.component.RendererRanking;

import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.JScrollPane;

public class Ranking extends DataJPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2582357904692590601L;
	private JPanel panelContent;
	private JComboBox<TypesGame> comboBoxGame;
	
	public void createListRenderer(TypesGame game) {
		TypesRanking rank = null;
		panelContent.removeAll();
		for(TypesRanking r : Controler.getInstance().getData().getRanking().values()) {
			if(r.getGame() == game) {
				rank = r;
				break;
			}
		}
		if(rank == null) {
			JLabel empty = new JLabel();
			empty.setText("Aucune écurie ne possède d'équipe pour ce jeux");
			empty.setForeground(MasterFrame.COLOR_TEXT);
			empty.setFont(new Font("Cambria", Font.PLAIN , 20));
			panelContent.add(empty);
		} else {
			 HashMap<TypesStable, Integer> allSt = rank.getStables();
			 for(int ranking : rank.getRanking().keySet()) {
				 for(TypesStable stable : rank.getRanking().get(ranking)) {
					 panelContent.add(new RendererRanking(ranking, stable, allSt.get(stable)));
				 }
				 
			 }
			 
		}
		panelContent.setLayout(new GridLayout(0, 1));
		panelContent.revalidate();
	}
	
	
	
	public Ranking() {
		setLayout(new BorderLayout(0, 0));
		setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		JPanel panelTitle = new JPanel();
		add(panelTitle, BorderLayout.NORTH);
		panelTitle.setLayout(new BorderLayout(0, 0));
		
		JPanel panelGame = new JPanel();
		panelTitle.add(panelGame, BorderLayout.SOUTH);
		panelGame.setLayout(new BorderLayout(0, 0));
		panelGame.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		
		JPanel panel_3 = new JPanel();
		panelGame.add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_3.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		
		JPanel panel_1 = new JPanel();
		panel_3.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		panel_1.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		
		Component verticalStrut = Box.createVerticalStrut(10);
		panel_1.add(verticalStrut);
		
		comboBoxGame = new JComboBox<TypesGame>(TypesGame.values());
		comboBoxGame.setActionCommand("RANKING_COMBOGAME");
		comboBoxGame.addActionListener(Controler.getInstance());
		panel_1.add(comboBoxGame);
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(220, 50));
		panel_3.revalidate();
		panel_3.add(panel_4, BorderLayout.WEST);
		panel_4.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		
		JPanel panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(50, 60));
		panel_3.revalidate();
		panel_3.add(panel_5, BorderLayout.NORTH);
		panel_5.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		
		JPanel panel = new JPanel();
		panelTitle.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelTitle.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		
		Component strutTitle = Box.createVerticalStrut(20);
		panel.add(strutTitle, BorderLayout.NORTH);
		
		JLabel lblTitleStable = new JLabel("Classement");
		lblTitleStable.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleStable.setForeground(MasterFrame.COLOR_TEXT);
		lblTitleStable.setFont(new Font("Cambria", Font.BOLD, 40));
		panel.add(lblTitleStable);
		
		panelContent = new JPanel();
		panelContent.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		createListRenderer((TypesGame)comboBoxGame.getSelectedItem());
		
		
		JScrollPane scrollPane = new JScrollPane(panelContent);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		scrollPane.setBorder(null);
		add(scrollPane, BorderLayout.CENTER);

		double width = MasterFrame.getInstance().getFrameCenterDimension().getWidth();
		double height = MasterFrame.getInstance().getFrameCenterDimension().getHeight();
		Component horizontalStrut = Box.createHorizontalStrut(((int)width/4));
		add(horizontalStrut, BorderLayout.EAST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(((int)width/4));
		add(horizontalStrut_1, BorderLayout.WEST);
		
		Component verticalStrut_1 = Box.createVerticalStrut(((int)height/10));
		add(verticalStrut_1, BorderLayout.SOUTH);

		
		
		
		
	}
	
	public JComboBox<TypesGame> getComboBoxGame() {
		return comboBoxGame;
	}



	@Override
	public void dataUpdate() {
		createListRenderer((TypesGame)comboBoxGame.getSelectedItem());
		
	}
	
	
	

}
