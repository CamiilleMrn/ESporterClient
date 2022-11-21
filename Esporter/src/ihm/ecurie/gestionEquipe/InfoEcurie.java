package ihm.ecurie.gestionEquipe;

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
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JScrollPane;

public class InfoEcurie extends JPanel{

	private JFrame frame;
	private JTextField NomDelEcurie;
	private JTextField txtPalmares;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private static final long serialVersionUID = 8722294344861036522L;
	private JPanel panel;
	private JScrollPane scrollPane;

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
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel_2.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(15, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(0, 50, 0, 0));
		panel.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel PhotoKarmine = new JLabel("");
		PhotoKarmine.setIcon(new ImageIcon(InfoEcurie.class.getResource("/ihm/images/karmine-corp.jpg")));
		PhotoKarmine.setHorizontalAlignment(SwingConstants.CENTER);

		panel_4.add(PhotoKarmine);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		txtPalmares = new JTextField();
		txtPalmares.setBorder(null);
		txtPalmares.setEditable(false);
		txtPalmares.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPalmares.setHorizontalAlignment(SwingConstants.CENTER);
		txtPalmares.setText("Palmarès");
		panel_6.add(txtPalmares);
		txtPalmares.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		panel_5.add(scrollPane, BorderLayout.CENTER);
		
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
		panel_10.setBorder(new EmptyBorder(0, 20, 0, 0));
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
