package vue;

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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import controleur.Controler;
import types.TypesImage;
import types.TypesPool;
import types.TypesTeam;
import types.TypesTournament;
import vue.component.DataJPanel;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ProgramMatchs extends DataJPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 749816653732061373L;
	private JLabel lblTournament;
	private JTable tableFinalRanking;
	private TypesTournament tournament;
	private JTable tableGroupStageA;
	private JTable tableGroupStageB;
	private JTable tableGroupStageC;
	private JTable tableGroupStageD;

	/**
	 * Create the panel.
	 */	
	public ProgramMatchs(TypesTournament tournament) {
		

		
		
		System.out.println(tournament);
		this.tournament = tournament;
		setLayout(new BorderLayout(0, 0));
		

		JPanel panelEmpty = new JPanel();
		add(panelEmpty, BorderLayout.NORTH);
		panelEmpty.setLayout(new BorderLayout(0, 0));

		lblTournament = new JLabel();
		lblTournament.setText(tournament.getName());
		lblTournament.setHorizontalAlignment(SwingConstants.CENTER);
		lblTournament.setFont(new Font("Cambria", Font.BOLD, 25));
		panelEmpty.add(lblTournament, BorderLayout.SOUTH);

		Component verticalStrutAboveTitle = Box.createVerticalStrut(20);
		panelEmpty.add(verticalStrutAboveTitle, BorderLayout.NORTH);


		
		
		
		

		String[] HeaderFinalColumn = new String[] { "Logo", "Nom de l' quipe", "Point de classement" };
		String[] HeaderGroupStageA = new String[] { "Logo", "Nom de l' quipe", "Point de classement" };
		
		
		String[] HeaderGroupStageB = new String[] { "Logo", "Nom de l' quipe", "Point de classement" };
		
		
		String[] HeaderGroupStageC = new String[] { "Logo", "Nom de l' quipe", "Point de classement" };
		
		
		String[] HeaderGroupStageD = new String[] { "Logo", "Nom de l' quipe", "Point de classement" };
		
		
		JPanel panelAllOfTable = new JPanel();
		
		JScrollPane scrollPaneWithGroupeStageAndFinalRanking = new JScrollPane(panelAllOfTable);
		//scrollPaneWithGroupeStageAndFinalRanking.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//scrollPaneWithGroupeStageAndFinalRanking.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		add(scrollPaneWithGroupeStageAndFinalRanking, BorderLayout.CENTER);
		
		//scrollPaneWithGroupeStageAndFinalRanking.add(panelAllOfTable);
		//scrollPaneWithGroupeStageAndFinalRanking.setViewportView(panelAllOfTable);
		//////add(panelAllOfTable, BorderLayout.CENTER);
		JPanel panelFinalRanking = new JPanel();
		//panelFinalRanking.setVisible(getFocusTraversalKeysEnabled());
		panelAllOfTable.setLayout(new BorderLayout(0, 0));
		panelAllOfTable.add(panelFinalRanking, BorderLayout.NORTH);
		
		panelFinalRanking.setLayout(new BorderLayout(0, 0));
		
		JPanel panelOfFinalRankingTitle = new JPanel();
		panelOfFinalRankingTitle.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panelFinalRanking.add(panelOfFinalRankingTitle, BorderLayout.NORTH);
		panelOfFinalRankingTitle.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panelOfFinalRankingTitle.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JButton btnProgram = new JButton("Voir Programme");
		
		btnProgram.addActionListener(Controler.getInstance());
		btnProgram.setActionCommand("PROGRAM_MATCH_MATCH");
		
		btnProgram.setHorizontalTextPosition(SwingConstants.CENTER);
		panel_2.add(btnProgram);
		
		JLabel lblOfFinalRankingTitle = new JLabel("Playoffs");
		lblOfFinalRankingTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblOfFinalRankingTitle.setFont(new Font("Cambria", Font.PLAIN, 30));
		lblOfFinalRankingTitle.setAlignmentY(1.0f);
		panelOfFinalRankingTitle.add(lblOfFinalRankingTitle);
		
		DefaultTableModel defaultablemodel = new DefaultTableModel(HeaderFinalColumn, 0) {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = -5126366483507988L;

			public java.lang.Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			};
		};



		tableFinalRanking = new JTable(defaultablemodel);
		tableFinalRanking.setEnabled(false);
		tableFinalRanking.setRowHeight(35);
		tableFinalRanking.setFont(new Font("Cambria", Font.PLAIN, 15));

		
		
		JScrollPane scrollPaneFinalRanking = new JScrollPane();
		scrollPaneFinalRanking.setBorder(new EmptyBorder(0, (int)(getWidthMain()/4), 0, (int)(getWidthMain()/4)));
		panelFinalRanking.add(scrollPaneFinalRanking);
		scrollPaneFinalRanking.setPreferredSize(new Dimension(200, 166));
		scrollPaneFinalRanking.add(tableFinalRanking);
		scrollPaneFinalRanking.setViewportView(tableFinalRanking);
		
		Component verticalStrutBetweenGroupStageAndFinalRanking = Box.createVerticalStrut(40);
		//panelAllOfTable.add(verticalStrutBetweenGroupStageAndFinalRanking);
		panelFinalRanking.add(verticalStrutBetweenGroupStageAndFinalRanking, BorderLayout.SOUTH);
		
		
		JPanel panelGroupStage = new JPanel();
		panelAllOfTable.add(panelGroupStage, BorderLayout.SOUTH);
		panelGroupStage.setLayout(new GridLayout(0, 4, 10, 0));
		
		JPanel panelOfGroupeA = new JPanel();

		panelGroupStage.add(panelOfGroupeA);
		panelOfGroupeA.setLayout(new BorderLayout(0, 0));

		
		
		defaultablemodel = new DefaultTableModel(HeaderGroupStageA, 0) {
					
					/**
					 * 
					 */
					private static final long serialVersionUID = -5126366483507988L;
		
					public java.lang.Class<?> getColumnClass(int column) {
						return getValueAt(0, column).getClass();
					};
		};
		
		
		tableGroupStageA = new JTable(defaultablemodel);
		tableGroupStageA.setFont(new Font("Cambria", Font.PLAIN, 10));
		tableGroupStageA.setEnabled(false);
		tableGroupStageA.setRowHeight(35);
		tableGroupStageA.setFont(new Font("Cambria", Font.PLAIN, 15));
		
		JScrollPane scrollPaneGroupStageA = new JScrollPane();
		panelOfGroupeA.add(scrollPaneGroupStageA);
		scrollPaneGroupStageA.add(tableGroupStageA);
		scrollPaneGroupStageA.setPreferredSize(new Dimension(300, 166));
		scrollPaneGroupStageA.setViewportView(tableGroupStageA);
		
		JLabel lblOfGroupATitle = new JLabel("Groupe A");
		lblOfGroupATitle.setFont(new Font("Cambria", Font.PLAIN, 30));
		lblOfGroupATitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelOfGroupeA.add(lblOfGroupATitle, BorderLayout.NORTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panelOfGroupeA.add(horizontalStrut, BorderLayout.WEST);
		
		JPanel panelOfGroupB = new JPanel();
		panelGroupStage.add(panelOfGroupB);
		panelOfGroupB.setLayout(new BorderLayout(0, 0));

		
		defaultablemodel = new DefaultTableModel(HeaderGroupStageB, 0) {
					
					/**
					 * 
					 */
					private static final long serialVersionUID = -5126366483507988L;
		
					public java.lang.Class<?> getColumnClass(int column) {
						return getValueAt(0, column).getClass();
					};
		};
		
		
		
		tableGroupStageB = new JTable(defaultablemodel);
		tableGroupStageB.setEnabled(false);
		tableGroupStageB.setRowHeight(35);
		tableGroupStageB.setFont(new Font("Cambria", Font.PLAIN, 15));
		
		JScrollPane scrollPaneGroupStageB = new JScrollPane();
		panelOfGroupB.add(scrollPaneGroupStageB, BorderLayout.CENTER);
		scrollPaneGroupStageB.add(tableGroupStageB);
		scrollPaneGroupStageB.setPreferredSize(new Dimension(300, 166));
		scrollPaneGroupStageB.setViewportView(tableGroupStageB);
		
		JLabel lblOfGroupBTitle = new JLabel("Groupe B");
		lblOfGroupBTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblOfGroupBTitle.setFont(new Font("Cambria", Font.PLAIN, 30));
		panelOfGroupB.add(lblOfGroupBTitle, BorderLayout.NORTH);
		
		JPanel panelOfGroupC = new JPanel();
		panelGroupStage.add(panelOfGroupC);
		panelOfGroupC.setLayout(new BorderLayout(0, 0));
		
		defaultablemodel = new DefaultTableModel(HeaderGroupStageC, 0) {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = -5126366483507988L;

			public java.lang.Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			};
		};
		

		tableGroupStageC = new JTable(defaultablemodel);
		tableGroupStageC.setEnabled(false);
		tableGroupStageC.setRowHeight(35);
		tableGroupStageC.setFont(new Font("Cambria", Font.PLAIN, 15));
		
		JScrollPane scrollPaneGroupStageC = new JScrollPane();
		panelOfGroupC.add(scrollPaneGroupStageC);
		scrollPaneGroupStageC.add(tableGroupStageC);
		scrollPaneGroupStageC.setPreferredSize(new Dimension(300, 166));
		scrollPaneGroupStageC.setViewportView(tableGroupStageC);
	
		JLabel lblOfGroupCTitle = new JLabel("Groupe C");
		lblOfGroupCTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblOfGroupCTitle.setFont(new Font("Cambria", Font.PLAIN, 30));
		panelOfGroupC.add(lblOfGroupCTitle, BorderLayout.NORTH);
		
		JPanel panelofGroupD = new JPanel();
		panelGroupStage.add(panelofGroupD);
		panelofGroupD.setLayout(new BorderLayout(0, 0));
		
		defaultablemodel = new DefaultTableModel(HeaderGroupStageD, 0) {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = -5126366483507988L;

			public java.lang.Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			};
		};
		
		
		tableGroupStageD = new JTable(defaultablemodel);
		tableGroupStageD.setEnabled(false);
		tableGroupStageD.setRowHeight(35);
		tableGroupStageD.setFont(new Font("Cambria", Font.PLAIN, 15));
		
		JScrollPane scrollPaneGroupStageD = new JScrollPane();
		panelofGroupD.add(scrollPaneGroupStageD);
		scrollPaneGroupStageD.add(tableGroupStageD);
		scrollPaneGroupStageD.setPreferredSize(new Dimension(300, 166));
		scrollPaneGroupStageD.setViewportView(tableGroupStageD);
		
		JLabel lblOfGroupDTitle = new JLabel("Groupe D");
		lblOfGroupDTitle.setFont(new Font("Cambria", Font.PLAIN, 30));
		lblOfGroupDTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelofGroupD.add(lblOfGroupDTitle, BorderLayout.NORTH);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panelofGroupD.add(horizontalStrut_1, BorderLayout.EAST);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panelGroupStage.add(verticalStrut);
		
		createPool();
			
	}
	
	public void createPool() {
		((DefaultTableModel)tableFinalRanking.getModel()).getDataVector().removeAllElements();
		((DefaultTableModel)tableGroupStageA.getModel()).getDataVector().removeAllElements();
		((DefaultTableModel)tableGroupStageB.getModel()).getDataVector().removeAllElements();
		((DefaultTableModel)tableGroupStageC.getModel()).getDataVector().removeAllElements();
		((DefaultTableModel)tableGroupStageD.getModel()).getDataVector().removeAllElements();
		
		
		ArrayList<TypesPool> pools = Controler.getInstance().getData().getCalendar().get(tournament.getId()).getPool();
		
		HashMap<TypesTeam,Integer> p = pools.get(4).getPoint();
		List<Entry<TypesTeam, Integer>> listSorted = new LinkedList<>(p.entrySet());
		
		Comparator<Entry<TypesTeam, Integer>> comp = new Comparator<Map.Entry<TypesTeam,Integer>>() {
			
			@Override
			public int compare(Entry<TypesTeam, Integer> o1, Entry<TypesTeam, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		}; 
		
		Collections.sort(listSorted, comp.reversed());
		
		
		Object[][] dataFinalColumn = new Object[4][3];
		DefaultTableModel model = (DefaultTableModel)tableFinalRanking.getModel();
		int i=0;
		for (Entry<TypesTeam, Integer> e : listSorted) {
			//if (p.entrySet().size()!=4) {
				model.addRow(new Object[] {"", e.getKey().getStable().getNickname(), e.getValue()});
				model.setValueAt(new ImageIcon(TypesImage.resize(e.getKey().getStable().getLogo().getImage(),35,35)), i, 0);
				//dataFinalColumn[i] = new Object[] {"", e.getKey().getStable().getNickname(), e.getValue()};
			//}
			i++;
		}
		for (int j=0; j<4-p.entrySet().size(); j++) {
			model.addRow(new Object[] {"", "A determiner", ""});
			i++;
		}

		p = pools.get(0).getPoint();
		listSorted = new LinkedList<>(p.entrySet());
		
		Collections.sort(listSorted, comp.reversed());
		Object[][] dataGroupStageA = new Object[4][3];
		model = (DefaultTableModel)tableGroupStageA.getModel();
		i=0;
		for (Entry<TypesTeam, Integer> e : listSorted) {
			model.addRow(new Object[] {"", e.getKey().getStable().getNickname(), e.getValue()});
			model.setValueAt(new ImageIcon(TypesImage.resize(e.getKey().getStable().getLogo().getImage(),35,35)), i, 0);
			//dataGroupStageA[i] = new Object[] {e.getKey().getStable().getLogo().getImage(), e.getKey().getStable().getNickname(), e.getValue()};
			i++;
		}

		p = pools.get(1).getPoint();
		listSorted = new LinkedList<>(p.entrySet());
		
		Collections.sort(listSorted, comp.reversed());
		Object[][] dataGroupStageB = new Object[4][3];
		model = (DefaultTableModel)tableGroupStageB.getModel();
		i=0;
		for (Entry<TypesTeam, Integer> e : listSorted) {
			model.addRow(new Object[] {"", e.getKey().getStable().getNickname(), e.getValue()});
			model.setValueAt(new ImageIcon(TypesImage.resize(e.getKey().getStable().getLogo().getImage(),35,35)), i, 0);
			//dataGroupStageB[i] = new Object[] {e.getKey().getStable().getLogo().getImage(), e.getKey().getStable().getNickname(), e.getValue()};
			i++;
		}
		
		p = pools.get(2).getPoint();
		Object[][] dataGroupStageC = new Object[4][3];
		listSorted = new LinkedList<>(p.entrySet());
		
		Collections.sort(listSorted, comp.reversed());
		model = (DefaultTableModel)tableGroupStageC.getModel();
		i=0;
		for (Entry<TypesTeam, Integer> e : listSorted) {
			model.addRow(new Object[] {"", e.getKey().getStable().getNickname(), e.getValue()});
			model.setValueAt(new ImageIcon(TypesImage.resize(e.getKey().getStable().getLogo().getImage(),35,35)), i, 0);
			//dataGroupStageC[i] = new Object[] {e.getKey().getStable().getLogo().getImage(), e.getKey().getStable().getNickname(), e.getValue()};
			i++;
		}
		
		p = pools.get(3).getPoint();
		Object[][] dataGroupStageD = new Object[4][3];
		listSorted = new LinkedList<>(p.entrySet());
		
		Collections.sort(listSorted, comp.reversed());
		model = (DefaultTableModel)tableGroupStageD.getModel();
		i=0;
		for (Entry<TypesTeam, Integer> e : listSorted) {
			model.addRow(new Object[] {"", e.getKey().getStable().getNickname(), e.getValue()});
			model.setValueAt(new ImageIcon(TypesImage.resize(e.getKey().getStable().getLogo().getImage(),35,35)), i, 0);
			//dataGroupStageD[i] = new Object[] {e.getKey().getStable().getLogo().getImage(), e.getKey().getStable().getNickname(), e.getValue()};
			i++;
		}
		
		((DefaultTableModel)tableFinalRanking.getModel()).fireTableDataChanged();
		((DefaultTableModel)tableGroupStageA.getModel()).fireTableDataChanged();
		((DefaultTableModel)tableGroupStageB.getModel()).fireTableDataChanged();
		((DefaultTableModel)tableGroupStageC.getModel()).fireTableDataChanged();
		((DefaultTableModel)tableGroupStageD.getModel()).fireTableDataChanged();
		
		this.revalidate();
		this.repaint();
		
		
	}

	
	public TypesTournament getTournament() {
		return tournament;
	}
	
	
	private double getWidthMain() {
		return MasterFrame.getInstance().getFrameCenterDimension().getWidth();
		
	}
	
	private double getHeightMain() {
		return MasterFrame.getInstance().getFrameCenterDimension().getHeight();
	}


	@Override
	public void dataUpdate() {
		createPool();
		this.revalidate();
		this.repaint();
		
	}
}
