package ihm.organisateur;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.UIManager;

import ihm.component.DatePicker;

import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;

public class Calendrier extends JPanel{
	private JList<String> langages;
	private JTextField TexteDate;
	private JList<String> listTournoi;

	/**
	 * Create the application.
	 */
	public Calendrier() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JScrollPane scrollPaneCenter = new JScrollPane();
		add(scrollPaneCenter, BorderLayout.CENTER);
		DefaultListModel<String> model = new DefaultListModel<String>();
		listTournoi = new JList<String>();
		listTournoi.setModel(model);
		scrollPaneCenter.add(listTournoi);
		listTournoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPaneCenter.setViewportView(listTournoi);
		

		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 3, 200, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		TexteDate = new JTextField();
		TexteDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(TexteDate, BorderLayout.CENTER);
		TexteDate.setColumns(10);
		
		JButton TroisPoint = new JButton("...");
		TroisPoint.addActionListener(new ActionListener() {
				//performed action
				public void actionPerformed(ActionEvent arg0) 
				{
					//create frame new object  f
					final JFrame f = new JFrame();
					//set text which is collected by date picker i.e. set date 
					TexteDate.setText(new DatePicker(f).setPickedDate());
				}
			});
		panel_2.add(TroisPoint, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JComboBox FiltrerLesJeux = new JComboBox();
		FiltrerLesJeux.setFont(new Font("Tahoma", Font.PLAIN, 15));
		FiltrerLesJeux.setModel(new DefaultComboBoxModel(new String[] {"Rocket League", "League Of Legends", "Dota 2", "Overwatch 2", "Brawlala", "Super Smash Bros"}));
		
		panel_3.add(FiltrerLesJeux);
	
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);

		
		JButton CreerUnTournoi = new JButton("Creer un tournois");
		CreerUnTournoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		CreerUnTournoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		
		panel_4.add(CreerUnTournoi);
		
	}

}

