package ihm.ecurie.gestionEquipe;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.ComboBoxUI;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import java.awt.Font;

import ihm.MasterFrame;
import ihm.component.ComboBoxRendererArrow;
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
		setBackground(MasterFrame.COULEUR_MASTER_FOND);
		setPreferredSize(MasterFrame.getInstance().getCenterDimension());
		JFrame frame = MasterFrame.getInstance().getFrame(); 
		JPanel panelMain = new JPanel();
		panelMain.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		add(panelMain, BorderLayout.CENTER);
		GridBagLayout gbl_panelMain = new GridBagLayout();
		int cote = (int) (frame.getWidth()*0.15);
		int centre = (int) (frame.getWidth()*0.7);
		

		gbl_panelMain.columnWidths = new int[] {cote+1, centre, cote};
		gbl_panelMain.rowHeights = new int[] {(int) (frame.getHeight()*0.06), (int) (frame.getHeight()*0.22), (int) (frame.getHeight()*0.28), (int) (frame.getHeight()*0.3), (int) (frame.getHeight()*0.14)};
		gbl_panelMain.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panelMain.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelMain.setLayout(gbl_panelMain);
		
		JLabel TitrePage = new JLabel("Ajouter une \u00E9quipe");
		TitrePage.setFont(new Font("Cambria", Font.PLAIN, 27));
		TitrePage.setForeground(MasterFrame.COULEUR_TEXTE);
		GridBagConstraints gbc_TitrePage = new GridBagConstraints();
		gbc_TitrePage.anchor = GridBagConstraints.SOUTH;
		gbc_TitrePage.insets = new Insets(0, 0, 5, 5);
		gbc_TitrePage.gridx = 1;
		gbc_TitrePage.gridy = 0;
		panelMain.add(TitrePage, gbc_TitrePage);
		
		JPanel panelJeux = new JPanel();
		panelJeux.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_panelJeux = new GridBagConstraints();
		gbc_panelJeux.anchor = GridBagConstraints.SOUTHWEST;
		gbc_panelJeux.insets = new Insets(0, 0, 5, 5);
		gbc_panelJeux.gridx = 1;
		gbc_panelJeux.gridy = 1;
		panelMain.add(panelJeux, gbc_panelJeux);
		
		JComboBox<Jeu> comboBox = new JComboBox<>(Jeu.values());
	
		comboBox.setUI((ComboBoxUI) ComboBoxRendererArrow.createUI(comboBox));
		comboBox.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		comboBox.setFont(new Font("Cambria", Font.PLAIN, 15));
		comboBox.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		comboBox.setForeground(MasterFrame.COULEUR_TEXTE);
		comboBox.setSelectedItem(jeu);
		panelJeux.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MasterFrame.getInstance().setPanel(AjouterEquipe.class, (Jeu)comboBox.getSelectedItem());
				
			}
		});
		
		
		JPanel panelJoueur = new JPanel();
		panelJoueur.setBorder(null);
		panelJoueur.setBackground(MasterFrame.COULEUR_MASTER_FOND);
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
		panelValider.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		GridBagConstraints gbc_panelValider = new GridBagConstraints();
		gbc_panelValider.insets = new Insets(0, 0, 0, 5);
		gbc_panelValider.anchor = GridBagConstraints.NORTHEAST;
		gbc_panelValider.gridx = 1;
		gbc_panelValider.gridy = 3;
		panelMain.add(panelValider, gbc_panelValider);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnValider.setVerticalAlignment(SwingConstants.BOTTOM);
		btnValider.setMargin(new Insets(14, 0, 14, 14));
		btnValider.setIconTextGap(10);
		btnValider.setHorizontalTextPosition(SwingConstants.LEFT);
		btnValider.setHorizontalAlignment(SwingConstants.LEFT);
		btnValider.setForeground(MasterFrame.COULEUR_TEXTE);
		btnValider.setFont(new Font("Cambria", Font.PLAIN, 22));
		btnValider.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, MasterFrame.COULEUR_MASTER, null, MasterFrame.COULEUR_MASTER, null));
		btnValider.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		btnValider.setAlignmentY(1.0f);
		panelValider.add(btnValider);
		System.out.println(this.getSize().width);
		
	}

}
