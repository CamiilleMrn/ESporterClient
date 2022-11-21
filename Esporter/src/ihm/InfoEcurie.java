package ihm;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;

import ihm.component.InfoEcuriePalmaRenderer;
import types.EcurieInfo;
import types.Titre;

import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.Box;

public class InfoEcurie extends JPanel{

	private JTextField NomDelEcurie;
	private JPanel North;
	private JPanel BtnBack;
	private JPanel BtnEcuAndInfo;
	private JPanel Vide;
	private JPanel Vide2;
	private static final long serialVersionUID = 8722294344861036522L;
	private JPanel Center;
	private EcurieInfo ecurie;
	private JTextField textField;
	
	public JPanel createListPalma() {
		ArrayList<Titre> liste = ecurie.getPalmares();
		
		JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(0, 1));
        
        for(Titre t : liste) {
			System.out.println(t);
			pan.add(new InfoEcuriePalmaRenderer(t));
		}
		return pan;
	}
	
	/**
	 * Create the application.
	 */
	public InfoEcurie(EcurieInfo ecurie) {
		this.ecurie = ecurie;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel all = new JPanel();
		all.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		add(all, BorderLayout.CENTER);
		all.setLayout(new BorderLayout(0, 0));
		
		Center = new JPanel();
		Center.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		all.add(Center, BorderLayout.CENTER);
		Center.setLayout(new BorderLayout(15, 0));
		
		JPanel Photo = new JPanel();
		Photo.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		Photo.setBorder(new EmptyBorder(0, 50, 0, 0));
		Center.add(Photo, BorderLayout.WEST);
		Photo.setLayout(new BorderLayout(0, 0));
		
		JLabel Image = new JLabel("");
		Image.setIcon(new ImageIcon(InfoEcurie.class.getResource("/ihm/images/karmine-corp.jpg")));
		Image.setHorizontalAlignment(SwingConstants.CENTER);

		Photo.add(Image);
		
		JPanel Palmares = new JPanel();
		Center.add(Palmares);
		Palmares.setLayout(new BoxLayout(Palmares, BoxLayout.Y_AXIS));
		
		JPanel Title = new JPanel();
		Title.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		Palmares.add(Title);
		Title.setLayout(new GridLayout(0, 1, 0, 0));
		
		textField = new JTextField();
		textField.setAlignmentX(Component.RIGHT_ALIGNMENT);
		textField.setAlignmentY(Component.TOP_ALIGNMENT);
		textField.setText("Palmarès");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Cambria", Font.PLAIN, 25));
		textField.setEditable(false);
		textField.setBorder(null);
		textField.setBackground(new Color(96, 96, 96));
		Title.add(textField);
		
		JScrollPane scrollPaneCenter = new JScrollPane((Component) null);
		scrollPaneCenter.setBorder(new EmptyBorder(50, 100, 50, 100));
		scrollPaneCenter.setBackground(new Color(96, 96, 96));
		Palmares.add(scrollPaneCenter);
		
		North = new JPanel();
		all.add(North, BorderLayout.NORTH);
		North.setLayout(new BorderLayout(0, 0));
		JPanel TitleEquipe = new JPanel();
		
		TitleEquipe.setLayout(new BorderLayout(0, 0));
		North.add(TitleEquipe, BorderLayout.SOUTH);
		NomDelEcurie = new JTextField();
		NomDelEcurie.setForeground(MasterFrame.COULEUR_TEXTE);
		NomDelEcurie.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		NomDelEcurie.setEditable(false);
		NomDelEcurie.setBorder(null);
		NomDelEcurie.setHorizontalAlignment(SwingConstants.CENTER);
		NomDelEcurie.setFont(new Font("Cambria", Font.PLAIN, 25));
		NomDelEcurie.setText(ecurie.getNom());
		TitleEquipe.add(NomDelEcurie, BorderLayout.CENTER);
		NomDelEcurie.setColumns(10);
		
		BtnBack = new JPanel();
		North.add(BtnBack, BorderLayout.CENTER);
		BtnBack.setLayout(new BorderLayout(0, 0));
		
		BtnEcuAndInfo = new JPanel();
		BtnEcuAndInfo.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		BtnEcuAndInfo.setBorder(new EmptyBorder(0, 20, 0, 0));
		BtnBack.add(BtnEcuAndInfo, BorderLayout.WEST);
		BtnEcuAndInfo.setLayout(new BorderLayout(0, 0));
		
		Vide = new JPanel();
		Vide.setBorder(null);
		Vide.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		BtnBack.add(Vide, BorderLayout.CENTER);
		Vide.setLayout(new BorderLayout(0, 0));
		JButton Ecuries = new JButton("Ecuries /");
		Ecuries.setForeground(MasterFrame.COULEUR_TEXTE);
		Ecuries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Ecuries.setBackground(null);
		Ecuries.setContentAreaFilled(false);
		Ecuries.setBorder(null);
		Ecuries.setFont(new Font("Cambria", Font.PLAIN, 20));
		BtnEcuAndInfo.add(Ecuries, BorderLayout.WEST);
		
		JButton VoirInfo = new JButton(" Voir Info");
		VoirInfo.setForeground(MasterFrame.COULEUR_TEXTE);
		VoirInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		VoirInfo.setBackground(null);
		VoirInfo.setContentAreaFilled(false);
		VoirInfo.setBorder(null);
		VoirInfo.setFont(new Font("Cambria", Font.PLAIN, 20));
		BtnEcuAndInfo.add(VoirInfo, BorderLayout.EAST);
		
		Vide2 = new JPanel();
		Vide2.setBorder(null);
		Vide2.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		FlowLayout fl_Vide2 = (FlowLayout) Vide2.getLayout();
		fl_Vide2.setVgap(10);
		BtnBack.add(Vide2, BorderLayout.NORTH);
				
	}

}
