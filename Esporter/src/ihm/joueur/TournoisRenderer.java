package ihm.joueur;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import ihm.MasterFrame;
import types.TournoiInfo;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class TournoisRenderer extends JPanel implements ListCellRenderer<TournoiInfo> {
	
	private JLabel lbTournamentName = new JLabel();
	private JLabel lbArrowIcon = new JLabel();
	
	
	public TournoisRenderer () {
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
		
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends TournoiInfo> list, TournoiInfo value, int index,
			boolean isSelected, boolean cellHasFocus) {
		lbTournamentName.setText(value.getNom());
		lbArrowIcon.setIcon(new ImageIcon(getClass().getResource("../images/Chevron.png")));
		return this;
	}

	
}
