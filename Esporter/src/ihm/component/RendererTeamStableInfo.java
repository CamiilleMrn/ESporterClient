package ihm.component;

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

import ihm.MasterFrame;
import types.TypesTeam;

public class RendererTeamStableInfo extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TypesTeam team;
	private JLabel lbTeamName = new JLabel();
	private JButton lbArrowIcon = new JButton();

	public RendererTeamStableInfo(TypesTeam team) {
		
	this.team = team;
	setBorder(new MatteBorder(0, 0, 1, 0, MasterFrame.COLOR_TEXT));
	setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
	setLayout(new BorderLayout(5,5));
	JPanel panelText = new JPanel(new GridLayout(1,0));
	panelText.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
	panelText.setPreferredSize(new Dimension(500,100));
	lbTeamName.setForeground(MasterFrame.COLOR_TEXT);
	panelText.add(lbTeamName);
	add(panelText, BorderLayout.WEST);
	
	lbArrowIcon.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			MasterFrame.getInstance().setPanel(ihm.SeePlayerInfos.class, team);
		}
	});
	
	lbArrowIcon.setBorder(null);
	lbArrowIcon.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
	add(lbArrowIcon, BorderLayout.EAST);
	lbTeamName.setText(this.team.getStable().getNickname() + " - " + this.team.getGame());
	try {
		lbArrowIcon.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("../images/Chevron.png"))));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}
