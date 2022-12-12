package ihm.player;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import ihm.MasterFrame;
import ihm.component.DataJPanel;
import types.TypesPlayer;
import types.TypesTournament;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class RendererPlayerCalendar extends DataJPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTournamentName = new JLabel();
	private JButton lblArrowIcon = new JButton();
	private final JPanel panelBtnRegister = new JPanel();
	private JButton lbInscriptionButton;
	private TypesTournament tournament;
	
	
	public RendererPlayerCalendar (TypesTournament tournament) {
		this.tournament = tournament;
		setBorder(new MatteBorder(0, 0, 1, 0, MasterFrame.COLOR_TEXT));
		setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		setLayout(new BorderLayout(5,5));
		JPanel panelContent = new JPanel(new GridLayout(1,0));
		panelContent.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelContent.setPreferredSize(new Dimension(500,100));
		lblTournamentName.setForeground(MasterFrame.COLOR_TEXT);
		panelContent.add(lblTournamentName);
		add(panelContent, BorderLayout.WEST);
		panelBtnRegister.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelContent.add(panelBtnRegister);
		
		if(this.tournament.getRegistered().contains(((TypesPlayer)MasterFrame.getInstance().getUser().getInfo()).getIdTeam())) {
			lbInscriptionButton = new JButton("Se désinscrire");
		}else {
			lbInscriptionButton = new JButton("S'inscrire");
		}

		GridBagLayout gbl_panelBtnRegister = new GridBagLayout();
		gbl_panelBtnRegister.columnWidths = new int[] {0, 0, 0, 0};
		gbl_panelBtnRegister.rowHeights = new int[] {0, 0};
		gbl_panelBtnRegister.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panelBtnRegister.rowWeights = new double[]{0.0, 0.0};
		panelBtnRegister.setLayout(gbl_panelBtnRegister);
		
		lbInscriptionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog confirmation = new RegisterTournament(tournament.getId(), tournament);
			}
		});
		lbInscriptionButton.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		lbInscriptionButton.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, MasterFrame.COLOR_TEXT), new EmptyBorder(3, 11, 3, 11)));
		lbInscriptionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbInscriptionButton.setHorizontalAlignment(SwingConstants.CENTER);
		lbInscriptionButton.setForeground(MasterFrame.COLOR_TEXT);
		GridBagConstraints gbc_lbInscriptionButton = new GridBagConstraints();
		gbc_lbInscriptionButton.fill = GridBagConstraints.BOTH;
		gbc_lbInscriptionButton.insets = new Insets(0, 0, 5, 5);
		gbc_lbInscriptionButton.gridx = 0;
		gbc_lbInscriptionButton.gridy = 0;
		panelBtnRegister.add(lbInscriptionButton, gbc_lbInscriptionButton);
		
		
		lblArrowIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(lblArrowIcon, BorderLayout.EAST);
		
		lblTournamentName.setText(this.tournament.getName()+ " - " +this.tournament.getRegisterDate());
		
		lblArrowIcon.setBorder(null);
		lblArrowIcon.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		try {
			lblArrowIcon.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("../images/Chevron.png"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void dataUpdate() {
		if(tournament.getRegistered().contains(((TypesPlayer)MasterFrame.getInstance().getUser().getInfo()).getIdTeam())) {
			lbInscriptionButton = new JButton("Se désinscrire");
		} else {
			lbInscriptionButton = new JButton("S'inscrire");
		}
	}
	
	



}
