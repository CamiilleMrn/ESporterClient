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

public class CreationTournoi extends JPanel{

	private static final long serialVersionUID = 4384792209233281239L;
	private JTextField TxtCreationTournoi;
	private JTextField txtNameOfTournoi;
	private JTextField textField_1;
	private JTextField txtDate;
	private JTextField txtDatePicker;
	private JTextField txtRenomm;
	private JTextField txtDateLimiteInscription;
	private JTextField textDatePickerLimitIncri;
	private JTextField txtJeux;
	private JPanel all;

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
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		TxtCreationTournoi = new JTextField();
		TxtCreationTournoi.setEditable(false);
		TxtCreationTournoi.setFont(new Font("Cambria", Font.PLAIN, 25));
		TxtCreationTournoi.setText("CREATION TOURNOI");
		TxtCreationTournoi.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(TxtCreationTournoi);
		TxtCreationTournoi.setColumns(10);
		
		JPanel panel_vide3 = new JPanel();
		FlowLayout fl_panel_vide3 = (FlowLayout) panel_vide3.getLayout();
		fl_panel_vide3.setVgap(15);
		panel.add(panel_vide3, BorderLayout.NORTH);
		
		JPanel panel_center = new JPanel();
		add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new GridLayout(1, 7, 0, 0));
		
		JPanel panel_vide1 = new JPanel();
		panel_center.add(panel_vide1);
		
		JPanel panel_Tournoi = new JPanel();
		panel_center.add(panel_Tournoi);
		panel_Tournoi.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_txtTournoi = new JPanel();
		panel_Tournoi.add(panel_txtTournoi);
		panel_txtTournoi.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtNameOfTournoi = new JTextField();
		txtNameOfTournoi.setEditable(false);
		txtNameOfTournoi.setHorizontalAlignment(SwingConstants.CENTER);
		txtNameOfTournoi.setText("Nom du tournois");
		txtNameOfTournoi.setFont(new Font("Cambria", Font.PLAIN, 20));
		panel_txtTournoi.add(txtNameOfTournoi);
		txtNameOfTournoi.setColumns(17);
		
		JPanel panel_NameTournoi = new JPanel();
		panel_Tournoi.add(panel_NameTournoi);
		panel_NameTournoi.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_NameTournoi.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_Date = new JPanel();
		panel_center.add(panel_Date);
		panel_Date.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_txtDate = new JPanel();
		panel_Date.add(panel_txtDate);
		panel_txtDate.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtDate = new JTextField();
		txtDate.setHorizontalAlignment(SwingConstants.CENTER);
		txtDate.setEditable(false);
		txtDate.setText("Date");
		txtDate.setFont(new Font("Cambria", Font.PLAIN, 20));
		panel_txtDate.add(txtDate);
		txtDate.setColumns(10);
		
		JPanel panel_DatePicker = new JPanel();
		panel_DatePicker.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_Date.add(panel_DatePicker);
		panel_DatePicker.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtDatePicker = new JTextField();
		txtDatePicker.setHorizontalAlignment(SwingConstants.CENTER);
		txtDatePicker.setFont(new Font("Cambria", Font.PLAIN, 15));
		panel_DatePicker.add(txtDatePicker);
		txtDatePicker.setColumns(10);
		
		JButton btnOpenDatePicker = new JButton("...");
		btnOpenDatePicker.addActionListener(new ActionListener() 
		{	
			//performed action
			public void actionPerformed(ActionEvent arg0) 
			{
				//create frame new object  f
				final JFrame f = new JFrame();
				//set text which is collected by date picker i.e. set date 
				txtDatePicker.setText(new DatePicker(f).setPickedDate());
			}
		});
		panel_DatePicker.add(btnOpenDatePicker);
		
		JPanel panel_Renom = new JPanel();
		panel_center.add(panel_Renom);
		panel_Renom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_txtDisableRenom = new JPanel();
		panel_Renom.add(panel_txtDisableRenom);
		panel_txtDisableRenom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtRenomm = new JTextField();
		txtRenomm.setText("Renommé");
		txtRenomm.setHorizontalAlignment(SwingConstants.CENTER);
		txtRenomm.setEditable(false);
		txtRenomm.setFont(new Font("Cambria", Font.PLAIN, 20));
		panel_txtDisableRenom.add(txtRenomm);
		txtRenomm.setColumns(12);
		
		JPanel panel_ComboRenom = new JPanel();
		panel_Renom.add(panel_ComboRenom);
		panel_ComboRenom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JComboBox comboBox_renom = new JComboBox();
		comboBox_renom.setFont(new Font("Cambria", Font.PLAIN, 15));
		panel_ComboRenom.add(comboBox_renom);
		
		JPanel panel_DateLimiteIncri = new JPanel();
		panel_center.add(panel_DateLimiteIncri);
		panel_DateLimiteIncri.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_txtDateLimiteInscription = new JPanel();
		panel_DateLimiteIncri.add(panel_txtDateLimiteInscription);
		panel_txtDateLimiteInscription.setLayout(new GridLayout(1, 0, 0, 0));
		
		txtDateLimiteInscription = new JTextField();
		txtDateLimiteInscription.setText("Date limite inscription");
		txtDateLimiteInscription.setHorizontalAlignment(SwingConstants.CENTER);
		txtDateLimiteInscription.setFont(new Font("Cambria", Font.PLAIN, 20));
		txtDateLimiteInscription.setEditable(false);
		panel_txtDateLimiteInscription.add(txtDateLimiteInscription);
		txtDateLimiteInscription.setColumns(18);
		
		JPanel panel_DatePickerInscription = new JPanel();
		panel_DateLimiteIncri.add(panel_DatePickerInscription);
		panel_DatePickerInscription.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textDatePickerLimitIncri = new JTextField();
		textDatePickerLimitIncri.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_DatePickerInscription.add(textDatePickerLimitIncri);
		textDatePickerLimitIncri.setColumns(10);
		
		JButton btnDisplayDatePicker = new JButton("...");
		panel_DatePickerInscription.add(btnDisplayDatePicker);
		btnDisplayDatePicker.addActionListener(new ActionListener() 
		{	
			//performed action
			public void actionPerformed(ActionEvent arg0) 
			{
				//create frame new object  f
				final JFrame f = new JFrame();
				//set text which is collected by date picker i.e. set date 
				textDatePickerLimitIncri.setText(new DatePicker(f).setPickedDate());
			}
		});
		
		JPanel panel_DisplayJeu = new JPanel();
		panel_center.add(panel_DisplayJeu);
		panel_DisplayJeu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_txtJEUX = new JPanel();
		panel_DisplayJeu.add(panel_txtJEUX);
		panel_txtJEUX.setLayout(new GridLayout(1, 0, 0, 0));
		
		txtJeux = new JTextField();
		txtJeux.setText("Jeu(x)");
		txtJeux.setHorizontalAlignment(SwingConstants.CENTER);
		txtJeux.setEditable(false);
		txtJeux.setFont(new Font("Cambria", Font.PLAIN, 20));
		panel_txtJEUX.add(txtJeux);
		txtJeux.setColumns(10);
		
		JComboBox comboBoxJeu = new JComboBox();
		panel_DisplayJeu.add(comboBoxJeu);
		comboBoxJeu.setFont(new Font("Cambria", Font.PLAIN, 15));
		
		JPanel panel_comboJeu = new JPanel();
		panel_DisplayJeu.add(panel_comboJeu);
		panel_comboJeu.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_vide2 = new JPanel();
		panel_center.add(panel_vide2);
		
		
		JPanel panel_BtnCAncelValidate = new JPanel();
		add(panel_BtnCAncelValidate, BorderLayout.SOUTH);
		panel_BtnCAncelValidate.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_BtnCAncelValidate.add(panel_6, BorderLayout.EAST);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Annuler");
		btnNewButton.setFont(new Font("Cambria", Font.PLAIN, 20));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		panel_6.add(btnNewButton, BorderLayout.WEST);
		
		JButton btnNewButton_1 = new JButton("Valider");
		btnNewButton_1.setFont(new Font("Cambria", Font.PLAIN, 20));
		panel_6.add(btnNewButton_1, BorderLayout.EAST);
		

		

	}

}
