package ihm.component;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import ihm.MasterFrame;
import types.TypesStable;
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
	private JButton lbArrowIcon = new JButton();
	private final JPanel panel = new JPanel();
	private final Component verticalGlueTop = Box.createVerticalGlue();
	private final JLabel lbStableName = new JLabel();
	private final Component verticalGlueBottom = Box.createVerticalGlue();

	public RendererStable (TypesStable stable) {
		setPreferredSize(new Dimension(getPreferredSize().width, 150));
		setBorder(new MatteBorder(0, 0, 1, 0, MasterFrame.COLOR_TEXT));
		setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		setLayout(new BorderLayout(5,5));
		JPanel panelText = new JPanel(new GridLayout(1,0));
		panelText.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelText.setPreferredSize(new Dimension(500,100));
		panelText.add(lbStableLogo);

			BufferedImage logoEcurie = stable.getLogo().getImage();
			logoEcurie = resize(logoEcurie, 200, 200);
			lbStableLogo.setIcon(new ImageIcon(logoEcurie));
			
		add(panelText, BorderLayout.WEST);
		panel.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelText.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(verticalGlueTop);
		Insets i = lbStableName.getInsets();
		i.set(10,10,10,10);
		lbStableName.setFont(new Font("Cambria", Font.PLAIN, 15));
		lbStableName.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		lbStableName.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbStableName.setHorizontalAlignment(SwingConstants.CENTER);
		lbStableName.setForeground(MasterFrame.COLOR_TEXT);
		lbStableName.setText(stable.getName());
		
		panel.add(lbStableName);
		panel.add(verticalGlueBottom);
		lbArrowIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MasterFrame.getInstance().setPanel(ihm.StableInfo.class, stable);
			}
		});
		add(lbArrowIcon, BorderLayout.EAST);
		lbArrowIcon.setBorder(null);
		lbArrowIcon.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		try {
			lbArrowIcon.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("../images/Chevron.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}

}
