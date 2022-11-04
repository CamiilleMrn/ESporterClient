package ihm.ecurie.gestionEquipe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import javax.swing.JButton;
import java.awt.Font;

import ihm.MasterFrame;
import ihm.component.containerJoueur;
import types.Jeu;


public class AjouterEquipe extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5531842744073477854L;
	private Jeu jeu;
	/**
	 * Create the application.
	 */
	public AjouterEquipe(Jeu jeu) {
		this.jeu = jeu;
		initialize();
		this.setVisible(true);
		this.repaint();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//JPanel root = new JPanel();
		//root.setLayout(new BorderLayout());
		JPanel panelMain = new JPanel();
		panelMain.setBackground(Color.DARK_GRAY);
		add(panelMain, BorderLayout.CENTER);
		GridBagLayout gbl_panelMain = new GridBagLayout();
		gbl_panelMain.columnWidths = new int[] {100, 600, 100};
		gbl_panelMain.rowHeights = new int[] {100, 70, 130, 100, 60};
		gbl_panelMain.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panelMain.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelMain.setLayout(gbl_panelMain);
		
		JLabel TitrePage = new JLabel("Ajouter une \u00E9quipe");
		TitrePage.setFont(new Font("Cambria", Font.PLAIN, 27));
		TitrePage.setForeground(Color.WHITE);
		GridBagConstraints gbc_TitrePage = new GridBagConstraints();
		gbc_TitrePage.anchor = GridBagConstraints.SOUTH;
		gbc_TitrePage.insets = new Insets(0, 0, 5, 5);
		gbc_TitrePage.gridx = 1;
		gbc_TitrePage.gridy = 0;
		panelMain.add(TitrePage, gbc_TitrePage);
		
		JPanel panelJeux = new JPanel();
		panelJeux.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panelJeux = new GridBagConstraints();
		gbc_panelJeux.anchor = GridBagConstraints.SOUTHWEST;
		gbc_panelJeux.insets = new Insets(0, 0, 5, 5);
		gbc_panelJeux.gridx = 1;
		gbc_panelJeux.gridy = 1;
		panelMain.add(panelJeux, gbc_panelJeux);
		
		JComboBox<Jeu> comboBox = new JComboBox<>(Jeu.values());
		comboBox.setSelectedItem(jeu);
		panelJeux.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MasterFrame.getInstance().setPanel(new AjouterEquipe((Jeu)comboBox.getSelectedItem()));
				
			}
		});
		
		
		JPanel panelJoueur = new JPanel();
		panelJoueur.setBorder(null);
		panelJoueur.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panelJoueur = new GridBagConstraints();
		gbc_panelJoueur.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelJoueur.insets = new Insets(0, 0, 5, 5);
		gbc_panelJoueur.gridx = 1;
		gbc_panelJoueur.gridy = 2;
		panelMain.add(panelJoueur, gbc_panelJoueur);
		
		int tailleEquipe = jeu.getJoueurMax();
		containerJoueur[] listeJoueur = new containerJoueur[tailleEquipe];
		for (int i=0; i<tailleEquipe; i++) {
			listeJoueur[i] = new containerJoueur();
			panelJoueur.add(listeJoueur[i]);
		}
		
		JPanel panelValider = new JPanel();
		panelValider.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panelValider = new GridBagConstraints();
		gbc_panelValider.insets = new Insets(0, 0, 0, 5);
		gbc_panelValider.anchor = GridBagConstraints.NORTHEAST;
		gbc_panelValider.gridx = 1;
		gbc_panelValider.gridy = 3;
		panelMain.add(panelValider, gbc_panelValider);
		
		JButton btnValider = new JButton("Valider");
		panelValider.add(btnValider);
		
	}

}
