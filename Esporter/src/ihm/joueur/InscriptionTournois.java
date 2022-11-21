package ihm.joueur;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dialog.ModalityType;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

import ihm.MasterFrame;

public class InscriptionTournois extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5369653307234398589L;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscriptionTournois window = new InscriptionTournois();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InscriptionTournois() {

		initialize();
		setModalityType(ModalityType.APPLICATION_MODAL);
		setVisible(true);
		setAlwaysOnTop(true);
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
		getContentPane().setBackground(MasterFrame.COULEUR_MASTER_FOND);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel label = new JLabel("");
		getContentPane().add(label);
		
		JPanel TextContainer = new JPanel();
		TextContainer.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		getContentPane().add(TextContainer);
		TextContainer.setLayout(new BoxLayout(TextContainer, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		TextContainer.add(horizontalGlue);
		
		JLabel lblNewLabel = new JLabel("Confirmer votre inscription");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Cambria", Font.PLAIN, 10));
		lblNewLabel.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		lblNewLabel.setAlignmentX(0.5f);
		TextContainer.add(lblNewLabel);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		TextContainer.add(horizontalGlue_1);
		
		JPanel ButtonContainer = new JPanel();
		ButtonContainer.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		getContentPane().add(ButtonContainer);
		GridBagLayout gbl_ButtonContainer = new GridBagLayout();
		gbl_ButtonContainer.columnWidths = new int[] {0};
		gbl_ButtonContainer.rowHeights = new int[] {30, 0, 0};
		gbl_ButtonContainer.columnWeights = new double[]{1.0};
		gbl_ButtonContainer.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		ButtonContainer.setLayout(gbl_ButtonContainer);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 20, 0));
		panel.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.SOUTH;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		ButtonContainer.add(panel, gbc_panel);
		
		JButton btnNewButton = new JButton("Oui");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Non");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnNewButton_1);
	}

}
