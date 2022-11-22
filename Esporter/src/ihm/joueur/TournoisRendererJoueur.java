package ihm.joueur;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import ihm.MasterFrame;
import ihm.component.DataJPanel;
import types.JoueurInfo;
import types.TournoiInfo;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TournoisRendererJoueur extends DataJPanel{
	
	private JLabel lbTournamentName = new JLabel();
	private JButton lbArrowIcon = new JButton();
	private final JPanel panel = new JPanel();
	private final Component verticalGlue = Box.createVerticalGlue();
	private final JButton lbInscriptionButton = new JButton();
	private final Component verticalGlue_1 = Box.createVerticalGlue();
	private TournoiInfo tournoi;
	
	
	public TournoisRendererJoueur (TournoiInfo tournoi) {
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
		Insets i = lbInscriptionButton.getInsets();
		i.set(10,10,10,10);
		
		if(tournoi.getInscris().contains(((JoueurInfo)MasterFrame.getInstance().getUser().getInfo()).getId_equipe())) {
			lbInscriptionButton.setVisible(false);
		}
		
		lbInscriptionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog confirmation = new InscriptionTournois(tournoi.getId());
			}
		});
		lbInscriptionButton.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		lbInscriptionButton.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)), new EmptyBorder(3, 11, 3, 10)));
		lbInscriptionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbInscriptionButton.setHorizontalAlignment(SwingConstants.CENTER);
		lbInscriptionButton.setForeground(MasterFrame.COULEUR_TEXTE);
		
		panel.add(lbInscriptionButton);
		panel.add(verticalGlue_1);
		lbArrowIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(lbArrowIcon, BorderLayout.EAST);
		
		lbTournamentName.setText(this.tournoi.getNom()+ " - " +this.tournoi.getDateInscription());
		lbInscriptionButton.setText("S'inscrire");
		
		lbArrowIcon.setBorder(null);
		lbArrowIcon.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		try {
			lbArrowIcon.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("../images/Chevron.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void dataUpdate() {
		if(tournoi.getInscris().contains(((JoueurInfo)MasterFrame.getInstance().getUser().getInfo()).getId_equipe())) {
			lbInscriptionButton.setVisible(false);
		}
	}
	
	



}
