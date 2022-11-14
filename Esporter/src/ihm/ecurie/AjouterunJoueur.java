package ihm.ecurie;
//import statements
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;

import ihm.component.DatePicker;
import ihm.component.containerJoueur;
import types.JoueurInfo;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.FlowLayout;



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
		private JPanel panelDateContrat;
		private JPanel panelInfo;
		private JPanel panelphoto;
		private JTextField TexteNom;
		private JTextField Prenom;
		private JTextField DateDeNaissance;
		private JLabel PhotoJoueur;
		private JPanel PanelDebContrat;
		private JPanel PanelFinContrat;
		private JPanel panelValider;
		private JTextField DateDebutTournoi;
		private JTextField DateFinDuContrat;
		private JPanel PanelPrenomTxt;
		private JTextField TexteDemanderLaPhotoDuJoueur;
		private JPanel PanelNaisTxt;
		private JTextField TextePrenom;
		private JPanel PanelNomTxt;
		private JTextField TexteDuNom;
		private JTextField textPrenom;
		private JButton TroisPoint3;
		private JFileChooser choose = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		public static final Color COULEUR_MASTER = new Color(0,164,210);
		public static final Color COULEUR_MASTER_FOND = Color.DARK_GRAY;
		public static final Color COULEUR_TEXTE = Color.WHITE;
		private JPanel PanelBtnValider;
		private JButton BtnValider;


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
		setBounds(100, 100, 563, 316);
		//create new JPanel in contentPane
		contentPane = new JPanel();
		contentPane.setBackground(COULEUR_MASTER_FOND);
		//set border of frame
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//set contentPane 
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		//create button and there object
		JButton TroisPoint2 = new JButton("...");
		TroisPoint2.setBorder(null);
		TroisPoint2.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
				TexteDate2.setBorder(null);
				TexteDate2.setHorizontalAlignment(SwingConstants.CENTER);
				TexteDate2.setFont(new Font("Tahoma", Font.PLAIN, 13));
				TexteDate2.setColumns(11);
		
		JButton TroisPoint= new JButton("...");
		TroisPoint.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TroisPoint.setBorder(null);
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
				TexteDate.setBorder(null);
				TexteDate.setHorizontalAlignment(SwingConstants.CENTER);
				TexteDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
				TexteDate.setColumns(11);
		
		
		panelDateContrat = new JPanel();
		panelDateContrat.setBackground(COULEUR_MASTER_FOND);
		contentPane.add(panelDateContrat, BorderLayout.SOUTH);
		panelDateContrat.setLayout(new BorderLayout(0, 0));
		
		PanelDebContrat = new JPanel();
		panelDateContrat.add(PanelDebContrat, BorderLayout.WEST);
		PanelDebContrat.setLayout(new BorderLayout(0, 0));
	
		DateDebutTournoi = new JTextField();
		DateDebutTournoi.setForeground(Color.WHITE);
		DateDebutTournoi.setBackground(COULEUR_MASTER_FOND);
		DateDebutTournoi.setHorizontalAlignment(SwingConstants.CENTER);
		DateDebutTournoi.setText("Date debut du contrat");
		DateDebutTournoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		DateDebutTournoi.setEditable(false);
		PanelDebContrat.add(DateDebutTournoi, BorderLayout.NORTH);
		PanelDebContrat.add(TroisPoint, BorderLayout.EAST);
		PanelDebContrat.add(TexteDate, BorderLayout.WEST);
		DateDebutTournoi.setColumns(10);
		DateDebutTournoi.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		
		PanelFinContrat = new JPanel();
		panelDateContrat.add(PanelFinContrat, BorderLayout.EAST);
		PanelFinContrat.setLayout(new BorderLayout(0, 0));
		PanelFinContrat.add(TroisPoint2, BorderLayout.EAST);
		PanelFinContrat.add(TexteDate2, BorderLayout.WEST);
		
		DateFinDuContrat = new JTextField();
		DateFinDuContrat.setForeground(Color.WHITE);
		DateFinDuContrat.setBackground(COULEUR_MASTER_FOND);
		DateFinDuContrat.setHorizontalAlignment(SwingConstants.CENTER);
		DateFinDuContrat.setFont(new Font("Tahoma", Font.BOLD, 11));
		DateFinDuContrat.setText("Date fin du contrat");
		DateFinDuContrat.setEditable(false);
		PanelFinContrat.add(DateFinDuContrat, BorderLayout.NORTH);
		DateFinDuContrat.setColumns(10);
		DateFinDuContrat.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		
		panelValider = new JPanel();
		panelValider.setBackground(COULEUR_MASTER_FOND);
		panelDateContrat.add(panelValider, BorderLayout.SOUTH);
		panelValider.setLayout(new BorderLayout(0, 0));
		
		PanelBtnValider = new JPanel();
		panelValider.add(PanelBtnValider, BorderLayout.EAST);
		PanelBtnValider.setLayout(new BorderLayout(0, 0));
		
		BtnValider = new JButton("Valider");
		BtnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BtnValider.setForeground(Color.WHITE);
		BtnValider.setBackground(COULEUR_MASTER);
		BtnValider.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PanelBtnValider.add(BtnValider, BorderLayout.NORTH);
		
		panelInfo = new JPanel();
		panelInfo.setBackground(COULEUR_MASTER_FOND);
		contentPane.add(panelInfo, BorderLayout.EAST);
		GridBagLayout gbl_panelInfo = new GridBagLayout();
		gbl_panelInfo.columnWidths = new int[] {136, 136};
		gbl_panelInfo.rowHeights = new int[] {53, 53, 52};
		gbl_panelInfo.columnWeights = new double[]{0.0, 0.0};
		gbl_panelInfo.rowWeights = new double[]{1.0, 0.0, 0.0};
		panelInfo.setLayout(gbl_panelInfo);
						
						TexteNom = new JTextField();
						TexteNom.setForeground(Color.WHITE);
						TexteNom.setBackground(COULEUR_MASTER_FOND);
						TexteNom.setBorder(null);
						TexteNom.setHorizontalAlignment(SwingConstants.CENTER);
						TexteNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
						TexteNom.setText("Nom   :");
						TexteNom.setEditable(false);
						GridBagConstraints gbc_TexteNom = new GridBagConstraints();
						gbc_TexteNom.fill = GridBagConstraints.BOTH;
						gbc_TexteNom.gridx = 0;
						gbc_TexteNom.gridy = 0;
						panelInfo.add(TexteNom, gbc_TexteNom);
						
						TexteNom.setColumns(9);
						
						PanelNomTxt = new JPanel();
						FlowLayout flowLayout = (FlowLayout) PanelNomTxt.getLayout();
						flowLayout.setVgap(0);
						flowLayout.setHgap(0);
						GridBagConstraints gbc_PanelNomTxt = new GridBagConstraints();
						gbc_PanelNomTxt.gridx = 1;
						gbc_PanelNomTxt.gridy = 0;
						panelInfo.add(PanelNomTxt, gbc_PanelNomTxt);
						
						TexteDuNom = new JTextField();
						TexteDuNom.setBorder(null);
						TexteDuNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
						TexteDuNom.setHorizontalAlignment(SwingConstants.CENTER);
						TexteDuNom.setColumns(10);
						PanelNomTxt.add(TexteDuNom);
						

						
						Prenom = new JTextField();
						Prenom.setForeground(Color.WHITE);
						Prenom.setBorder(null);
						Prenom.setBackground(COULEUR_MASTER_FOND);
						Prenom.setText("Prenom  :");
						Prenom.setHorizontalAlignment(SwingConstants.CENTER);
						Prenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
						Prenom.setEditable(false);
						GridBagConstraints gbc_Prenom = new GridBagConstraints();
						gbc_Prenom.fill = GridBagConstraints.BOTH;
						gbc_Prenom.gridx = 0;
						gbc_Prenom.gridy = 1;
						panelInfo.add(Prenom, gbc_Prenom);
						Prenom.setColumns(10);
						
						PanelPrenomTxt = new JPanel();
						GridBagConstraints gbc_PanelPrenomTxt = new GridBagConstraints();
						gbc_PanelPrenomTxt.gridx = 1;
						gbc_PanelPrenomTxt.gridy = 1;
						panelInfo.add(PanelPrenomTxt, gbc_PanelPrenomTxt);
						PanelPrenomTxt.setLayout(new BorderLayout(0, 0));
						
						textPrenom = new JTextField();
						textPrenom.setBorder(null);
						textPrenom.setHorizontalAlignment(SwingConstants.CENTER);
						textPrenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
						textPrenom.setColumns(10);
						PanelPrenomTxt.add(textPrenom, BorderLayout.CENTER);
		
		PanelNaisTxt = new JPanel();
		PanelNaisTxt.setBackground(COULEUR_MASTER_FOND);
		GridBagConstraints gbc_PanelNaisTxt = new GridBagConstraints();
		gbc_PanelNaisTxt.gridx = 1;
		gbc_PanelNaisTxt.gridy = 2;
		panelInfo.add(PanelNaisTxt, gbc_PanelNaisTxt);
		
		TextePrenom = new JTextField();
		TextePrenom.setBorder(null);
		TextePrenom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		PanelNaisTxt.add(TextePrenom);
		TextePrenom.setHorizontalAlignment(SwingConstants.CENTER);
		TextePrenom.setColumns(10);
		
		TroisPoint3 = new JButton("...");
		TroisPoint3.setBorder(null);
		TroisPoint3.setForeground(Color.WHITE);
		TroisPoint3.setBackground(Color.WHITE);
		TroisPoint3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFrame f = new JFrame();
				//set text which is collected by date picker i.e. set date 
				TextePrenom.setText(new DatePicker(f).setPickedDate());
			}
		});
		TroisPoint3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		TroisPoint3.setFocusPainted(false);
		TroisPoint3.setContentAreaFilled(false);
		PanelNaisTxt.add(TroisPoint3);
						
						DateDeNaissance = new JTextField();
						DateDeNaissance.setBorder(null);
						DateDeNaissance.setForeground(Color.WHITE);
						DateDeNaissance.setBackground(COULEUR_MASTER_FOND);
						DateDeNaissance.setHorizontalAlignment(SwingConstants.CENTER);
						DateDeNaissance.setFont(new Font("Tahoma", Font.PLAIN, 15));
						DateDeNaissance.setText("Date de naissance");
						DateDeNaissance.setEditable(false);
						GridBagConstraints gbc_DateDeNaissance = new GridBagConstraints();
						gbc_DateDeNaissance.fill = GridBagConstraints.BOTH;
						gbc_DateDeNaissance.gridx = 0;
						gbc_DateDeNaissance.gridy = 2;
						panelInfo.add(DateDeNaissance, gbc_DateDeNaissance);
						DateDeNaissance.setColumns(10);
		panelphoto = new JPanel();
		contentPane.add(panelphoto, BorderLayout.CENTER);
		panelphoto.setLayout(new BorderLayout(0, 0));
		
		PhotoJoueur = new JLabel("");
		PhotoJoueur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				 int res = choose.showOpenDialog(null);
				 if (res == JFileChooser.APPROVE_OPTION) {
				      File file = choose.getSelectedFile();
				      System.out.println(file.getAbsolutePath());
				    }
			}
		});
		PhotoJoueur.setIcon(null);
		panelphoto.add(PhotoJoueur);
		
		TexteDemanderLaPhotoDuJoueur = new JTextField();
		TexteDemanderLaPhotoDuJoueur.setForeground(Color.WHITE);
		TexteDemanderLaPhotoDuJoueur.setBackground(COULEUR_MASTER_FOND);
		TexteDemanderLaPhotoDuJoueur.setFont(new Font("Tahoma", Font.PLAIN, 11));
		TexteDemanderLaPhotoDuJoueur.setText("Ajouter la photo du joueur ci-dessous :");
		TexteDemanderLaPhotoDuJoueur.setEditable(false);
		panelphoto.add(TexteDemanderLaPhotoDuJoueur, BorderLayout.NORTH);
		TexteDemanderLaPhotoDuJoueur.setColumns(10);
		TexteDemanderLaPhotoDuJoueur.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	}
}