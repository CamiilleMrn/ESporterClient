package ihm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Color;

public class LogIn extends JPanel{

	private JFrame frame;
	private JTextField txtSaisirIdentifiant;
	private JPasswordField txtSaisirPsw;


	/**
	 * Create the application.
	 */
	public LogIn() {
		this.setVisible(false);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel containerLogin = new JPanel();
		containerLogin.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, MasterFrame.COULEUR_MASTER, MasterFrame.COULEUR_MASTER, MasterFrame.COULEUR_TEXTE, MasterFrame.COULEUR_MASTER));
		containerLogin.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		add(containerLogin);
		containerLogin.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel containerPictureLogin = new JPanel();
		containerPictureLogin.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		containerLogin.add(containerPictureLogin);
		GridBagLayout gbl_containerPictureLogin = new GridBagLayout();
		gbl_containerPictureLogin.columnWidths = new int[] {0};
		gbl_containerPictureLogin.rowHeights = new int[] {containerLogin.getHeight()};
		gbl_containerPictureLogin.columnWeights = new double[]{0.0, 0.0};
		gbl_containerPictureLogin.rowWeights = new double[]{0.0};
		containerPictureLogin.setLayout(gbl_containerPictureLogin);
		
		JLabel lblNewLabel_1 = new JLabel("\r\n");
		lblNewLabel_1.setFont(new Font("Cambria", Font.PLAIN, 10));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Cam\\OneDrive\\COURS\\S3\\SAE - Saison Esport\\AvatarLogin.jpg"));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.ipady = containerLogin.getHeight()/2;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		containerPictureLogin.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JPanel ContainerConn = new JPanel();
		ContainerConn.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		containerLogin.add(ContainerConn);
		GridBagLayout gbl_ContainerConn = new GridBagLayout();
		gbl_ContainerConn.columnWidths = new int[] {0};
		gbl_ContainerConn.rowHeights = new int[] {0, 0, 0};
		gbl_ContainerConn.columnWeights = new double[]{1.0};
		gbl_ContainerConn.rowWeights = new double[]{1.0, 1.0, 1.0};
		ContainerConn.setLayout(gbl_ContainerConn);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.fill = GridBagConstraints.VERTICAL;
		gbc_panel_9.anchor = GridBagConstraints.WEST;
		gbc_panel_9.ipady = 10;
		gbc_panel_9.insets = new Insets(0, 0, 5, 0);
		gbc_panel_9.ipadx = 50;
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 1;
		ContainerConn.add(panel_9, gbc_panel_9);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[] {0};
		gbl_panel_9.rowHeights = new int[] {0, 0, 0, 0};
		gbl_panel_9.columnWeights = new double[]{0.0, 0.0};
		gbl_panel_9.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel_9.setLayout(gbl_panel_9);
		
		JLabel lblNewLabel_3 = new JLabel("Identifiant\r\n");
		lblNewLabel_3.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(MasterFrame.COULEUR_TEXTE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		panel_9.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtSaisirIdentifiant = new JTextField();
		txtSaisirIdentifiant.setFont(new Font("Cambria", Font.PLAIN, 12));
		txtSaisirIdentifiant.setBorder(new MatteBorder(0, 0, 1, 0, MasterFrame.COULEUR_MASTER));
		txtSaisirIdentifiant.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		txtSaisirIdentifiant.setForeground(MasterFrame.COULEUR_TEXTE);
		GridBagConstraints gbc_txtSaisirIdentifiant = new GridBagConstraints();
		gbc_txtSaisirIdentifiant.anchor = GridBagConstraints.WEST;
		gbc_txtSaisirIdentifiant.insets = new Insets(0, 0, 5, 5);
		gbc_txtSaisirIdentifiant.gridwidth = 2;
		gbc_txtSaisirIdentifiant.gridx = 0;
		gbc_txtSaisirIdentifiant.gridy = 3;
		panel_9.add(txtSaisirIdentifiant, gbc_txtSaisirIdentifiant);
		txtSaisirIdentifiant.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mot de passe\r\n");
		lblNewLabel_2.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(MasterFrame.COULEUR_TEXTE);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		panel_9.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtSaisirPsw = new JPasswordField();
		txtSaisirPsw.setForeground(MasterFrame.COULEUR_TEXTE);
		txtSaisirPsw.setFont(new Font("Cambria", Font.PLAIN, 12));
		txtSaisirPsw.setBorder(new MatteBorder(0, 0, 1, 0, MasterFrame.COULEUR_MASTER));
		txtSaisirPsw.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_txtSaisirPsw = new GridBagConstraints();
		gbc_txtSaisirPsw.insets = new Insets(0, 0, 0, 5);
		gbc_txtSaisirPsw.anchor = GridBagConstraints.WEST;
		gbc_txtSaisirPsw.gridx = 0;
		gbc_txtSaisirPsw.gridy = 5;
		panel_9.add(txtSaisirPsw, gbc_txtSaisirPsw);
		txtSaisirPsw.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.ipadx = 20;
		gbc_panel_10.anchor = GridBagConstraints.SOUTH;
		gbc_panel_10.insets = new Insets(0, 0, 5, 0);
		gbc_panel_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_10.gridx = 0;
		gbc_panel_10.gridy = 2;
		ContainerConn.add(panel_10, gbc_panel_10);
		
		JButton btnNewButton = new JButton("<html><body><u>Mot de passe oublié ? </u></body></html>");
		btnNewButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewButton.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton.setVerticalTextPosition(SwingConstants.TOP);
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnNewButton.setMargin(new Insets(2, 14, 20, 16));
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Cambria", Font.ITALIC, 10));
		btnNewButton.setForeground(MasterFrame.COULEUR_MASTER);
		btnNewButton.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_10.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Connexion\r\n");
		lblNewLabel.setForeground(MasterFrame.COULEUR_TEXTE);
		lblNewLabel.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblNewLabel.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		ContainerConn.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel_7 = new JPanel();
		panel_7.setPreferredSize(new Dimension(5, 10));
		panel_7.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel_7.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_7.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		containerLogin.add(panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[] {0, 0};
		gbl_panel_7.rowHeights = new int[] {250, 0};
		gbl_panel_7.columnWeights = new double[]{0.0, 0.0};
		gbl_panel_7.rowWeights = new double[]{0.0, 0.0};
		panel_7.setLayout(gbl_panel_7);
		
		JButton boutonConnexion = new JButton("  Connexion  \r\n");
		boutonConnexion.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		boutonConnexion.setHorizontalTextPosition(SwingConstants.LEFT);
		boutonConnexion.setHorizontalAlignment(SwingConstants.LEFT);
		boutonConnexion.setIconTextGap(10);
		boutonConnexion.setMargin(new Insets(14, 0, 14, 14));
		boutonConnexion.setFont(new Font("Cambria", Font.PLAIN, 12));
		boutonConnexion.setForeground(MasterFrame.COULEUR_TEXTE);
		boutonConnexion.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 164, 210), null, new Color(0, 164, 210), null));
		boutonConnexion.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		boutonConnexion.setVerticalTextPosition(SwingConstants.BOTTOM);
		boutonConnexion.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_boutonConnexion = new GridBagConstraints();
		gbc_boutonConnexion.insets = new Insets(0, 0, 5, 0);
		gbc_boutonConnexion.gridheight = 0;
		gbc_boutonConnexion.anchor = GridBagConstraints.SOUTH;
		gbc_boutonConnexion.gridx = 1;
		gbc_boutonConnexion.gridy = 0;
		panel_7.add(boutonConnexion, gbc_boutonConnexion);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_1.setPreferredSize(new Dimension(100, 250));
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_2.setPreferredSize(new Dimension(100, 250));
		add(panel_2, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_3.setPreferredSize(new Dimension(550, 100));
		panel_3.setSize(new Dimension(100, 100));
		panel_3.setMinimumSize(new Dimension(100, 100));
		add(panel_3, BorderLayout.WEST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_4.setPreferredSize(new Dimension(550, 100));
		add(panel_4, BorderLayout.EAST);
		
		constructeurBouttonConnexion(boutonConnexion);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAnnuler.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAnnuler.setPreferredSize(new Dimension(93, 21));
		btnAnnuler.setMinimumSize(new Dimension(93, 21));
		btnAnnuler.setMaximumSize(new Dimension(93, 21));
		btnAnnuler.setMargin(new Insets(10, 0, 14, 14));
		btnAnnuler.setIconTextGap(10);
		btnAnnuler.setHorizontalTextPosition(SwingConstants.LEFT);
		btnAnnuler.setHorizontalAlignment(SwingConstants.LEFT);
		btnAnnuler.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnAnnuler.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnAnnuler.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, MasterFrame.COULEUR_MASTER, null, MasterFrame.COULEUR_MASTER, null));
		btnAnnuler.setForeground(MasterFrame.COULEUR_TEXTE);
		btnAnnuler.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnnuler.gridx = 0;
		gbc_btnAnnuler.gridy = 1;
		panel_7.add(btnAnnuler, gbc_btnAnnuler);
		
		constructeurBouttonAnnuler(btnAnnuler);
	}
	
	public void constructeurBouttonAnnuler(JButton boutonAnnuler) {
		boutonAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MasterFrame master = MasterFrame.getInstance();
				setVisible(false);
				master.getMain().setVisible(true);
			}
		});
	}
	
	public void constructeurBouttonConnexion(JButton boutonConnexion) {
		boutonConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MasterFrame master = MasterFrame.getInstance();
				try {
					String identifiant = txtSaisirIdentifiant.getText();
					String psw = new String(txtSaisirPsw.getPassword());

					master.getUser().login(identifiant, psw);
					setVisible(false);
					master.getMain().setVisible(true);
				} catch (Exception e1) {
					master.error(e1);
				}
			}
		});
	}

}

