package ihm.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import ihm.MasterFrame;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class boutonMenu extends JRadioButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8366959265584745626L;
	private JPanel panelToChange;
	
	public boutonMenu(boolean selected,String texte, JPanel panelToChange) {
		super(texte, new ImageIcon());
		setSelected(selected);
		setFocusPainted(false);
		setText(texte);
		setHorizontalAlignment(CENTER);
		
		setPreferredSize(new Dimension(150,75));
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (!isSelected()) {
					setSelected(true);
					
					MasterFrame.getInstance().setPanel(panelToChange);
					MasterFrame.getInstance().getFrame().repaint();
				}
			}
		});
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics g2 = g.create();
		int width = getBounds().width;
		int height = getBounds().height;
		g2.setClip(0, 0, width, height+16);
		setForeground(MasterFrame.COULEUR_TEXTE);
		if (isSelected()) {		
			setBackground(MasterFrame.COULEUR_MASTER);
			g2.setColor(getBackground());

			Polygon p = new Polygon();
			p.addPoint(0, 0);
			p.addPoint(0, height-1);
			p.addPoint((width/2)-20, height-1);
			p.addPoint((width/2), height+15);
			p.addPoint((width/2)+20, height-1);
			p.addPoint(width, height-1);
			p.addPoint(width, 0);
			
			g2.drawPolygon(p);
			g2.fillPolygon(p);
			
		    
		} else {
			setBackground(MasterFrame.COULEUR_MASTER_FOND);
			g2.setColor(getBackground());

			Polygon p = new Polygon();
			p.addPoint(0, 0);
			p.addPoint(0, height-1);
			p.addPoint(width, height-1);
			p.addPoint(width, 0);
			g2.drawPolygon(p);
			g2.fillPolygon(p);
		}
		g2.dispose();
		super.paintComponent(g);
		
	}
	
	

}
