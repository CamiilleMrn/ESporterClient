package ihm.ecurie;
//import statements
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ihm.component.DatePicker;
import ihm.component.containerJoueur;
import types.JoueurInfo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;



//create class and extend with JFrame
public class AjouterunJoueur extends JDialog
{	
		/**
	 * 
	 */
	private static final long serialVersionUID = -725884370429132629L;
		//add JPanel to the contentPane
		private JPanel contentPane;
		//declare variable
		private JTextField TexteDate2;
		private JTextField TexteDate;
		private JPanel panel;
		private JPanel panel_1;
		private JPanel panel_2;
		private JTextField TexteNom;
		private JTextField Prenom;
		private JTextField DateDeNaissance;
		private JLabel PhotoJoueur;
		private JPanel panel_3;
		private JPanel panel_4;
		private JPanel panel_5;
		private JTextField DateDebutTournoi;
		private JTextField DateFinDuContrat;
		private JButton btnNewButton_1;
		private JPanel panel_6;
		private JTextField TexteDemanderLaPhotoDuJoueur;
		private JPanel panel_7;
		private JTextField TextePrenom;
		private JPanel panel_8;
		private JTextField TexteDuNom;
		private JTextField textField_2;
		private JButton TroisPoint3;
	


	/**
	 * Create the frame.
	 */
	//create constructor of class
	public AjouterunJoueur(containerJoueur container) 
	{

		//set title
		setTitle("Ajouter joueur ");
		//set close operation on frame
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//set bounds of frame
		setBounds(100, 100, 522, 285);
		//create new JPanel in contentPane
		contentPane = new JPanel();
		//set border of frame
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//set contentPane 
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//create button and there object
		JButton TroisPoint2 = new JButton("...");
		TroisPoint2.setContentAreaFilled(false); 
		TroisPoint2.setFocusPainted(false); 
		TroisPoint2.addActionListener(new ActionListener() 
		{	
			//performed action
			public void actionPerformed(ActionEvent arg0) 
			{
				//create frame new object  f
				final JFrame f = new JFrame();
				//set text which is collected by date picker i.e. set date 
				TexteDate2.setText(new DatePicker(f).setPickedDate());
			}
		});
		//create text field
				TexteDate2 = new JTextField();
				TexteDate2.setHorizontalAlignment(SwingConstants.CENTER);
				TexteDate2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				TexteDate2.setColumns(10);
		
		JButton TroisPoint= new JButton("...");
		TroisPoint.setContentAreaFilled(false); 
		TroisPoint.setFocusPainted(false); 
		TroisPoint.addActionListener(new ActionListener() 
		{	
			//performed action
			public void actionPerformed(ActionEvent arg0) 
			{
				//create frame new object  f
				final JFrame f = new JFrame();
				//set text which is collected by date picker i.e. set date 
				TexteDate.setText(new DatePicker(f).setPickedDate());
			}
		});
		//create text field
				TexteDate = new JTextField();
				TexteDate.setHorizontalAlignment(SwingConstants.CENTER);
				TexteDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
				TexteDate.setColumns(10);
		
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new BorderLayout(0, 0));
	
