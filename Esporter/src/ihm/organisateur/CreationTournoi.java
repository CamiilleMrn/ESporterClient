package ihm.organisateur;

import java.awt.EventQueue;


import javax.swing.JComboBox;
import javax.swing.JDialog;
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
import types.TournoiInfo;
import types.exception.InvalidPermission;
import utilisateur.User;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;

public class CreationTournoi extends JPanel{

	private static final long serialVersionUID = 4384792209233281239L;
	private JLabel lblPageTitle;
	private JPanel all;
	private JTextField txtDateStartTournament;
	private JTextField txtTournamentName;

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
		
		txtTournamentName = new JTextField();
		txtTournamentName.setHorizontalAlignment(SwingConstants.CENTER);
		txtTournamentName.setForeground(MasterFrame.COULEUR_TEXTE);
		txtTournamentName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTournamentName.setColumns(10);
		txtTournamentName.setBackground(new Color(96, 96, 96));
		panel_txtFieldTournamentName.add(txtTournamentName);
		
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
		lblColumnDateOfTournament.setText("Date début tournoi");
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
		
		txtDateStartTournament = new JTextField();
		txtDateStartTournament.setHorizontalAlignment(SwingConstants.CENTER);
		txtDateStartTournament.setForeground(MasterFrame.COULEUR_TEXTE);
		txtDateStartTournament.setFont(new Font("Cambria", Font.PLAIN, 15));
		txtDateStartTournament.setColumns(10);
		txtDateStartTournament.setBackground(new Color(96, 96, 96));
		panel_DatePicketDateTournament.add(txtDateStartTournament);
		
		JButton btnOpenDatePickerDateTournament = new JButton("...");
		btnOpenDatePickerDateTournament.setForeground(MasterFrame.COULEUR_TEXTE);
		btnOpenDatePickerDateTournament.setBackground(new Color(0, 164, 210));
		btnOpenDatePickerDateTournament.addActionListener(new ActionListener() {
			//performed action
			public void actionPerformed(ActionEvent arg0) 
			{
				//create frame new object  f
				final JFrame f = new JFrame();
				//set text which is collected by date picker i.e. set date 
				txtDateStartTournament.setText(new DatePicker(f).setPickedDate());
			}
		});
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
		
		JComboBox<Renomme> comboBoxFame = new JComboBox<Renomme>(Renomme.values());
		comboBoxFame.setBorder(new MatteBorder(1, 1, 1, 1, MasterFrame.COULEUR_MASTER_FOND));
		comboBoxFame.setUI((ComboBoxUI) ComboBoxRendererArrow.createUI(comboBoxFame));
		comboBoxFame.setForeground(MasterFrame.COULEUR_TEXTE);
		comboBoxFame.setFont(new Font("Cambria", Font.PLAIN, 15));
		comboBoxFame.setBackground(new Color(96, 96, 96));
		panel_ComboBoxFame.add(comboBoxFame);
		
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
		
		JComboBox<Jeu> comboBoxGame = new JComboBox<Jeu>(Jeu.values());
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
		
		JPanel panelContainerButton = new JPanel();
		panelContainerButton.setBorder(new EmptyBorder(0, 0, 0, 30));
		panelContainerButton.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_BtnCancelValidate.add(panelContainerButton, BorderLayout.EAST);
		
		JButton btnCancel = new JButton("Annuler");
		btnCancel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, MasterFrame.COULEUR_MASTER, null, MasterFrame.COULEUR_MASTER, null));
		btnCancel.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		btnCancel.setForeground(MasterFrame.COULEUR_TEXTE);
		btnCancel.setFont(new Font("Cambria", Font.PLAIN, 20));
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MasterFrame.getInstance().setPanel(ihm.organisateur.Calendrier.class, null);
			}
			
		});
		panelContainerButton.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		panelContainerButton.add(btnCancel);
		
		JButton btnConfirm = new JButton("Valider");
		btnConfirm.setForeground(SystemColor.text);
		btnConfirm.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, MasterFrame.COULEUR_MASTER, null, MasterFrame.COULEUR_MASTER, null));
		btnConfirm.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		btnConfirm.setFont(new Font("Cambria", Font.PLAIN, 20));
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(txtDateStartTournament.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Veuillez préciser la date de début du tournoi","Error", JOptionPane.ERROR_MESSAGE);
					}else if(txtTournamentName.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Veuillez préciser le nom du tournoi","Error", JOptionPane.ERROR_MESSAGE);
					}else {
						Date tournamentStart = null;
						try {
							tournamentStart = Date.valueOf(txtDateStartTournament.getText());
						} catch (IllegalArgumentException e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "Format de date invalide","Error", JOptionPane.ERROR_MESSAGE);
							return;
						}
						int n = JOptionPane.showConfirmDialog(null, "Confirmez vous l'ajout du tournoi ?","Confirmation", JOptionPane.YES_NO_OPTION);
						if (n == JOptionPane.YES_OPTION) {
							TournoiInfo t = new TournoiInfo(tournamentStart, txtTournamentName.getText(), 
									(Renomme) comboBoxFame.getSelectedItem(), (Jeu) comboBoxGame.getSelectedItem(), -1);
							if (MasterFrame.getInstance().getUser().getData().listeTournoiTrie().contains(t)) { 
								JOptionPane.showMessageDialog(null, "Un tournoi à cette date existe déjà","Error", JOptionPane.ERROR_MESSAGE);
							}else{
								MasterFrame.getInstance().getUser().ajouterTournoi(t);
								MasterFrame.getInstance().setPanel(ihm.organisateur.Calendrier.class, null);
							}
						}
					}
				} catch (InvalidPermission e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panelContainerButton.add(btnConfirm);
	}

}
