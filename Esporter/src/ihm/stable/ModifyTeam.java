package ihm.stable;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ModifyTeam extends JPanel {
	
	public ModifyTeam() {
		setLayout(new GridLayout(0, 1, 0, 0));
			
		JPanel panel = new JPanel();
		add(panel);
			
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
			
		JPanel panel_1 = new JPanel();
		add(panel_1);
	}

}
