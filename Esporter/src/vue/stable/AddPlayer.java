package vue.stable;

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

import controleur.Controler;
import controleur.State;
import types.TypesStable;
import vue.MasterFrame;
import vue.component.ContainerPlayer;
import vue.component.DatePicker;
import types.TypesPlayer;
import types.TypesLogin;
import types.TypesRegisterPlayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;

//create class and extend with JFrame
public class AddPlayer extends JDialog {
	/**
	* 
	*/
	private static final long serialVersionUID = -725884370429132629L;
	// add JPanel to the contentPane
	private JPanel contentPane;
	// declare variable
	private JTextField txtEndContractDate;
	private JTextField txtStartContractDate;
	private JPanel panelContractDate;
	private JPanel panelInfo;
	private JPanel panelImage;
	private JLabel lblName;
	private JLabel lblFirstname;
	private JLabel lblBirthDate;
	private JLabel lblPlayerImageIcon;
	private JPanel panelStartContract;
	private JPanel panelEndContract;
	private JPanel panelBottom;
	private JLabel lblStartContractDate;
	private JLabel lblEndContratDate;
	private JPanel panelFirstname;
	private JLabel txtPlayerImage;
	private JPanel panelBirthDate;
	private JTextField txtBirthDate;
	private JPanel panelName;
	private JTextField txtName;
	private JTextField txtFirstname;
	private JButton btnMoreBirthDate;
	private JPanel panelValidate;
	private JButton btnValidate;
	private JLabel lblUsername;
	private JPanel panelUsername;
	private JTextField txtUsername;
	private JLabel lblPassword;
	private JPanel panelPassword;
	private JTextField txtPassword;
	private BufferedImage image;
	private JFileChooser fileExplorer;
	private ContainerPlayer container;

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	//create constructor of class
	public AddPlayer(ContainerPlayer container)
	{
		super(MasterFrame.getInstance().getFrame(), "Ajouter joueur ", false);
		this.container = container;
		Controler.getInstance().openDialog(this, State.ADD_PLAYER);
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				Controler.getInstance().closeDialog();
				dispose();
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		setModalityType(ModalityType.APPLICATION_MODAL);
		//set title
		setTitle("Ajouter joueur ");
		//set close operation on frame
		//set bounds of frame
		setBounds(100, 100, 617, 341);
		//create new JPanel in contentPane
		contentPane = new JPanel();
		contentPane.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		//set border of frame
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//set contentPane 
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		//create button and there object
		JButton btnMoreEndContract = new JButton("...");
		btnMoreEndContract.setBackground(MasterFrame.COLOR_MASTER);
		btnMoreEndContract.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
		btnMoreEndContract.setFont(new Font("Cambria", Font.PLAIN, 15));
		btnMoreEndContract.setContentAreaFilled(false); 
		btnMoreEndContract.setFocusPainted(false); 
		btnMoreEndContract.addActionListener(Controler.getInstance());
		btnMoreEndContract.setActionCommand("ADD_PLAYER_MORE2");
		//create text field
				txtEndContractDate = new JTextField();
				txtEndContractDate.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
				txtEndContractDate.setHorizontalAlignment(SwingConstants.CENTER);
				txtEndContractDate.setFont(new Font("Cambria", Font.PLAIN, 13));
				txtEndContractDate.setColumns(11);
		
		JButton btnMoreStartContract= new JButton("...");
		btnMoreStartContract.setBackground(MasterFrame.COLOR_MASTER);
		btnMoreStartContract.setFont(new Font("Cambria", Font.PLAIN, 15));
		btnMoreStartContract.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
		btnMoreStartContract.setContentAreaFilled(false); 
		btnMoreStartContract.setFocusPainted(false); 
		btnMoreStartContract.addActionListener(Controler.getInstance());
		btnMoreStartContract.setActionCommand("ADD_PLAYER_MORE3");
		//create text field
				txtStartContractDate = new JTextField();
				txtStartContractDate.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
				txtStartContractDate.setHorizontalAlignment(SwingConstants.CENTER);
				txtStartContractDate.setFont(new Font("Cambria", Font.PLAIN, 13));
				txtStartContractDate.setColumns(11);
		
		
		panelContractDate = new JPanel();
		panelContractDate.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		contentPane.add(panelContractDate, BorderLayout.SOUTH);
		panelContractDate.setLayout(new BorderLayout(0, 0));
		
		panelStartContract = new JPanel();
		panelStartContract.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelContractDate.add(panelStartContract, BorderLayout.WEST);
		panelStartContract.setLayout(new BorderLayout(0, 0));
	
		lblStartContractDate = new JLabel();
		lblStartContractDate.setForeground(MasterFrame.COLOR_TEXT);
		lblStartContractDate.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		lblStartContractDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartContractDate.setText("Date debut du contrat");
		lblStartContractDate.setFont(new Font("Cambria", Font.BOLD, 12));
		panelStartContract.add(lblStartContractDate, BorderLayout.NORTH);
		panelStartContract.add(btnMoreStartContract, BorderLayout.EAST);
		panelStartContract.add(txtStartContractDate, BorderLayout.WEST);
		lblStartContractDate.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		
		panelEndContract = new JPanel();
		panelContractDate.add(panelEndContract, BorderLayout.EAST);
		panelEndContract.setLayout(new BorderLayout(0, 0));
		panelEndContract.add(btnMoreEndContract, BorderLayout.EAST);
		panelEndContract.add(txtEndContractDate, BorderLayout.WEST);
		
		lblEndContratDate = new JLabel();
		lblEndContratDate.setForeground(MasterFrame.COLOR_TEXT);
		lblEndContratDate.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		lblEndContratDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndContratDate.setFont(new Font("Cambria", Font.BOLD, 12));
		lblEndContratDate.setText("Date fin du contrat");
		panelEndContract.add(lblEndContratDate, BorderLayout.NORTH);
		lblEndContratDate.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		
		panelBottom = new JPanel();
		panelBottom.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelContractDate.add(panelBottom, BorderLayout.SOUTH);
		panelBottom.setLayout(new BorderLayout(0, 0));
		
		panelValidate = new JPanel();
		panelBottom.add(panelValidate, BorderLayout.EAST);
		panelValidate.setLayout(new BorderLayout(0, 0));
		
		btnValidate = new JButton("Valider");
		btnValidate.setActionCommand("ADD_PLAYER_VALIDATE");
		btnValidate.addActionListener(Controler.getInstance());
		
		btnValidate.setForeground(Color.WHITE);
		btnValidate.setBackground(MasterFrame.COLOR_MASTER);
		btnValidate.setFont(new Font("Cambria", Font.PLAIN, 15));
		panelValidate.add(btnValidate, BorderLayout.NORTH);
		
		panelInfo = new JPanel();
		panelInfo.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		contentPane.add(panelInfo, BorderLayout.EAST);
		GridBagLayout gbl_panelInfo = new GridBagLayout();
		gbl_panelInfo.columnWidths = new int[] {136, 136};
		gbl_panelInfo.rowHeights = new int[] {53, 53, 52, 0, 0};
		gbl_panelInfo.columnWeights = new double[]{1.0, 1.0};
		gbl_panelInfo.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0};
		panelInfo.setLayout(gbl_panelInfo);
						
