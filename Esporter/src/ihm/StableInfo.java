package ihm;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;

import ihm.component.DataJPanel;
import ihm.component.RendererStableInfo;
import ihm.component.RendererStableTitle;
import types.TypesStable;
import types.TypesTeam;
import types.TypesTitle;

import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Container;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.Box;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;

public class StableInfo extends DataJPanel{

	private JLabel lblStableName;
	private JPanel panelNorth;
	private JPanel panelBtnBack;
	private JPanel panelBtnStables;
	private JPanel panelDummyTop;
	private JPanel panelDummyRight;
	private static final long serialVersionUID = 8722294344861036522L;
	private JPanel panelCenter;
	private TypesStable stable;
	private JPanel panelInfo;
	private JPanel panelTitles;
	private JPanel panelAllTitles;
	private JPanel panAllTeams;
	private JLabel lblTitle;
	private JLabel lblImageStable;
	private JPanel panelSeparator;
	private JPanel panelTeamInfo;
	private JLabel lblNoTitle = new JLabel();
	private JLabel lblNoTeam = new JLabel();
	private JPanel panelTeamTitle;
	private JPanel panelTeam;
	private JLabel lblTeamTitle;
	
	public void createListTitle() {
		ArrayList<TypesTitle> liste = stable.getTitles();
		if(liste.isEmpty() || liste == null ) {
			lblNoTitle.setText("Cette écurie n'a pas encore obtenu de titre");
			lblNoTitle.setForeground(MasterFrame.COULEUR_TEXTE);
			lblNoTitle.setFont(new Font("Cambria", Font.PLAIN , 20));
			panelAllTitles.add(lblNoTitle);
		}else {
	        for(TypesTitle t : liste) {
				panelAllTitles.add(new RendererStableTitle(t));
			}
		}
	}
	
	private void createListTeam() {
		HashMap<Integer,TypesTeam> liste = stable.getTeams();
		if(liste.isEmpty()) {
			lblNoTeam.setText("Cette écurie n'a pas d'équipe");
			lblNoTeam.setForeground(MasterFrame.COULEUR_TEXTE);
			lblNoTeam.setFont(new Font("Cambria", Font.PLAIN , 20));
			panAllTeams.add(lblNoTeam);
		}else {
			for(HashMap.Entry<Integer, TypesTeam> set : liste.entrySet()) {
				if(set.getValue().getStable() == stable) {
					panAllTeams.add(new RendererStableInfo(set.getValue()));
				}
			}
		}
	}
	
