package ihm.component;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import ihm.InfoEcurie;
import ihm.MasterFrame;
import types.EcurieInfo;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class EcurieRenderer extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EcurieInfo ecurie;
	private JLabel lbEcurieLogo = new JLabel();
	private JButton lbArrowIcon = new JButton();
	private final JPanel panel = new JPanel();
	private final Component verticalGlue = Box.createVerticalGlue();
	private final JLabel lbEcurieName = new JLabel();
	private final Component verticalGlue_1 = Box.createVerticalGlue();

	public EcurieRenderer (EcurieInfo ecurie) {
		this.ecurie = ecurie;
		setBorder(new MatteBorder(0, 0, 1, 0, MasterFrame.COULEUR_TEXTE));
		setBackground(MasterFrame.COULEUR_MASTER_FOND);
		setLayout(new BorderLayout(5,5));
		JPanel panelText = new JPanel(new GridLayout(1,0));
		panelText.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelText.setPreferredSize(new Dimension(500,100));
		panelText.add(lbEcurieLogo);
		try {
			lbEcurieLogo.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("../images/karmine-corp.jpg"))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		lbEcurieName.setText(ecurie.getNom());
		
		panel.add(lbEcurieName);
		panel.add(verticalGlue_1);
		lbArrowIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MasterFrame.getInstance().setPanel(ihm.InfoEcurie.class, ecurie);
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
