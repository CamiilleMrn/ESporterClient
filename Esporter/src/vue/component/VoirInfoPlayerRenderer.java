package vue.component;

import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.border.EmptyBorder;

import types.TypesImage;
import types.TypesPlayer;
import vue.MasterFrame;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;

public class VoirInfoPlayerRenderer extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TypesPlayer player;

	public VoirInfoPlayerRenderer(TypesPlayer player) {
		setBorder(new CompoundBorder(new EmptyBorder(20, 20, 20, 20), new MatteBorder(2, 2, 2, 2, MasterFrame.COULEUR_MASTER)));
		setBackground(MasterFrame.COULEUR_MASTER_FOND);
		this.player = player;
		setLayout(new GridLayout(0, 1, 0, 0));
	
		JPanel panel_ContainterPicture = new JPanel();
		panel_ContainterPicture.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		add(panel_ContainterPicture);
		
		JLabel lblPlayerPicture = new JLabel();
		lblPlayerPicture.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPlayerPicture.setIcon(new ImageIcon(player.getImage().getImage()));
		BufferedImage bff_playerPicture = player.getImage().getImage();
		bff_playerPicture = types.TypesImage.resize(bff_playerPicture, 250, 250);
		panel_ContainterPicture.setLayout(new BoxLayout(panel_ContainterPicture, BoxLayout.Y_AXIS));
		lblPlayerPicture.setIcon(new ImageIcon(bff_playerPicture));
		panel_ContainterPicture.add(lblPlayerPicture);
		
		JPanel panel_ContainerInfo = new JPanel();
		panel_ContainerInfo.setBackground(Color.DARK_GRAY);
		panel_ContainerInfo.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(panel_ContainerInfo);
		panel_ContainerInfo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblPlayerName = new JLabel(player.getFirstName() + " " + player.getName());
		lblPlayerName.setPreferredSize(new Dimension(100,40));
		lblPlayerName.setToolTipText(player.getFirstName() + " " + player.getName());
		lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerName.setForeground(MasterFrame.COULEUR_TEXTE);
		lblPlayerName.setFont(new Font("Cambria", Font.BOLD, 30));
		panel_ContainerInfo.add(lblPlayerName);
		
		JLabel lblDateOfBith = new JLabel("Date de naissance : "+player.getBirthDate());
		lblDateOfBith.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateOfBith.setForeground(MasterFrame.COULEUR_TEXTE);
		lblDateOfBith.setFont(new Font("Cambria",Font.PLAIN, 20));
		panel_ContainerInfo.add(lblDateOfBith);
		
		JLabel lblStartContractDate = new JLabel("Début contrat : " + player.getContractStartDate());
		lblStartContractDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblStartContractDate.setForeground(MasterFrame.COULEUR_TEXTE);
		lblStartContractDate.setFont(new Font("Cambria", Font.PLAIN, 20));
		panel_ContainerInfo.add(lblStartContractDate);
		
		JLabel lblEndContractDate = new JLabel("Date fin contrat : "+player.getContractEndDate());
		lblEndContractDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndContractDate.setForeground(MasterFrame.COULEUR_TEXTE);
		lblEndContractDate.setFont(new Font("Cambria", Font.PLAIN, 20));
		panel_ContainerInfo.add(lblEndContractDate);
		
	}

}
