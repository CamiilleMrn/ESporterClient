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
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.UnknownHostException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.SwingConstants;

import ihm.component.DataJPanel;
import ihm.component.MenuButton;
import ihm.error.Error;
import ihm.error.ErrorPanel;
import types.TypesStable;
import types.TypesPlayer;
import types.TypesImage;
import types.TypesMenu;
import types.TypesPermission;
import types.exception.ExceptionLogin;
import types.exception.ExceptionInvalidPermission;
import utilisateur.User;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MasterFrame {

	private JFrame frame;
	public static final Color COLOR_MASTER = new Color(0,164,210);
	public static final Color COLOR_MASTER_BACKGROUND = Color.WHITE;
	public static final Color COLOR_TEXT = Color.BLACK;
	public static final Color COLOR_TEXT_MENU = Color.WHITE;
	public static final Color COLOR_MENU_BACKGROUND = Color.BLACK;
	private JPanel panelMenuBtn;
	private ButtonGroup btnGroupMenu;
	private static volatile MasterFrame instance;
	private User user;
	private JPanel panelHeader;
	private JPanel panelMain;
	private ErrorPanel error;
	private LogIn loginPage;
	private JLabel lblAccountName;
	private JLabel lblAccountLogo;
	private JButton btnLogin;
	private static volatile DataJPanel currentPanel = null;

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
			fireError(e);
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
		panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());

		
		error = new ErrorPanel();
		root.setLayer(error, javax.swing.JLayeredPane.POPUP_LAYER);
		error.setBounds(0,0,frame.getWidth(), frame.getHeight());
		frame.getContentPane().add(error, BorderLayout.CENTER, 1);
		
		frame.getContentPane().add(panelMain,BorderLayout.CENTER, 3);
		panelMain.setBounds(0,0,frame.getWidth(), frame.getHeight());
		
		
		
		loginPage = new LogIn();
		frame.getContentPane().add(loginPage, BorderLayout.CENTER,2);
		
		frame.addComponentListener(new ComponentAdapter() {
		
			@Override
			public void componentResized(ComponentEvent e) {
				panelMain.setBounds(0,0,frame.getWidth(), frame.getHeight());
				error.setBounds(0,0,frame.getWidth(), frame.getHeight());
				error.resize();
				frame.repaint();
			}
		});
		
		frame.addWindowStateListener(new WindowAdapter() {
			@Override
			public void windowStateChanged(WindowEvent e) {
				panelMain.setBounds(0,0,frame.getWidth(), frame.getHeight());
				error.setBounds(0,0,frame.getWidth(), frame.getHeight());
				error.resize();
				frame.repaint();
			}
		});
		/*Maintenant que le JLayeredPane a �t� fait on va pouvoir y superposer le main et le panel de gestion des erreurs
		 * Nous aurons ainsi le panel qui se mettra en visible quand il en aura besoin.*/

		
		
		panelHeader = new JPanel();
		panelHeader.setBackground(COLOR_MENU_BACKGROUND);
		panelMain.add(panelHeader, BorderLayout.NORTH);
		panelHeader.setLayout(new BorderLayout(0, 0));
		
		

		JPanel panelAccount = new JPanel();
		panelAccount.setPreferredSize(new Dimension(250,50));
		panelAccount.setBackground(COLOR_MASTER);
		panelHeader.add(panelAccount, BorderLayout.EAST);
		panelAccount.setLayout(new BorderLayout(0, 0));
		
		JPanel nomComptePanel = new JPanel();
		BorderLayout bl_nomComptePanel = new BorderLayout();
		bl_nomComptePanel.setVgap(20);
		nomComptePanel.setLayout(bl_nomComptePanel);
		nomComptePanel.setBackground(COLOR_MASTER);
		panelAccount.add(nomComptePanel, BorderLayout.CENTER);
		
		lblAccountName = new JLabel("compte");
		lblAccountName.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountName.setForeground(Color.WHITE);
		nomComptePanel.add(lblAccountName, BorderLayout.SOUTH);
		
		lblAccountLogo = new JLabel("");
		lblAccountLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountLogo.setForeground(Color.WHITE);
		nomComptePanel.add(lblAccountLogo, BorderLayout.CENTER);
		
		btnLogin = new JButton("Se Connecter");
		
		panelAccount.add(btnLogin, BorderLayout.SOUTH);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(COLOR_MENU_BACKGROUND);
		panelHeader.add(panelMenu, BorderLayout.CENTER);
		panelMenu.setLayout(new BorderLayout(0, 0));
		
		JPanel panelEsporter = new JPanel();
		panelEsporter.setBackground(COLOR_MENU_BACKGROUND);
		panelMenu.add(panelEsporter, BorderLayout.WEST);
		panelEsporter.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(getClass().getResource("./images/ESporterLogo.png")));
		panelEsporter.add(lblLogo);
		
		
		panelMenuBtn = new JPanel();

		panelMenuBtn.setBackground(COLOR_MENU_BACKGROUND);
		FlowLayout fl_panelMenuBtn = (FlowLayout) panelMenuBtn.getLayout();
		fl_panelMenuBtn.setAlignment(FlowLayout.RIGHT);
		fl_panelMenuBtn.setVgap(0);
		fl_panelMenuBtn.setHgap(0);
		panelMenu.add(panelMenuBtn, BorderLayout.CENTER);
		
		JPanel panelDummyRight = new JPanel();
		panelDummyRight.setPreferredSize(new Dimension(35, 10));
		panelDummyRight.setBackground(COLOR_MENU_BACKGROUND);
		panelMenu.add(panelDummyRight, BorderLayout.EAST);
		
		JPanel panelDummyTop = new JPanel();
		panelDummyTop.setPreferredSize(new Dimension(10, 35));
		panelDummyTop.setBackground(COLOR_MENU_BACKGROUND);
		panelMenu.add(panelDummyTop, BorderLayout.NORTH);
		
		
		btnGroupMenu = new ButtonGroup();
		TypesMenu m = TypesMenu.VISITOR;
		MenuButton[] menu = m.getMenu();
		for (int i=0; i<menu.length;i++) {
			panelMenuBtn.add(menu[i]);
			btnGroupMenu.add(menu[i]);
		}
		
		JPanel footer = new JPanel();
		panelMain.add(footer, BorderLayout.SOUTH);
		
		setAccount();
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user.getPermission()!=TypesPermission.VISITOR) {
					//LOGGED IN
					user.logout();
					setMenu(TypesMenu.VISITOR);
					setPanel(ihm.visitor.Home.class, null);
					
				} else {
					//NOT LOG IN
					panelMain.setVisible(false);
					error.setVisible(false);
					loginPage.setVisible(true);
					loginPage.getTxtUsername().requestFocus();
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
		return panelMain;
	}
	
	public DataJPanel getCurrentPanel() {
		return currentPanel;
	}
	
	public void setCurrentPanel(DataJPanel currentPanel) {
		MasterFrame.currentPanel = currentPanel;
	}
	
	
	public void setMenu(TypesMenu m) {
		panelMenuBtn.removeAll();
		btnGroupMenu = new ButtonGroup();
		MenuButton[] menu = m.getMenu();
		for (int i=0; i<menu.length;i++) {
			
			panelMenuBtn.add(menu[i]);
			btnGroupMenu.add(menu[i]);
		}
		menu[0].setSelected(true);
		setAccount();
		frame.getContentPane().repaint();
		System.out.println(menu[0].getPanelToChange());
		
	}
	
	public void setAccount() {
		switch(user.getPermission()) {
		case REFEREE:
			btnLogin.setText("Se deconnecter");
			lblAccountLogo.setIcon(null);
			lblAccountName.setText("Arbitre");
			setPanel(ihm.referee.Home.class, null);
			break;
		case STABLE:
			btnLogin.setText("Se deconnecter");
			TypesStable e = (TypesStable)user.getInfo();
			lblAccountName.setText(e.getName());
			BufferedImage logoStable = ((TypesStable)MasterFrame.getInstance().getUser().getInfo()).getLogo().getImage();
			logoStable = TypesImage.resize(logoStable, 100, 100);
			lblAccountLogo.setIcon(new ImageIcon(logoStable));
			//logoCompte.setIcon(e.getLogo());
			setPanel(ihm.stable.Home.class, null);
			break;
		case PLAYER:
			btnLogin.setText("Se deconnecter");
			TypesPlayer p = (TypesPlayer)user.getInfo();
			lblAccountName.setText(p.getName());
			BufferedImage picture = ( (TypesPlayer) MasterFrame.getInstance().getUser().getInfo() ).getImage().getImage();
			picture = TypesImage.resize(picture, 80, 100);
			lblAccountLogo.setIcon(new ImageIcon(picture));
			//logoCompte.setIcon(j.getPhoto());
			setPanel(ihm.player.Home.class, null);
			break;
		case ORGANIZER:
			lblAccountLogo.setIcon(null);
			btnLogin.setText("Se deconnecter");
			lblAccountName.setText("Esporter");
			setPanel(ihm.organizer.Home.class, null);
			break;
		case VISITOR:
			lblAccountLogo.setIcon(null);
			btnLogin.setText("Se connecter");
			lblAccountName.setText("Visiteur");
			setPanel(ihm.visitor.Home.class, null);
			break;
		default:
			break;
		
		}
	}
	
	public void setPanel(Class<? extends JPanel> clazz, Object ob) {
		BorderLayout layout = (BorderLayout)panelMain.getLayout();
		Constructor<? extends JPanel> ctor;
		Object o = null;
		try {
			if (ob != null) {
				ctor = clazz.getConstructor(ob.getClass());
				o = ctor.newInstance(ob);
			} else {
				ctor = clazz.getConstructor((Class<?>[])null);
				o = ctor.newInstance((Object[])null);
			}
			
		} catch(NoSuchMethodException e) {
			try {
				ctor = clazz.getConstructor((Class<?>[])null);
				o = ctor.newInstance((Object[])null);
			} catch (NoSuchMethodException | SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel p = (JPanel) o;
		if (layout.getLayoutComponent(BorderLayout.CENTER)!=null)
			panelMain.remove(layout.getLayoutComponent(BorderLayout.CENTER));
		panelMain.add((Component) p, BorderLayout.CENTER);
		panelMain.revalidate();
		panelMain.repaint();
		if (p instanceof DataJPanel) {
			setCurrentPanel((DataJPanel)p);
		} else {
			setCurrentPanel(null);
		}
		panelHeader.revalidate();
		panelHeader.validate();
		panelHeader.repaint();
	}
	
	public void dataUpdate() {
		if (currentPanel!=null) {
			//setPanel(currentMainPanel.getClass(), user.getPermission());
			
			currentPanel.dataUpdate();
		}
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public User getUser() {
		return user;
	}
	
	public Point getFrameCenter() {
		return new Point(frame.getLocation().x+(frame.getWidth()/2), frame.getLocation().y+(frame.getHeight()/2));
	}
	
	public void fireError(Exception e) {
		error.setState(e, false);
		error.setVisible(true);
		frame.repaint();
		
	}
	
	public LogIn getLoginPage() {
		return loginPage;
	}
	
	public Dimension getFrameCenterDimension() {
		return this.frame.getContentPane().getSize();
	}
	
	


}
