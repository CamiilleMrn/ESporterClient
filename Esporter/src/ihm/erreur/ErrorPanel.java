package ihm.erreur;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ihm.MasterFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 972390881488216598L;
	private JFrame frame;
	private Exception e;
	private JLabel texte;
	private JCircleProgressBar progressBar;
	private JButton valider;
	private Thread t;
	private boolean persistent;
	private JPanel panelDummy1;
	private JPanel panelDummy2;
	private JPanel panelDummy3;
	private JPanel panelDummy4;
	
	public ErrorPanel() {
		this.setVisible(false);
		initalize();
		
		t = new Thread(new Runnable() {
			
			

			@Override
			public void run() {
				while(true) {
					if (e==null) {
						try {
							System.out.println("Thread error sleep");
							wait();
							System.out.println("Thread error Wake up");
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					} else {
						
						if(persistent) {
							
						}
						
					}
				}
				
			}
		}); 
	}
	
	public void setException(Exception e) {
		this.e = e;
		System.out.println("Thread error notify");
		this.t.notify();
	}
	
	public void stop() {
		e=null;
	}
	
	public void setTexte(String s) {
		texte.setText(s);
	}
	
	public void setState(Exception e, Boolean persistent) {
		this.persistent = persistent;
		if(persistent) {
			progressBar.setVisible(true);
			valider.setVisible(false);
		} else {
			progressBar.setVisible(false);
			valider.setVisible(true);
		}
		setException(e);
	}
	
	private void initalize() {
		//setSize(frame.getPreferredSize());
		setPreferredSize(new Dimension(1920,1080));
		setLayout(new BorderLayout(0, 0));
		//setBounds(0, 0, frame.getWidth(), frame.getHeight());
		Color c = new Color(0,164,210,150);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBackground(MasterFrame.COULEUR_MASTER_FOND);
		
		panelDummy1 = new JPanel();
		panelDummy1.setPreferredSize(new Dimension(1920, 400));
		add(panelDummy1, BorderLayout.NORTH);
		
		
		
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
		
		JLabel Titre = new JLabel("Erreur");
		Titre.setFont(new Font("Tahoma", Font.PLAIN, 19));
		Titre.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(Titre);
		
		JPanel panelTexte = new JPanel();
		panel.add(panelTexte);
		
		progressBar = new JCircleProgressBar();
		texte = new JLabel();
		panelTexte.add(texte);
		panelTexte.add(progressBar);
		
		valider = new JButton();
		panel.add(valider);
		ErrorPanel pan = this;
		valider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pan.setVisible(false);
				
			}
		});
		
		
		
	}
	
	public void resize() {
		panelDummy1.setPreferredSize(new Dimension(getWidth(), 400));
		panelDummy2.setPreferredSize(new Dimension(getWidth(), 400));
		panelDummy3.setPreferredSize(new Dimension(400, getHeight()));
		panelDummy4.setPreferredSize(new Dimension(400, getHeight()));
	}
	
	
}
