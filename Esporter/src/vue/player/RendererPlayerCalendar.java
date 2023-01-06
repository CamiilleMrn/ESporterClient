package vue.player;

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

import controleur.Controler;
import types.TypesGame;
import types.TypesPlayer;
import types.TypesTournament;
import vue.MasterFrame;
import vue.component.DataJPanel;
import vue.component.RendererCalendar;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class RendererPlayerCalendar extends DataJPanel implements RendererCalendar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTournamentName = new JLabel();
	private JButton lblArrowIcon = new JButton();
	private final JPanel panelBtnRegister = new JPanel();
	private JButton lbInscriptionButton;
	private TypesTournament tournament;
	
	
	public RendererPlayerCalendar (TypesTournament tournament, int id) {
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
		
		
		int idStable = ((TypesPlayer)MasterFrame.getInstance().getUser().getInfo()).getIdStable();
		int idTeam = ((TypesPlayer)MasterFrame.getInstance().getUser().getInfo()).getIdTeam();
		TypesGame game = MasterFrame.getInstance().getUser().getData().getStables().get(idStable).getTeams().get(idTeam).getGame();
		lbInscriptionButton = new JButton("");
		lbInscriptionButton.setVisible(false);
		if (!tournament.isFull() && tournament.getGame()== game) {
			if(tournament.getRegistered().contains(((TypesPlayer)MasterFrame.getInstance().getUser().getInfo()).getIdTeam())) {
				lbInscriptionButton = new JButton("Se désinscrire");
			} else {
				lbInscriptionButton = new JButton("S'inscrire");
			}
		}
		if (tournament.isFull() && tournament.getRegistered().contains(((TypesPlayer)MasterFrame.getInstance().getUser().getInfo()).getIdTeam())) {
			lbInscriptionButton = new JButton("Vous etes inscrit");
			lbInscriptionButton.setEnabled(false);
		}

		GridBagLayout gbl_panelBtnRegister = new GridBagLayout();
		gbl_panelBtnRegister.columnWidths = new int[] {0, 0, 0, 0};
		gbl_panelBtnRegister.rowHeights = new int[] {0, 0};
		gbl_panelBtnRegister.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panelBtnRegister.rowWeights = new double[]{0.0, 0.0};
		panelBtnRegister.setLayout(gbl_panelBtnRegister);
		
		lbInscriptionButton.addActionListener(Controler.getInstance());
		lbInscriptionButton.setActionCommand("CALENDAR RENDERER INSCRIPTION "+id);
		
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
		
		
		lblArrowIcon.addActionListener(Controler.getInstance());
		lblArrowIcon.setActionCommand("CALENDAR RENDERER POOL "+id);
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
		
		lblArrowIcon.setVisible(false);
		if (this.tournament.isFull()) {
			lblArrowIcon.setVisible(true);
		}
		
	}
	
	@Override
	public void dataUpdate() {
		int idStable = ((TypesPlayer)MasterFrame.getInstance().getUser().getInfo()).getIdStable();
		int idTeam = ((TypesPlayer)MasterFrame.getInstance().getUser().getInfo()).getIdTeam();
		TypesGame game = MasterFrame.getInstance().getUser().getData().getStables().get(idStable).getTeams().get(idTeam).getGame();
		if (!tournament.isFull() && tournament.getGame()!= game) {
			if(tournament.getRegistered().contains(((TypesPlayer)MasterFrame.getInstance().getUser().getInfo()).getIdTeam())) {
				lbInscriptionButton = new JButton("Se désinscrire");
			} else {
				lbInscriptionButton = new JButton("S'inscrire");
			}
		}
		if (tournament.isFull() && tournament.getRegistered().contains(((TypesPlayer)MasterFrame.getInstance().getUser().getInfo()).getIdTeam())) {
			lbInscriptionButton = new JButton("Vous etes deja inscrit");
			lbInscriptionButton.setEnabled(false);
		}
	}

	@Override
	public TypesTournament getTournament() {
		return tournament;
	}
	
	



}
