package ihm.stable.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;

public class InfoEcurie extends JPanel{

	private JFrame frame;
	private JTextField NomDelEcurie;
	private JTextField txtPalmares;
	private JPanel North;
	private JPanel BtnBack;
	private JPanel BtnEcuAndInfo;
	private JPanel Vide;
	private JPanel Vide2;
	private static final long serialVersionUID = 8722294344861036522L;
	private JPanel Center;
	private JScrollPane ListPalma;
	public static final Color COULEUR_MASTER = new Color(0,164,210);
	public static final Color COULEUR_MASTER_FOND = new Color(96, 96, 96);
	public static final Color COULEUR_TEXTE = Color.WHITE;
	public static final Color COULEUR_MENU_FOND = Color.BLACK;
	/**
	 * Create the application.
	 */
	public InfoEcurie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DefaultListModel<String> model = new DefaultListModel<String>();
		setLayout(new BorderLayout(0, 0));
		
		JPanel all = new JPanel();
		all.setBackground(COULEUR_MASTER_FOND);
		add(all, BorderLayout.CENTER);
		all.setLayout(new BorderLayout(0, 0));
		
		Center = new JPanel();
		Center.setBackground(COULEUR_MASTER_FOND);
		all.add(Center, BorderLayout.CENTER);
		Center.setLayout(new BorderLayout(15, 0));
		
		JPanel Photo = new JPanel();
		Photo.setBackground(COULEUR_MASTER_FOND);
		Photo.setBorder(new EmptyBorder(0, 50, 0, 0));
		Center.add(Photo, BorderLayout.WEST);
		Photo.setLayout(new BorderLayout(0, 0));
		
		JLabel Image = new JLabel("");
		Image.setIcon(new ImageIcon(InfoEcurie.class.getResource("/ihm/images/karmine-corp.jpg")));
		Image.setHorizontalAlignment(SwingConstants.CENTER);

		Photo.add(Image);
		
		JPanel Palmares = new JPanel();
		Center.add(Palmares);
		Palmares.setLayout(new BorderLayout(0, 0));
		
		JPanel Title = new JPanel();
		Palmares.add(Title, BorderLayout.NORTH);
		Title.setLayout(new BorderLayout(0, 0));
		
		txtPalmares = new JTextField();
		txtPalmares.setBackground(COULEUR_MASTER_FOND);
		txtPalmares.setForeground(COULEUR_TEXTE);
		txtPalmares.setBorder(null);
		txtPalmares.setEditable(false);
		txtPalmares.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPalmares.setHorizontalAlignment(SwingConstants.CENTER);
		txtPalmares.setText("Palmarès");
		Title.add(txtPalmares);
		txtPalmares.setColumns(10);
		
		ListPalma = new JScrollPane();
		ListPalma.setBorder(null);
		Palmares.add(ListPalma, BorderLayout.CENTER);
		JList listPalmares = new JList<String>();
		listPalmares.setFont(new Font("Tahoma", Font.BOLD, 15));
		ListPalma.add(listPalmares);
		ListPalma.setViewportView(listPalmares);
		North = new JPanel();
		all.add(North, BorderLayout.NORTH);
		North.setLayout(new BorderLayout(0, 0));
		JPanel TitleEquipe = new JPanel();
		
		TitleEquipe.setLayout(new BorderLayout(0, 0));
		North.add(TitleEquipe, BorderLayout.SOUTH);
		NomDelEcurie = new JTextField();
		NomDelEcurie.setForeground(COULEUR_TEXTE);
		NomDelEcurie.setBackground(COULEUR_MASTER_FOND);
		NomDelEcurie.setEditable(false);
		NomDelEcurie.setBorder(null);
		NomDelEcurie.setHorizontalAlignment(SwingConstants.CENTER);
		NomDelEcurie.setFont(new Font("Tahoma", Font.PLAIN, 25));
		NomDelEcurie.setText("Karmine Corp");
		TitleEquipe.add(NomDelEcurie, BorderLayout.CENTER);
		NomDelEcurie.setColumns(10);
		
		BtnBack = new JPanel();
		North.add(BtnBack, BorderLayout.CENTER);
		BtnBack.setLayout(new BorderLayout(0, 0));
		
		BtnEcuAndInfo = new JPanel();
		BtnEcuAndInfo.setBackground(COULEUR_MASTER_FOND);
		BtnEcuAndInfo.setBorder(new EmptyBorder(0, 20, 0, 0));
		BtnBack.add(BtnEcuAndInfo, BorderLayout.WEST);
		BtnEcuAndInfo.setLayout(new BorderLayout(0, 0));
		
		Vide = new JPanel();
		Vide.setBorder(null);
		Vide.setBackground(COULEUR_MASTER_FOND);
		BtnBack.add(Vide, BorderLayout.CENTER);
		Vide.setLayout(new BorderLayout(0, 0));
		JButton Ecuries = new JButton("Ecuries /");
		Ecuries.setForeground(COULEUR_TEXTE);
		Ecuries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Ecuries.setBackground(null);
		Ecuries.setContentAreaFilled(false);
		Ecuries.setBorder(null);
		Ecuries.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BtnEcuAndInfo.add(Ecuries, BorderLayout.WEST);
		
		JButton VoirInfo = new JButton(" Voir Info");
		VoirInfo.setForeground(COULEUR_TEXTE);
		VoirInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		VoirInfo.setBackground(null);
		VoirInfo.setContentAreaFilled(false);
		VoirInfo.setBorder(null);
		VoirInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BtnEcuAndInfo.add(VoirInfo, BorderLayout.EAST);
		
		Vide2 = new JPanel();
		Vide2.setBorder(null);
		Vide2.setBackground(COULEUR_MASTER_FOND);
		FlowLayout fl_Vide2 = (FlowLayout) Vide2.getLayout();
		fl_Vide2.setVgap(10);
		BtnBack.add(Vide2, BorderLayout.NORTH);
		
		
		
	}

}
