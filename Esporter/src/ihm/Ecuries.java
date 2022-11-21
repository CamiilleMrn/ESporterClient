package ihm;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Ecuries extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5774382066208287732L;
	private JTextField nothing;
	public static final Color COULEUR_MASTER = new Color(0,164,210);
	public static final Color COULEUR_MASTER_FOND = new Color(96, 96, 96);
	public static final Color COULEUR_TEXTE = Color.WHITE;
	public static final Color COULEUR_MENU_FOND = Color.BLACK;
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
		panel_1.setBackground(COULEUR_MASTER_FOND);
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		
		nothing = new JTextField();
		nothing.setBackground(COULEUR_MASTER_FOND);
		nothing.setForeground(COULEUR_TEXTE);
		nothing.setEditable(false);
		nothing.setText("Liste des équipes");
		nothing.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nothing.setBorder(null);
		nothing.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(nothing);
		nothing.setColumns(20);

	}

}
