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
import ihm.VoirInfoJoueur;
import types.EquipeInfo;
import types.TournoiInfo;

public class EcurieInfoTeamRenderer extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EquipeInfo equipe;
	private JLabel lbTeamName = new JLabel();
	private JButton lbArrowIcon = new JButton();
	private TournoiInfo tournoi;

	public EcurieInfoTeamRenderer(EquipeInfo equipe) {
		
	this.equipe = equipe;
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
			MasterFrame.getInstance().setPanel(ihm.VoirInfoJoueur.class, equipe);
		}
	});
	
	lbArrowIcon.setBorder(null);
	lbArrowIcon.setBackground(MasterFrame.COULEUR_MASTER_FOND);
	add(lbArrowIcon, BorderLayout.EAST);
	lbTeamName.setText(this.equipe.getEcurie().getDiminutif() + " - " + this.equipe.getJeu());
	try {
		lbArrowIcon.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("../images/Chevron.png"))));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}