		DateDebutTournoi = new JTextField();
		DateDebutTournoi.setHorizontalAlignment(SwingConstants.CENTER);
		DateDebutTournoi.setText("Date debut du contrat");
		DateDebutTournoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DateDebutTournoi.setEditable(false);
		panel_3.add(DateDebutTournoi, BorderLayout.NORTH);
		panel_3.add(TroisPoint, BorderLayout.EAST);
		panel_3.add(TexteDate, BorderLayout.WEST);
		DateDebutTournoi.setColumns(10);
		DateDebutTournoi.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		
		panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.EAST);
		panel_4.setLayout(new BorderLayout(0, 0));
		panel_4.add(TroisPoint2, BorderLayout.EAST);
		panel_4.add(TexteDate2, BorderLayout.WEST);
		
		DateFinDuContrat = new JTextField();
		DateFinDuContrat.setHorizontalAlignment(SwingConstants.CENTER);
		DateFinDuContrat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DateFinDuContrat.setText("Date fin du contrat");
		DateFinDuContrat.setEditable(false);
		panel_4.add(DateFinDuContrat, BorderLayout.NORTH);
		DateFinDuContrat.setColumns(10);
		DateFinDuContrat.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		
		panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		btnNewButton_1 = new JButton("Valider");
		btnNewButton_1.setContentAreaFilled(false); 
		btnNewButton_1.setFocusPainted(false); 
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(btnNewButton_1, BorderLayout.EAST);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {136, 136};
		gbl_panel_1.rowHeights = new int[] {53, 53, 53};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 0.0};
		panel_1.setLayout(gbl_panel_1);
						
						TexteNom = new JTextField();
						TexteNom.setHorizontalAlignment(SwingConstants.CENTER);
						TexteNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
						TexteNom.setText("Nom   :");
						TexteNom.setEditable(false);
						GridBagConstraints gbc_TexteNom = new GridBagConstraints();
						gbc_TexteNom.fill = GridBagConstraints.BOTH;
						gbc_TexteNom.gridx = 0;
						gbc_TexteNom.gridy = 0;
						panel_1.add(TexteNom, gbc_TexteNom);
						
						TexteNom.setColumns(10);
						
						panel_8 = new JPanel();
						GridBagConstraints gbc_panel_8 = new GridBagConstraints();
						gbc_panel_8.gridx = 1;
						gbc_panel_8.gridy = 0;
						panel_1.add(panel_8, gbc_panel_8);
						
						TexteDuNom = new JTextField();
						TexteDuNom.setHorizontalAlignment(SwingConstants.CENTER);
						TexteDuNom.setColumns(5);
						panel_8.add(TexteDuNom);
						

						
						Prenom = new JTextField();
						Prenom.setText("Prenom  :");
						Prenom.setHorizontalAlignment(SwingConstants.CENTER);
						Prenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
						Prenom.setEditable(false);
						GridBagConstraints gbc_Prenom = new GridBagConstraints();
						gbc_Prenom.fill = GridBagConstraints.BOTH;
						gbc_Prenom.gridx = 0;
						gbc_Prenom.gridy = 1;
						panel_1.add(Prenom, gbc_Prenom);
						Prenom.setColumns(10);
						
						panel_6 = new JPanel();
						GridBagConstraints gbc_panel_6 = new GridBagConstraints();
						gbc_panel_6.gridx = 1;
						gbc_panel_6.gridy = 1;
						panel_1.add(panel_6, gbc_panel_6);
						panel_6.setLayout(new BorderLayout(0, 0));
						
						textField_2 = new JTextField();
						textField_2.setHorizontalAlignment(SwingConstants.CENTER);
						textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
						textField_2.setColumns(8);
						panel_6.add(textField_2, BorderLayout.CENTER);
		
		panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.gridx = 1;
		gbc_panel_7.gridy = 2;
		panel_1.add(panel_7, gbc_panel_7);
		
		TextePrenom = new JTextField();
		panel_7.add(TextePrenom);
		TextePrenom.setHorizontalAlignment(SwingConstants.CENTER);
		TextePrenom.setColumns(10);
		
		TroisPoint3 = new JButton("...");
		TroisPoint3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		TroisPoint3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		TroisPoint3.setFocusPainted(false);
		TroisPoint3.setContentAreaFilled(false);
		panel_7.add(TroisPoint3);
						
						DateDeNaissance = new JTextField();
						DateDeNaissance.setHorizontalAlignment(SwingConstants.CENTER);
						DateDeNaissance.setFont(new Font("Tahoma", Font.PLAIN, 15));
						DateDeNaissance.setText("Date de naissance");
						DateDeNaissance.setEditable(false);
						GridBagConstraints gbc_DateDeNaissance = new GridBagConstraints();
						gbc_DateDeNaissance.fill = GridBagConstraints.BOTH;
						gbc_DateDeNaissance.gridx = 0;
						gbc_DateDeNaissance.gridy = 2;
						panel_1.add(DateDeNaissance, gbc_DateDeNaissance);
						DateDeNaissance.setColumns(10);
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		PhotoJoueur = new JLabel("");
		PhotoJoueur.setIcon(null);
		panel_2.add(PhotoJoueur);
		
		TexteDemanderLaPhotoDuJoueur = new JTextField();
		TexteDemanderLaPhotoDuJoueur.setFont(new Font("Tahoma", Font.PLAIN, 12));
		TexteDemanderLaPhotoDuJoueur.setText("Ajouter la photo du joueur ci-dessous :");
		TexteDemanderLaPhotoDuJoueur.setEditable(false);
		panel_2.add(TexteDemanderLaPhotoDuJoueur, BorderLayout.NORTH);
		TexteDemanderLaPhotoDuJoueur.setColumns(10);
		TexteDemanderLaPhotoDuJoueur.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JoueurInfo joueur = new JoueurInfo(0,TexteNom.getText(), TextePrenom.getText(), null, Date.valueOf(DateDeNaissance.getText()), Date.valueOf(DateDebutTournoi.getText()), Date.valueOf(DateFinDuContrat.getText()), "fr");
				container.setJoueur(joueur);
			}
		});
	}
}