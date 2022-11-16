package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

public class Ecuries extends JPanel{

	private JFrame frame;
	private JTextField NomDelEcurie;
	private JTextField txtPalmares;
	private JTextField Titre1;
	private JTextField DateTitre1;
	private JTextField Titre2;
	private JTextField DateTitre2;
	private JTextField Titre3;
	private JTextField DateTitre3;
	private JLabel label_1;
	private JLabel label_3;
	private JLabel label_5;
	private JLabel label_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private static final long serialVersionUID = 8722294344861036522L;

	/**
	 * Create the application.
	 */
	public Ecuries() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DefaultListModel<String> model = new DefaultListModel<String>();
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel PhotoKarmine = new JLabel("");
		PhotoKarmine.setIcon(new ImageIcon(Ecuries.class.getResource("/ihm/images/karmine-corp.jpg")));
		PhotoKarmine.setHorizontalAlignment(SwingConstants.CENTER);

		panel_4.add(PhotoKarmine);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		txtPalmares = new JTextField();
		txtPalmares.setBorder(null);
		txtPalmares.setEditable(false);
		txtPalmares.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPalmares.setHorizontalAlignment(SwingConstants.CENTER);
		txtPalmares.setText("Palmarès");
		panel_6.add(txtPalmares);
		txtPalmares.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new GridLayout(0, 2, 0, -30));
		
		Titre1 = new JTextField();
		Titre1.setBorder(null);
		Titre1.setEditable(false);
		Titre1.setHorizontalAlignment(SwingConstants.CENTER);
		Titre1.setText(" European Master Champion LOL");
		Titre1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_7.add(Titre1);
		Titre1.setColumns(10);
		
		DateTitre1 = new JTextField();
		DateTitre1.setBorder(null);
		DateTitre1.setEditable(false);
		DateTitre1.setHorizontalAlignment(SwingConstants.CENTER);
		DateTitre1.setText("2021 / 2022");
		DateTitre1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_7.add(DateTitre1);
		DateTitre1.setColumns(10);
		
		label_1 = new JLabel("");
		panel_7.add(label_1);
		
		label_3 = new JLabel("");
		panel_7.add(label_3);
		
		Titre2 = new JTextField();
		Titre2.setHorizontalAlignment(SwingConstants.CENTER);
		Titre2.setBorder(null);
		Titre2.setText("RLCS Regional EU Champion RL");
		Titre2.setEditable(false);
		Titre2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_7.add(Titre2);
		Titre2.setColumns(10);
		
		DateTitre2 = new JTextField();
		DateTitre2.setBorder(null);
		DateTitre2.setEditable(false);
		DateTitre2.setHorizontalAlignment(SwingConstants.CENTER);
		DateTitre2.setText("2022");
		DateTitre2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_7.add(DateTitre2);
		DateTitre2.setColumns(10);
		
		label_5 = new JLabel("");
		panel_7.add(label_5);
		
		label_7 = new JLabel("");
		panel_7.add(label_7);
		
		Titre3 = new JTextField();
		Titre3.setHorizontalAlignment(SwingConstants.CENTER);
		Titre3.setBorder(null);
		Titre3.setEditable(false);
		Titre3.setText("HexLeague Champion Split 2 ");
		Titre3.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_7.add(Titre3);
		Titre3.setColumns(10);
		
		DateTitre3 = new JTextField();
		DateTitre3.setBorder(null);
		DateTitre3.setEditable(false);
		DateTitre3.setHorizontalAlignment(SwingConstants.CENTER);
		DateTitre3.setText("2022");
		DateTitre3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_7.add(DateTitre3);
		DateTitre3.setColumns(10);
		
		panel_8 = new JPanel();
		panel_2.add(panel_8, BorderLayout.NORTH);
		panel_8.setLayout(new BorderLayout(0, 0));
		JPanel panel_3 = new JPanel();
		
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_8.add(panel_3, BorderLayout.SOUTH);
		NomDelEcurie = new JTextField();
		NomDelEcurie.setEditable(false);
		NomDelEcurie.setBorder(null);
		NomDelEcurie.setHorizontalAlignment(SwingConstants.CENTER);
		NomDelEcurie.setFont(new Font("Tahoma", Font.PLAIN, 25));
		NomDelEcurie.setText("Karmine Corp");
		panel_3.add(NomDelEcurie, BorderLayout.CENTER);
		NomDelEcurie.setColumns(10);
		
		panel_9 = new JPanel();
		panel_8.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		panel_10 = new JPanel();
		panel_9.add(panel_10, BorderLayout.WEST);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		panel_11 = new JPanel();
		panel_9.add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(new BorderLayout(0, 0));
		JButton Ecuries = new JButton("Ecuries /");
		Ecuries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Ecuries.setBackground(null);
		Ecuries.setContentAreaFilled(false);
		Ecuries.setBorder(null);
		Ecuries.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_10.add(Ecuries, BorderLayout.WEST);
		
		JButton VoirInfo = new JButton(" Voir Info");
		VoirInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		VoirInfo.setBackground(null);
		VoirInfo.setContentAreaFilled(false);
		VoirInfo.setBorder(null);
		VoirInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_10.add(VoirInfo, BorderLayout.EAST);
		
		panel_12 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_12.getLayout();
		flowLayout.setVgap(10);
		panel_9.add(panel_12, BorderLayout.NORTH);
	}

}
