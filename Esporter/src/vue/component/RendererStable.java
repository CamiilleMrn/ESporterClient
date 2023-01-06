package vue.component;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import controleur.Controler;
import types.TypesImage;
import types.TypesStable;
import vue.MasterFrame;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics2D;

public class RendererStable extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbStableLogo = new JLabel();
	private JButton btnArrowIcon = new JButton();
	private final JPanel panel = new JPanel();
	private final Component verticalGlueTop = Box.createVerticalGlue();
	private final JLabel lblStableName = new JLabel();
	private final Component verticalGlueBottom = Box.createVerticalGlue();
	private TypesStable stable;

	public RendererStable (TypesStable stable, int id) {
		this.stable = stable;
		setPreferredSize(new Dimension(getPreferredSize().width, 150));
		setBorder(new MatteBorder(0, 0, 1, 0, MasterFrame.COLOR_TEXT));
		setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		setLayout(new BorderLayout(5,5));
		JPanel panelText = new JPanel(new GridLayout(1,0));
		panelText.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelText.setPreferredSize(new Dimension(500,100));
		panelText.add(lbStableLogo);

		BufferedImage logoEcurie = stable.getLogo().getImage();
		logoEcurie = TypesImage.resize(logoEcurie, 200, 200);
		lbStableLogo.setIcon(new ImageIcon(logoEcurie));
			
		add(panelText, BorderLayout.WEST);
		panel.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelText.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(verticalGlueTop);
		Insets i = lblStableName.getInsets();
		i.set(10,10,10,10);
		lblStableName.setFont(new Font("Cambria", Font.PLAIN, 15));
		lblStableName.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		lblStableName.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblStableName.setHorizontalAlignment(SwingConstants.CENTER);
		lblStableName.setForeground(MasterFrame.COLOR_TEXT);
		lblStableName.setText(stable.getName());
		
		panel.add(lblStableName);
		panel.add(verticalGlueBottom);
		btnArrowIcon.addActionListener(Controler.getInstance());
		btnArrowIcon.setActionCommand("STABLE_LIST RENDERER "+id);
		add(btnArrowIcon, BorderLayout.EAST);
		btnArrowIcon.setBorder(null);
		btnArrowIcon.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		try {
			btnArrowIcon.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("../images/Chevron.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public TypesStable getStable() {
		return stable;
	}

}
