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
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class TournoisRendererJoueur extends DataJPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbTournamentName = new JLabel();
	private JButton lbArrowIcon = new JButton();
	private final JPanel panel = new JPanel();
	private final JButton lbInscriptionButton;
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
		
		if(tournoi.getInscris().contains(((JoueurInfo)MasterFrame.getInstance().getUser().getInfo()).getId_equipe())) {
			lbInscriptionButton = new JButton("Se désinscrire");
		}else {
			lbInscriptionButton = new JButton("S'inscrire");
		}

		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0, 0, 0, 0};
		gbl_panel.rowHeights = new int[] {0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		lbInscriptionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog confirmation = new InscriptionTournois(tournoi.getId(), tournoi);
			}
		});
		lbInscriptionButton.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		lbInscriptionButton.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)), new EmptyBorder(3, 11, 3, 11)));
		lbInscriptionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbInscriptionButton.setHorizontalAlignment(SwingConstants.CENTER);
		lbInscriptionButton.setForeground(MasterFrame.COULEUR_TEXTE);
		GridBagConstraints gbc_lbInscriptionButton = new GridBagConstraints();
		gbc_lbInscriptionButton.fill = GridBagConstraints.BOTH;
		gbc_lbInscriptionButton.insets = new Insets(0, 0, 5, 5);
		gbc_lbInscriptionButton.gridx = 0;
		gbc_lbInscriptionButton.gridy = 0;
		panel.add(lbInscriptionButton, gbc_lbInscriptionButton);
		
		
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
	
	public void dataUpdate() {
		if(tournoi.getInscris().contains(((JoueurInfo)MasterFrame.getInstance().getUser().getInfo()).getId_equipe())) {
			lbInscriptionButton.setVisible(false);
		}
	}
	
	



}
