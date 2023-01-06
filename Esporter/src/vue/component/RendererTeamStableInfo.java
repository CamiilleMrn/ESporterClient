package vue.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import controleur.Controler;
import types.TypesTeam;
import vue.MasterFrame;

public class RendererTeamStableInfo extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TypesTeam team;
	private JLabel lblTeamName = new JLabel();
	private JButton btnArrowIcon = new JButton();

	public RendererTeamStableInfo(TypesTeam team, int id) {
			
		this.team = team;
		setBorder(new MatteBorder(0, 0, 1, 0, MasterFrame.COLOR_TEXT));
		setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		setLayout(new BorderLayout(5,5));
		JPanel panelText = new JPanel(new GridLayout(1,0));
		panelText.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelText.setPreferredSize(new Dimension(500,100));
		lblTeamName.setForeground(MasterFrame.COLOR_TEXT);
		panelText.add(lblTeamName);
		add(panelText, BorderLayout.WEST);
		
		btnArrowIcon.addActionListener(Controler.getInstance());
		btnArrowIcon.setActionCommand("STABLE_INFO RENDERER "+id);
		
		
		btnArrowIcon.setBorder(null);
		btnArrowIcon.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		add(btnArrowIcon, BorderLayout.EAST);
		lblTeamName.setText(this.team.getStable().getNickname() + " - " + this.team.getGame());
		try {
			btnArrowIcon.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("../images/Chevron.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public TypesTeam getTeam() {
		return team;
	}

}
