package ihm.component;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ihm.MasterFrame;
import types.TypesStable;
import types.TypesTitle;

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

public class RendererStableTitle extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RendererStableTitle(TypesTitle title) {
		
		setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		setPreferredSize(new Dimension(500,100));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel containerNameTitle = new JPanel();
		containerNameTitle.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND );
		add(containerNameTitle);
		GridBagLayout gbl_containerNameTitle = new GridBagLayout();
		gbl_containerNameTitle.columnWidths = new int[] {0};
		gbl_containerNameTitle.rowHeights = new int[] {0, 0, 0};
		gbl_containerNameTitle.columnWeights = new double[]{0.0};
		gbl_containerNameTitle.rowWeights = new double[]{0.0, 0.0, 0.0};
		containerNameTitle.setLayout(gbl_containerNameTitle);
		
		Component verticalGlue = Box.createVerticalGlue();
		GridBagConstraints gbc_verticalGlue = new GridBagConstraints();
		gbc_verticalGlue.insets = new Insets(0, 0, 5, 0);
		gbc_verticalGlue.gridx = 0;
		gbc_verticalGlue.gridy = 0;
		containerNameTitle.add(verticalGlue, gbc_verticalGlue);
		
		JLabel lblTitle = new JLabel();
		lblTitle.setForeground(MasterFrame.COLOR_TEXT);
		lblTitle.setText(title.getName());
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 1;
		containerNameTitle.add(lblTitle, gbc_lblTitle);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		GridBagConstraints gbc_verticalGlue_1 = new GridBagConstraints();
		gbc_verticalGlue_1.gridx = 0;
		gbc_verticalGlue_1.gridy = 2;
		containerNameTitle.add(verticalGlue_1, gbc_verticalGlue_1);
		
		JPanel containerYearTitle = new JPanel();
		containerYearTitle.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		add(containerYearTitle);
		GridBagLayout gbl_containerYearTitle = new GridBagLayout();
		gbl_containerYearTitle.columnWidths = new int[] {0};
		gbl_containerYearTitle.rowHeights = new int[] {0};
		gbl_containerYearTitle.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_containerYearTitle.rowWeights = new double[]{0.0};
		containerYearTitle.setLayout(gbl_containerYearTitle);
		
		Component verticalGlue_2 = Box.createVerticalGlue();
		GridBagConstraints gbc_verticalGlue_2 = new GridBagConstraints();
		gbc_verticalGlue_2.anchor = GridBagConstraints.WEST;
		gbc_verticalGlue_2.insets = new Insets(0, 0, 0, 5);
		gbc_verticalGlue_2.gridx = 0;
		gbc_verticalGlue_2.gridy = 0;
		containerYearTitle.add(verticalGlue_2, gbc_verticalGlue_2);
		
		JLabel lblTitleDate = new JLabel();
		lblTitleDate.setForeground(MasterFrame.COLOR_TEXT);
		lblTitleDate.setText(title.getObtentionDate().toString());
		GridBagConstraints gbc_lblTitleDate = new GridBagConstraints();
		gbc_lblTitleDate.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTitleDate.insets = new Insets(0, 0, 0, 5);
		gbc_lblTitleDate.gridx = 1;
		gbc_lblTitleDate.gridy = 0;
		containerYearTitle.add(lblTitleDate, gbc_lblTitleDate);
		
		Component verticalGlue_3 = Box.createVerticalGlue();
		GridBagConstraints gbc_verticalGlue_3 = new GridBagConstraints();
		gbc_verticalGlue_3.anchor = GridBagConstraints.WEST;
		gbc_verticalGlue_3.gridx = 2;
		gbc_verticalGlue_3.gridy = 0;
		containerYearTitle.add(verticalGlue_3, gbc_verticalGlue_3);
	}
}
