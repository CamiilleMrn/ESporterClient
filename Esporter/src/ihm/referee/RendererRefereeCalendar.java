package ihm.referee;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import ihm.MasterFrame;
import types.TypesTournament;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RendererRefereeCalendar extends JPanel{
	
	private JLabel lbTournamentName = new JLabel();
	private JButton lbArrowIcon = new JButton();
	private final JPanel panel = new JPanel();
	private final Component verticalGlue = Box.createVerticalGlue();
	private final JButton lbInscriptionButton = new JButton();
	private final Component verticalGlue_1 = Box.createVerticalGlue();
	private TypesTournament tournament;
	
	
	public RendererRefereeCalendar (TypesTournament tournament) {
		this.tournament = tournament;
		setBorder(new MatteBorder(0, 0, 1, 0, MasterFrame.COLOR_TEXT));
		setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		setLayout(new BorderLayout(5,5));
		JPanel panelText = new JPanel(new GridLayout(1,0));
		panelText.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelText.setPreferredSize(new Dimension(500,100));
		lbTournamentName.setForeground(MasterFrame.COLOR_TEXT);
		panelText.add(lbTournamentName);
		add(panelText, BorderLayout.WEST);
		panel.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelText.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(verticalGlue);
		Insets i = lbInscriptionButton.getInsets();
		i.set(10,10,10,10);
		lbInscriptionButton.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		lbInscriptionButton.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)), new EmptyBorder(3, 11, 3, 10)));
		lbInscriptionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbInscriptionButton.setHorizontalAlignment(SwingConstants.CENTER);
		lbInscriptionButton.setForeground(MasterFrame.COLOR_TEXT);
		
		panel.add(lbInscriptionButton);
		panel.add(verticalGlue_1);
		lbArrowIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MasterFrame.getInstance().setPanel(ihm.visitor.ProgrammeMatch.class, null);
			}
		});
		add(lbArrowIcon, BorderLayout.EAST);
		
		lbTournamentName.setText(this.tournament.getName()+ " - " +this.tournament.getRegisterDate());
		lbInscriptionButton.setText("Entrer le score");
		
		lbArrowIcon.setBorder(null);
		lbArrowIcon.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		try {
			lbArrowIcon.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("../images/Chevron.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}
