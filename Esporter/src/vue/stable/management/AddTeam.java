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


public class AddTeam extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5531842744073477854L;
	private TypesGame game;
	private ContainerPlayer[] playerList;
	private JComboBox<TypesGame>  comboBox;
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
		JPanel panelMain = new JPanel();
		panelMain.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		add(panelMain, BorderLayout.CENTER);
		GridBagLayout gbl_panelMain = new GridBagLayout();
		int side = (int) (frame.getWidth()*0.15);
		int center = (int) (frame.getWidth()*0.7);
		

		gbl_panelMain.columnWidths = new int[] {side+1, center, side};
		gbl_panelMain.rowHeights = new int[] {(int) (frame.getHeight()*0.06), (int) (frame.getHeight()*0.22), (int) (frame.getHeight()*0.28), (int) (frame.getHeight()*0.3), (int) (frame.getHeight()*0.14)};
		gbl_panelMain.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panelMain.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelMain.setLayout(gbl_panelMain);
		
		JLabel lblTitle = new JLabel("Ajouter une \u00E9quipe");
		lblTitle.setFont(new Font("Cambria", Font.PLAIN, 27));
		lblTitle.setForeground(MasterFrame.COLOR_TEXT);
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.SOUTH;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 0;
		panelMain.add(lblTitle, gbc_lblTitle);
		
		JPanel lblGame = new JPanel();
		lblGame.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		GridBagConstraints gbc_lblGame = new GridBagConstraints();
		gbc_lblGame.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblGame.insets = new Insets(0, 0, 5, 5);
		gbc_lblGame.gridx = 1;
		gbc_lblGame.gridy = 1;
		panelMain.add(lblGame, gbc_lblGame);
		
		comboBox = new JComboBox<>(TypesGame.values());
	
		comboBox.setUI((ComboBoxUI) ComboBoxRendererArrow.createUI(comboBox));
		comboBox.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		comboBox.setFont(new Font("Cambria", Font.PLAIN, 15));
		comboBox.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		comboBox.setForeground(MasterFrame.COLOR_TEXT);
		comboBox.setSelectedItem(game);
		lblGame.add(comboBox);
		comboBox.setActionCommand("ADD_TEAM_COMBOGAME");
		comboBox.addActionListener(Controler.getInstance());
		
		
		JPanel panelPlayer = new JPanel();
		panelPlayer.setBorder(null);
		panelPlayer.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		GridBagConstraints gbc_panelPlayer = new GridBagConstraints();
		gbc_panelPlayer.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelPlayer.insets = new Insets(0, 0, 5, 5);
		gbc_panelPlayer.gridx = 1;
		gbc_panelPlayer.gridy = 2;
		panelMain.add(panelPlayer, gbc_panelPlayer);
		
		int teamSize = game.getMaxPlayer();
		playerList = new ContainerPlayer[teamSize];
		for (int i=0; i<teamSize; i++) {
			playerList[i] = new ContainerPlayer();
			panelPlayer.add(playerList[i]);
		}
		
		JPanel panelValidate = new JPanel();
		panelValidate.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		GridBagConstraints gbc_panelValidate = new GridBagConstraints();
		gbc_panelValidate.insets = new Insets(0, 0, 0, 5);
		gbc_panelValidate.anchor = GridBagConstraints.NORTHEAST;
		gbc_panelValidate.gridx = 1;
		gbc_panelValidate.gridy = 3;
		panelMain.add(panelValidate, gbc_panelValidate);
		
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
