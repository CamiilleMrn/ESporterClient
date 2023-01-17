package vue.error;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controleur.Controler;
import vue.MasterFrame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 972390881488216598L;
	private JFrame frame;
	private volatile Exception e;
	private JLabel texte;
	private JCircleProgressBar progressBar;
	private Thread t;
	private boolean persistent;
	private ErrorPanel instance;
	private JPanel panel_1;
	private JButton btnContinuer;
	private JPanel panel;
	private boolean critical;
	private JLabel Titre;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	
	public ErrorPanel() {
		setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		this.setVisible(false);
		initalize();
		e = null;
		this.instance = this;
		
		panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(200,200));
		add(panel_2, BorderLayout.NORTH);
		panel_2.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		
		panel_3 = new JPanel();
		add(panel_3, BorderLayout.SOUTH);
		panel_3.setPreferredSize(new Dimension(200,200));
		panel_3.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		
		panel_4 = new JPanel();
		add(panel_4, BorderLayout.WEST);
		panel_4.setPreferredSize(new Dimension(200,200));
		panel_4.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		
		panel_5 = new JPanel();
		add(panel_5, BorderLayout.EAST);
		panel_5.setPreferredSize(new Dimension(200,200));
		panel_5.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		t = new Thread(new Runnable() {
			
			

			@Override
			public void run() {
				
				while(true) {
					synchronized (instance) {
						if (e==null) {
							try {
								System.out.println("Thread error sleep");
								instance.wait();
								System.out.println("Thread error Wake up");
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						} else {
							
							if(persistent) {
								
							}
							try {
								Thread.sleep(10);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					}
				}
				
			}
		}); 
		t.start();
	}
	
	public void setException(Exception e) {
		synchronized (this) {
			this.e = e;
			if (e!=null) {
				Controler.getInstance().openError();
				System.out.println("Thread error notify");
				this.notify();
			}
		}
		
	}
	
	public void setTexte(String s) {
		texte.setText(s);
	}
	
	public void setState(Exception e, Boolean persistent, boolean critical) {
		this.persistent = persistent;
		this.critical = critical;
		if(persistent) {
			progressBar.setVisible(true);
			btnContinuer.setVisible(false);
		} else {
			progressBar.setVisible(false);
			btnContinuer.setVisible(true);
		}
		setTexte(e.getMessage());
		setException(e);
		this.revalidate();
		this.repaint();
	}
	
	private void initalize() {
		//setSize(frame.getPreferredSize());
		setPreferredSize(new Dimension(1920,1080));
		setLayout(new BorderLayout(0, 0));
		//setBounds(0, 0, frame.getWidth(), frame.getHeight());
		Color dark = MasterFrame.COLOR_MASTER_BACKGROUND.darker();
		Color c = new Color(dark.getRed(),dark.getGreen(), dark.getBlue(),150);
		setOpaque(true);
		JPanel panel = new JPanel();
		
		panel.setBorder(new EmptyBorder(PROPERTIES, ALLBITS, ABORT, HEIGHT));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel.setForeground(MasterFrame.COLOR_TEXT);
		panel.setOpaque(false);
		
		
		
		setBackground(c);
		
		Titre = new JLabel("Erreur");
		
		Titre.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		Titre.setForeground(MasterFrame.COLOR_TEXT);
		Titre.setFont(new Font("Tahoma", Font.PLAIN, 19));
		Titre.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(Titre, BorderLayout.NORTH);
		
		JPanel panelTexte = new JPanel();
		panel.add(panelTexte);
		
		progressBar = new JCircleProgressBar();
		texte = new JLabel();
		panelTexte.add(texte);
		panelTexte.add(progressBar);
		texte.setForeground(MasterFrame.COLOR_TEXT);
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		
		btnContinuer = new JButton();
		btnContinuer.addActionListener(Controler.getInstance());
		btnContinuer.addKeyListener(Controler.getInstance());
		btnContinuer.setActionCommand("ERROR_CONTINUE");
		btnContinuer.setText("Continuer");
		panel_1.add(btnContinuer);
		
		panelTexte.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panelTexte.setForeground(MasterFrame.COLOR_TEXT);
		
		panel_1.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel_1.setForeground(MasterFrame.COLOR_TEXT);
		
		
		
		
		
	}
	
	
	
	public boolean isCritical() {
		return critical;
	}

	public void resize() {
		//panelDummy1.setPreferredSize(new Dimension(getWidth(), 400));
		//panelDummy2.setPreferredSize(new Dimension(getWidth(), 400));
		//panelDummy3.setPreferredSize(new Dimension(400, getHeight()));
		//panelDummy4.setPreferredSize(new Dimension(400, getHeight()));
	}
	
	
}