						lblName = new JLabel();
						lblName.setForeground(MasterFrame.COLOR_TEXT);
						lblName.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
						lblName.setBorder(null);
						lblName.setHorizontalAlignment(SwingConstants.CENTER);
						lblName.setFont(new Font("Cambria", Font.PLAIN, 15));
						lblName.setText("Nom   :");
						GridBagConstraints gbc_lblName = new GridBagConstraints();
						gbc_lblName.insets = new Insets(0, 0, 5, 5);
						gbc_lblName.fill = GridBagConstraints.BOTH;
						gbc_lblName.gridx = 0;
						gbc_lblName.gridy = 0;
						panelInfo.add(lblName, gbc_lblName);
						
						panelName = new JPanel();
						FlowLayout flowLayout = (FlowLayout) panelName.getLayout();
						flowLayout.setVgap(0);
						flowLayout.setHgap(3);
						GridBagConstraints gbc_panelName = new GridBagConstraints();
						gbc_panelName.insets = new Insets(0, 0, 5, 0);
						gbc_panelName.gridx = 1;
						gbc_panelName.gridy = 0;
						panelInfo.add(panelName, gbc_panelName);
						
						txtName = new JTextField();
						txtName.setBackground(Color.WHITE);
						txtName.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
						txtName.setFont(new Font("Cambria", Font.PLAIN, 15));
						txtName.setHorizontalAlignment(SwingConstants.CENTER);
						txtName.setColumns(12);
						panelName.add(txtName);
						

						
						lblFirstname = new JLabel();
						lblFirstname.setForeground(MasterFrame.COLOR_TEXT);
						lblFirstname.setBorder(null);
						lblFirstname.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
						lblFirstname.setText("Prenom  :");
						lblFirstname.setHorizontalAlignment(SwingConstants.CENTER);
						lblFirstname.setFont(new Font("Cambria", Font.PLAIN, 15));
						GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
						gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
						gbc_lblFirstName.fill = GridBagConstraints.BOTH;
						gbc_lblFirstName.gridx = 0;
						gbc_lblFirstName.gridy = 1;
						panelInfo.add(lblFirstname, gbc_lblFirstName);
						
