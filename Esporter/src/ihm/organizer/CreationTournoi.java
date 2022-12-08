package ihm.organizer;

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
import types.TypesGame;
import types.TypesFame;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JLabel;

public class CreationTournoi extends JPanel{

	private static final long serialVersionUID = 4384792209233281239L;
	private JTextField txtTitle;
	private JLabel lblName;
	private JTextField txtName;
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
		JPanel panelTitle = new JPanel();
		add(panelTitle, BorderLayout.NORTH);
		panelTitle.setLayout(new BorderLayout(0, 0));
		
		txtTitle = new JTextField();
		txtTitle.setEditable(false);
		txtTitle.setFont(new Font("Cambria", Font.PLAIN, 25));
		txtTitle.setText("CREATION TOURNOI");
		txtTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitle.add(txtTitle);
		txtTitle.setColumns(10);
		
		JPanel panelDummy = new JPanel();
		FlowLayout fl_panelDummy = (FlowLayout) panelDummy.getLayout();
		fl_panelDummy.setVgap(15);
		panelTitle.add(panelDummy, BorderLayout.NORTH);
		
		JPanel panelContent = new JPanel();
		add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new GridLayout(1, 7, 0, 0));
		
		JPanel panelDummyLeft = new JPanel();
		panelContent.add(panelDummyLeft);
		
		JPanel panelName = new JPanel();
		panelContent.add(panelName);
		panelName.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelLblName = new JPanel();
		panelName.add(panelLblName);
		panelLblName.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblName = new JLabel();
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setText("Nom du tournois");
		lblName.setFont(new Font("Cambria", Font.PLAIN, 20));
		panelLblName.add(lblName);
		
		JPanel panelTxtName = new JPanel();
		panelName.add(panelTxtName);
		panelTxtName.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelTxtName.add(txtName);
		txtName.setColumns(10);
		
		JPanel panelDate = new JPanel();
		panelContent.add(panelDate);
		panelDate.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_txtDate = new JPanel();
		panelDate.add(panel_txtDate);
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
		panelDate.add(panel_DatePicker);
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
		
		JPanel panelFame = new JPanel();
		panelContent.add(panelFame);
		panelFame.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_txtDisableRenom = new JPanel();
		panelFame.add(panel_txtDisableRenom);
		panel_txtDisableRenom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtRenomm = new JTextField();
		txtRenomm.setText("Renommé");
		txtRenomm.setHorizontalAlignment(SwingConstants.CENTER);
		txtRenomm.setEditable(false);
		txtRenomm.setFont(new Font("Cambria", Font.PLAIN, 20));
		panel_txtDisableRenom.add(txtRenomm);
		txtRenomm.setColumns(12);
		
		JPanel panel_ComboRenom = new JPanel();
		panelFame.add(panel_ComboRenom);
		panel_ComboRenom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JComboBox comboBox_renom = new JComboBox();
		comboBox_renom.setFont(new Font("Cambria", Font.PLAIN, 15));
		panel_ComboRenom.add(comboBox_renom);
		
		JPanel panelRegisterDate = new JPanel();
		panelContent.add(panelRegisterDate);
		panelRegisterDate.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_txtDateLimiteInscription = new JPanel();
		panelRegisterDate.add(panel_txtDateLimiteInscription);
		panel_txtDateLimiteInscription.setLayout(new GridLayout(1, 0, 0, 0));
		
		txtDateLimiteInscription = new JTextField();
		txtDateLimiteInscription.setText("Date limite inscription");
		txtDateLimiteInscription.setHorizontalAlignment(SwingConstants.CENTER);
		txtDateLimiteInscription.setFont(new Font("Cambria", Font.PLAIN, 20));
		txtDateLimiteInscription.setEditable(false);
		panel_txtDateLimiteInscription.add(txtDateLimiteInscription);
		txtDateLimiteInscription.setColumns(18);
		
		JPanel panel_DatePickerInscription = new JPanel();
		panelRegisterDate.add(panel_DatePickerInscription);
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
		
		JPanel panelGame = new JPanel();
		panelContent.add(panelGame);
		panelGame.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_txtJEUX = new JPanel();
		panelGame.add(panel_txtJEUX);
		panel_txtJEUX.setLayout(new GridLayout(1, 0, 0, 0));
		
		txtJeux = new JTextField();
		txtJeux.setText("Jeu(x)");
		txtJeux.setHorizontalAlignment(SwingConstants.CENTER);
		txtJeux.setEditable(false);
		txtJeux.setFont(new Font("Cambria", Font.PLAIN, 20));
		panel_txtJEUX.add(txtJeux);
		txtJeux.setColumns(10);
		
		JComboBox comboBoxJeu = new JComboBox();
		panelGame.add(comboBoxJeu);
		comboBoxJeu.setFont(new Font("Cambria", Font.PLAIN, 15));
		
		JPanel panel_comboJeu = new JPanel();
		panelGame.add(panel_comboJeu);
		panel_comboJeu.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelDummyRight = new JPanel();
		panelContent.add(panelDummyRight);
		
		
		JPanel panelBtnCancelValidate = new JPanel();
		add(panelBtnCancelValidate, BorderLayout.SOUTH);
		panelBtnCancelValidate.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panelBtnCancelValidate.add(panel_6, BorderLayout.EAST);
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
