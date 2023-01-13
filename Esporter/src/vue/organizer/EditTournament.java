package vue.organizer;

import java.awt.EventQueue;


import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.ComboBoxUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JTable;


import controleur.Controler;
import vue.MasterFrame;
import vue.component.ComboBoxRendererArrow;
import vue.component.DatePicker;
import types.TypesGame;
import types.TypesTeam;
import types.TypesTournament;
import types.exception.ExceptionInvalidPermission;
import types.TypesFame;

import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EditTournament extends JPanel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3520166225301312734L;
	private JLabel lblPageTitle;
	private JPanel all;
	private JTextField txtDateStartTournament;
	private JTextField txtTournamentName;
	private TypesTournament tournament;
	private JComboBox<TypesGame> comboBoxGame;
	private JComboBox<TypesFame> comboBoxFame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public EditTournament(TypesTournament tournament) {
		this.tournament = tournament;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		all = new JPanel();
		all.setBounds(100, 100, 300, 187);
		all.setLayout(new BorderLayout(0, 0));
		setLayout(new GridLayout(0, 1, 0, 0));
		JPanel panel_PageTitle = new JPanel();
		panel_PageTitle.setForeground(MasterFrame.COLOR_TEXT);
		panel_PageTitle.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		add(panel_PageTitle);
		panel_PageTitle.setLayout(new BorderLayout(0, 0));
		
		lblPageTitle = new JLabel();
		lblPageTitle.setBorder(null);
		lblPageTitle.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		lblPageTitle.setForeground(MasterFrame.COLOR_TEXT);
		lblPageTitle.setFont(new Font("Cambria", Font.BOLD, 40));
		lblPageTitle.setText("Modifier un tournoi");
		lblPageTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel_PageTitle.add(lblPageTitle);
		
		JPanel panel_Table = new JPanel();
		add(panel_Table);
		panel_Table.setLayout(new GridLayout(1, 7, 0, 0));
		
		JPanel panel_BorderLeft = new JPanel();
		panel_BorderLeft.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_Table.add(panel_BorderLeft);
		
		JPanel panel_Column1 = new JPanel();
		panel_Column1.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_Table.add(panel_Column1);
		panel_Column1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_TitleColumn1 = new JPanel();
		panel_TitleColumn1.setBorder(null);
		panel_TitleColumn1.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_Column1.add(panel_TitleColumn1);
		panel_TitleColumn1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_lblColumn1 = new JPanel();
		panel_lblColumn1.setBorder(new MatteBorder(0, 2, 2, 2, MasterFrame.COLOR_MASTER));
		panel_lblColumn1.setBackground(Color.BLACK);
		panel_TitleColumn1.add(panel_lblColumn1, BorderLayout.SOUTH);
		
		JLabel lblColumnNameOfTournoi = new JLabel();
		lblColumnNameOfTournoi.setVerticalAlignment(SwingConstants.BOTTOM);
		lblColumnNameOfTournoi.setText("Nom du tournois");
		lblColumnNameOfTournoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblColumnNameOfTournoi.setForeground(MasterFrame.COLOR_TEXT_MENU);
		lblColumnNameOfTournoi.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblColumnNameOfTournoi.setBorder(null);
		lblColumnNameOfTournoi.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		lblColumnNameOfTournoi.setAlignmentY(1.0f);
		panel_lblColumn1.add(lblColumnNameOfTournoi);
		
		JPanel panel_EntryColumn1 = new JPanel();
		panel_EntryColumn1.setBorder(new MatteBorder(0, 2, 0, 2, MasterFrame.COLOR_MASTER));
		panel_EntryColumn1.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_Column1.add(panel_EntryColumn1);
		GridBagLayout gbl_panel_EntryColumn1 = new GridBagLayout();
		gbl_panel_EntryColumn1.columnWidths = new int[] {0};
		gbl_panel_EntryColumn1.rowHeights = new int[] {0};
		gbl_panel_EntryColumn1.columnWeights = new double[]{0.0};
		gbl_panel_EntryColumn1.rowWeights = new double[]{0.0};
		panel_EntryColumn1.setLayout(gbl_panel_EntryColumn1);
		
		JPanel panel_txtFieldTournamentName = new JPanel();
		panel_txtFieldTournamentName.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		GridBagConstraints gbc_panel_txtFieldTournamentName = new GridBagConstraints();
		gbc_panel_txtFieldTournamentName.gridx = 0;
		gbc_panel_txtFieldTournamentName.gridy = 0;
		panel_EntryColumn1.add(panel_txtFieldTournamentName, gbc_panel_txtFieldTournamentName);
		
		txtTournamentName = new JTextField(tournament.getName());
		txtTournamentName.setText(tournament.getName());
		txtTournamentName.setHorizontalAlignment(SwingConstants.CENTER);
		txtTournamentName.setForeground(MasterFrame.COLOR_TEXT);
		txtTournamentName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTournamentName.setColumns(10);
		txtTournamentName.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_txtFieldTournamentName.add(txtTournamentName);
		
		JPanel panel_Column2 = new JPanel();
		panel_Column2.setForeground(MasterFrame.COLOR_TEXT);
		panel_Column2.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_Table.add(panel_Column2);
		panel_Column2.setLayout(new BoxLayout(panel_Column2, BoxLayout.Y_AXIS));
		
		JPanel panel_TitleColumn2 = new JPanel();
		panel_TitleColumn2.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_TitleColumn2.setForeground(MasterFrame.COLOR_TEXT);
		panel_Column2.add(panel_TitleColumn2);
		panel_TitleColumn2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_lblColumn2 = new JPanel();
		panel_lblColumn2.setBorder(new MatteBorder(0, 2, 2, 2, MasterFrame.COLOR_MASTER));
		panel_lblColumn2.setBackground(Color.BLACK);
		panel_TitleColumn2.add(panel_lblColumn2, BorderLayout.SOUTH);
		
		JLabel lblColumnDateOfTournament = new JLabel();
		lblColumnDateOfTournament.setText("Date début tournoi");
		lblColumnDateOfTournament.setHorizontalAlignment(SwingConstants.CENTER);
		lblColumnDateOfTournament.setForeground(MasterFrame.COLOR_TEXT_MENU);
		lblColumnDateOfTournament.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblColumnDateOfTournament.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_lblColumn2.add(lblColumnDateOfTournament);
		
		JPanel panel_EntryTournamentDate = new JPanel();
		panel_EntryTournamentDate.setBorder(new MatteBorder(0, 2, 0, 2, MasterFrame.COLOR_MASTER));
		panel_EntryTournamentDate.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_Column2.add(panel_EntryTournamentDate);
		GridBagLayout gbl_panel_EntryTournamentDate = new GridBagLayout();
		gbl_panel_EntryTournamentDate.columnWidths = new int[] {0, 0};
		gbl_panel_EntryTournamentDate.rowHeights = new int[] {0};
		gbl_panel_EntryTournamentDate.columnWeights = new double[]{0.0};
		gbl_panel_EntryTournamentDate.rowWeights = new double[]{0.0};
		panel_EntryTournamentDate.setLayout(gbl_panel_EntryTournamentDate);
		
		JPanel panel_DatePicketDateTournament = new JPanel();
		panel_DatePicketDateTournament.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		GridBagConstraints gbc_panel_DatePicketDateTournament = new GridBagConstraints();
		gbc_panel_DatePicketDateTournament.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_DatePicketDateTournament.gridx = 0;
		gbc_panel_DatePicketDateTournament.gridy = 0;
		panel_EntryTournamentDate.add(panel_DatePicketDateTournament, gbc_panel_DatePicketDateTournament);
		
		txtDateStartTournament = new JTextField();
		txtDateStartTournament.setText(tournament.getRegisterDate().toString());
		txtDateStartTournament.setHorizontalAlignment(SwingConstants.CENTER);
		txtDateStartTournament.setForeground(MasterFrame.COLOR_TEXT);
		txtDateStartTournament.setFont(new Font("Cambria", Font.PLAIN, 15));
		txtDateStartTournament.setColumns(10);
		txtDateStartTournament.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_DatePicketDateTournament.add(txtDateStartTournament);
		
		JButton btnOpenDatePickerDateTournament = new JButton("...");
		btnOpenDatePickerDateTournament.setForeground(MasterFrame.COLOR_TEXT);
		btnOpenDatePickerDateTournament.setBackground(new Color(0, 164, 210));
		btnOpenDatePickerDateTournament.addActionListener(Controler.getInstance());
		btnOpenDatePickerDateTournament.setActionCommand("MODIFY_TOURNAMENT_DATE");
		panel_DatePicketDateTournament.add(btnOpenDatePickerDateTournament);
		
		JPanel panel_Column3 = new JPanel();
		panel_Column3.setForeground(MasterFrame.COLOR_TEXT);
		panel_Column3.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_Table.add(panel_Column3);
		panel_Column3.setLayout(new BoxLayout(panel_Column3, BoxLayout.Y_AXIS));
		
		JPanel panel_TitleColumn3 = new JPanel();
		panel_TitleColumn3.setForeground(MasterFrame.COLOR_TEXT);
		panel_TitleColumn3.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_Column3.add(panel_TitleColumn3);
		panel_TitleColumn3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_lblColumn3 = new JPanel();
		panel_lblColumn3.setBorder(new MatteBorder(0, 2, 2, 2, MasterFrame.COLOR_MASTER));
		panel_lblColumn3.setBackground(Color.BLACK);
		panel_TitleColumn3.add(panel_lblColumn3, BorderLayout.SOUTH);
		
		JLabel lblFame = new JLabel();
		lblFame.setText("Renommée");
		lblFame.setHorizontalAlignment(SwingConstants.CENTER);
		lblFame.setForeground(MasterFrame.COLOR_TEXT_MENU);
		lblFame.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblFame.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_lblColumn3.add(lblFame);
		
		JPanel panel_EntryTournamentFame = new JPanel();
		panel_EntryTournamentFame.setBorder(new MatteBorder(0, 2, 0, 2, MasterFrame.COLOR_MASTER));
		panel_EntryTournamentFame.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_Column3.add(panel_EntryTournamentFame);
		GridBagLayout gbl_panel_EntryTournamentFame = new GridBagLayout();
		gbl_panel_EntryTournamentFame.columnWidths = new int[] {0};
		gbl_panel_EntryTournamentFame.rowHeights = new int[] {0};
		gbl_panel_EntryTournamentFame.columnWeights = new double[]{0.0, 0.0};
		gbl_panel_EntryTournamentFame.rowWeights = new double[]{0.0};
		panel_EntryTournamentFame.setLayout(gbl_panel_EntryTournamentFame);
		
		JPanel panel_ComboBoxFame = new JPanel();
		panel_ComboBoxFame.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		GridBagConstraints gbc_panel_ComboBoxFame = new GridBagConstraints();
		gbc_panel_ComboBoxFame.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_ComboBoxFame.gridx = 1;
		gbc_panel_ComboBoxFame.gridy = 0;
		panel_EntryTournamentFame.add(panel_ComboBoxFame, gbc_panel_ComboBoxFame);
		
		comboBoxFame = new JComboBox<TypesFame>(TypesFame.values());
		comboBoxFame.setSelectedItem(tournament.getFame());
		comboBoxFame.setBorder(new MatteBorder(1, 1, 1, 1, MasterFrame.COLOR_MASTER_BACKGROUND));
		comboBoxFame.setUI((ComboBoxUI) ComboBoxRendererArrow.createUI(comboBoxFame));
		comboBoxFame.setForeground(MasterFrame.COLOR_TEXT);
		comboBoxFame.setFont(new Font("Cambria", Font.PLAIN, 15));
		comboBoxFame.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_ComboBoxFame.add(comboBoxFame);
		
		JPanel panel_Column5 = new JPanel();
		panel_Column5.setForeground(MasterFrame.COLOR_TEXT);
		panel_Column5.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_Table.add(panel_Column5);
		panel_Column5.setLayout(new BoxLayout(panel_Column5, BoxLayout.Y_AXIS));
		
		JPanel panel_TitleColumn5 = new JPanel();
		panel_TitleColumn5.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_TitleColumn5.setForeground(MasterFrame.COLOR_TEXT);
		panel_Column5.add(panel_TitleColumn5);
		panel_TitleColumn5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_lblColumn5 = new JPanel();
		panel_lblColumn5.setBorder(new MatteBorder(0, 2, 2, 2, MasterFrame.COLOR_MASTER));
		panel_lblColumn5.setBackground(Color.BLACK);
		panel_TitleColumn5.add(panel_lblColumn5, BorderLayout.SOUTH);
		
		JLabel lblGame = new JLabel();
		lblGame.setText("Jeu(x)");
		lblGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblGame.setForeground(MasterFrame.COLOR_TEXT_MENU);
		lblGame.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblGame.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_lblColumn5.add(lblGame);
		
		JPanel panel_EntryTournamentGame = new JPanel();
		panel_EntryTournamentGame.setBorder(new MatteBorder(0, 2, 0, 2, MasterFrame.COLOR_MASTER));
		panel_EntryTournamentGame.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_Column5.add(panel_EntryTournamentGame);
		GridBagLayout gbl_panel_EntryTournamentGame = new GridBagLayout();
		gbl_panel_EntryTournamentGame.columnWidths = new int[] {0};
		gbl_panel_EntryTournamentGame.rowHeights = new int[] {0};
		gbl_panel_EntryTournamentGame.columnWeights = new double[]{0.0, 0.0};
		gbl_panel_EntryTournamentGame.rowWeights = new double[]{0.0};
		panel_EntryTournamentGame.setLayout(gbl_panel_EntryTournamentGame);
		
		JPanel panel_ComboBoxGame = new JPanel();
		panel_ComboBoxGame.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		GridBagConstraints gbc_panel_ComboBoxGame = new GridBagConstraints();
		gbc_panel_ComboBoxGame.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_ComboBoxGame.gridx = 1;
		gbc_panel_ComboBoxGame.gridy = 0;
		panel_EntryTournamentGame.add(panel_ComboBoxGame, gbc_panel_ComboBoxGame);
		
		comboBoxGame = new JComboBox<TypesGame>(TypesGame.values());
		comboBoxGame.setEnabled(false);
		comboBoxGame.setSelectedItem(tournament.getGame());
		comboBoxGame.setBorder(new MatteBorder(1, 1, 1, 1, MasterFrame.COLOR_MASTER_BACKGROUND));
		comboBoxGame.setUI((ComboBoxUI) ComboBoxRendererArrow.createUI(comboBoxGame));
		comboBoxGame.setForeground(MasterFrame.COLOR_TEXT);
		comboBoxGame.setFont(new Font("Cambria", Font.PLAIN, 15));
		comboBoxGame.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_ComboBoxGame.add(comboBoxGame);
		
		JPanel panel_BorderRight = new JPanel();
		panel_BorderRight.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_Table.add(panel_BorderRight);
		
		
		JPanel panel_BtnCancelValidate = new JPanel();
		panel_BtnCancelValidate.setBorder(null);
		panel_BtnCancelValidate.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_BtnCancelValidate.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_BtnCancelValidate.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		add(panel_BtnCancelValidate);
		panel_BtnCancelValidate.setLayout(new BorderLayout(0, 0));
		
		JPanel panelContainerButton = new JPanel();
		panelContainerButton.setBorder(new EmptyBorder(0, 0, 0, 30));
		panelContainerButton.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_BtnCancelValidate.add(panelContainerButton, BorderLayout.EAST);
		
		JButton btnCancel = new JButton("Annuler");
		btnCancel.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCancel.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCancel.setMargin(new Insets(14, 0, 14, 14));
		btnCancel.setIconTextGap(10);
		btnCancel.setHorizontalTextPosition(SwingConstants.LEFT);
		btnCancel.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancel.setForeground(MasterFrame.COLOR_TEXT_MENU);
		btnCancel.setFont(new Font("Cambria", Font.PLAIN, 22));
		btnCancel.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 120, 215)), new EmptyBorder(3, 5, 3, 5)));
		btnCancel.setBackground(MasterFrame.COLOR_MASTER);
		btnCancel.setAlignmentY(1.0f);
		btnCancel.addActionListener(Controler.getInstance());
		btnCancel.setActionCommand("MODIFY_TOURNAMENT_CANCEl");
		panelContainerButton.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		panelContainerButton.add(btnCancel);
		
		JButton btnConfirm = new JButton("Valider");
		btnConfirm.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnConfirm.setVerticalAlignment(SwingConstants.BOTTOM);
		btnConfirm.setMargin(new Insets(14, 0, 14, 14));
		btnConfirm.setIconTextGap(10);
		btnConfirm.setHorizontalTextPosition(SwingConstants.LEFT);
		btnConfirm.setHorizontalAlignment(SwingConstants.LEFT);
		btnConfirm.setForeground(MasterFrame.COLOR_TEXT_MENU);
		btnConfirm.setFont(new Font("Cambria", Font.PLAIN, 22));
		btnConfirm.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 120, 215)), new EmptyBorder(3, 5, 3, 5)));
		btnConfirm.setBackground(MasterFrame.COLOR_MASTER);
		btnConfirm.setAlignmentY(1.0f);
		btnConfirm.addActionListener(Controler.getInstance());
		btnConfirm.setActionCommand("MODIFY_TOURNAMENT_VALIDATE");
		panelContainerButton.add(btnConfirm);
	}
	
	public JTextField getTxtDateStartTournament() {
		return txtDateStartTournament;
	}
	public JTextField getTxtTournamentName() {
		return txtTournamentName;
	}
	public JComboBox<TypesGame> getComboBoxGame()
	{
	return comboBoxGame;	
	}
	public JComboBox<TypesFame> getComboBoxFame() {
		return comboBoxFame;
	}
	public TypesTournament getTournament() {
		return tournament;
	}
}
