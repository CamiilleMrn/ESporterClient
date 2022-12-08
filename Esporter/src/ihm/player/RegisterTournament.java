package ihm.player;

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

import types.TypesGame;
import types.TypesPlayer;
import types.TypesTournament;
import types.exception.ExceptionInvalidPermission;
import javax.swing.border.SoftBevelBorder;

import ihm.MasterFrame;

import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;

public class RegisterTournament extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5369653307234398589L;
	private int id;
	private TypesTournament tournament;

	/**
	 * Create the application.
	 */
	public RegisterTournament(int id, TypesTournament tournament) {
		this.id= id;
		this.tournament = tournament;

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
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_panelTitle = new GridBagConstraints();
		gbc_panelTitle.insets = new Insets(0, 0, 5, 0);
		gbc_panelTitle.gridx = 0;
		gbc_panelTitle.gridy = 0;
		getContentPane().add(panelTitle, gbc_panelTitle);
		panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblTitle = new JLabel("Confirmer votre inscription ?");
		if(tournament.getRegistered().contains(((TypesPlayer)MasterFrame.getInstance().getUser().getInfo()).getIdTeam())){
			lblTitle.setText("Confirmer votre désinscription");
		}
		lblTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Cambria", Font.PLAIN, 16));
		lblTitle.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		lblTitle.setAlignmentX(0.5f);
		panelTitle.add(lblTitle);
		
		JPanel panelBtn = new JPanel();
		panelBtn.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_panelBtn = new GridBagConstraints();
		gbc_panelBtn.gridx = 0;
		gbc_panelBtn.gridy = 1;
		getContentPane().add(panelBtn, gbc_panelBtn);
		GridBagLayout gbl_panelBtn = new GridBagLayout();
		gbl_panelBtn.columnWidths = new int[] {0};
		gbl_panelBtn.rowHeights = new int[] {0};
		gbl_panelBtn.columnWeights = new double[]{0.0};
		gbl_panelBtn.rowWeights = new double[]{0.0, 1.0};
		panelBtn.setLayout(gbl_panelBtn);
		
		JPanel panelCentered = new JPanel();
		panelCentered.setBorder(new EmptyBorder(0, 0, 20, 0));
		panelCentered.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_panelCentered = new GridBagConstraints();
		gbc_panelCentered.anchor = GridBagConstraints.SOUTH;
		gbc_panelCentered.insets = new Insets(0, 0, 0, 5);
		gbc_panelCentered.gridx = 0;
		gbc_panelCentered.gridy = 1;
		panelBtn.add(panelCentered, gbc_panelCentered);
		
		JButton btnYes = new JButton("Oui");
		btnYes.setForeground(MasterFrame.COULEUR_TEXTE);
		btnYes.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		btnYes.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 164, 210), null, new Color(0, 164, 210), null), new EmptyBorder(5, 15, 5, 15)));
		btnYes.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!tournament.getRegistered().contains(((TypesPlayer)MasterFrame.getInstance().getUser().getInfo()).getIdTeam())){
					try {
						MasterFrame.getInstance().getUser().registerTournament(id);
						dispose();
					} catch (ExceptionInvalidPermission e1) {
						
						e1.printStackTrace();
					}
				}else {
					try {
						MasterFrame.getInstance().getUser().unregisterTournament(id, TypesGame.gameToInt(tournament.getGame()));
					} catch (ExceptionInvalidPermission e1) {
						e1.printStackTrace();
					};
					dispose();
				}
			}
		});
		btnYes.setHorizontalAlignment(SwingConstants.LEADING);
		panelCentered.add(btnYes);
		
		JButton btnNo = new JButton("Non");
		btnNo.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		btnNo.setForeground(MasterFrame.COULEUR_TEXTE);
		btnNo.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 164, 210), null, new Color(0, 164, 210), null), new EmptyBorder(5, 15, 5, 15)));
		btnNo.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panelCentered.add(btnNo);
	}

}
