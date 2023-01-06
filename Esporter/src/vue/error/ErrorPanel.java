package vue.error;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;

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
	private JPanel panelDummy1;
	private JPanel panelDummy2;
	private JPanel panelDummy3;
	private JPanel panelDummy4;
	private ErrorPanel instance;
	private JPanel panel_1;
	private JButton btnContinuer;
	private JPanel panel;
	private JLabel Titre;
	
	public ErrorPanel() {
		this.setVisible(false);
		initalize();
		e = null;
		this.instance = this;
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
	
	public void setState(Exception e, Boolean persistent) {
		this.persistent = persistent;
		if(persistent) {
			progressBar.setVisible(true);
			btnContinuer.setVisible(false);
		} else {
			progressBar.setVisible(false);
			btnContinuer.setVisible(true);
		}
		setTexte(e.getMessage());
		setException(e);
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
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBackground(MasterFrame.COLOR_MASTER_BACKGROUND);
		panel.setForeground(MasterFrame.COLOR_TEXT);
		panel.setOpaque(false);
		
		panelDummy1 = new JPanel();
		panelDummy1.setPreferredSize(new Dimension(1920, 400));
		add(panelDummy1, BorderLayout.NORTH);
		
		setBackground(c);
		
		panelDummy2 = new JPanel();
		panelDummy2.setPreferredSize(new Dimension(1920, 400));
		add(panelDummy2, BorderLayout.SOUTH);
		
		panelDummy3 = new JPanel();
		panelDummy3.setPreferredSize(new Dimension(400, 1080));
		add(panelDummy3, BorderLayout.WEST);
		
		panelDummy4 = new JPanel();
		panelDummy4.setPreferredSize(new Dimension(400, 1080));
		add(panelDummy4, BorderLayout.EAST);
		
		panelDummy1.setBackground(c);
		panelDummy2.setBackground(c);
		panelDummy3.setBackground(c);
		panelDummy4.setBackground(c);
		
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
	
	public void resize() {
		panelDummy1.setPreferredSize(new Dimension(getWidth(), 400));
		panelDummy2.setPreferredSize(new Dimension(getWidth(), 400));
		panelDummy3.setPreferredSize(new Dimension(400, getHeight()));
		panelDummy4.setPreferredSize(new Dimension(400, getHeight()));
	}
	
	
}
