package ihm.component;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ihm.MasterFrame;
import types.EcurieInfo;
import types.Titre;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;

public class InfoEcuriePalmaRenderer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Titre titre;

	public InfoEcuriePalmaRenderer(Titre titre) {
		this.titre = titre;
		
		setBackground(MasterFrame.COULEUR_MASTER_FOND);
		setPreferredSize(new Dimension(500,100));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel containerNamePalma = new JPanel();
		containerNamePalma.setBackground(MasterFrame.COULEUR_MASTER_FOND );
		add(containerNamePalma);
		GridBagLayout gbl_containerNamePalma = new GridBagLayout();
		gbl_containerNamePalma.columnWidths = new int[] {0};
		gbl_containerNamePalma.rowHeights = new int[] {0, 0, 0};
		gbl_containerNamePalma.columnWeights = new double[]{0.0};
		gbl_containerNamePalma.rowWeights = new double[]{0.0, 0.0, 0.0};
		containerNamePalma.setLayout(gbl_containerNamePalma);
		
		Component verticalGlue = Box.createVerticalGlue();
		GridBagConstraints gbc_verticalGlue = new GridBagConstraints();
		gbc_verticalGlue.insets = new Insets(0, 0, 5, 0);
		gbc_verticalGlue.gridx = 0;
		gbc_verticalGlue.gridy = 0;
		containerNamePalma.add(verticalGlue, gbc_verticalGlue);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setForeground(MasterFrame.COULEUR_TEXTE);
		lblNewLabel.setText(titre.getNom());
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		containerNamePalma.add(lblNewLabel, gbc_lblNewLabel);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		GridBagConstraints gbc_verticalGlue_1 = new GridBagConstraints();
		gbc_verticalGlue_1.gridx = 0;
		gbc_verticalGlue_1.gridy = 2;
		containerNamePalma.add(verticalGlue_1, gbc_verticalGlue_1);
		
		JPanel containerYearPalma = new JPanel();
		containerYearPalma.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		add(containerYearPalma);
		GridBagLayout gbl_containerYearPalma = new GridBagLayout();
		gbl_containerYearPalma.columnWidths = new int[] {0};
		gbl_containerYearPalma.rowHeights = new int[] {0};
		gbl_containerYearPalma.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_containerYearPalma.rowWeights = new double[]{0.0};
		containerYearPalma.setLayout(gbl_containerYearPalma);
		
		Component verticalGlue_2 = Box.createVerticalGlue();
		GridBagConstraints gbc_verticalGlue_2 = new GridBagConstraints();
		gbc_verticalGlue_2.anchor = GridBagConstraints.WEST;
		gbc_verticalGlue_2.insets = new Insets(0, 0, 0, 5);
		gbc_verticalGlue_2.gridx = 0;
		gbc_verticalGlue_2.gridy = 0;
		containerYearPalma.add(verticalGlue_2, gbc_verticalGlue_2);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setForeground(MasterFrame.COULEUR_TEXTE);
		lblNewLabel_1.setText(titre.getObtention().toString());
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		containerYearPalma.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		Component verticalGlue_3 = Box.createVerticalGlue();
		GridBagConstraints gbc_verticalGlue_3 = new GridBagConstraints();
		gbc_verticalGlue_3.anchor = GridBagConstraints.WEST;
		gbc_verticalGlue_3.gridx = 2;
		gbc_verticalGlue_3.gridy = 0;
		containerYearPalma.add(verticalGlue_3, gbc_verticalGlue_3);
	}
}
