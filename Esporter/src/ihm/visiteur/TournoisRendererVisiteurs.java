package ihm.visiteur;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.MatteBorder;

import ihm.MasterFrame;
import types.TournoiInfo;

public class TournoisRendererVisiteurs extends JPanel{
	
	private JLabel lbTournamentName = new JLabel();
	private JLabel lbArrowIcon = new JLabel();
	private TournoiInfo tournoi;
	
	public TournoisRendererVisiteurs(TournoiInfo tournoi) {
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
		add(lbArrowIcon, BorderLayout.EAST);
		lbTournamentName.setText(this.tournoi.getNom()+" - "+this.tournoi.getDateInscription());
		lbArrowIcon.setIcon(new ImageIcon(getClass().getResource("../images/Chevron.png")));
		
	}



}
