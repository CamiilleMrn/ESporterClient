package vue.stable;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import controleur.Controler;
import javax.swing.SwingConstants;

public class RegisterStable extends JPanel {
	private JTextField txtStableName;
	private JTextField txtNickname;
	private JPasswordField txtPassword;
	private JFileChooser fileExplorer;
	private JTextField txtUsername;
	private JLabel lblPictureChooser;
	private BufferedImage image = null;

	/**
	 * Create the panel.
	 */
	public RegisterStable() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panelContainerHeader = new JPanel();
		add(panelContainerHeader);
		panelContainerHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblRegister = new JLabel("Inscription");
		lblRegister.setFont(new Font("Cambria", Font.BOLD, 24));
		panelContainerHeader.add(lblRegister);
		
		JPanel panelContainerContent = new JPanel();
		panelContainerContent.setBorder(new EmptyBorder(0, 100, 100, 100));
		add(panelContainerContent);
		panelContainerContent.setLayout(new BoxLayout(panelContainerContent, BoxLayout.X_AXIS));
		
		Panel panelContainerPicture = new Panel();
		panelContainerContent.add(panelContainerPicture);
		panelContainerPicture.setLayout(new BorderLayout(0, 0));
		
		JPanel panelContainerPictureInside = new JPanel();
		panelContainerPictureInside.setBorder(new EmptyBorder(0, 20, 0, 0));
		panelContainerPicture.add(panelContainerPictureInside);
		
		fileExplorer = new JFileChooser();
        fileExplorer.setCurrentDirectory(new File(System.getProperty("user.home")));
        //filtrer les fichiers
        FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        fileExplorer.setFileFilter(imageFilter);
		
		lblPictureChooser = new JLabel("");
		lblPictureChooser.setPreferredSize(new Dimension(100, 100));
		lblPictureChooser.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
		lblPictureChooser.addMouseListener(Controler.getInstance());
		panelContainerPictureInside.setLayout(new BorderLayout(0, 0));
		panelContainerPictureInside.add(lblPictureChooser);
		
		JLabel lblStableLogo = new JLabel("Logo de l'écurie");
		lblStableLogo.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblStableLogo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblStableLogo.setBorder(new EmptyBorder(50, 0, 0, 0));
		lblStableLogo.setFont(new Font("Cambria", Font.PLAIN, 14));
		lblStableLogo.setHorizontalAlignment(SwingConstants.CENTER);
		panelContainerPictureInside.add(lblStableLogo, BorderLayout.NORTH);
		
		JPanel panelBottom = new JPanel();
		panelBottom.setBorder(new EmptyBorder(50, 0, 0, 0));
		panelContainerPictureInside.add(panelBottom, BorderLayout.SOUTH);
		
		
		Panel panelContainerForm = new Panel();
		panelContainerContent.add(panelContainerForm);
		GridBagLayout gbl_panelContainerForm = new GridBagLayout();
		gbl_panelContainerForm.columnWidths = new int[] {0, 0, 0};
		gbl_panelContainerForm.rowHeights = new int[] {0, 0, 0};
		gbl_panelContainerForm.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panelContainerForm.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		panelContainerForm.setLayout(gbl_panelContainerForm);
		
		Label lblStableName = new Label("Nom de l'écurie :");
		GridBagConstraints gbc_lblStableName = new GridBagConstraints();
		gbc_lblStableName.anchor = GridBagConstraints.WEST;
		gbc_lblStableName.insets = new Insets(0, 0, 5, 5);
		gbc_lblStableName.gridx = 1;
		gbc_lblStableName.gridy = 0;
		panelContainerForm.add(lblStableName, gbc_lblStableName);
		
		txtStableName = new JTextField();
		txtStableName.setColumns(10);
		GridBagConstraints gbc_txtStableName = new GridBagConstraints();
		gbc_txtStableName.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtStableName.insets = new Insets(0, 0, 5, 0);
		gbc_txtStableName.gridx = 2;
		gbc_txtStableName.gridy = 0;
		panelContainerForm.add(txtStableName, gbc_txtStableName);
		
		Label lblNickName = new Label("Diminutif :");
		GridBagConstraints gbc_lblNickName = new GridBagConstraints();
		gbc_lblNickName.anchor = GridBagConstraints.WEST;
		gbc_lblNickName.insets = new Insets(0, 0, 5, 5);
		gbc_lblNickName.gridx = 1;
		gbc_lblNickName.gridy = 1;
		panelContainerForm.add(lblNickName, gbc_lblNickName);
		
		txtNickname = new JTextField();
		txtNickname.setColumns(10);
		GridBagConstraints gbc_txtNickname = new GridBagConstraints();
		gbc_txtNickname.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtNickname.insets = new Insets(0, 0, 5, 0);
		gbc_txtNickname.gridx = 2;
		gbc_txtNickname.gridy = 1;
		panelContainerForm.add(txtNickname, gbc_txtNickname);
		
		JLabel lblNewLabel = new JLabel(" Nom d'utilisateur :");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		panelContainerForm.add(lblNewLabel, gbc_lblNewLabel);
		
		txtUsername = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		panelContainerForm.add(txtUsername, gbc_textField);
		txtUsername.setColumns(10);
		
		Label lblPassw = new Label("Mot de passe :");
		GridBagConstraints gbc_lblPassw = new GridBagConstraints();
		gbc_lblPassw.anchor = GridBagConstraints.WEST;
		gbc_lblPassw.insets = new Insets(0, 0, 0, 5);
		gbc_lblPassw.gridx = 1;
		gbc_lblPassw.gridy = 3;
		panelContainerForm.add(lblPassw, gbc_lblPassw);
		
		txtPassword = new JPasswordField();
		txtPassword.setMaximumSize(new Dimension(7, 20));
		GridBagConstraints gbc_textPswd = new GridBagConstraints();
		gbc_textPswd.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPswd.gridx = 2;
		gbc_textPswd.gridy = 3;
		panelContainerForm.add(txtPassword, gbc_textPswd);
		txtPassword.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panelContainerContent.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EmptyBorder(0, 0, 20, 10));
		panel_4.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JButton btnValidate = new JButton("Valider");
		btnValidate.setPreferredSize(new Dimension(50, 23));
		btnValidate.setMinimumSize(new Dimension(70, 23));
		btnValidate.setMaximumSize(new Dimension(70, 23));
		panel_5.add(btnValidate);
		
		btnValidate.setActionCommand("REGISTER_STABLE_VALIDATE");
		btnValidate.addActionListener(Controler.getInstance());
		
		JButton btnCancel = new JButton("Annuler");
		panel_5.add(btnCancel, BorderLayout.NORTH);
		btnCancel.setActionCommand("REGISTER_STABLE_CANCEL");
		btnCancel.addActionListener(Controler.getInstance());

	}
	
	public void setFile(File selFile) {
		try {
			String path = selFile.getCanonicalPath();
			lblPictureChooser.setIcon(new ImageIcon(path));
			image = ImageIO.read(selFile);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public JTextField getTxtStableName() {
		return txtStableName;
	}

	public JTextField getTxtNickname() {
		return txtNickname;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public JFileChooser getFileExplorer() {
		return fileExplorer;
	}

	public JTextField getTxtUsername() {
		return txtUsername;
	}

}
