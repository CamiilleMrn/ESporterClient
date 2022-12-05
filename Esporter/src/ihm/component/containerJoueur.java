package ihm.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import ihm.MasterFrame;
import ihm.ecurie.AjouterunJoueur;
import types.JoueurInfo;
import types.registerJoueur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Insets;
import java.awt.Font;
public class containerJoueur extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6951669578094176958L;
	private registerJoueur joueur = null;
	private JLabel photo;
	private JLabel nomJoueur;
	private static final int WIDTH = 100;
	private static final int HEIGHT = 150;
	/**
	 * Create the panel.
	 */
	public containerJoueur() {
		setBorder(new LineBorder(MasterFrame.COULEUR_MASTER, 2, true));
		setSize(WIDTH, HEIGHT);
		setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {WIDTH};
		gridBagLayout.rowHeights = new int[] {HEIGHT-HEIGHT/4, HEIGHT/4};
		gridBagLayout.columnWeights = new double[]{0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		setLayout(gridBagLayout);
		
		photo = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(photo, gbc_lblNewLabel);
		
		containerJoueur self = this;
		
		nomJoueur = new JLabel("");
		nomJoueur.setFont(new Font("Cambria", Font.PLAIN, 11));
		GridBagConstraints gbc_nomJoueur = new GridBagConstraints();
		gbc_nomJoueur.gridx = 0;
		gbc_nomJoueur.gridy = 1;
		add(nomJoueur, gbc_nomJoueur);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Open Window to change player
				AjouterunJoueur ajout = new AjouterunJoueur(self);
				ajout.setVisible(true);
				ajout.setAlwaysOnTop(true);
			}
		});
		
	}
	
	public void setJoueur(registerJoueur joueur) {
		this.joueur = joueur;
		nomJoueur.setText(joueur.getJoueur().getNom()+" "+joueur.getJoueur().getPrenom());
		BufferedImage bf = joueur.getJoueur().getPhoto().getImage();
		bf = types.Image.resize(bf, WIDTH-1, HEIGHT-HEIGHT/4-1);
		photo.setIcon(new ImageIcon(bf));
		revalidate();
		repaint();
		repaint();
	}
	
	
	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		BufferedImage bf = joueur.getJoueur().getPhoto().getImage();
		g.drawImage(bf, 0, 0, null);
	}
	
	public registerJoueur getJoueur() {
		return joueur;
	}
	
	

}
