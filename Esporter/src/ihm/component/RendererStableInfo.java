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

public class RendererStableInfo extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TypesTeam team;
	private JLabel lbTeamName = new JLabel();
	private JButton lbArrowIcon = new JButton();

	public RendererStableInfo(TypesTeam team) {
		
	this.team = team;
	setBorder(new MatteBorder(0, 0, 1, 0, MasterFrame.COULEUR_TEXTE));
	setBackground(MasterFrame.COULEUR_MASTER_FOND);
	setLayout(new BorderLayout(5,5));
	JPanel panelText = new JPanel(new GridLayout(1,0));
	panelText.setBackground(MasterFrame.COULEUR_MASTER_FOND);
	panelText.setPreferredSize(new Dimension(500,100));
	lbTeamName.setForeground(MasterFrame.COULEUR_TEXTE);
	panelText.add(lbTeamName);
	add(panelText, BorderLayout.WEST);
	
	lbArrowIcon.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		}
	});
	
	lbArrowIcon.setBorder(null);
	lbArrowIcon.setBackground(MasterFrame.COULEUR_MASTER_FOND);
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
