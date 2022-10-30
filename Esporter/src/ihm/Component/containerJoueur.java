package ihm.Component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.SystemColor;
import Types.Joueur;
public class containerJoueur extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6951669578094176958L;
	private Image photo = null;
	private Joueur joueur = new Joueur();
	private static final int WIDTH = 100;
	private static final int HEIGHT = 150;
	/**
	 * Create the panel.
	 */
	public containerJoueur() {
		setBorder(new LineBorder(SystemColor.textHighlight, 2, true));
		setSize(WIDTH, HEIGHT);
		setBackground(Color.DARK_GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {WIDTH};
		gridBagLayout.rowHeights = new int[] {HEIGHT-HEIGHT/4, HEIGHT/4};
		gridBagLayout.columnWeights = new double[]{0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		setLayout(gridBagLayout);
		
		JPanel containerNom = new JPanel();
		containerNom.setSize(WIDTH, HEIGHT/4);
		containerNom.setBackground(new Color(255, 255, 255, 65));
		GridBagConstraints gbc_containerNom = new GridBagConstraints();
		gbc_containerNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_containerNom.anchor = GridBagConstraints.SOUTH;
		gbc_containerNom.gridx = 0;
		gbc_containerNom.gridy = 1;
		add(containerNom, gbc_containerNom);
		
		JLabel nomJoueur = new JLabel(joueur.getNom()+" "+joueur.getPrenom());
		containerNom.add(nomJoueur);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Open Window to change player
				System.out.println("Ouverture");
			}
		});
		
	}
	
	
	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		g.drawImage(photo, 0, 0, null);
	}
	
	

}