	/**
	 * Create the application.
	 */
	public StableInfo(TypesStable stable) {
		this.stable = stable;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelAll = new JPanel();
		panelAll.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		add(panelAll, BorderLayout.CENTER);
		panelAll.setLayout(new BorderLayout(0, 0));
		
		panelCenter = new JPanel();
		panelCenter.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelAll.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		
		panelSeparator = new JPanel();
		panelSeparator.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelCenter.add(panelSeparator);
		
		panelInfo = new JPanel();
		panelInfo.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelCenter.add(panelInfo);
		panelInfo.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblImageStable = new JLabel();
		lblImageStable.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblImageStable.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		lblImageStable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		panelInfo.add(lblImageStable);
		
		

		//File file = new File("images/ESporterLogo.png");
		BufferedImage logoEcurie = stable.getLogo().getImage();
		logoEcurie = resize(logoEcurie, 400, 300);
		lblImageStable.setIcon(new ImageIcon(logoEcurie));
		
		
		panelTitles = new JPanel();
		panelTitles.setBorder(null);
		panelTitles.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelTitles.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelInfo.add(panelTitles);
		panelTitles.setLayout(new GridLayout(0, 1, 0, -30));
		
		
		lblTitle = new JLabel("Palmarès");
		lblTitle.setForeground(MasterFrame.COULEUR_TEXTE);
		lblTitle.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setAlignmentX(0.5f);
		panelTitles.add(lblTitle);
		
		panelAllTitles = new JPanel();
		panelAllTitles.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		createListTitle();
		JScrollPane scrollPaneTitles = new JScrollPane(panelAllTitles);
		scrollPaneTitles.setAlignmentY(Component.TOP_ALIGNMENT);
		scrollPaneTitles.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		scrollPaneTitles.setBorder(new EmptyBorder(50, 100, 50, 100));
		panelTitles.add(scrollPaneTitles);
		
		panelTeamInfo = new JPanel();
		panelTeamInfo.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelCenter.add(panelTeamInfo);
		panelTeamInfo.setLayout(new BoxLayout(panelTeamInfo, BoxLayout.Y_AXIS));
		
		panelTeamTitle = new JPanel();
		panelTeamTitle.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelTeamInfo.add(panelTeamTitle);
		
		lblTeamTitle = new JLabel("Equipes");
		lblTeamTitle.setForeground(MasterFrame.COULEUR_TEXTE);
		lblTeamTitle.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 30));
		panelTeamTitle.add(lblTeamTitle);
		
		panelTeam = new JPanel();
		panelTeam.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelTeamInfo.add(panelTeam);
		
		panAllTeams = new JPanel();
		panAllTeams.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		createListTeam();
		JScrollPane scrollPaneTeam = new JScrollPane(panAllTeams);
		scrollPaneTeam.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		scrollPaneTeam.setBorder(new EmptyBorder(50, 100, 50, 100));
		panelTeam.add(scrollPaneTeam, BorderLayout.CENTER);
		
		
		
		panelNorth = new JPanel();
		panelAll.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new BorderLayout(0, 0));
		JPanel panelTitleEquipe = new JPanel();
		
		panelTitleEquipe.setLayout(new BorderLayout(0, 0));
		panelNorth.add(panelTitleEquipe, BorderLayout.SOUTH);
		lblStableName = new JLabel(stable.getName()+"  ("+stable.getNickname()+")");
		lblStableName.setForeground(MasterFrame.COULEUR_TEXTE);
		lblStableName.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		lblStableName.setBorder(null);
		lblStableName.setHorizontalAlignment(SwingConstants.CENTER);
		lblStableName.setFont(new Font("Cambria", Font.BOLD, 50));
		panelTitleEquipe.add(lblStableName, BorderLayout.CENTER);
		
		panelBtnBack = new JPanel();
		panelNorth.add(panelBtnBack, BorderLayout.CENTER);
		panelBtnBack.setLayout(new BorderLayout(0, 0));
		
		panelBtnStables = new JPanel();
		panelBtnStables.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelBtnStables.setBorder(new EmptyBorder(0, 20, 0, 0));
		panelBtnBack.add(panelBtnStables, BorderLayout.WEST);
		panelBtnStables.setLayout(new BorderLayout(0, 0));
		
		panelDummyTop = new JPanel();
		panelDummyTop.setBorder(null);
		panelDummyTop.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panelBtnBack.add(panelDummyTop, BorderLayout.CENTER);
		panelDummyTop.setLayout(new BorderLayout(0, 0));
		JButton btnStable = new JButton("Ecuries /");
		btnStable.setForeground(MasterFrame.COULEUR_MASTER);
		btnStable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MasterFrame.getInstance().setPanel(ihm.Stables.class, stable);
			}
		});
		btnStable.setBackground(null);
		btnStable.setContentAreaFilled(false);
		btnStable.setBorder(null);
		btnStable.setFont(new Font("Cambria", Font.PLAIN, 20));
		panelBtnStables.add(btnStable, BorderLayout.WEST);
		
		JButton btnInfo = new JButton(" Voir Info");
		btnInfo.setForeground(MasterFrame.COULEUR_TEXTE);
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInfo.setBackground(null);
		btnInfo.setContentAreaFilled(false);
		btnInfo.setBorder(null);
		btnInfo.setFont(new Font("Cambria", Font.PLAIN, 20));
		panelBtnStables.add(btnInfo, BorderLayout.EAST);
		
		panelDummyRight = new JPanel();
		panelDummyRight.setBorder(null);
		panelDummyRight.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		FlowLayout fl_panelDummyRight = (FlowLayout) panelDummyRight.getLayout();
		fl_panelDummyRight.setVgap(10);
		panelBtnBack.add(panelDummyRight, BorderLayout.NORTH);
				
	}

	@Override
	public void dataUpdate() {
		createListTitle();
		
	}
	
	public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}

}
