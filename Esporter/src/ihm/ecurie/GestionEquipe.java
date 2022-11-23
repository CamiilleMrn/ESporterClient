package ihm.ecurie;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.plaf.ComboBoxUI;

import ihm.MasterFrame;
import ihm.component.ComboBoxRendererArrow;
import ihm.component.ComboBoxRendererCell;
import ihm.component.ComboBoxRendererEditor;
import ihm.ecurie.gestionEquipe.AjouterEquipe;
import types.Jeu;

import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GestionEquipe extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2160024974466737852L;
	private JList<String> listTournoi;
	private JTextField txtGestionDesquipes;
	
	/**
	 * Create the application.
	 */
	public GestionEquipe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DefaultListModel<String> model = new DefaultListModel<String>();
		setLayout(new BorderLayout(0, 0));
		

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel.add(panel_1);
		panel_2.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 3, 200, 0));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JComboBox<Jeu> comboBox = new JComboBox<>(Jeu.values());
		comboBox.setUI((ComboBoxUI) ComboBoxRendererArrow.createUI(comboBox));
		
		panel_3.add(comboBox);
	
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel.add(panel_4);

		
		JButton AjouterUneEquipe = new JButton("Ajouter une \u00E9quipe");
		AjouterUneEquipe.setBackground(MasterFrame.COULEUR_MASTER);
		AjouterUneEquipe.setForeground(MasterFrame.COULEUR_TEXTE);

		AjouterUneEquipe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		AjouterUneEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MasterFrame.getInstance().setPanel(AjouterEquipe.class, (Jeu)comboBox.getSelectedItem());
				MasterFrame.getInstance().getMain().setVisible(true);
			}
		});

		
		panel_4.add(AjouterUneEquipe);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.CENTER);
		panel_5.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		txtGestionDesquipes = new JTextField();
		txtGestionDesquipes.setBorder(null);
		txtGestionDesquipes.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		txtGestionDesquipes.setForeground(MasterFrame.COULEUR_TEXTE);
		txtGestionDesquipes.setEditable(false);
		txtGestionDesquipes.setHorizontalAlignment(SwingConstants.CENTER);
		txtGestionDesquipes.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtGestionDesquipes.setText("GESTION DES ÉQUIPES");
		panel_5.add(txtGestionDesquipes);
		txtGestionDesquipes.setColumns(15);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_6.getLayout();
		flowLayout.setVgap(15);
		panel_6.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		panel_6.setBorder(null);
		panel_2.add(panel_6, BorderLayout.NORTH);
		

		JScrollPane scrollPaneCenter = new JScrollPane();
		add(scrollPaneCenter);
		listTournoi = new JList<String>();
		listTournoi.setModel(model);
		scrollPaneCenter.add(listTournoi);
		listTournoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPaneCenter.setViewportView(listTournoi);
		
		
		
	}

}

