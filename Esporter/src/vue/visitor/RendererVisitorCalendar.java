package vue.visitor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.MatteBorder;

import controleur.Controler;
import types.TypesTournament;
import vue.MasterFrame;
import vue.component.RendererCalendar;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RendererVisitorCalendar extends JPanel implements RendererCalendar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4997617698553753596L;
	private JLabel lblTournamentName = new JLabel();
	private JButton lblArrowIcon = new JButton();
	private TypesTournament tournament;
	
	public RendererVisitorCalendar(TypesTournament tournament, int id) {
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
		
		lblArrowIcon.addActionListener(Controler.getInstance());
		lblArrowIcon.setActionCommand("CALENDAR RENDERER POOL "+id);
		
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
		
		lblArrowIcon.setVisible(false);
		if (this.tournament.isFull()) {
			lblArrowIcon.setVisible(true);
		}
		
	}

	@Override
	public TypesTournament getTournament() {
		return tournament;
	}



}
