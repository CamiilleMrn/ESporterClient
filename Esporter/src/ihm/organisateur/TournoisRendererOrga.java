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
	private TournoiInfo tournoi;
	private final Component verticalGlue = Box.createVerticalGlue();
	private final JPanel panel_1 = 	new JPanel();
	private final JButton lbModifyButton = new JButton();
	private final Component verticalGlue_1 = Box.createVerticalGlue();
	private final JLabel lbSep = new JLabel(" | ");
	private final JButton btnSupprimer = new JButton("Supprimer");
	
	
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
		panel.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelText.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(verticalGlue);
		
		panel_1.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		lbModifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		lbModifyButton.setText("Modifier");
		lbModifyButton.setHorizontalAlignment(SwingConstants.CENTER);
		lbModifyButton.setForeground(MasterFrame.COULEUR_TEXTE);
		lbModifyButton.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)), new EmptyBorder(3, 11, 3, 10)));
		lbModifyButton.setBackground(new Color(96, 96, 96));
		lbModifyButton.setAlignmentX(0.5f);
		
		panel_1.add(lbModifyButton);
		
		lbSep.setForeground(MasterFrame.COULEUR_TEXTE);
		panel_1.add(lbSep);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnSupprimer.setHorizontalAlignment(SwingConstants.CENTER);
		btnSupprimer.setForeground(MasterFrame.COULEUR_TEXTE);
		btnSupprimer.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)), new EmptyBorder(3, 11, 3, 10)));
		btnSupprimer.setBackground(new Color(96, 96, 96));
		btnSupprimer.setAlignmentX(0.5f);
		panel_1.add(btnSupprimer);
		
		panel.add(verticalGlue_1);

		lbArrowIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(lbArrowIcon, BorderLayout.EAST);
		
		lbTournamentName.setText(this.tournoi.getNom()+ " - " +this.tournoi.getDateInscription());
		
		lbArrowIcon.setBorder(null);
		lbArrowIcon.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		try {
			lbArrowIcon.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("../images/Chevron.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
}
	
