package vue.stable;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Panel;
import java.io.File;
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

public class RegisterStable extends JPanel {
	private JTextField txtVghj;
	private JTextField textField_1;
	private JPasswordField textField;
	private JFileChooser fileExplorer;

	/**
	 * Create the panel.
	 */
	public RegisterStable() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblRegister = new JLabel("Inscription");
		lblRegister.setFont(new Font("Cambria", Font.BOLD, 24));
		panel.add(lblRegister);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		Panel panel_2 = new Panel();
		panel_1.add(panel_2);
		
		
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		
		JLabel lblNewLabel = new JLabel("Logo de l'écurie");
		panel_7.add(lblNewLabel);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		
		fileExplorer = new JFileChooser();
        fileExplorer.setCurrentDirectory(new File(System.getProperty("user.home")));
        //filtrer les fichiers
        FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        fileExplorer.setFileFilter(imageFilter);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
		lblNewLabel_1.addMouseListener(Controler.getInstance());
		panel_6.add(lblNewLabel_1);
		
		
		Panel panel_3 = new Panel();
		panel_1.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] {0, 0, 0};
		gbl_panel_3.rowHeights = new int[] {0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel_3.setLayout(gbl_panel_3);
		
		Label label = new Label("Nom de l'écurie :");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		panel_3.add(label, gbc_label);
		
		txtVghj = new JTextField();
		txtVghj.setColumns(10);
		GridBagConstraints gbc_txtVghj = new GridBagConstraints();
		gbc_txtVghj.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtVghj.insets = new Insets(0, 0, 5, 5);
		gbc_txtVghj.gridx = 2;
		gbc_txtVghj.gridy = 0;
		panel_3.add(txtVghj, gbc_txtVghj);
		
		Label label_1 = new Label("Diminutif :");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 1;
		panel_3.add(label_1, gbc_label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 1;
		panel_3.add(textField_1, gbc_textField_1);
		
		Label label_2 = new Label("Mot de passe :");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 2;
		panel_3.add(label_2, gbc_label_2);
		
		textField = new JPasswordField();
		textField.setMaximumSize(new Dimension(7, 20));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		panel_3.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EmptyBorder(0, 0, 20, 10));
		panel_4.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setPreferredSize(new Dimension(50, 23));
		btnNewButton.setMinimumSize(new Dimension(70, 23));
		btnNewButton.setMaximumSize(new Dimension(70, 23));
		panel_5.add(btnNewButton);

	}

}
