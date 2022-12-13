package ihm.component;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import types.TypesTournament;

import java.awt.Rectangle;

public class ProgramMatchs extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 749816653732061373L;
	private JLabel lblTournament;
	private JTable tableFinalRanking;
	private TypesTournament tournament;

	/**
	 * Create the panel.
	 */	
	public ProgramMatchs(TypesTournament tournament) {
		this.tournament = tournament;
		setLayout(new BorderLayout(0, 0));
		

		JPanel panelEmpty = new JPanel();
		add(panelEmpty, BorderLayout.NORTH);
		panelEmpty.setLayout(new BorderLayout(0, 0));

		lblTournament = new JLabel();
		lblTournament.setText("Tournoi X");
		lblTournament.setHorizontalAlignment(SwingConstants.CENTER);
		lblTournament.setFont(new Font("Cambria", Font.BOLD, 25));
		panelEmpty.add(lblTournament, BorderLayout.SOUTH);

		Component verticalStrutAboveTitle = Box.createVerticalStrut(20);
		panelEmpty.add(verticalStrutAboveTitle, BorderLayout.NORTH);

		JScrollPane scrollPaneWithGroupeStageAndFinalRanking = new JScrollPane();
		add(scrollPaneWithGroupeStageAndFinalRanking, BorderLayout.CENTER);
		//System.out.println("hello");
		String[] HeaderFinalColumn = new String[] { "Logo", "Nom de l'équipe", "Point de classement" };
		Object[][] dataFinalColumn = new Object[][] { { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, };
		
		String[] HeaderGroupStageA = new String[] { "Logo", "Nom de l'équipe", "Point de classement" };
		Object[][] dataGroupStageA = new Object[][] { { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, };
		
		String[] HeaderGroupStageB = new String[] { "Logo", "Nom de l'équipe", "Point de classement" };
		Object[][] dataGroupStageB = new Object[][] { { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, };
		
		String[] HeaderGroupStageC = new String[] { "Logo", "Nom de l'équipe", "Point de classement" };
		Object[][] dataGroupStageC = new Object[][] { { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, };
		
		String[] HeaderGroupStageD = new String[] { "Logo", "Nom de l'équipe", "Point de classement" };
		Object[][] dataGroupStageD = new Object[][] { { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, };
		
		JPanel panelAllOfTable = new JPanel();
		scrollPaneWithGroupeStageAndFinalRanking.add(panelAllOfTable);
		scrollPaneWithGroupeStageAndFinalRanking.setViewportView(panelAllOfTable);
		panelAllOfTable.setLayout(new GridLayout(0, 1, 0, -100));
		JPanel panelFinalRanking = new JPanel();
		panelFinalRanking.setVisible(getFocusTraversalKeysEnabled());
		panelAllOfTable.add(panelFinalRanking);
		panelFinalRanking.setLayout(new GridLayout(2, 3, 0, 5));
		
		JPanel panelOfFinalRankingTitle = new JPanel();
		panelOfFinalRankingTitle.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panelFinalRanking.add(panelOfFinalRankingTitle);
		GridBagLayout gbl_panelOfFinalRankingTitle = new GridBagLayout();
		gbl_panelOfFinalRankingTitle.columnWidths = new int[] {0};
		gbl_panelOfFinalRankingTitle.rowHeights = new int[] {0};
		gbl_panelOfFinalRankingTitle.columnWeights = new double[]{0.0};
		gbl_panelOfFinalRankingTitle.rowWeights = new double[]{0.0};
		panelOfFinalRankingTitle.setLayout(gbl_panelOfFinalRankingTitle);
		
		JLabel lblOfFinalRankingTitle = new JLabel("Playoffs");
		lblOfFinalRankingTitle.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblOfFinalRankingTitle.setFont(new Font("Cambria", Font.PLAIN, 30));
		GridBagConstraints gbc_lblOfFinalRankingTitle = new GridBagConstraints();
		gbc_lblOfFinalRankingTitle.insets = new Insets(125, 0, 0, 0);
		gbc_lblOfFinalRankingTitle.fill = GridBagConstraints.BOTH;
		gbc_lblOfFinalRankingTitle.gridx = 0;
		gbc_lblOfFinalRankingTitle.gridy = 0;
		panelOfFinalRankingTitle.add(lblOfFinalRankingTitle, gbc_lblOfFinalRankingTitle);
		
		tableFinalRanking = new JTable(dataFinalColumn, HeaderFinalColumn);
		tableFinalRanking.setEnabled(false);
		tableFinalRanking.setRowHeight(35);
		tableFinalRanking.setFont(new Font("Cambria", Font.PLAIN, 15));
		
		
		JScrollPane scrollPaneFinalRanking = new JScrollPane();
		scrollPaneFinalRanking.setBorder(new EmptyBorder(0, 600, 0, 600));
		panelFinalRanking.add(scrollPaneFinalRanking);
		scrollPaneFinalRanking.setPreferredSize(new Dimension(400, 166));
		scrollPaneFinalRanking.add(tableFinalRanking);
		scrollPaneFinalRanking.setViewportView(tableFinalRanking);
		
		Component verticalStrutBetweenGroupStageAndFinalRanking = Box.createVerticalStrut(0);
		panelAllOfTable.add(verticalStrutBetweenGroupStageAndFinalRanking);

		JPanel panelGroupStage = new JPanel();
		panelAllOfTable.add(panelGroupStage);
		panelGroupStage.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		Component horizontalStrutBeforeGroupStageA = Box.createHorizontalStrut(20);
		panelGroupStage.add(horizontalStrutBeforeGroupStageA);
		
		JPanel panelOfGroupeA = new JPanel();
		panelGroupStage.add(panelOfGroupeA);
		panelOfGroupeA.setLayout(new BorderLayout(0, 0));

		JTable tableGroupStageA = new JTable( dataGroupStageA,HeaderGroupStageA);
		tableGroupStageA.setFont(new Font("Cambria", Font.PLAIN, 10));
		tableGroupStageA.setEnabled(false);
		tableGroupStageA.setRowHeight(35);
		tableGroupStageA.setFont(new Font("Cambria", Font.PLAIN, 15));
		
		JScrollPane scrollPaneGroupStageA = new JScrollPane();
		panelOfGroupeA.add(scrollPaneGroupStageA);
		scrollPaneGroupStageA.add(tableGroupStageA);
		scrollPaneGroupStageA.setPreferredSize(new Dimension(400, 166));
		scrollPaneGroupStageA.setViewportView(tableGroupStageA);
		
		JLabel lblOfGroupATitle = new JLabel("Groupe A");
		lblOfGroupATitle.setFont(new Font("Cambria", Font.PLAIN, 30));
		lblOfGroupATitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelOfGroupeA.add(lblOfGroupATitle, BorderLayout.NORTH);
	
		Component horizontalStrutBetweenAB = Box.createHorizontalStrut(20);
		panelGroupStage.add(horizontalStrutBetweenAB);
		
		JPanel panelOfGroupB = new JPanel();
		panelGroupStage.add(panelOfGroupB);
		panelOfGroupB.setLayout(new BorderLayout(0, 0));

		JTable tableGroupStageB = new JTable(dataGroupStageB,HeaderGroupStageB);
		tableGroupStageB.setEnabled(false);
		tableGroupStageB.setRowHeight(35);
		tableGroupStageB.setFont(new Font("Cambria", Font.PLAIN, 15));
		
		JScrollPane scrollPaneGroupStageB = new JScrollPane();
		panelOfGroupB.add(scrollPaneGroupStageB, BorderLayout.CENTER);
		scrollPaneGroupStageB.add(tableGroupStageB);
		scrollPaneGroupStageB.setPreferredSize(new Dimension(400, 166));
		scrollPaneGroupStageB.setViewportView(tableGroupStageB);
		
		JLabel lblOfGroupBTitle = new JLabel("Groupe B");
		lblOfGroupBTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblOfGroupBTitle.setFont(new Font("Cambria", Font.PLAIN, 30));
		panelOfGroupB.add(lblOfGroupBTitle, BorderLayout.NORTH);
		
		Component horizontalStrutBetweenBC = Box.createHorizontalStrut(20);
		panelGroupStage.add(horizontalStrutBetweenBC);
		
		JPanel panelOfGroupC = new JPanel();
		panelGroupStage.add(panelOfGroupC);
		panelOfGroupC.setLayout(new BorderLayout(0, 0));
		
		JTable tableGroupStageC = new JTable(dataGroupStageC,HeaderGroupStageC);
		tableGroupStageC.setEnabled(false);
		tableGroupStageC.setRowHeight(35);
		tableGroupStageC.setFont(new Font("Cambria", Font.PLAIN, 15));
		
		JScrollPane scrollPaneGroupStageC = new JScrollPane();
		panelOfGroupC.add(scrollPaneGroupStageC);
		scrollPaneGroupStageC.add(tableGroupStageC);
		scrollPaneGroupStageC.setPreferredSize(new Dimension(400, 166));
		scrollPaneGroupStageC.setViewportView(tableGroupStageC);
	
		JLabel lblOfGroupCTitle = new JLabel("Groupe C");
		lblOfGroupCTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblOfGroupCTitle.setFont(new Font("Cambria", Font.PLAIN, 30));
		panelOfGroupC.add(lblOfGroupCTitle, BorderLayout.NORTH);
		
		Component horizontalStrutBetweenCD = Box.createHorizontalStrut(20);
		panelGroupStage.add(horizontalStrutBetweenCD);
		
		JPanel panelofGroupD = new JPanel();
		panelGroupStage.add(panelofGroupD);
		panelofGroupD.setLayout(new BorderLayout(0, 0));
		
		JTable tableGroupStageD = new JTable(dataGroupStageD,HeaderGroupStageD);
		tableGroupStageD.setEnabled(false);
		tableGroupStageD.setRowHeight(35);
		tableGroupStageD.setFont(new Font("Cambria", Font.PLAIN, 15));
		
		JScrollPane scrollPaneGroupStageD = new JScrollPane();
		panelofGroupD.add(scrollPaneGroupStageD);
		scrollPaneGroupStageD.add(tableGroupStageD);
		scrollPaneGroupStageD.setPreferredSize(new Dimension(400, 166));
		scrollPaneGroupStageD.setViewportView(tableGroupStageD);
		
		JLabel lblOfGroupDTitle = new JLabel("Groupe D");
		lblOfGroupDTitle.setFont(new Font("Cambria", Font.PLAIN, 30));
		lblOfGroupDTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelofGroupD.add(lblOfGroupDTitle, BorderLayout.NORTH);
		
		Component horizontalStrutAfterGroupStageD = Box.createHorizontalStrut(20);
		panelGroupStage.add(horizontalStrutAfterGroupStageD);
			
	}
}
