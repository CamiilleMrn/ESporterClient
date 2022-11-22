package ihm.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import types.Jeu;

public class ComboBoxRendererCell extends JLabel implements ListCellRenderer<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ComboBoxRendererCell() {
		setOpaque(true);
		setFont(new Font("Cambria", Font.BOLD, 12));
		setBackground(Color.BLUE);
		setForeground(Color.YELLOW);
	}
	
	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		setText(((Jeu) value).getNom());
		return this;
	}

}
