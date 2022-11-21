package ihm.ecurie.gestionEquipe;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class ListeEquipe extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5774382066208287732L;
	private JTextField nothing;

	/**
	 * Create the panel.
	 */
	public ListeEquipe() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane ListEquipe = new JScrollPane();
		panel.add(ListEquipe);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		
		nothing = new JTextField();
		nothing.setEditable(false);
		nothing.setText("Liste des équipes");
		nothing.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nothing.setBorder(null);
		nothing.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(nothing);
		nothing.setColumns(20);

	}

}
