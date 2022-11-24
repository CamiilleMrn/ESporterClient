package ihm.ecurie;

//import statements
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import ihm.MasterFrame;
import ihm.component.DatePicker;
import ihm.component.containerJoueur;
import types.EcurieInfo;
import types.JoueurInfo;
import types.Login;
import types.registerJoueur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.FlowLayout;

//create class and extend with JFrame
public class AjouterunJoueur extends JDialog {
	/**
	* 
	*/
	private static final long serialVersionUID = -725884370429132629L;
	// add JPanel to the contentPane
	private JPanel contentPane;
	// declare variable
	private JTextField TexteDateFinContrat;
	private JTextField TexteDateDebContrat;
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
	private JTextField txtDateNaissance;
	private JPanel PanelNomTxt;
	private JTextField TexteDuNom;
	private JTextField textPrenom;
	private JButton TroisPoint3;
	private JFileChooser choose = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	public static final Color COULEUR_MASTER = new Color(0, 164, 210);
	public static final Color COULEUR_MASTER_FOND = Color.DARK_GRAY;
	public static final Color COULEUR_TEXTE = Color.WHITE;
	private JPanel PanelBtnValider;
	private JButton BtnValider;
	private JTextField titleidentifiant;
	private JPanel panelIdentifiant;
	private JTextField identifianttxt;
	private JTextField txtMotDePasse;
	private JPanel panel;
	private JTextField textField_1;
	private BufferedImage image;

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	//create constructor of class
	public AjouterunJoueur(containerJoueur container)
	{

		//set title
		setTitle("Ajouter joueur ");
		//set close operation on frame
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//set bounds of frame
		setBounds(100, 100, 617, 341);
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
		TroisPoint2.setFont(new Font("Cambria", Font.PLAIN, 15));
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
				TexteDateFinContrat.setText(new DatePicker(f).setPickedDate());
			}
		});
		//create text field
				TexteDateFinContrat = new JTextField();
				TexteDateFinContrat.setBorder(null);
				TexteDateFinContrat.setHorizontalAlignment(SwingConstants.CENTER);
				TexteDateFinContrat.setFont(new Font("Cambria", Font.PLAIN, 13));
				TexteDateFinContrat.setColumns(11);
		
		JButton TroisPoint= new JButton("...");
		TroisPoint.setFont(new Font("Cambria", Font.PLAIN, 15));
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
				TexteDateDebContrat.setText(new DatePicker(f).setPickedDate());
			}
		});
		//create text field
				TexteDateDebContrat = new JTextField();
				TexteDateDebContrat.setBorder(null);
				TexteDateDebContrat.setHorizontalAlignment(SwingConstants.CENTER);
				TexteDateDebContrat.setFont(new Font("Cambria", Font.PLAIN, 13));
				TexteDateDebContrat.setColumns(11);
		
		
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
		DateDebutTournoi.setFont(new Font("Cambria", Font.BOLD, 12));
		DateDebutTournoi.setEditable(false);
		PanelDebContrat.add(DateDebutTournoi, BorderLayout.NORTH);
		PanelDebContrat.add(TroisPoint, BorderLayout.EAST);
		PanelDebContrat.add(TexteDateDebContrat, BorderLayout.WEST);
		DateDebutTournoi.setColumns(10);
		DateDebutTournoi.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		
		PanelFinContrat = new JPanel();
		panelDateContrat.add(PanelFinContrat, BorderLayout.EAST);
		PanelFinContrat.setLayout(new BorderLayout(0, 0));
		PanelFinContrat.add(TroisPoint2, BorderLayout.EAST);
		PanelFinContrat.add(TexteDateFinContrat, BorderLayout.WEST);
		
		DateFinDuContrat = new JTextField();
		DateFinDuContrat.setForeground(Color.WHITE);
		DateFinDuContrat.setBackground(COULEUR_MASTER_FOND);
		DateFinDuContrat.setHorizontalAlignment(SwingConstants.CENTER);
		DateFinDuContrat.setFont(new Font("Cambria", Font.BOLD, 12));
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
			public void actionPerformed(ActionEvent e) throws IllegalArgumentException{
				
				String nom = TexteDuNom.getText();
				String prenom = textPrenom.getText();
				
				Date dateDebutContrat= Date.valueOf(TexteDateDebContrat.getText());
				Date dateNaissance= Date.valueOf(txtDateNaissance.getText());
				Date dateFinContrat= Date.valueOf(TexteDateFinContrat.getText());
				ByteArrayOutputStream blob = new ByteArrayOutputStream();
				image = resize(image, 200, 300);
				try {
					ImageIO.write(image, "png", blob);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				InputStream is = new ByteArrayInputStream(blob.toByteArray());
				if (nom == null) {
					MasterFrame.getInstance().error(new IllegalArgumentException("Le champ nom n'est pas specifié"));
				}else if(prenom==null){
					MasterFrame.getInstance().error( new IllegalArgumentException("Le champ prenom n'est pas specifié"));
				}else if(dateDebutContrat==null){
					MasterFrame.getInstance().error( new IllegalArgumentException("Le champ debut du contrat n'est pas specifié"));
				}else if(dateNaissance==null) {
					MasterFrame.getInstance().error( new IllegalArgumentException("Le champ date de naissance n'est pas specifié"));
				}else if(dateFinContrat== null) {
					MasterFrame.getInstance().error( new IllegalArgumentException("Le champ date de fin du contrat n'est pas specifié"));
				}else if(is == null) {
					MasterFrame.getInstance().error( new IllegalArgumentException("Il y a une erreur avec la photo"));
				}else {
					try {
						BufferedImage bf = ImageIO.read(is);
						types.Image im = new types.Image(image, "png");
						JoueurInfo joueur = new JoueurInfo(-1,nom, prenom,im,dateNaissance,dateDebutContrat,dateFinContrat,-1,-1,((EcurieInfo)MasterFrame.getInstance().getUser().getInfo()).getId());
						Login l = new Login(identifianttxt.getText(), textField_1.getText());
						container.setJoueur(new registerJoueur(joueur, l));
						dispose();
					} catch (IOException e1) {
						MasterFrame.getInstance().error( new IllegalArgumentException("Il y a une erreur avec la photo"));
					} 
					
				}
				
			}
		});
		
		BtnValider.setForeground(Color.WHITE);
		BtnValider.setBackground(COULEUR_MASTER);
		BtnValider.setFont(new Font("Cambria", Font.PLAIN, 15));
		PanelBtnValider.add(BtnValider, BorderLayout.NORTH);
		
		panelInfo = new JPanel();
		panelInfo.setBackground(COULEUR_MASTER_FOND);
		contentPane.add(panelInfo, BorderLayout.EAST);
		GridBagLayout gbl_panelInfo = new GridBagLayout();
		gbl_panelInfo.columnWidths = new int[] {136, 136};
		gbl_panelInfo.rowHeights = new int[] {53, 53, 52, 0, 0};
		gbl_panelInfo.columnWeights = new double[]{1.0, 1.0};
		gbl_panelInfo.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0};
		panelInfo.setLayout(gbl_panelInfo);
						
						TexteNom = new JTextField();
						TexteNom.setForeground(Color.WHITE);
						TexteNom.setBackground(COULEUR_MASTER_FOND);
						TexteNom.setBorder(null);
						TexteNom.setHorizontalAlignment(SwingConstants.CENTER);
						TexteNom.setFont(new Font("Cambria", Font.PLAIN, 15));
						TexteNom.setText("Nom   :");
						TexteNom.setEditable(false);
						GridBagConstraints gbc_TexteNom = new GridBagConstraints();
						gbc_TexteNom.insets = new Insets(0, 0, 5, 5);
						gbc_TexteNom.fill = GridBagConstraints.BOTH;
						gbc_TexteNom.gridx = 0;
						gbc_TexteNom.gridy = 0;
						panelInfo.add(TexteNom, gbc_TexteNom);
						
						TexteNom.setColumns(10);
						
						PanelNomTxt = new JPanel();
						FlowLayout flowLayout = (FlowLayout) PanelNomTxt.getLayout();
						flowLayout.setVgap(0);
						flowLayout.setHgap(3);
						GridBagConstraints gbc_PanelNomTxt = new GridBagConstraints();
						gbc_PanelNomTxt.insets = new Insets(0, 0, 5, 0);
						gbc_PanelNomTxt.gridx = 1;
						gbc_PanelNomTxt.gridy = 0;
						panelInfo.add(PanelNomTxt, gbc_PanelNomTxt);
						
						TexteDuNom = new JTextField();
						TexteDuNom.setBorder(null);
						TexteDuNom.setFont(new Font("Cambria", Font.PLAIN, 15));
						TexteDuNom.setHorizontalAlignment(SwingConstants.CENTER);
						TexteDuNom.setColumns(12);
						PanelNomTxt.add(TexteDuNom);
						

						
						Prenom = new JTextField();
						Prenom.setForeground(Color.WHITE);
						Prenom.setBorder(null);
						Prenom.setBackground(COULEUR_MASTER_FOND);
						Prenom.setText("Prenom  :");
						Prenom.setHorizontalAlignment(SwingConstants.CENTER);
						Prenom.setFont(new Font("Cambria", Font.PLAIN, 15));
						Prenom.setEditable(false);
						GridBagConstraints gbc_Prenom = new GridBagConstraints();
						gbc_Prenom.insets = new Insets(0, 0, 5, 5);
						gbc_Prenom.fill = GridBagConstraints.BOTH;
						gbc_Prenom.gridx = 0;
						gbc_Prenom.gridy = 1;
						panelInfo.add(Prenom, gbc_Prenom);
						Prenom.setColumns(10);
						
						PanelPrenomTxt = new JPanel();
						GridBagConstraints gbc_PanelPrenomTxt = new GridBagConstraints();
						gbc_PanelPrenomTxt.insets = new Insets(0, 0, 5, 0);
						gbc_PanelPrenomTxt.gridx = 1;
						gbc_PanelPrenomTxt.gridy = 1;
						panelInfo.add(PanelPrenomTxt, gbc_PanelPrenomTxt);
						PanelPrenomTxt.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 0));
						
						textPrenom = new JTextField();
						textPrenom.setBorder(null);
						textPrenom.setHorizontalAlignment(SwingConstants.CENTER);
						textPrenom.setFont(new Font("Cambria", Font.PLAIN, 15));
						textPrenom.setColumns(12);
						PanelPrenomTxt.add(textPrenom);
		
		PanelNaisTxt = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) PanelNaisTxt.getLayout();
		flowLayout_1.setVgap(10);
		flowLayout_1.setHgap(3);
		PanelNaisTxt.setBackground(COULEUR_MASTER_FOND);
		PanelNaisTxt.setBorder(null);
		GridBagConstraints gbc_PanelNaisTxt = new GridBagConstraints();
		gbc_PanelNaisTxt.insets = new Insets(0, 0, 5, 0);
		gbc_PanelNaisTxt.gridx = 1;
		gbc_PanelNaisTxt.gridy = 2;
		panelInfo.add(PanelNaisTxt, gbc_PanelNaisTxt);
		
		txtDateNaissance = new JTextField();
		txtDateNaissance.setBorder(null);
		txtDateNaissance.setFont(new Font("Cambria", Font.PLAIN, 15));
		PanelNaisTxt.add(txtDateNaissance);
		txtDateNaissance.setHorizontalAlignment(SwingConstants.CENTER);
		txtDateNaissance.setColumns(11);
		
		TroisPoint3 = new JButton("...");
		TroisPoint3.setBorder(null);
		TroisPoint3.setBackground(Color.WHITE);
		TroisPoint3.setForeground(COULEUR_TEXTE);
		TroisPoint3.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {
				final JFrame f = new JFrame();
				//set text which is collected by date picker i.e. set date 
				txtDateNaissance.setText(new DatePicker(f).setPickedDate());
			}
		});
		TroisPoint3.setFont(new Font("Cambria", Font.PLAIN, 12));
		TroisPoint3.setFocusPainted(false);
		TroisPoint3.setContentAreaFilled(false);
		PanelNaisTxt.add(TroisPoint3);
						
						DateDeNaissance = new JTextField();
						DateDeNaissance.setBorder(null);
						DateDeNaissance.setForeground(Color.WHITE);
						DateDeNaissance.setBackground(COULEUR_MASTER_FOND);
						DateDeNaissance.setHorizontalAlignment(SwingConstants.CENTER);
						DateDeNaissance.setFont(new Font("Cambria", Font.PLAIN, 15));
						DateDeNaissance.setText("Date de naissance");
						DateDeNaissance.setEditable(false);
						GridBagConstraints gbc_DateDeNaissance = new GridBagConstraints();
						gbc_DateDeNaissance.insets = new Insets(0, 0, 5, 5);
						gbc_DateDeNaissance.fill = GridBagConstraints.BOTH;
						gbc_DateDeNaissance.gridx = 0;
						gbc_DateDeNaissance.gridy = 2;
						panelInfo.add(DateDeNaissance, gbc_DateDeNaissance);
						DateDeNaissance.setColumns(10);
						
						titleidentifiant = new JTextField();
						titleidentifiant.setHorizontalAlignment(SwingConstants.CENTER);
						titleidentifiant.setBackground(COULEUR_MASTER_FOND);
						titleidentifiant.setForeground(COULEUR_TEXTE);
						titleidentifiant.setBorder(null);
						titleidentifiant.setText("Identifiant :");
						titleidentifiant.setEditable(false);
						titleidentifiant.setFont(new Font("Cambria", Font.PLAIN, 15));
						GridBagConstraints gbc_titleidentifiant = new GridBagConstraints();
						gbc_titleidentifiant.insets = new Insets(0, 0, 5, 5);
						gbc_titleidentifiant.fill = GridBagConstraints.HORIZONTAL;
						gbc_titleidentifiant.gridx = 0;
						gbc_titleidentifiant.gridy = 3;
						panelInfo.add(titleidentifiant, gbc_titleidentifiant);
						titleidentifiant.setColumns(10);
						
						panelIdentifiant = new JPanel();
						panelIdentifiant.setBorder(null);
						panelIdentifiant.setBackground(COULEUR_MASTER_FOND);
						FlowLayout fl_panelIdentifiant = (FlowLayout) panelIdentifiant.getLayout();
						fl_panelIdentifiant.setVgap(0);
						fl_panelIdentifiant.setHgap(3);
						GridBagConstraints gbc_panelIdentifiant = new GridBagConstraints();
						gbc_panelIdentifiant.insets = new Insets(0, 0, 5, 0);
						gbc_panelIdentifiant.gridx = 1;
						gbc_panelIdentifiant.gridy = 3;
						panelInfo.add(panelIdentifiant, gbc_panelIdentifiant);
						
						identifianttxt = new JTextField();
						identifianttxt.setFont(new Font("Cambria", Font.PLAIN, 12));
						identifianttxt.setHorizontalAlignment(SwingConstants.CENTER);
						panelIdentifiant.add(identifianttxt);
						identifianttxt.setColumns(15);
						
						txtMotDePasse = new JTextField();
						txtMotDePasse.setBackground(COULEUR_MASTER_FOND);
						txtMotDePasse.setForeground(COULEUR_TEXTE);
						txtMotDePasse.setBorder(null);
						txtMotDePasse.setFont(new Font("Cambria", Font.PLAIN, 15));
						txtMotDePasse.setText("Mot de passe :");
						txtMotDePasse.setHorizontalAlignment(SwingConstants.CENTER);
						GridBagConstraints gbc_txtMotDePasse = new GridBagConstraints();
						gbc_txtMotDePasse.insets = new Insets(0, 0, 0, 5);
						gbc_txtMotDePasse.fill = GridBagConstraints.HORIZONTAL;
						gbc_txtMotDePasse.gridx = 0;
						gbc_txtMotDePasse.gridy = 4;
						panelInfo.add(txtMotDePasse, gbc_txtMotDePasse);
						txtMotDePasse.setColumns(10);
						
						panel = new JPanel();
						FlowLayout flowLayout_2 = (FlowLayout) panel.getLayout();
						flowLayout_2.setHgap(3);
						panel.setBorder(null);
						panel.setBackground(COULEUR_MASTER_FOND);
						GridBagConstraints gbc_panel = new GridBagConstraints();
						gbc_panel.fill = GridBagConstraints.BOTH;
						gbc_panel.gridx = 1;
						gbc_panel.gridy = 4;
						panelInfo.add(panel, gbc_panel);
						
						textField_1 = new JTextField();
						textField_1.setHorizontalAlignment(SwingConstants.CENTER);
						textField_1.setFont(new Font("Cambria", Font.PLAIN, 12));
						panel.add(textField_1);
						textField_1.setColumns(15);
		panelphoto = new JPanel();
		contentPane.add(panelphoto, BorderLayout.CENTER);
		panelphoto.setLayout(new BorderLayout(0, 0));
		
		PhotoJoueur = new JLabel("");
		PhotoJoueur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser file = new JFileChooser();
		        file.setCurrentDirectory(new File(System.getProperty("user.home")));
		        //filtrer les fichiers
		        FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
		        file.setFileFilter(imageFilter);
		        int res = file.showOpenDialog(null);
		        //si l'utilisateur clique sur enregistrer dans Jfilechooser
		        if(res == JFileChooser.APPROVE_OPTION){
		          File selFile = file.getSelectedFile();

		          try {
			        String path = selFile.getCanonicalPath();
			        PhotoJoueur.setIcon(new ImageIcon(path));
					image = ImageIO.read(selFile);
					
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		          
		          }
		      }
		    });
		PhotoJoueur.setIcon(null);
		panelphoto.add(PhotoJoueur);
		
		TexteDemanderLaPhotoDuJoueur = new JTextField();
		TexteDemanderLaPhotoDuJoueur.setForeground(Color.WHITE);
		TexteDemanderLaPhotoDuJoueur.setBackground(COULEUR_MASTER_FOND);
		TexteDemanderLaPhotoDuJoueur.setFont(new Font("Cambria", Font.PLAIN, 15));
		TexteDemanderLaPhotoDuJoueur.setText("Ajouter la photo du joueur ci-dessous :");
		TexteDemanderLaPhotoDuJoueur.setEditable(false);
		panelphoto.add(TexteDemanderLaPhotoDuJoueur, BorderLayout.NORTH);
		TexteDemanderLaPhotoDuJoueur.setColumns(10);
		TexteDemanderLaPhotoDuJoueur.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		if (container.getJoueur() != null) {
			JoueurInfo j = container.getJoueur().getJoueur();
			TexteDuNom.setText(j.getNom());
			TexteDateDebContrat.setText(j.getDateDebutContrat().toString());
			TexteDateFinContrat.setText(j.getDateFinContrat().toString());
			textPrenom.setText(j.getPrenom());
			PhotoJoueur.setIcon(new ImageIcon(j.getPhoto().getImage()));
			txtDateNaissance.setText(j.getDateNaissance().toString());
			identifianttxt.setText(container.getJoueur().getLogin().getUsername());
			textField_1.setText(container.getJoueur().getLogin().getPassword());
			image = j.getPhoto().getImage();
		}
	
		
	}
	
	public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}
}