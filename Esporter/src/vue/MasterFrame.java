package vue;
 


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

import controleur.Controler;
import controleur.State;
import model.user.User;
import types.TypesStable;
import types.TypesPlayer;
import types.TypesImage;
import types.TypesMenu;
import types.TypesPermission;
import types.exception.ExceptionLogin;
import vue.component.DataJPanel;
import vue.component.MenuButton;
import vue.error.Error;
import vue.error.ErrorPanel;
import vue.organizer.Calendar;
import types.exception.ExceptionInvalidPermission;

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
	private JPanel panelHeader;
	private JPanel panelMain;
	private ErrorPanel error;
	private LogIn loginPage;
	private JLabel lblAccountName;
	private JLabel lblAccountLogo;
	private JButton btnLogin;
	private static volatile DataJPanel currentDataPanel = null;
	private static volatile MasterFrame instance;
	private static volatile JPanel currentPanel = null;
	private Controler controler;

	/**
	 * Create the application.
	 */
	public static MasterFrame getInstance() {
		if (instance==null) {
			instance = new MasterFrame();
		}
		return instance;
	}
	
	
	
	private MasterFrame() {
		this.controler = Controler.getInstance();
		this.instance = this;
		initialize();
		
		frame.pack();
		
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setMinimumSize(new Dimension(1450,700));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setPreferredSize(new Dimension(1920,1080));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
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
				error.resize(frame.getWidth(), frame.getHeight());
				loginPage.resize(frame.getWidth(), frame.getHeight());
				frame.repaint();
				frame.revalidate();
			}
		});
		
		frame.addWindowStateListener(new WindowAdapter() {
			@Override
			public void windowStateChanged(WindowEvent e) {
				panelMain.setBounds(0,0,frame.getWidth(), frame.getHeight());
				error.setBounds(0,0,frame.getWidth(), frame.getHeight());
				loginPage.resize(frame.getWidth(), frame.getHeight());
				error.resize(frame.getWidth(), frame.getHeight());
				frame.revalidate();
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
			menu[i].addActionListener(controler);
		}
		
		JPanel footer = new JPanel();
		panelMain.add(footer, BorderLayout.SOUTH);
		
		setAccount();
		
		/*btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controler.getUser().getPermission()!=TypesPermission.VISITOR) {
					//LOGGED IN
					controler.getUser().logout();
					setMenu(TypesMenu.VISITOR);
					setPanel(vue.visitor.Home.class, null);
					
				} else {
					//NOT LOG IN
					panelMain.setVisible(false);
					error.setVisible(false);
					loginPage.setVisible(true);
					loginPage.getTxtUsername().requestFocus();
				}
			}
		});*/
		
		btnLogin.addActionListener(controler);
		btnLogin.setActionCommand("menuLogin");
		
		
		/*Maintenant que le JLayeredPane a �t� fait on va pouvoir y superposer le main et le panel de gestion des erreurs
		 * Nous aurons ainsi le panel qui se mettra en visible quand il en aura besoin.
		 * */
		panelMain.add(new vue.Calendar(TypesPermission.VISITOR));
		
		menu[0].doClick();
		
	}
	
	public ErrorPanel getError() {
		return error;
	}
	
	public JPanel getMain() {
		return panelMain;
	}
	
	public DataJPanel getCurrentDataPanel() {
		return currentDataPanel;
	}
	
	public void setCurrentDataPanel(DataJPanel currentPanel) {
		MasterFrame.currentDataPanel = currentPanel;
	}
	
	
	public void setMenu(TypesMenu m) {
		panelMenuBtn.removeAll();
		btnGroupMenu = new ButtonGroup();
		MenuButton[] menu = m.getMenu();
		for (int i=0; i<menu.length;i++) {
			
			panelMenuBtn.add(menu[i]);
			btnGroupMenu.add(menu[i]);
			menu[i].addActionListener(controler);
		}
		menu[0].setSelected(true);
		setAccount();
		frame.getContentPane().repaint();
		
	}
	
	public void setAccount() {
		switch(controler.getUser().getPermission()) {
		case REFEREE:
			btnLogin.setText("Se deconnecter");
			lblAccountLogo.setIcon(null);
			lblAccountName.setText("Arbitre");
			
			break;
		case STABLE:
			btnLogin.setText("Se deconnecter");
			TypesStable e = (TypesStable)controler.getUser().getInfo();
			lblAccountName.setText(e.getName());
			BufferedImage logoStable = ((TypesStable)controler.getUser().getInfo()).getLogo().getImage();
			logoStable = TypesImage.resize(logoStable, 100, 100);
			lblAccountLogo.setIcon(new ImageIcon(logoStable));

			break;
		case PLAYER:
			btnLogin.setText("Se deconnecter");
			TypesPlayer p = (TypesPlayer)controler.getUser().getInfo();
			lblAccountName.setText(p.getName());
			BufferedImage picture = ( (TypesPlayer)controler.getUser().getInfo() ).getImage().getImage();
			picture = TypesImage.resize(picture, 80, 100);
			lblAccountLogo.setIcon(new ImageIcon(picture));

			break;
		case ORGANIZER:
			lblAccountLogo.setIcon(null);
			btnLogin.setText("Se deconnecter");
			lblAccountName.setText("Esporter");

			break;
		case VISITOR:
			lblAccountLogo.setIcon(null);
			btnLogin.setText("Se connecter");
			lblAccountName.setText("Visiteur");

			break;
		default:
			break;
		
		}
		Controler.getInstance().setState(State.CALENDAR);
		if(controler.getUser().getPermission() == TypesPermission.ORGANIZER) {
			setPanel(vue.organizer.Calendar.class, null);
		} else {
			setPanel(vue.Calendar.class, controler.getUser().getPermission());
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
			setCurrentDataPanel((DataJPanel)p);
		} else {
			setCurrentDataPanel(null);
		}
		MasterFrame.setCurrentPanel(p);
		panelHeader.revalidate();
		panelHeader.validate();
		panelHeader.repaint();
	}
	
	public void dataUpdate() {
		if (currentDataPanel!=null) {
			//setPanel(currentMainPanel.getClass(), user.getPermission());
			
			currentDataPanel.dataUpdate();
			currentDataPanel.repaint();
			currentDataPanel.revalidate();
		}
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public User getUser() {
		return controler.getUser();
	}
	
	public Point getFrameCenter() {
		return new Point(frame.getLocation().x+(frame.getWidth()/2), frame.getLocation().y+(frame.getHeight()/2));
	}
	
	public void fireError(Exception e,boolean persistant, boolean critical ) {
		error.setState(e, false, critical);
		error.setVisible(true);
		frame.repaint();
		
	}
	
	public LogIn getLoginPage() {
		return loginPage;
	}
	
	public Dimension getFrameCenterDimension() {
		return this.frame.getContentPane().getSize();
	}
	
	
	public static void setCurrentPanel(JPanel currentPanel) {
		MasterFrame.currentPanel = currentPanel;
	}
	
	public static JPanel getCurrentPanel() {
		return currentPanel;
	}
	


}
