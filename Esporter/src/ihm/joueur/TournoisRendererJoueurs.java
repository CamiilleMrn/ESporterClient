package ihm.joueur;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
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

import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class TournoisRendererJoueurs extends JPanel implements ListCellRenderer<TournoiInfo> {
	
	private JLabel lbTournamentName = new JLabel();
	private JLabel lbArrowIcon = new JLabel();
	private final JPanel panel = new JPanel();
	private final Component verticalGlue = Box.createVerticalGlue();
	private final JLabel lbInscriptionButton = new JLabel();
	private final Component verticalGlue_1 = Box.createVerticalGlue();
	
	
	public TournoisRendererJoueurs () {
		setBorder(new MatteBorder(0, 0, 1, 0, MasterFrame.COULEUR_TEXTE));
		setBackground(MasterFrame.COULEUR_MASTER_FOND);
		setLayout(new BorderLayout(5,5));
		JPanel panelText = new JPanel(new GridLayout(1,0));
		panelText.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelText.setPreferredSize(new Dimension(500,100));
		lbTournamentName.setForeground(MasterFrame.COULEUR_TEXTE);
		panelText.add(lbTournamentName);
		add(panelText, BorderLayout.WEST);
		panel.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelText.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(verticalGlue);
		Insets i = lbInscriptionButton.getInsets();
		i.set(10,10,10,10);
		lbInscriptionButton.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)), new EmptyBorder(3, 11, 3, 10)));
		lbInscriptionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbInscriptionButton.setHorizontalAlignment(SwingConstants.CENTER);
		lbInscriptionButton.setForeground(MasterFrame.COULEUR_TEXTE);
		
		panel.add(lbInscriptionButton);
		panel.add(verticalGlue_1);
		add(lbArrowIcon, BorderLayout.EAST);
		
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends TournoiInfo> list, TournoiInfo value, int index,
			boolean isSelected, boolean cellHasFocus) {
		lbTournamentName.setText(value.getNom()+ " - " +value.getDateInscription());
		lbInscriptionButton.setText("S'inscrire");
		lbArrowIcon.setIcon(new ImageIcon(getClass().getResource("../images/Chevron.png")));
		return this;
	}

	
}
