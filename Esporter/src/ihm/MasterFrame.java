 package ihm;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;

import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;

import ihm.component.boutonMenu;
import ihm.erreur.Error;
import ihm.erreur.ErrorPanel;
import types.EcurieInfo;
import types.JoueurInfo;
import types.exception.InvalidPermission;
import utilisateur.User;

public class MasterFrame {

	private JFrame frame;
	public static final Color COULEUR_MASTER = new Color(0,164,210);
	public static final Color COULEUR_MASTER_FOND = Color.DARK_GRAY;
	public static final Color COULEUR_TEXTE = Color.WHITE;
	private JPanel panelMenu;
	private ButtonGroup boutonGroupMenu;
	private static MasterFrame instance;
	private User user;
	private JLabel nomCompte;
	private JLabel logoCompte;
	private JPanel header;
	private JPanel main;
	private ErrorPanel error;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MasterFrame window = getInstance();
					window.initialize();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	private MasterFrame() {
		try {
			this.user = new User();
			
		} catch (UnknownHostException e) {
			error(e);
		} catch (IOException e) {
			e.printStackTrace();
		}
		initialize();
		frame.pack();
		
	}
	
	public static synchronized MasterFrame getInstance() {
		if (instance==null)
			instance = new MasterFrame();
		return instance;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setMinimumSize(new Dimension(1450,700));
		frame.setPreferredSize(new Dimension(1920,1080));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane root = new JLayeredPane();
		root.setLayout(new BorderLayout());
		
		frame.setContentPane(root);
		main = new JPanel();
		main.setLayout(new BorderLayout());

		frame.getContentPane().add(main,BorderLayout.CENTER, JLayeredPane.DEFAULT_LAYER);
		main.setBounds(0,0,frame.getWidth(), frame.getHeight());
		
		error = new ErrorPanel();
		error.setBounds(0,0,frame.getWidth(), frame.getHeight());
		frame.getContentPane().add(error, BorderLayout.CENTER, 2);
		
		frame.addComponentListener(new ComponentAdapter() {
		
			@Override
			public void componentResized(ComponentEvent e) {
				main.setBounds(0,0,frame.getWidth(), frame.getHeight());
				error.setBounds(0,0,frame.getWidth(), frame.getHeight());
				error.resize();
				frame.repaint();
			}
		});
		
		frame.addWindowStateListener(new WindowAdapter() {
			@Override
			public void windowStateChanged(WindowEvent e) {
				main.setBounds(0,0,frame.getWidth(), frame.getHeight());
				error.setBounds(0,0,frame.getWidth(), frame.getHeight());
				error.resize();
				frame.repaint();
			}
		});

		frame.getContentPane().add(main, BorderLayout.CENTER);
		/*Maintenant que le JLayeredPane a ï¿½tï¿½ fait on va pouvoir y superposer le main et le panel de gestion des erreurs
		 * Nous aurons ainsi le panel qui se mettra en visible quand il en aura besoin.*/

		
		
		header = new JPanel();
		header.setBackground(COULEUR_MASTER_FOND);
		main.add(header, BorderLayout.NORTH);
		header.setLayout(new BorderLayout(0, 0));
		
		

		JPanel connexion = new JPanel();
		connexion.setPreferredSize(new Dimension(250,50));
		connexion.setBackground(COULEUR_MASTER);
		header.add(connexion, BorderLayout.EAST);
		
		nomCompte = new JLabel("compte");
		nomCompte.setHorizontalAlignment(SwingConstants.CENTER);
		nomCompte.setForeground(COULEUR_TEXTE);
		connexion.add(nomCompte);
		
		logoCompte = new JLabel("logo");
		logoCompte.setHorizontalAlignment(SwingConstants.CENTER);
		logoCompte.setForeground(COULEUR_TEXTE);
		connexion.add(logoCompte);
		
		JPanel panel = new JPanel();
		panel.setBackground(COULEUR_MASTER_FOND);
		header.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelEsporter = new JPanel();
		panelEsporter.setBackground(COULEUR_MASTER_FOND);
		panel.add(panelEsporter, BorderLayout.WEST);
		panelEsporter.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		JLabel logo = new JLabel("logo");
		logo.setForeground(COULEUR_TEXTE);
		panelEsporter.add(logo);
		
		JLabel nomComp = new JLabel("Esporter");
		nomComp.setForeground(COULEUR_TEXTE);
		panelEsporter.add(nomComp);
		
		panelMenu = new JPanel();

		panelMenu.setBackground(COULEUR_MASTER_FOND);
		FlowLayout flowLayout_1 = (FlowLayout) panelMenu.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(0);
		panel.add(panelMenu, BorderLayout.CENTER);
		
		JPanel panelDummyRight = new JPanel();
		panelDummyRight.setPreferredSize(new Dimension(35, 10));
		panelDummyRight.setBackground(COULEUR_MASTER_FOND);
		panel.add(panelDummyRight, BorderLayout.EAST);
		
		JPanel panelDummyTop = new JPanel();
		panelDummyTop.setPreferredSize(new Dimension(10, 35));
		panelDummyTop.setBackground(COULEUR_MASTER_FOND);
		panel.add(panelDummyTop, BorderLayout.NORTH);
		
		
		boutonGroupMenu = new ButtonGroup();
		TypeMenu m = TypeMenu.Visiteurs;
		boutonMenu[] menu = m.getMenu();
		for (int i=0; i<menu.length;i++) {
			panelMenu.add(menu[i]);
			boutonGroupMenu.add(menu[i]);
		}
		
		JPanel footer = new JPanel();
		main.add(footer, BorderLayout.SOUTH);
		
		setCompte();
		
		connexion.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				user.login("test", "mdpTest");
			}
		});
		
		
		/*Maintenant que le JLayeredPane a été fait on va pouvoir y superposer le main et le panel de gestion des erreurs
		 * Nous aurons ainsi le panel qui se mettra en visible quand il en aura besoin.
		 * */
		
		
	}
	
	
	
	public void setMenu(TypeMenu m) {
		panelMenu.removeAll();
		boutonGroupMenu = new ButtonGroup();
		boutonMenu[] menu = m.getMenu();
		for (int i=0; i<menu.length;i++) {
			panelMenu.add(menu[i]);
			boutonGroupMenu.add(menu[i]);
		}
		setCompte();
		frame.getContentPane().repaint();
	}
	
	public void setCompte() {
		switch(user.getPermission()) {
		case ARBITRE:
			nomCompte.setText("Arbitre");
			break;
		case ECURIE:
			EcurieInfo e = (EcurieInfo)user.getInfo();
			nomCompte.setText(e.getNom());
			//logoCompte.setIcon(e.getLogo());
			break;
		case JOUEUR:
			JoueurInfo j = (JoueurInfo)user.getInfo();
			nomCompte.setText(j.getNom());
			//logoCompte.setIcon(j.getPhoto());
			break;
		case ORGANISATEUR:
			nomCompte.setText("Esporter");
			break;
		case VISITEUR:
			nomCompte.setText("Visiteur");
			break;
		default:
			break;
		
		}
	}
	
	public void setPanel(JPanel p) {
		BorderLayout layout = (BorderLayout)main.getLayout();
		if (layout.getLayoutComponent(BorderLayout.CENTER)!=null)
			main.remove(layout.getLayoutComponent(BorderLayout.CENTER));
		main.add(p, BorderLayout.CENTER);
		main.revalidate();
		main.repaint();
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public User getUser() {
		return user;
	}
	
	public Point getCentre() {
		return new Point(frame.getLocation().x+(frame.getWidth()/2), frame.getLocation().y+(frame.getHeight()/2));
	}
	
	public void error(Exception e) {
		Error dialog = new Error(e);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
	
	public Dimension getCenterDimension() {
		return this.frame.getContentPane().getSize();
	}


}
