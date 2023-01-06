package vue.stable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controleur.Controler;
import types.TypesTeam;
import vue.MasterFrame;

public class RendererTeamStableManagement extends JPanel {

	private static final long serialVersionUID = 1L;
	private TypesTeam team;
	private JLabel lblTeamName = new JLabel();
	private JButton btnArrowIcon = new JButton();
	private final JPanel panel = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JButton btnNewButton = new JButton("Modifier");
	
	public RendererTeamStableManagement(TypesTeam team, int id) {
		
		this.team = team;
		setBorder(new MatteBorder(0, 0, 1, 0, MasterFrame.COLOR_TEXT));
		setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		setLayout(new BorderLayout(5,5));
		JPanel panelText = new JPanel(new GridLayout(1,0));
		panelText.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelText.setPreferredSize(new Dimension(500, 100));
		lblTeamName.setForeground(MasterFrame.COLOR_TEXT);
		panelText.add(lblTeamName);
		add(panelText, BorderLayout.WEST);
		
		btnArrowIcon.addActionListener(Controler.getInstance());
		btnArrowIcon.setActionCommand("STABLE_MANAGEMENT RENDERER INFO "+id);
		
		btnArrowIcon.setBorder(null);
		btnArrowIcon.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		add(btnArrowIcon, BorderLayout.EAST);
		lblTeamName.setText(this.team.getStable().getNickname() + " - " + this.team.getGame());
		panel.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		
		panelText.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel_2.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		btnNewButton.setForeground(MasterFrame.COLOR_TEXT);
		btnNewButton.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) MasterFrame.COLOR_TEXT), new EmptyBorder(2, 7, 2, 7)));
		btnNewButton.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.addActionListener(Controler.getInstance());
		btnNewButton.setActionCommand("STABLE_MANAGEMENT RENDERER MODIFY "+id);
		panel_2.add(btnNewButton);
		try {
			btnArrowIcon.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("../images/Chevron.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public TypesTeam getTeam() {
		return team;
	}
	
}
