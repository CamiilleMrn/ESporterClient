package ihm.erreur;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class ErrorPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 972390881488216598L;
	private JFrame frame;
	
	public ErrorPanel(JFrame frame) {
		this.frame = frame;
		
		initalize();
	}
	
	private void initalize() {
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(frame.getContentPane().getWidth(), frame.getContentPane().getHeight()));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelDummy1 = new JPanel();
		panelDummy1.setBounds(0,0,400,400);
		add(panelDummy1, BorderLayout.NORTH);
		
		
		JPanel panelDummy2 = new JPanel();
		add(panelDummy2, BorderLayout.SOUTH);
		
		JPanel panelDummy3 = new JPanel();
		add(panelDummy3, BorderLayout.WEST);
		
		JPanel panelDummy4 = new JPanel();
		add(panelDummy4, BorderLayout.EAST);
	}
	
	
}
