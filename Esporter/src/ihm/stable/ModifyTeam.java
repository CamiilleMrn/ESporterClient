package ihm.stable;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import ihm.MasterFrame;
import ihm.component.ContainerModifyPlayer;
import ihm.component.ContainerPlayer;
import ihm.component.DataJPanel;
import socket.Response;
import types.TypesGame;
import types.TypesPlayer;
import types.TypesStable;
import types.TypesTeam;
import types.exception.ExceptionTeamNotFull;

public class ModifyTeam extends JPanel {
	
	private static final long serialVersionUID = -5531842744073477854L;
	private TypesTeam team;
	private ContainerModifyPlayer[] playerList;
	/**
	 * Create the application.
	 */
	public ModifyTeam(TypesTeam team) {
		this.team = team;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBackground(MasterFrame.COULEUR_MASTER_FOND);
		setPreferredSize(MasterFrame.getInstance().getFrameCenterDimension());
		JFrame frame = MasterFrame.getInstance().getFrame(); 
		JPanel panelMain = new JPanel();
		panelMain.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		add(panelMain, BorderLayout.CENTER);
		GridBagLayout gbl_panelMain = new GridBagLayout();
		int side = (int) (frame.getWidth()*0.15);
		int center = (int) (frame.getWidth()*0.7);
		

		gbl_panelMain.columnWidths = new int[] {side+1, center, side};
		gbl_panelMain.rowHeights = new int[] {(int) (frame.getHeight()*0.06), (int) (frame.getHeight()*0.22), (int) (frame.getHeight()*0.28), (int) (frame.getHeight()*0.3), (int) (frame.getHeight()*0.14)};
		gbl_panelMain.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panelMain.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelMain.setLayout(gbl_panelMain);
		
		JLabel lblTitle = new JLabel("Ajouter une \u00E9quipe");
		lblTitle.setFont(new Font("Cambria", Font.PLAIN, 27));
		lblTitle.setForeground(MasterFrame.COULEUR_TEXTE);
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.SOUTH;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 0;
		panelMain.add(lblTitle, gbc_lblTitle);
		
		JPanel lblGame = new JPanel();
		lblGame.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_lblGame = new GridBagConstraints();
		gbc_lblGame.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblGame.insets = new Insets(0, 0, 5, 5);
		gbc_lblGame.gridx = 1;
		gbc_lblGame.gridy = 1;
		panelMain.add(lblGame, gbc_lblGame);
		
		JPanel panelPlayer = new JPanel();
		panelPlayer.setBorder(null);
		panelPlayer.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_panelPlayer = new GridBagConstraints();
		gbc_panelPlayer.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelPlayer.insets = new Insets(0, 0, 5, 5);
		gbc_panelPlayer.gridx = 1;
		gbc_panelPlayer.gridy = 2;
		panelMain.add(panelPlayer, gbc_panelPlayer);
		
		int teamSize = team.getGame().getMaxPlayer();
		playerList = new ContainerModifyPlayer[teamSize];
		TypesPlayer[] compTeam = (TypesPlayer[])this.team.getPlayers().values().toArray(new TypesPlayer[0]);
		for (int i=0; i<teamSize; i++) {
			playerList[i] = new ContainerModifyPlayer();
			panelPlayer.add(playerList[i]);
			playerList[i].setPlayer(compTeam[i]);
		}
		
		JPanel panelValidate = new JPanel();
		panelValidate.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_panelValidate = new GridBagConstraints();
		gbc_panelValidate.insets = new Insets(0, 0, 0, 5);
		gbc_panelValidate.anchor = GridBagConstraints.NORTHEAST;
		gbc_panelValidate.gridx = 1;
		gbc_panelValidate.gridy = 3;
		panelMain.add(panelValidate, gbc_panelValidate);
		
		JButton btnValidate = new JButton("Valider");
		btnValidate.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnValidate.setVerticalAlignment(SwingConstants.BOTTOM);
		btnValidate.setMargin(new Insets(14, 0, 14, 14));
		btnValidate.setIconTextGap(10);
		btnValidate.setHorizontalTextPosition(SwingConstants.LEFT);
		btnValidate.setHorizontalAlignment(SwingConstants.LEFT);
		btnValidate.setForeground(MasterFrame.COULEUR_TEXTE);
		btnValidate.setFont(new Font("Cambria", Font.PLAIN, 22));
		btnValidate.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, MasterFrame.COULEUR_MASTER, null, MasterFrame.COULEUR_MASTER, null));
		btnValidate.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		btnValidate.setAlignmentY(1.0f);
		panelValidate.add(btnValidate);
		btnValidate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				for (ContainerModifyPlayer c : playerList) {
					if (c.getPlayer()==null) {
						MasterFrame.getInstance().fireError(new ExceptionTeamNotFull("Erreur de modification de l'équipe"));
						return;
					}
				}
				HashMap<Integer,TypesPlayer> players = new HashMap<>();
				for (ContainerModifyPlayer c : playerList) {
					players.put(c.getPlayer().getId(),c.getPlayer());
				}
				TypesTeam newTeam = new TypesTeam(team.getGame(), team.getStable(), players, team.getId());
				MasterFrame.getInstance().getUser().modifyTeam(newTeam);
				MasterFrame.getInstance().getUser().getWaiting().waitFor(Response.UPDATE_TEAM, Response.ERROR);
				if (MasterFrame.getInstance().getUser().getWaiting().getActualState()==Response.UPDATE_TEAM) {
					MasterFrame.getInstance().setPanel(ihm.stable.TeamManagement.class, null);
				}
				
			}
		});
		
	}

}
