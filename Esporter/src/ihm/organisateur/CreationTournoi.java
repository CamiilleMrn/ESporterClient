package ihm.organisateur;

import java.awt.EventQueue;


import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;


import backend.Tournoi;
import ihm.MasterFrame;
import ihm.component.ComboBoxRendererArrow;
import ihm.component.DatePicker;
import types.Jeu;
import types.Renomme;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;

public class CreationTournoi extends JPanel{

	private static final long serialVersionUID = 4384792209233281239L;
	private JLabel lblPageTitle;
	private JPanel all;
	private JTextField textField_DateTournament;
	private JTextField textField_LimitDate;
	private JTextField textField_TournamentName;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public CreationTournoi() {

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
		panel_PageTitle.setForeground(MasterFrame.COULEUR_TEXTE);
		panel_PageTitle.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		add(panel_PageTitle);
		panel_PageTitle.setLayout(new BorderLayout(0, 0));
		
		lblPageTitle = new JLabel();
		lblPageTitle.setBorder(null);
		lblPageTitle.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		lblPageTitle.setForeground(MasterFrame.COULEUR_TEXTE);
		lblPageTitle.setFont(new Font("Cambria", Font.BOLD, 40));
		lblPageTitle.setText("Création d'un tournoi");
		lblPageTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel_PageTitle.add(lblPageTitle);
		
		JPanel panel_Table = new JPanel();
		add(panel_Table);
		panel_Table.setLayout(new GridLayout(1, 7, 0, 0));
		
		JPanel panel_BorderLeft = new JPanel();
		panel_BorderLeft.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_Table.add(panel_BorderLeft);
		
		JPanel panel_Column1 = new JPanel();
		panel_Column1.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_Table.add(panel_Column1);
		panel_Column1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_TitleColumn1 = new JPanel();
		panel_TitleColumn1.setBorder(null);
		panel_TitleColumn1.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_Column1.add(panel_TitleColumn1);
		panel_TitleColumn1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_lblColumn1 = new JPanel();
		panel_lblColumn1.setBorder(new MatteBorder(0, 2, 2, 2, MasterFrame.COULEUR_MASTER));
		FlowLayout fl_panel_lblColumn1 = (FlowLayout) panel_lblColumn1.getLayout();
		panel_lblColumn1.setBackground(Color.BLACK);
		panel_TitleColumn1.add(panel_lblColumn1, BorderLayout.SOUTH);
		
		JLabel lblColumnNameOfTournoi = new JLabel();
		lblColumnNameOfTournoi.setVerticalAlignment(SwingConstants.BOTTOM);
		lblColumnNameOfTournoi.setText("Nom du tournois");
		lblColumnNameOfTournoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblColumnNameOfTournoi.setForeground(MasterFrame.COULEUR_TEXTE);
		lblColumnNameOfTournoi.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblColumnNameOfTournoi.setBorder(null);
		lblColumnNameOfTournoi.setBackground(new Color(96, 96, 96));
		lblColumnNameOfTournoi.setAlignmentY(1.0f);
		panel_lblColumn1.add(lblColumnNameOfTournoi);
		
		JPanel panel_EntryColumn1 = new JPanel();
		panel_EntryColumn1.setBorder(new MatteBorder(0, 2, 0, 2, MasterFrame.COULEUR_MASTER));
		panel_EntryColumn1.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_Column1.add(panel_EntryColumn1);
		GridBagLayout gbl_panel_EntryColumn1 = new GridBagLayout();
		gbl_panel_EntryColumn1.columnWidths = new int[] {0};
		gbl_panel_EntryColumn1.rowHeights = new int[] {0};
		gbl_panel_EntryColumn1.columnWeights = new double[]{0.0};
		gbl_panel_EntryColumn1.rowWeights = new double[]{0.0};
		panel_EntryColumn1.setLayout(gbl_panel_EntryColumn1);
		
		JPanel panel_txtFieldTournamentName = new JPanel();
		panel_txtFieldTournamentName.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_panel_txtFieldTournamentName = new GridBagConstraints();
		gbc_panel_txtFieldTournamentName.gridx = 0;
		gbc_panel_txtFieldTournamentName.gridy = 0;
		panel_EntryColumn1.add(panel_txtFieldTournamentName, gbc_panel_txtFieldTournamentName);
		
		textField_TournamentName = new JTextField();
		textField_TournamentName.setHorizontalAlignment(SwingConstants.CENTER);
		textField_TournamentName.setForeground(MasterFrame.COULEUR_TEXTE);
		textField_TournamentName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_TournamentName.setColumns(10);
		textField_TournamentName.setBackground(new Color(96, 96, 96));
		panel_txtFieldTournamentName.add(textField_TournamentName);
		
		JPanel panel_Column2 = new JPanel();
		panel_Column2.setForeground(MasterFrame.COULEUR_TEXTE);
		panel_Column2.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_Table.add(panel_Column2);
		panel_Column2.setLayout(new BoxLayout(panel_Column2, BoxLayout.Y_AXIS));
		
		JPanel panel_TitleColumn2 = new JPanel();
		panel_TitleColumn2.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_TitleColumn2.setForeground(MasterFrame.COULEUR_TEXTE);
		panel_Column2.add(panel_TitleColumn2);
		panel_TitleColumn2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_lblColumn2 = new JPanel();
		panel_lblColumn2.setBorder(new MatteBorder(0, 2, 2, 2, MasterFrame.COULEUR_MASTER));
		panel_lblColumn2.setBackground(Color.BLACK);
		panel_TitleColumn2.add(panel_lblColumn2, BorderLayout.SOUTH);
		
		JLabel lblColumnDateOfTournament = new JLabel();
		lblColumnDateOfTournament.setText("Date");
		lblColumnDateOfTournament.setHorizontalAlignment(SwingConstants.CENTER);
		lblColumnDateOfTournament.setForeground(MasterFrame.COULEUR_TEXTE);
		lblColumnDateOfTournament.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblColumnDateOfTournament.setBackground(new Color(96, 96, 96));
		panel_lblColumn2.add(lblColumnDateOfTournament);
		
		JPanel panel_EntryTournamentDate = new JPanel();
		panel_EntryTournamentDate.setBorder(new MatteBorder(0, 2, 0, 2, MasterFrame.COULEUR_MASTER));
		panel_EntryTournamentDate.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_Column2.add(panel_EntryTournamentDate);
		GridBagLayout gbl_panel_EntryTournamentDate = new GridBagLayout();
		gbl_panel_EntryTournamentDate.columnWidths = new int[] {0, 0};
		gbl_panel_EntryTournamentDate.rowHeights = new int[] {0};
		gbl_panel_EntryTournamentDate.columnWeights = new double[]{0.0};
		gbl_panel_EntryTournamentDate.rowWeights = new double[]{0.0};
		panel_EntryTournamentDate.setLayout(gbl_panel_EntryTournamentDate);
		
		JPanel panel_DatePicketDateTournament = new JPanel();
		panel_DatePicketDateTournament.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_panel_DatePicketDateTournament = new GridBagConstraints();
		gbc_panel_DatePicketDateTournament.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_DatePicketDateTournament.gridx = 0;
		gbc_panel_DatePicketDateTournament.gridy = 0;
		panel_EntryTournamentDate.add(panel_DatePicketDateTournament, gbc_panel_DatePicketDateTournament);
		
		textField_DateTournament = new JTextField();
		textField_DateTournament.setHorizontalAlignment(SwingConstants.CENTER);
		textField_DateTournament.setForeground(MasterFrame.COULEUR_TEXTE);
		textField_DateTournament.setFont(new Font("Cambria", Font.PLAIN, 15));
		textField_DateTournament.setColumns(10);
		textField_DateTournament.setBackground(new Color(96, 96, 96));
		panel_DatePicketDateTournament.add(textField_DateTournament);
		
		JButton btnOpenDatePickerDateTournament = new JButton("...");
		btnOpenDatePickerDateTournament.setForeground(MasterFrame.COULEUR_TEXTE);
		btnOpenDatePickerDateTournament.setBackground(new Color(0, 164, 210));
		panel_DatePicketDateTournament.add(btnOpenDatePickerDateTournament);
		
		JPanel panel_Column3 = new JPanel();
		panel_Column3.setForeground(MasterFrame.COULEUR_TEXTE);
		panel_Column3.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_Table.add(panel_Column3);
		panel_Column3.setLayout(new BoxLayout(panel_Column3, BoxLayout.Y_AXIS));
		
		JPanel panel_TitleColumn3 = new JPanel();
		panel_TitleColumn3.setForeground(MasterFrame.COULEUR_TEXTE);
		panel_TitleColumn3.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_Column3.add(panel_TitleColumn3);
		panel_TitleColumn3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_lblColumn3 = new JPanel();
		panel_lblColumn3.setBorder(new MatteBorder(0, 2, 2, 2, MasterFrame.COULEUR_MASTER));
		panel_lblColumn3.setBackground(Color.BLACK);
		panel_TitleColumn3.add(panel_lblColumn3, BorderLayout.SOUTH);
		
		JLabel lblFame = new JLabel();
		lblFame.setText("Renommée");
		lblFame.setHorizontalAlignment(SwingConstants.CENTER);
		lblFame.setForeground(MasterFrame.COULEUR_TEXTE);
		lblFame.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblFame.setBackground(new Color(96, 96, 96));
		panel_lblColumn3.add(lblFame);
		
		JPanel panel_EntryTournamentFame = new JPanel();
		panel_EntryTournamentFame.setBorder(new MatteBorder(0, 2, 0, 2, MasterFrame.COULEUR_MASTER));
		panel_EntryTournamentFame.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_Column3.add(panel_EntryTournamentFame);
		GridBagLayout gbl_panel_EntryTournamentFame = new GridBagLayout();
		gbl_panel_EntryTournamentFame.columnWidths = new int[] {0};
		gbl_panel_EntryTournamentFame.rowHeights = new int[] {0};
		gbl_panel_EntryTournamentFame.columnWeights = new double[]{0.0, 0.0};
		gbl_panel_EntryTournamentFame.rowWeights = new double[]{0.0};
		panel_EntryTournamentFame.setLayout(gbl_panel_EntryTournamentFame);
		
		JPanel panel_ComboBoxFame = new JPanel();
		panel_ComboBoxFame.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_panel_ComboBoxFame = new GridBagConstraints();
		gbc_panel_ComboBoxFame.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_ComboBoxFame.gridx = 1;
		gbc_panel_ComboBoxFame.gridy = 0;
		panel_EntryTournamentFame.add(panel_ComboBoxFame, gbc_panel_ComboBoxFame);
		
		//JComboBox<Renomme> comboBox_fame = new JComboBox<Renomme>(Renomme.values());
		JComboBox comboBox_fame = new JComboBox();
		comboBox_fame.setBorder(new MatteBorder(1, 1, 1, 1, MasterFrame.COULEUR_MASTER_FOND));
		comboBox_fame.setUI((ComboBoxUI) ComboBoxRendererArrow.createUI(comboBox_fame));
		comboBox_fame.setForeground(MasterFrame.COULEUR_TEXTE);
		comboBox_fame.setFont(new Font("Cambria", Font.PLAIN, 15));
		comboBox_fame.setBackground(new Color(96, 96, 96));
		panel_ComboBoxFame.add(comboBox_fame);
		
		JPanel panel_Column4 = new JPanel();
		panel_Column4.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_Column4.setForeground(MasterFrame.COULEUR_TEXTE);
		panel_Table.add(panel_Column4);
		panel_Column4.setLayout(new BoxLayout(panel_Column4, BoxLayout.Y_AXIS));
		
		JPanel panel_TitleColumn4 = new JPanel();
		panel_TitleColumn4.setForeground(MasterFrame.COULEUR_TEXTE);
		panel_TitleColumn4.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_Column4.add(panel_TitleColumn4);
		panel_TitleColumn4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_lblColumn4 = new JPanel();
		panel_lblColumn4.setBorder(new MatteBorder(0, 2, 2, 2, MasterFrame.COULEUR_MASTER));
		panel_lblColumn4.setBackground(Color.BLACK);
		panel_TitleColumn4.add(panel_lblColumn4, BorderLayout.SOUTH);
		
		JLabel lblLimitDateInscription = new JLabel();
		lblLimitDateInscription.setText("Date limite");
		lblLimitDateInscription.setForeground(MasterFrame.COULEUR_TEXTE);
		lblLimitDateInscription.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblLimitDateInscription.setBackground(new Color(96, 96, 96));
		panel_lblColumn4.add(lblLimitDateInscription);
		
		JPanel panel_EntryTournamentLimitDate = new JPanel();
		panel_EntryTournamentLimitDate.setBorder(new MatteBorder(0, 2, 0, 2, MasterFrame.COULEUR_MASTER));
		panel_EntryTournamentLimitDate.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_Column4.add(panel_EntryTournamentLimitDate);
		GridBagLayout gbl_panel_EntryTournamentLimitDate = new GridBagLayout();
		gbl_panel_EntryTournamentLimitDate.columnWidths = new int[] {0, 0};
		gbl_panel_EntryTournamentLimitDate.rowHeights = new int[] {0};
		gbl_panel_EntryTournamentLimitDate.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_EntryTournamentLimitDate.rowWeights = new double[]{0.0};
		panel_EntryTournamentLimitDate.setLayout(gbl_panel_EntryTournamentLimitDate);
		
		JPanel panel_DatePicketLimitDate = new JPanel();
		panel_DatePicketLimitDate.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_panel_DatePicketLimitDate = new GridBagConstraints();
		gbc_panel_DatePicketLimitDate.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_DatePicketLimitDate.gridx = 0;
		gbc_panel_DatePicketLimitDate.gridy = 0;
		panel_EntryTournamentLimitDate.add(panel_DatePicketLimitDate, gbc_panel_DatePicketLimitDate);
		panel_DatePicketLimitDate.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField_LimitDate = new JTextField();
		textField_LimitDate.setForeground(MasterFrame.COULEUR_TEXTE);
		textField_LimitDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_LimitDate.setColumns(10);
		textField_LimitDate.setBackground(new Color(96, 96, 96));
		panel_DatePicketLimitDate.add(textField_LimitDate);
		
		JButton btnDisplayDatePickerLimitDate = new JButton("...");
		btnDisplayDatePickerLimitDate.setForeground(MasterFrame.COULEUR_TEXTE);
		btnDisplayDatePickerLimitDate.setBackground(new Color(0, 164, 210));
		panel_DatePicketLimitDate.add(btnDisplayDatePickerLimitDate);
		
		JPanel panel_Column5 = new JPanel();
		panel_Column5.setForeground(MasterFrame.COULEUR_TEXTE);
		panel_Column5.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_Table.add(panel_Column5);
		panel_Column5.setLayout(new BoxLayout(panel_Column5, BoxLayout.Y_AXIS));
		
		JPanel panel_TitleColumn5 = new JPanel();
		panel_TitleColumn5.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_TitleColumn5.setForeground(MasterFrame.COULEUR_TEXTE);
		panel_Column5.add(panel_TitleColumn5);
		panel_TitleColumn5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_lblColumn5 = new JPanel();
		panel_lblColumn5.setBorder(new MatteBorder(0, 2, 2, 2, MasterFrame.COULEUR_MASTER));
		panel_lblColumn5.setBackground(Color.BLACK);
		panel_TitleColumn5.add(panel_lblColumn5, BorderLayout.SOUTH);
		
		JLabel lblGame = new JLabel();
		lblGame.setText("Jeu(x)");
		lblGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblGame.setForeground(MasterFrame.COULEUR_TEXTE);
		lblGame.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblGame.setBackground(new Color(96, 96, 96));
		panel_lblColumn5.add(lblGame);
		
		JPanel panel_EntryTournamentGame = new JPanel();
		panel_EntryTournamentGame.setBorder(new MatteBorder(0, 2, 0, 2, MasterFrame.COULEUR_MASTER));
		panel_EntryTournamentGame.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_Column5.add(panel_EntryTournamentGame);
		GridBagLayout gbl_panel_EntryTournamentGame = new GridBagLayout();
		gbl_panel_EntryTournamentGame.columnWidths = new int[] {0};
		gbl_panel_EntryTournamentGame.rowHeights = new int[] {0};
		gbl_panel_EntryTournamentGame.columnWeights = new double[]{0.0, 0.0};
		gbl_panel_EntryTournamentGame.rowWeights = new double[]{0.0};
		panel_EntryTournamentGame.setLayout(gbl_panel_EntryTournamentGame);
		
		JPanel panel_ComboBoxGame = new JPanel();
		panel_ComboBoxGame.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_panel_ComboBoxGame = new GridBagConstraints();
		gbc_panel_ComboBoxGame.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_ComboBoxGame.gridx = 1;
		gbc_panel_ComboBoxGame.gridy = 0;
		panel_EntryTournamentGame.add(panel_ComboBoxGame, gbc_panel_ComboBoxGame);
		
		//JComboBox<Jeu> comboBoxGame = new JComboBox<Jeu>(Jeu.values());
		JComboBox comboBoxGame = new JComboBox();
		comboBoxGame.setBorder(new MatteBorder(1, 1, 1, 1, MasterFrame.COULEUR_MASTER_FOND));
		comboBoxGame.setUI((ComboBoxUI) ComboBoxRendererArrow.createUI(comboBoxGame));
		comboBoxGame.setForeground(MasterFrame.COULEUR_TEXTE);
		comboBoxGame.setFont(new Font("Cambria", Font.PLAIN, 15));
		comboBoxGame.setBackground(new Color(96, 96, 96));
		panel_ComboBoxGame.add(comboBoxGame);
		
		JPanel panel_BorderRight = new JPanel();
		panel_BorderRight.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_Table.add(panel_BorderRight);
		
		
		JPanel panel_BtnCancelValidate = new JPanel();
		panel_BtnCancelValidate.setBorder(null);
		panel_BtnCancelValidate.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_BtnCancelValidate.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_BtnCancelValidate.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		add(panel_BtnCancelValidate);
		panel_BtnCancelValidate.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EmptyBorder(0, 0, 0, 30));
		panel_6.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_BtnCancelValidate.add(panel_6, BorderLayout.EAST);
		
		JButton btnNewButton = new JButton("Annuler");
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, MasterFrame.COULEUR_MASTER, null, MasterFrame.COULEUR_MASTER, null));
		btnNewButton.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		btnNewButton.setForeground(MasterFrame.COULEUR_TEXTE);
		btnNewButton.setFont(new Font("Cambria", Font.PLAIN, 20));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		panel_6.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		panel_6.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Valider");
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, MasterFrame.COULEUR_MASTER, null, MasterFrame.COULEUR_MASTER, null));
		btnNewButton_1.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		btnNewButton_1.setFont(new Font("Cambria", Font.PLAIN, 20));
		panel_6.add(btnNewButton_1);
		

		

	}

}
