 package ihm;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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
import types.Permission;
import types.exception.ErrorLogin;
import types.exception.InvalidPermission;
import utilisateur.User;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MasterFrame {

	private JFrame frame;
	public static final Color COULEUR_MASTER = new Color(0,164,210);
	public static final Color COULEUR_MASTER_FOND = new Color(96, 96, 96);
	public static final Color COULEUR_TEXTE = Color.WHITE;
	private JPanel panelMenu;
	private ButtonGroup boutonGroupMenu;
	private static MasterFrame instance;
	private User user;
	private JPanel header;
	private JPanel main;
	private ErrorPanel error;
	private LogIn loginPage;
	private JLabel nomCompte;
	private JLabel logoCompte;
	private JButton boutonConnection;

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

		frame.getContentPane().add(main,BorderLayout.CENTER, 3);
		main.setBounds(0,0,frame.getWidth(), frame.getHeight());
		
		error = new ErrorPanel();
		error.setBounds(0,0,frame.getWidth(), frame.getHeight());
		frame.getContentPane().add(error, BorderLayout.CENTER, 1);
		
		loginPage = new LogIn();
		frame.getContentPane().add(loginPage, BorderLayout.CENTER,2);
		
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
		/*Maintenant que le JLayeredPane a �t� fait on va pouvoir y superposer le main et le panel de gestion des erreurs
		 * Nous aurons ainsi le panel qui se mettra en visible quand il en aura besoin.*/

		
		
		header = new JPanel();
		header.setBackground(COULEUR_MASTER_FOND);
		main.add(header, BorderLayout.NORTH);
		header.setLayout(new BorderLayout(0, 0));
		
		

		JPanel connexion = new JPanel();
		connexion.setPreferredSize(new Dimension(250,50));
		connexion.setBackground(COULEUR_MASTER);
		header.add(connexion, BorderLayout.EAST);
		connexion.setLayout(new BorderLayout(0, 0));
		
		JPanel nomComptePanel = new JPanel();
		BorderLayout bl_nomComptePanel = new BorderLayout();
		bl_nomComptePanel.setVgap(20);
		nomComptePanel.setLayout(bl_nomComptePanel);
		nomComptePanel.setBackground(COULEUR_MASTER);
		connexion.add(nomComptePanel, BorderLayout.CENTER);
		
		nomCompte = new JLabel("compte");
		nomCompte.setHorizontalAlignment(SwingConstants.CENTER);
		nomCompte.setForeground(Color.WHITE);
		nomComptePanel.add(nomCompte, BorderLayout.SOUTH);
		
		logoCompte = new JLabel("logo");
		logoCompte.setHorizontalAlignment(SwingConstants.CENTER);
		logoCompte.setForeground(Color.WHITE);
		nomComptePanel.add(logoCompte, BorderLayout.CENTER);
		
		boutonConnection = new JButton("Se Connecter");
		
		connexion.add(boutonConnection, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(COULEUR_MASTER_FOND);
		header.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelEsporter = new JPanel();
		panelEsporter.setBackground(COULEUR_MASTER_FOND);
		panel.add(panelEsporter, BorderLayout.WEST);
		panelEsporter.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon(getClass().getResource("./images/ESporterLogo.png")));
		panelEsporter.add(logo);
		
		
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
		
		boutonConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user.getPermission()!=Permission.VISITEUR) {
					//LOGGED IN
					user.logout();
					setCompte();
					setMenu(TypeMenu.Visiteurs);
				} else {
					//NOT LOG IN
					main.setVisible(false);
					error.setVisible(false);
					loginPage.setVisible(true);
				}
			}
		});
		
		
		/*Maintenant que le JLayeredPane a �t� fait on va pouvoir y superposer le main et le panel de gestion des erreurs
		 * Nous aurons ainsi le panel qui se mettra en visible quand il en aura besoin.
		 * */
		
		
	}
	
	public ErrorPanel getError() {
		return error;
	}
	
	public JPanel getMain() {
		return main;
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
			boutonConnection.setText("Se deconnecter");
			nomCompte.setText("Arbitre");
			break;
		case ECURIE:
			boutonConnection.setText("Se deconnecter");
			EcurieInfo e = (EcurieInfo)user.getInfo();
			nomCompte.setText(e.getNom());
			//logoCompte.setIcon(e.getLogo());
			break;
		case JOUEUR:
			boutonConnection.setText("Se deconnecter");
			JoueurInfo j = (JoueurInfo)user.getInfo();
			nomCompte.setText(j.getNom());
			//logoCompte.setIcon(j.getPhoto());
			break;
		case ORGANISATEUR:
			boutonConnection.setText("Se deconnecter");
			nomCompte.setText("Esporter");
			break;
		case VISITEUR:
			boutonConnection.setText("Se connecter");
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
		error.setState(e, false);
		error.setVisible(true);
		
	}
	
	public LogIn getLoginPage() {
		return loginPage;
	}
	
	public Dimension getCenterDimension() {
		return this.frame.getContentPane().getSize();
	}


}
