package ihm.organisateur;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import ihm.MasterFrame;
import types.TournoiInfo;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class TournoisRendererOrga extends JPanel{
	
	private JLabel lbTournamentName = new JLabel();
	private JButton lbArrowIcon = new JButton();
	private final JPanel panel = new JPanel();
	private final Component verticalGlue = Box.createVerticalGlue();
	private final JLabel lbInscriptionButton = new JLabel();
	private final Component verticalGlue_1 = Box.createVerticalGlue();
	private TournoiInfo tournoi;
	
	
	public TournoisRendererOrga (TournoiInfo tournoi) {
		this.tournoi = tournoi;
		setBorder(new MatteBorder(0, 0, 1, 0, MasterFrame.COULEUR_TEXTE));
		setBackground(MasterFrame.COULEUR_MASTER_FOND);
		setLayout(new BorderLayout(5,5));
		JPanel panelText = new JPanel(new GridLayout(1,0));
		panelText.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelText.setPreferredSize(new Dimension(500,100));
		lbTournamentName.setForeground(MasterFrame.COULEUR_TEXTE);
		panelText.add(lbTournamentName);
		add(panelText, BorderLayout.WEST);
		
		lbArrowIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		lbArrowIcon.setBorder(null);
		lbArrowIcon.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		add(lbArrowIcon, BorderLayout.EAST);
		lbTournamentName.setText(this.tournoi.getNom()+" - "+this.tournoi.getDateInscription());
		try {
			lbArrowIcon.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("../images/Chevron.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
