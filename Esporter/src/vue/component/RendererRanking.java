package vue.component;

import javax.swing.JPanel;

import javax.swing.SwingConstants;

import types.TypesStable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class RendererRanking extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7129180901196990135L;

	/**
	 * Create the panel.
	 */
	public RendererRanking(int rank, TypesStable stable, int score) {
		setLayout(new BorderLayout(0, 0));
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLACK));
		this.setPreferredSize(new Dimension(560, 80));

		JPanel panelRanking = new JPanel();
		add(panelRanking, BorderLayout.CENTER);
		panelRanking.setLayout(new BorderLayout(0, 0));

		JPanel panelNumNameOfStable = new JPanel();
		panelRanking.add(panelNumNameOfStable, BorderLayout.WEST);
		panelNumNameOfStable.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelPosition = new JPanel();
		panelNumNameOfStable.add(panelPosition);

		JLabel lblRanking = new JLabel(String.valueOf(rank));
		lblRanking.setVerticalAlignment(SwingConstants.CENTER);
		lblRanking.setHorizontalAlignment(SwingConstants.LEFT);
		lblRanking.setFont(new Font("Cambria", Font.BOLD, 20));
		panelPosition.add(lblRanking);

		Component horizontalStrutBetweenRankName = Box.createHorizontalStrut(20);
		panelPosition.add(horizontalStrutBetweenRankName);

		JLabel lblNameStable = new JLabel(stable.getName());
		lblNameStable.setVerticalAlignment(SwingConstants.CENTER);
		lblNameStable.setFont(new Font("Cambria", Font.BOLD, 20));
		panelPosition.add(lblNameStable);

		JPanel panelOfEmpty = new JPanel();
		panelRanking.add(panelOfEmpty, BorderLayout.CENTER);
		panelOfEmpty.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelEmpty = new JPanel();
		panelOfEmpty.add(panelEmpty);

		JPanel panelNumPoint = new JPanel();
		add(panelNumPoint, BorderLayout.EAST);
		panelNumPoint.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_1_1 = new JPanel();
		panelNumPoint.add(panel_1_1);

		JLabel lblNewLabel_2 = new JLabel(String.valueOf(score)+" Points");
		lblNewLabel_2.setFont(new Font("Cambria", Font.PLAIN, 20));
		panel_1_1.add(lblNewLabel_2);

		Component verticalStrutNumPoint = Box.createVerticalStrut(20);
		add(verticalStrutNumPoint, BorderLayout.NORTH);
	}

}
