package ihm;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

import ihm.component.EcurieRenderer;
import types.EcurieInfo;
import types.TournoiInfo;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class Ecuries extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5774382066208287732L;
	private JTextField nothing;
	
	private JPanel createEcurieInfo() {
		HashMap<Integer, EcurieInfo> map = MasterFrame.getInstance().getUser().getData().getEcuries();
        
        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(0, 1));
        
        Iterator<EcurieInfo> ite = map.values().iterator();
		while (ite.hasNext()) {
			
			EcurieInfo t = ite.next();
			System.out.println(t);
			pan.add(new EcurieRenderer(t));
		}
		
        return pan;
       
	}
	
	/**
	 * Create the panel.
	 */
	public Ecuries() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane ListEquipe = new JScrollPane();
		panel.add(ListEquipe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		
		nothing = new JTextField();
		nothing.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		nothing.setForeground(MasterFrame.COULEUR_TEXTE);
		nothing.setEditable(false);
		nothing.setText("Liste des écuries");
		nothing.setFont(new Font("Cambria", Font.PLAIN, 20));
		nothing.setBorder(null);
		nothing.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(nothing);
		nothing.setColumns(20);
		
		JScrollPane scrollPaneCenter = new JScrollPane(createEcurieInfo());
		scrollPaneCenter.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		scrollPaneCenter.setBorder(new EmptyBorder(50, 100, 50, 100));
		panel.add(scrollPaneCenter, BorderLayout.CENTER);

	}

}
