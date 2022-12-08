package ihm.component;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import ihm.MasterFrame;
import types.TypesImage;
import types.TypesStable;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
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

public class EcurieRenderer extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbEcurieLogo = new JLabel();
	private JButton lbArrowIcon = new JButton();
	private final JPanel panel = new JPanel();
	private final Component verticalGlue = Box.createVerticalGlue();
	private final JLabel lbEcurieName = new JLabel();
	private final Component verticalGlue_1 = Box.createVerticalGlue();
	private TypesStable ecurie;

	public EcurieRenderer (TypesStable ecurie) {
		setPreferredSize(new Dimension(getPreferredSize().width, 150));
		this.ecurie = ecurie;
		setBorder(new MatteBorder(0, 0, 1, 0, MasterFrame.COULEUR_TEXTE));
		setBackground(MasterFrame.COULEUR_MASTER_FOND);
		setLayout(new BorderLayout(5,5));
		JPanel panelText = new JPanel(new GridLayout(1,0));
		panelText.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelText.setPreferredSize(new Dimension(500,100));
		panelText.add(lbEcurieLogo);

			BufferedImage logoEcurie = ecurie.getLogo().getImage();
			logoEcurie = TypesImage.resize(logoEcurie, 200, 200);
			lbEcurieLogo.setIcon(new ImageIcon(logoEcurie));
			
		add(panelText, BorderLayout.WEST);
		panel.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelText.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(verticalGlue);
		Insets i = lbEcurieName.getInsets();
		i.set(10,10,10,10);
		lbEcurieName.setFont(new Font("Cambria", Font.PLAIN, 15));
		lbEcurieName.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		lbEcurieName.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbEcurieName.setHorizontalAlignment(SwingConstants.CENTER);
		lbEcurieName.setForeground(MasterFrame.COULEUR_TEXTE);
		lbEcurieName.setText(ecurie.getName());
		
		panel.add(lbEcurieName);
		panel.add(verticalGlue_1);
		lbArrowIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MasterFrame.getInstance().setPanel(ihm.StableInfo.class, ecurie);
			}
		});
		add(lbArrowIcon, BorderLayout.EAST);
		lbArrowIcon.setBorder(null);
		lbArrowIcon.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		try {
			lbArrowIcon.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("../images/Chevron.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
