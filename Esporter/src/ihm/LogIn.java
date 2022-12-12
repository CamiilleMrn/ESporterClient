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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
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

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.border.LineBorder;

public class LogIn extends JPanel{

	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnProceed;

	
	public JTextField getTxtUsername() {
		return txtUsername;
	}

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
		
		JPanel panelLoginAll = new JPanel();
		panelLoginAll.setBorder(new LineBorder(MasterFrame.COLOR_MASTER, 4, true));
		panelLoginAll.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		add(panelLoginAll);
		panelLoginAll.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelPicture = new JPanel();
		panelPicture.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelLoginAll.add(panelPicture);
		GridBagLayout gbl_panelPicture = new GridBagLayout();
		gbl_panelPicture.columnWidths = new int[] {0};
		gbl_panelPicture.rowHeights = new int[] {panelLoginAll.getHeight()};
		gbl_panelPicture.columnWeights = new double[]{0.0, 0.0};
		gbl_panelPicture.rowWeights = new double[]{0.0};
		panelPicture.setLayout(gbl_panelPicture);
		
		JLabel lblPicture = new JLabel("\r\n");
		lblPicture.setFont(new Font("Cambria", Font.PLAIN, 10));
		lblPicture.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			lblPicture.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("images/AvatarLogin.jpg"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GridBagConstraints gbc_lblPicture = new GridBagConstraints();
		gbc_lblPicture.anchor = GridBagConstraints.WEST;
		gbc_lblPicture.ipady = panelLoginAll.getHeight()/2;
		gbc_lblPicture.gridx = 1;
		gbc_lblPicture.gridy = 0;
		panelPicture.add(lblPicture, gbc_lblPicture);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelLoginAll.add(panelLogin);
		GridBagLayout gbl_panelLogin = new GridBagLayout();
		gbl_panelLogin.columnWidths = new int[] {0};
		gbl_panelLogin.rowHeights = new int[] {0, 0, 0};
		gbl_panelLogin.columnWeights = new double[]{1.0};
		gbl_panelLogin.rowWeights = new double[]{1.0, 1.0, 1.0};
		panelLogin.setLayout(gbl_panelLogin);
		
		JPanel panelCredential = new JPanel();
		panelCredential.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		GridBagConstraints gbc_panelCredential = new GridBagConstraints();
		gbc_panelCredential.fill = GridBagConstraints.VERTICAL;
		gbc_panelCredential.anchor = GridBagConstraints.WEST;
		gbc_panelCredential.ipady = 10;
		gbc_panelCredential.insets = new Insets(0, 0, 5, 0);
		gbc_panelCredential.ipadx = 50;
		gbc_panelCredential.gridx = 0;
		gbc_panelCredential.gridy = 1;
		panelLogin.add(panelCredential, gbc_panelCredential);
		GridBagLayout gbl_panelCredential = new GridBagLayout();
		gbl_panelCredential.columnWidths = new int[] {0};
		gbl_panelCredential.rowHeights = new int[] {0, 0, 0, 0};
		gbl_panelCredential.columnWeights = new double[]{0.0, 0.0};
		gbl_panelCredential.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panelCredential.setLayout(gbl_panelCredential);
		
		JLabel lblUsername = new JLabel("Identifiant\r\n");
		lblUsername.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblUsername.setForeground(MasterFrame.COLOR_TEXT);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 2;
		panelCredential.add(lblUsername, gbc_lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Cambria", Font.PLAIN, 12));
		txtUsername.setBorder(new MatteBorder(0, 0, 1, 0, MasterFrame.COLOR_MASTER));
		txtUsername.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		txtUsername.setForeground(MasterFrame.COLOR_TEXT);
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.anchor = GridBagConstraints.WEST;
		gbc_txtUsername.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsername.gridwidth = 2;
		gbc_txtUsername.gridx = 0;
		gbc_txtUsername.gridy = 3;
		panelCredential.add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Mot de passe\r\n");
		lblPassword.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblPassword.setForeground(MasterFrame.COLOR_TEXT);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridwidth = 2;
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 4;
		panelCredential.add(lblPassword, gbc_lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setForeground(MasterFrame.COLOR_TEXT);
		txtPassword.setFont(new Font("Cambria", Font.PLAIN, 12));
		txtPassword.setBorder(new MatteBorder(0, 0, 1, 0, MasterFrame.COLOR_MASTER));
		txtPassword.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.insets = new Insets(0, 0, 0, 5);
		gbc_txtPassword.anchor = GridBagConstraints.WEST;
		gbc_txtPassword.gridx = 0;
		gbc_txtPassword.gridy = 5;
		panelCredential.add(txtPassword, gbc_txtPassword);
		txtPassword.setColumns(10);
		
		JPanel panelBtnForgot = new JPanel();
		panelBtnForgot.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		GridBagConstraints gbc_panelBtnForgot = new GridBagConstraints();
		gbc_panelBtnForgot.ipadx = 20;
		gbc_panelBtnForgot.anchor = GridBagConstraints.SOUTH;
		gbc_panelBtnForgot.insets = new Insets(0, 0, 5, 0);
		gbc_panelBtnForgot.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelBtnForgot.gridx = 0;
		gbc_panelBtnForgot.gridy = 2;
		panelLogin.add(panelBtnForgot, gbc_panelBtnForgot);
		
		JButton btnForgotPassword = new JButton("<html><body><u>Mot de passe oublié ? </u></body></html>");
		btnForgotPassword.setHorizontalTextPosition(SwingConstants.CENTER);
		btnForgotPassword.setAlignmentY(Component.TOP_ALIGNMENT);
		btnForgotPassword.setVerticalTextPosition(SwingConstants.TOP);
		btnForgotPassword.setVerticalAlignment(SwingConstants.TOP);
		btnForgotPassword.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnForgotPassword.setMargin(new Insets(2, 14, 20, 16));
		btnForgotPassword.setBorder(null);
		btnForgotPassword.setFont(new Font("Cambria", Font.ITALIC, 10));
		btnForgotPassword.setForeground(MasterFrame.COLOR_MASTER);
		btnForgotPassword.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelBtnForgot.add(btnForgotPassword);
		
		JLabel lblTitle = new JLabel("Connexion\r\n");
		lblTitle.setForeground(MasterFrame.COLOR_TEXT);
		lblTitle.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblTitle.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		panelLogin.add(lblTitle, gbc_lblTitle);
		
		JPanel panelBtnLogin = new JPanel();
		panelBtnLogin.setPreferredSize(new Dimension(5, 10));
		panelBtnLogin.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panelBtnLogin.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelBtnLogin.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelLoginAll.add(panelBtnLogin);
		
		JPanel panelDummyTop = new JPanel();
		panelDummyTop.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelDummyTop.setPreferredSize(new Dimension(80, 230));
		add(panelDummyTop, BorderLayout.NORTH);
		panelDummyTop.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelDummyBot = new JPanel();
		panelDummyBot.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelDummyBot.setPreferredSize(new Dimension(100, 230));
		add(panelDummyBot, BorderLayout.SOUTH);
		
		JPanel panelDummyLeft = new JPanel();
		panelDummyLeft.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelDummyLeft.setPreferredSize(new Dimension(500, 100));
		panelDummyLeft.setSize(new Dimension(100, 100));
		panelDummyLeft.setMinimumSize(new Dimension(100, 100));
		add(panelDummyLeft, BorderLayout.WEST);
		
		JPanel panelDummyRight = new JPanel();
		panelDummyRight.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelDummyRight.setPreferredSize(new Dimension(500, 100));
		add(panelDummyRight, BorderLayout.EAST);
		GridBagLayout gbl_panelBtnLogin = new GridBagLayout();
		gbl_panelBtnLogin.columnWidths = new int[] {0};
		gbl_panelBtnLogin.rowHeights = new int[]{21, 0, 0};
		gbl_panelBtnLogin.columnWeights = new double[]{1.0};
		gbl_panelBtnLogin.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelBtnLogin.setLayout(gbl_panelBtnLogin);
		
		JPanel panelBtnRight = new JPanel();
		panelBtnRight.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		GridBagConstraints gbc_panelBtnRight = new GridBagConstraints();
		gbc_panelBtnRight.anchor = GridBagConstraints.SOUTH;
		gbc_panelBtnRight.insets = new Insets(0, 0, 0, 5);
		gbc_panelBtnRight.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelBtnRight.gridx = 0;
		gbc_panelBtnRight.gridy = 1;
		panelBtnLogin.add(panelBtnRight, gbc_panelBtnRight);
		
		JButton btnCancel = new JButton("Annuler");
		btnCancel.setVerticalTextPosition(SwingConstants.TOP);
		btnCancel.setVerticalAlignment(SwingConstants.TOP);
		btnCancel.setPreferredSize(new Dimension(63, 21));
		btnCancel.setMinimumSize(new Dimension(93, 21));
		btnCancel.setMaximumSize(new Dimension(93, 21));
		btnCancel.setMargin(new Insets(10, 0, 14, 14));
		btnCancel.setIconTextGap(10);
		btnCancel.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancel.setForeground(MasterFrame.COLOR_TEXT);
		btnCancel.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnCancel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, MasterFrame.COLOR_MASTER, null, MasterFrame.COLOR_MASTER, null));
		btnCancel.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		btnCancel.setAlignmentY(0.0f);
		btnCancel.setAlignmentX(1.0f);
		panelBtnRight.add(btnCancel);
		
		constructeurBouttonAnnuler(btnCancel);
		
		btnProceed = new JButton("  Connexion  \r\n");
		btnProceed.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnProceed.setVerticalAlignment(SwingConstants.BOTTOM);
		btnProceed.setMargin(new Insets(14, 0, 14, 14));
		btnProceed.setIconTextGap(10);
		btnProceed.setHorizontalTextPosition(SwingConstants.LEFT);
		btnProceed.setHorizontalAlignment(SwingConstants.LEFT);
		btnProceed.setForeground(MasterFrame.COLOR_TEXT);
		btnProceed.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnProceed.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, MasterFrame.COLOR_MASTER, null, MasterFrame.COLOR_MASTER, null));
		btnProceed.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		btnProceed.setAlignmentY(1.0f);
		panelBtnRight.add(btnProceed);
		
		constructeurBouttonConnexion(btnProceed);
		
		constructeurBoutonEnter();
		
	}
	
	
	public void constructeurBoutonEnter() {
		txtUsername.addKeyListener(new KeyListener() {
					
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (isVisible()) {
					if (e.getKeyCode()==KeyEvent.VK_ENTER){
			            connection();
			        }
				}
			}
		});
		
		txtPassword.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (isVisible()) {
					if (e.getKeyCode()==KeyEvent.VK_ENTER){
						
			            connection();
			        }
				}
			}
		});
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
                connection();
            }
        });
		
	
	}
	
	public void connection() {
		requestFocus();
		MasterFrame master = MasterFrame.getInstance();
        try {
            String identifiant = txtUsername.getText();
            String psw = new String(txtPassword.getPassword());

            master.getUser().login(identifiant, psw);
            setVisible(false);
            master.getMain().setVisible(true);
        } catch (Exception e1) {
            master.fireError(e1);
        }
        txtPassword.setText(null);
	}

}

