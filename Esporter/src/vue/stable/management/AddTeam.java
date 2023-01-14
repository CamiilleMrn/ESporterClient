package vue.stable.management;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.ComboBoxUI;

import controleur.Controler;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import java.awt.Font;

import model.socket.Response;
import types.TypesStable;
import types.TypesGame;
import types.TypesRegisterTeam;
import types.TypesRegisterPlayer;
import types.exception.ExceptionTeamNotFull;
import vue.MasterFrame;
import vue.component.ComboBoxRendererArrow;
import vue.component.ContainerPlayer;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.Box;


public class AddTeam extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5531842744073477854L;
	private TypesGame game;
	private ContainerPlayer[] playerList;
	private JComboBox<TypesGame> comboBox;
	/**
	 * Create the application.
	 */
	public AddTeam(TypesGame game) {
		this.game = game;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		setPreferredSize(MasterFrame.getInstance().getFrameCenterDimension());
		JFrame frame = MasterFrame.getInstance().getFrame(); 
		setLayout(new BorderLayout(0, 0));
		JPanel panelMain = new JPanel();
		panelMain.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		add(panelMain);
		int side = (int) (frame.getWidth()*0.15);
		int center = (int) (frame.getWidth()*0.7);
		panelMain.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelMain.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Ajouter une équipe");
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("Cambria", Font.PLAIN, 27));
		panel_1.add(lblTitle);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel.add(panel_2, BorderLayout.SOUTH);
		
		comboBox = new JComboBox<>(TypesGame.values());
		comboBox.setUI((ComboBoxUI) ComboBoxRendererArrow.createUI(comboBox));
		comboBox.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		comboBox.setFont(new Font("Cambria", Font.PLAIN, 15));
		comboBox.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		comboBox.setForeground(MasterFrame.COLOR_TEXT);
		comboBox.setSelectedItem(game);
		comboBox.setActionCommand("ADD_TEAM_COMBOGAME");
		comboBox.addActionListener(Controler.getInstance());
		
		panel_2.add(comboBox);
		
		
		JPanel panelPlayer = new JPanel();
		panelPlayer.setBorder(null);
		panelPlayer.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelMain.add(panelPlayer);
		
		int teamSize = game.getMaxPlayer();
		playerList = new ContainerPlayer[teamSize];
		for (int i=0; i<teamSize; i++) {
			playerList[i] = new ContainerPlayer();
			panelPlayer.add(playerList[i]);
		}
		
		JPanel panelValidate = new JPanel();
		panelValidate.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelMain.add(panelValidate);
		
		JButton btnValidate = new JButton("Valider");
		btnValidate.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnValidate.setVerticalAlignment(SwingConstants.BOTTOM);
		btnValidate.setMargin(new Insets(14, 0, 14, 14));
		btnValidate.setIconTextGap(10);
		btnValidate.setHorizontalTextPosition(SwingConstants.LEFT);
		btnValidate.setHorizontalAlignment(SwingConstants.LEFT);
		btnValidate.setForeground(SystemColor.text);
		btnValidate.setFont(new Font("Cambria", Font.PLAIN, 22));
		btnValidate.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 120, 215)), new EmptyBorder(3, 5, 3, 5)));
		btnValidate.setBackground(MasterFrame.COLOR_MASTER);
		btnValidate.setAlignmentY(1.0f);
		panelValidate.add(btnValidate);
		btnValidate.addActionListener(Controler.getInstance());
		btnValidate.setActionCommand("ADD_TEAM_VALIDATE");
	}
	
	public JComboBox<TypesGame> getComboBox() {
		return comboBox;
	}
	
	public ContainerPlayer[] getPlayerList() {
		return playerList;
	}
	
	

}
