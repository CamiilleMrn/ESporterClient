package vue.organizer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import types.TypesTournament;
import vue.MasterFrame;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class RendererOrganizerCalendar extends JPanel{
	
	private JLabel lblTournamentName = new JLabel();
	private JButton lblArrowIcon = new JButton();
	private final JPanel panelBtnAction = new JPanel();
	private TypesTournament tournoi;
	private final Component verticalGlueTop = Box.createVerticalGlue();
	private final JPanel panelBtn = 	new JPanel();
	private final JButton btnModify = new JButton();
	private final Component verticalGlueBot = Box.createVerticalGlue();
	private final JLabel lblSep = new JLabel(" | ");
	private final JButton btnRemove = new JButton("Supprimer");
	
	
	public RendererOrganizerCalendar (TypesTournament tournoi) {
		this.tournoi = tournoi;
		setBorder(new MatteBorder(0, 0, 1, 0, MasterFrame.COULEUR_TEXTE));
		setBackground(MasterFrame.COULEUR_MASTER_FOND);
		setLayout(new BorderLayout(5,5));
		JPanel panelText = new JPanel(new GridLayout(1,0));
		panelText.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelText.setPreferredSize(new Dimension(500,100));
		lblTournamentName.setForeground(MasterFrame.COULEUR_TEXTE);
		panelText.add(lblTournamentName);
		add(panelText, BorderLayout.WEST);
		panelBtnAction.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelText.add(panelBtnAction);
		panelBtnAction.setLayout(new BoxLayout(panelBtnAction, BoxLayout.Y_AXIS));
		
		panelBtnAction.add(verticalGlueTop);
		
		panelBtn.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		
		panelBtnAction.add(panelBtn);
		panelBtn.setLayout(new BoxLayout(panelBtn, BoxLayout.X_AXIS));
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnModify.setText("Modifier");
		btnModify.setHorizontalAlignment(SwingConstants.CENTER);
		btnModify.setForeground(MasterFrame.COULEUR_TEXTE);
		btnModify.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)), new EmptyBorder(3, 11, 3, 10)));
		btnModify.setBackground(new Color(96, 96, 96));
		btnModify.setAlignmentX(0.5f);
		
		panelBtn.add(btnModify);
		
		lblSep.setForeground(MasterFrame.COULEUR_TEXTE);
		panelBtn.add(lblSep);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnRemove.setHorizontalAlignment(SwingConstants.CENTER);
		btnRemove.setForeground(MasterFrame.COULEUR_TEXTE);
		btnRemove.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)), new EmptyBorder(3, 11, 3, 10)));
		btnRemove.setBackground(new Color(96, 96, 96));
		btnRemove.setAlignmentX(0.5f);
		panelBtn.add(btnRemove);
		
		panelBtnAction.add(verticalGlueBot);

		lblArrowIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(lblArrowIcon, BorderLayout.EAST);
		
		lblTournamentName.setText(this.tournoi.getName()+ " - " +this.tournoi.getRegisterDate());
		
		lblArrowIcon.setBorder(null);
		lblArrowIcon.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		try {
			lblArrowIcon.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("../images/Chevron.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
}
	
