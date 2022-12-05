package ihm.component;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;

import ihm.MasterFrame;
import types.Permission;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;

public class boutonMenu extends JRadioButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8366959265584745626L;
	private Class panelToChange;
	private boolean mouseIn;
	private int mouseX;
	private boolean exited;
	private float alphaFadeOut;
	private Graphics2D g2;
	private Timer timer = null;
	private Permission permission;
	
	public boutonMenu(boolean selected,String texte, Class panelToChange, Permission permission) {
		super(texte, new ImageIcon());
		

		mouseIn=false;
		exited=false;
		alphaFadeOut=1.0f;
		this.permission = permission;
		setSelected(selected);
		setFocusPainted(false);
		setText(texte);
		setHorizontalAlignment(CENTER);
		setOpaque(true);
		setBackground(new Color(0,0,0,0));
		
		setPreferredSize(new Dimension(150,75));
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				setSelected(true);
					
				MasterFrame.getInstance().setPanel(panelToChange, permission);
				MasterFrame.getInstance().getFrame().repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				mouseIn=false;
				exited=true;
				if (timer!=null) {
					timer.stop();
				}
				timer = new Timer(10, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						repaint();
						
					}
				});
				timer.start();
			}
		});
		
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				if (!isSelected()) {
					if (!mouseIn) 
						mouseIn = true;
					mouseX = e.getX();
					repaint();
				}				
			}

			@Override
			public void mouseDragged(MouseEvent e) {}
			
		});
		
	}
	
	public Permission getPermission() {
		return permission;
	}
	
	public Class getPanelToChange() {
		return panelToChange;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if (!MasterFrame.getInstance().getLoginPage().isVisible() || !MasterFrame.getInstance().getError().isVisible()) {
			g2 = (Graphics2D)g.create();
			int width = getBounds().width;
			int height = getBounds().height;
			
			setForeground(MasterFrame.COULEUR_TEXTE);
			if (isSelected()) {	
				g2.setClip(0, 0, width, height+16);
				g2.setColor(MasterFrame.COULEUR_MASTER);
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
				
				g2.setClip(0, 0, width, height);
				g2.setColor(MasterFrame.COULEUR_MENU_FOND);
				Polygon p = new Polygon();
				p.addPoint(0, 0);
				p.addPoint(0, height-1);
				p.addPoint(width, height-1);
				p.addPoint(width, 0);
				g2.drawPolygon(p);
				g2.fillPolygon(p);
	
			}
			g2.dispose();
			
			if (mouseIn && !isSelected()) {
				g2 = (Graphics2D)g.create();
				//int brightness = (255 - (Math.abs(width/2-mouseX)*3));
				g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
				GradientPaint gp = new GradientPaint(0, height, new Color(0,164,210,100), 0, height/4, MasterFrame.COULEUR_MENU_FOND);
				g2.setPaint(gp);
				g2.fillRect(0, height/4, width, height*3/4);
				
				
				/*int centerPoint = mouseX;
				float radius = width/5;
				float[] dist = {0f,1f};	
				Color[] color = {new Color(0,164,210,brightness), new Color(0,0,0,0) };
				RadialGradientPaint rgp = new RadialGradientPaint(new Point(mouseX, height), radius, dist, color);	
				g2.setPaint(rgp);
				g2.fill(new Ellipse2D.Double(centerPoint - radius, height - radius, radius * 2, radius * 2));*/
				//GradientPaint gp2 = new GradientPaint(0, height, new Color(0,164,210,100), 0, height/4, MasterFrame.COULEUR_MASTER_FOND);
				//g2.setPaint(gp2);
				/*float[] dist2 = {0.75f,1f};	
				Color[] color2 = {new Color(0,164,210,brightness+55), new Color(0,0,0,0) };
				RadialGradientPaint rgp2 = new RadialGradientPaint(new Point(mouseX, height), radius, dist2, color2);	
				g2.setPaint(rgp2);
				g2.fillRect(mouseX-(int)radius, height-5, (int)radius*2, 5);*/
	
			}
			
			
			if(exited && !isSelected()) {
				if(alphaFadeOut>0 && !mouseIn) {
					g2 = (Graphics2D)g.create();
	
					g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
					GradientPaint gp = new GradientPaint(0, height, new Color(0,164,210,(int)(100*alphaFadeOut)), 0, height/4, MasterFrame.COULEUR_MENU_FOND);
					g2.setPaint(gp);
					
					g2.fillRect(0, height/4, width, height*3/4);
					alphaFadeOut-=0.07f;
				} else {
					g2.dispose();
					alphaFadeOut=1.0f;
					exited=false;
					timer.stop();
				}
	
			}
			if(mouseIn && !exited && !isSelected())
				g2.dispose();
			
			super.paintComponent(g);
		}
	}
	
}
