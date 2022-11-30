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
import types.JoueurInfo;
import types.TournoiInfo;
import types.exception.InvalidPermission;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;

public class InscriptionTournois extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5369653307234398589L;
	private JFrame frame;
	private int id;
	private TournoiInfo tournoi;

	/**
	 * Create the application.
	 */
	public InscriptionTournois(int id, TournoiInfo tournoi) {
		this.id= id;
		this.tournoi = tournoi;

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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0};
		gridBagLayout.rowHeights = new int[] {0, 0};
		gridBagLayout.columnWeights = new double[]{0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel TextContainer = new JPanel();
		TextContainer.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_TextContainer = new GridBagConstraints();
		gbc_TextContainer.insets = new Insets(0, 0, 5, 0);
		gbc_TextContainer.gridx = 0;
		gbc_TextContainer.gridy = 0;
		getContentPane().add(TextContainer, gbc_TextContainer);
		TextContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Confirmer votre inscription ?");
		if(tournoi.getInscris().contains(((JoueurInfo)MasterFrame.getInstance().getUser().getInfo()).getId_equipe())){
			lblNewLabel.setText("Confirmer votre désinscription");
		}
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Cambria", Font.PLAIN, 16));
		lblNewLabel.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		lblNewLabel.setAlignmentX(0.5f);
		TextContainer.add(lblNewLabel);
		
		JPanel ButtonContainer = new JPanel();
		ButtonContainer.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_ButtonContainer = new GridBagConstraints();
		gbc_ButtonContainer.gridx = 0;
		gbc_ButtonContainer.gridy = 1;
		getContentPane().add(ButtonContainer, gbc_ButtonContainer);
		GridBagLayout gbl_ButtonContainer = new GridBagLayout();
		gbl_ButtonContainer.columnWidths = new int[] {0};
		gbl_ButtonContainer.rowHeights = new int[] {0};
		gbl_ButtonContainer.columnWeights = new double[]{0.0};
		gbl_ButtonContainer.rowWeights = new double[]{0.0, 1.0};
		ButtonContainer.setLayout(gbl_ButtonContainer);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 20, 0));
		panel.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.SOUTH;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		ButtonContainer.add(panel, gbc_panel);
		
		JButton btnNewButton = new JButton("Oui");
		btnNewButton.setForeground(MasterFrame.COULEUR_TEXTE);
		btnNewButton.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		btnNewButton.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 164, 210), null, new Color(0, 164, 210), null), new EmptyBorder(5, 15, 5, 15)));
		btnNewButton.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!tournoi.getInscris().contains(((JoueurInfo)MasterFrame.getInstance().getUser().getInfo()).getId_equipe())){
					try {
						MasterFrame.getInstance().getUser().inscriptionTournoi(id);
						dispose();
					} catch (InvalidPermission e1) {
						
						e1.printStackTrace();
					}
				}else {
					//MasterFrame.getInstance().getUser().;
					dispose();
				}
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Non");
		btnNewButton_1.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		btnNewButton_1.setForeground(MasterFrame.COULEUR_TEXTE);
		btnNewButton_1.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 164, 210), null, new Color(0, 164, 210), null), new EmptyBorder(5, 15, 5, 15)));
		btnNewButton_1.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnNewButton_1);
	}

}
