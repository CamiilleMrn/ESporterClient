package ihm.stable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import ihm.MasterFrame;
import ihm.Stables;
import types.TypesTeam;
import types.TypesTournament;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RendererStableCalendar extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4218862590543030118L;
	private JLabel lblTournamentName = new JLabel();
	private JButton lblArrowIcon = new JButton();
	private TypesTournament tournament;
	private AbstractButton lblTeamName;
	
	public RendererStableCalendar(TypesTournament tournament) {
		this.tournament = tournament;
		setBorder(new MatteBorder(0, 0, 1, 0, MasterFrame.COLOR_TEXT));
		setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		setLayout(new BorderLayout(5,5));
		JPanel panelText = new JPanel(new GridLayout(1,0));
		panelText.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelText.setPreferredSize(new Dimension(500,100));
		lblTournamentName.setForeground(MasterFrame.COLOR_TEXT);
		panelText.add(lblTournamentName);
		add(panelText, BorderLayout.WEST);
		
		lblArrowIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MasterFrame.getInstance().setPanel(ihm.component.ProgramMatchs.class, null);
			}
		});
		
		lblArrowIcon.setBorder(null);
		lblArrowIcon.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		add(lblArrowIcon, BorderLayout.EAST);
		lblTournamentName.setText(this.tournament.getName()+" - "+this.tournament.getRegisterDate());
		try {
			lblArrowIcon.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("../images/Chevron.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}