						panelFirstname = new JPanel();
						GridBagConstraints gbc_panelFirstName = new GridBagConstraints();
						gbc_panelFirstName.insets = new Insets(0, 0, 5, 0);
						gbc_panelFirstName.gridx = 1;
						gbc_panelFirstName.gridy = 1;
						panelInfo.add(panelFirstname, gbc_panelFirstName);
						panelFirstname.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 0));
						
						txtFirstname = new JTextField();
						txtFirstname.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
						txtFirstname.setHorizontalAlignment(SwingConstants.CENTER);
						txtFirstname.setFont(new Font("Cambria", Font.PLAIN, 15));
						txtFirstname.setColumns(12);
						panelFirstname.add(txtFirstname);
		
		panelBirthDate = new JPanel();
		FlowLayout fl_panelBirthDate = (FlowLayout) panelBirthDate.getLayout();
		fl_panelBirthDate.setVgap(10);
		fl_panelBirthDate.setHgap(0);
		panelBirthDate.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelBirthDate.setBorder(null);
		GridBagConstraints gbc_panelBirthDate = new GridBagConstraints();
		gbc_panelBirthDate.insets = new Insets(0, 0, 5, 0);
		gbc_panelBirthDate.gridx = 1;
		gbc_panelBirthDate.gridy = 2;
		panelInfo.add(panelBirthDate, gbc_panelBirthDate);
		
		txtBirthDate = new JTextField();
		txtBirthDate.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
		txtBirthDate.setFont(new Font("Cambria", Font.PLAIN, 15));
		panelBirthDate.add(txtBirthDate);
		txtBirthDate.setHorizontalAlignment(SwingConstants.CENTER);
		txtBirthDate.setColumns(11);
		
		btnMoreBirthDate = new JButton("...");
		btnMoreBirthDate.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
		btnMoreBirthDate.setBackground(MasterFrame.COLOR_TEXT);
		btnMoreBirthDate.setForeground(MasterFrame.COLOR_TEXT);
		btnMoreBirthDate.addActionListener(Controler.getInstance());
		btnMoreBirthDate.setActionCommand("ADD_PLAYER_MORE1");
		
		btnMoreBirthDate.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnMoreBirthDate.setFocusPainted(false);
		btnMoreBirthDate.setContentAreaFilled(false);
		panelBirthDate.add(btnMoreBirthDate);
						
						lblBirthDate = new JLabel();
						lblBirthDate.setBorder(null);
						lblBirthDate.setForeground(MasterFrame.COLOR_TEXT);
						lblBirthDate.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
						lblBirthDate.setHorizontalAlignment(SwingConstants.CENTER);
						lblBirthDate.setFont(new Font("Cambria", Font.PLAIN, 15));
						lblBirthDate.setText("Date de naissance");
						GridBagConstraints gbc_lblBirthDate = new GridBagConstraints();
						gbc_lblBirthDate.insets = new Insets(0, 0, 5, 5);
						gbc_lblBirthDate.fill = GridBagConstraints.BOTH;
						gbc_lblBirthDate.gridx = 0;
						gbc_lblBirthDate.gridy = 2;
						panelInfo.add(lblBirthDate, gbc_lblBirthDate);
						
						lblUsername = new JLabel();
						lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
						lblUsername.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
						lblUsername.setForeground(MasterFrame.COLOR_TEXT);
						lblUsername.setBorder(null);
						lblUsername.setText("Identifiant :");
						lblUsername.setFont(new Font("Cambria", Font.PLAIN, 15));
						GridBagConstraints gbc_lblUsername = new GridBagConstraints();
						gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
						gbc_lblUsername.fill = GridBagConstraints.HORIZONTAL;
						gbc_lblUsername.gridx = 0;
						gbc_lblUsername.gridy = 3;
						panelInfo.add(lblUsername, gbc_lblUsername);
						
						panelUsername = new JPanel();
						panelUsername.setBorder(null);
						panelUsername.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
						FlowLayout fl_panelUsername = (FlowLayout) panelUsername.getLayout();
						fl_panelUsername.setVgap(0);
						fl_panelUsername.setHgap(3);
						GridBagConstraints gbc_panelUsername = new GridBagConstraints();
						gbc_panelUsername.insets = new Insets(0, 0, 5, 0);
						gbc_panelUsername.gridx = 1;
						gbc_panelUsername.gridy = 3;
						panelInfo.add(panelUsername, gbc_panelUsername);
						
						txtUsername = new JTextField();
						txtUsername.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
						txtUsername.setFont(new Font("Cambria", Font.PLAIN, 12));
						txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
						panelUsername.add(txtUsername);
						txtUsername.setColumns(15);
						
						lblPassword = new JLabel();
						lblPassword.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
						lblPassword.setForeground(MasterFrame.COLOR_TEXT);
						lblPassword.setBorder(null);
						lblPassword.setFont(new Font("Cambria", Font.PLAIN, 15));
						lblPassword.setText("Mot de passe :");
						lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
						GridBagConstraints gbc_txtMotDePasse = new GridBagConstraints();
						gbc_txtMotDePasse.insets = new Insets(0, 0, 0, 5);
						gbc_txtMotDePasse.fill = GridBagConstraints.HORIZONTAL;
						gbc_txtMotDePasse.gridx = 0;
						gbc_txtMotDePasse.gridy = 4;
						panelInfo.add(lblPassword, gbc_txtMotDePasse);
						
						panelPassword = new JPanel();
						FlowLayout fl_panelPassword = (FlowLayout) panelPassword.getLayout();
						fl_panelPassword.setHgap(3);
						panelPassword.setBorder(null);
						panelPassword.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
						GridBagConstraints gbc_panelPassword = new GridBagConstraints();
						gbc_panelPassword.fill = GridBagConstraints.BOTH;
						gbc_panelPassword.gridx = 1;
						gbc_panelPassword.gridy = 4;
						panelInfo.add(panelPassword, gbc_panelPassword);
						
						txtPassword = new JTextField();
						txtPassword.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
						txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
						txtPassword.setFont(new Font("Cambria", Font.PLAIN, 12));
						panelPassword.add(txtPassword);
						txtPassword.setColumns(15);
		panelImage = new JPanel();
		contentPane.add(panelImage, BorderLayout.CENTER);
		panelImage.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelImage.setLayout(new BorderLayout(0, 0));
		
		fileExplorer = new JFileChooser();
        fileExplorer.setCurrentDirectory(new File(System.getProperty("user.home")));
        //filtrer les fichiers
        FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        fileExplorer.setFileFilter(imageFilter);
		
		
		
		
		lblPlayerImageIcon = new JLabel("");
		
		lblPlayerImageIcon.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
		lblPlayerImageIcon.addMouseListener(Controler.getInstance());
		
		
		lblPlayerImageIcon.setIcon(null);
		panelImage.add(lblPlayerImageIcon);
		
		txtPlayerImage = new JLabel();
		txtPlayerImage.setForeground(MasterFrame.COLOR_TEXT);
		txtPlayerImage.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		txtPlayerImage.setFont(new Font("Cambria", Font.PLAIN, 15));
		txtPlayerImage.setText("Ajouter la photo du joueur ci-dessous :");
		panelImage.add(txtPlayerImage, BorderLayout.NORTH);
		txtPlayerImage.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		if (container.getPlayer() != null) {
			TypesPlayer j = container.getPlayer().getPlayer();
			txtName.setText(j.getName());
			txtStartContractDate.setText(j.getContractStartDate().toString());
			txtEndContractDate.setText(j.getContractEndDate().toString());
			txtFirstname.setText(j.getFirstName());
			BufferedImage bf = j.getImage().getImage();
			bf = resize(bf, 300, 400);
			lblPlayerImageIcon.setIcon(new ImageIcon());
			txtBirthDate.setText(j.getBirthDate().toString());
			txtUsername.setText(container.getPlayer().getLogin().getUsername());
			txtPassword.setText(container.getPlayer().getLogin().getPassword());
			image = j.getImage().getImage();
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
	
	public void setFile(File selFile) {
		try {
			String path = selFile.getCanonicalPath();
			lblPlayerImageIcon.setIcon(new ImageIcon(path));
			image = ImageIO.read(selFile);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public JFileChooser getFileExplorer() {
		return fileExplorer;
	}
	
	public JTextField getTxtBirthDate() {
		return txtBirthDate;
	}
	
	public JTextField getTxtEndContractDate() {
		return txtEndContractDate;
	}
	
	public JTextField getTxtFirstname() {
		return txtFirstname;
	}
	
	public JTextField getTxtName() {
		return txtName;
	}
	
	public JTextField getTxtPassword() {
		return txtPassword;
	}
	
	public JLabel getTxtPlayerImage() {
		return txtPlayerImage;
	}
	
	public JTextField getTxtStartContractDate() {
		return txtStartContractDate;
	}
	
	public JTextField getTxtUsername() {
		return txtUsername;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public ContainerPlayer getContainer() {
		return container;
	}

	
	
	
}