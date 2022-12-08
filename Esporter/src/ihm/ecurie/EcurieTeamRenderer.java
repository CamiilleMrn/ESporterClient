package ihm.ecurie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import ihm.MasterFrame;
import types.EquipeInfo;
import types.TournoiInfo;
import javax.swing.Box;

public class EcurieTeamRenderer extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EquipeInfo equipe;
	private JLabel lbTeamName = new JLabel();
	private JButton lbArrowIcon = new JButton();
	private AbstractButton lbModifyButton;
	private Component panel_1;
	private final JPanel panel = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JButton btnNewButton = new JButton("Modifier");
	
	public EcurieTeamRenderer(EquipeInfo equipe) {	
	this.equipe = equipe;
	setBorder(new MatteBorder(0, 0, 1, 0, MasterFrame.COULEUR_TEXTE));
	setBackground(MasterFrame.COULEUR_MASTER_FOND);
	setLayout(new BorderLayout(5,5));
	JPanel panelText = new JPanel(new GridLayout(1,0));
	panelText.setBackground(MasterFrame.COULEUR_MASTER_FOND);
	panelText.setPreferredSize(new Dimension(500, 100));
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
	panel.setBackground(MasterFrame.COULEUR_MASTER_FOND);
	
	panelText.add(panel);
	panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
	panel_2.setBackground(MasterFrame.COULEUR_MASTER_FOND);
	
	panel.add(panel_2);
	panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
	btnNewButton.setForeground(MasterFrame.COULEUR_TEXTE);
	btnNewButton.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) MasterFrame.COULEUR_TEXTE), new EmptyBorder(2, 7, 2, 7)));
	btnNewButton.setBackground(MasterFrame.COULEUR_MASTER_FOND);
	btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			MasterFrame.getInstance().setPanel(ihm.ecurie.ModifyTeam.class, panelText);
		}
	});
	
	panel_2.add(btnNewButton);
	try {
		lbArrowIcon.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("../images/Chevron.png"))));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
