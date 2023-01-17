package vue.player;

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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

import types.TypesGame;
import types.TypesPlayer;
import types.TypesTournament;
import types.exception.ExceptionInvalidPermission;
import vue.MasterFrame;

import javax.swing.border.SoftBevelBorder;

import controleur.Controler;
import controleur.State;

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
		getContentPane().setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		setBounds(100, 100, 450, 300);
		Controler.getInstance().openDialog(this, State.INSCRIPTION);
		
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
				Controler.getInstance().closeDialog();
				dispose();
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0};
		gridBagLayout.rowHeights = new int[] {0, 0};
		gridBagLayout.columnWeights = new double[]{0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
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
		lblTitle.setForeground(MasterFrame.COLOR_TEXT);
		lblTitle.setFont(new Font("Cambria", Font.PLAIN, 16));
		lblTitle.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		lblTitle.setAlignmentX(0.5f);
		panelTitle.add(lblTitle);
		
		JPanel panelBtn = new JPanel();
		panelBtn.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
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
		panelCentered.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		GridBagConstraints gbc_panelCentered = new GridBagConstraints();
		gbc_panelCentered.anchor = GridBagConstraints.SOUTH;
		gbc_panelCentered.insets = new Insets(0, 0, 0, 5);
		gbc_panelCentered.gridx = 0;
		gbc_panelCentered.gridy = 1;
		panelBtn.add(panelCentered, gbc_panelCentered);
		
		JButton btnYes = new JButton("Oui");
		btnYes.setForeground(MasterFrame.COLOR_TEXT);
		btnYes.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		btnYes.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 164, 210), null, new Color(0, 164, 210), null), new EmptyBorder(5, 15, 5, 15)));
		btnYes.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnYes.addActionListener(Controler.getInstance());
		btnYes.setActionCommand("INSCRIPTION_YES");
		
		btnYes.setHorizontalAlignment(SwingConstants.LEADING);
		panelCentered.add(btnYes);
		
		JButton btnNo = new JButton("Non");
		btnNo.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		btnNo.setForeground(MasterFrame.COLOR_TEXT);
		btnNo.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 164, 210), null, new Color(0, 164, 210), null), new EmptyBorder(5, 15, 5, 15)));
		btnNo.setFont(new Font("Cambria", Font.PLAIN, 12));
		btnNo.addActionListener(Controler.getInstance());
		btnNo.setActionCommand("INSCRIPTION_NO");
		panelCentered.add(btnNo);
	}
	
	public TypesTournament getTournament() {
		return tournament;
	}

}
