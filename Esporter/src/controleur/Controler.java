package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.data.Data;
import model.socket.Response;
import model.user.User;
import types.TypesFame;
import types.TypesGame;
import types.TypesImage;
import types.TypesLogin;
import types.TypesMenu;
import types.TypesPermission;
import types.TypesPlayer;
import types.TypesRegisterPlayer;
import types.TypesRegisterTeam;
import types.TypesStable;
import types.TypesTeam;
import types.TypesTournament;
import types.exception.ExceptionInvalidPermission;
import types.exception.ExceptionTeamNotFull;
import vue.Calendar;
import vue.LogIn;
import vue.MasterFrame;
import vue.SeePlayerInfos;
import vue.StableInfo;
import vue.Stables;
import vue.component.ContainerModifyPlayer;
import vue.component.ContainerPlayer;
import vue.component.DatePicker;
import vue.organizer.CreateTournament;
import vue.player.RegisterTournament;
import vue.stable.AddPlayer;
import vue.stable.ModifyPlayer;
import vue.stable.ModifyTeam;
import vue.stable.TeamManagement;
import vue.stable.management.AddTeam;

public class Controler implements ActionListener, MouseListener, KeyListener{

	private static Controler instance;
	private User user;
	private State state = null;
	private JDialog lastDialog = null;
	private State stateBefore;
	
	
	private Controler(){
		try {
			user = new User();
		} catch (UnknownHostException e) {
			System.out.println("Impossible de se connecter au server");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Controler getInstance() {
		if (instance==null)
			instance = new Controler();
		return instance;
	}
	
	public void dataUpdate() {
		MasterFrame.getInstance().dataUpdate();
	}
	
	public void setMenu(TypesMenu type) {
		MasterFrame.getInstance().setMenu(type);
	}
	
	public void fireError(Exception e ) {
		MasterFrame.getInstance().fireError(e);
	}
	
	public void openError() {
		stateBefore = state;
		
		state = State.ERROR;
		System.out.println("Passage de "+stateBefore+" à "+state);
	}
	
	public void closeError() {
		System.out.println("Passage de "+state+" à "+stateBefore);
		state = stateBefore;
		
	}
	
	public Data getData() {
		return user.getData();
	}
	
	public User getUser() {
		return user;
	}
	

	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////		 ACTION LISTENER PART 		/////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().contains("menu")) {
			if (user.getPermission() == TypesPermission.STABLE && e.getActionCommand().equals("menuStableManagement")) {
				MasterFrame.getInstance().setPanel(vue.stable.TeamManagement.class, null);
				state = State.STABLE_MANAGEMENT;
			} else if (e.getActionCommand().equals("menuCalendar")) {
				if(getUser().getPermission() == TypesPermission.ORGANIZER) {
					MasterFrame.getInstance().setPanel(vue.organizer.Calendar.class, null);
				} else {
					MasterFrame.getInstance().setPanel(vue.Calendar.class, getUser().getPermission());
				}
				
				
				state = State.CALENDAR;
			} else if (e.getActionCommand().equals("menuRanking")) {
				MasterFrame.getInstance().setPanel(vue.Ranking.class, null);
				state = State.RANKING;
			} else if (e.getActionCommand().equals("menuStable")) {
				MasterFrame.getInstance().setPanel(vue.Stables.class, null);
				state = State.STABLE_LIST;
			} else if (e.getActionCommand().equals("menuLogin")) {
				if(getUser().getPermission()!=TypesPermission.VISITOR) {
					//LOGGED IN
					getUser().logout();
					setMenu(TypesMenu.VISITOR);
					MasterFrame.getInstance().setPanel(vue.visitor.Home.class, null);
					state = State.HOME_VISITOR;
				} else {
					//NOT LOG IN
					MasterFrame.getInstance().getMain().setVisible(false);
					MasterFrame.getInstance().getError().setVisible(false);
					MasterFrame.getInstance().getLoginPage().setVisible(true);
					MasterFrame.getInstance().getLoginPage().getTxtUsername().requestFocus();
					state = State.LOGIN;
				}
			}
		} else {
			
			switch(state) {
			case ADD_PLAYER:
				AddPlayer jd = (AddPlayer)lastDialog;
				switch(e.getActionCommand()) {
				case "ADD_PLAYER_VALIDATE":
					String name = jd.getTxtName().getText();
					String firstname = jd.getTxtFirstname().getText();
					Date contractStartDate = null;
					Date birthDate = null;
					Date contractEndDate = null;
					BufferedImage image = jd.getImage();
					try {
					contractStartDate= Date.valueOf(jd.getTxtStartContractDate().getText());
					birthDate= Date.valueOf(jd.getTxtBirthDate().getText());
					contractEndDate= Date.valueOf(jd.getTxtEndContractDate().getText());
					} catch (IllegalArgumentException e1){
						
					}

					if (name == null) {
						JOptionPane.showMessageDialog(null, "Le champ nom n'est pas specifié","Erreur", JOptionPane.ERROR_MESSAGE);
					}else if(firstname==null){
						JOptionPane.showMessageDialog(null, "Le champ prenom n'est pas specifié","Erreur", JOptionPane.ERROR_MESSAGE);
					}else if(contractStartDate==null){
						JOptionPane.showMessageDialog(null, "Le champ debut du contrat n'est pas specifié","Erreur", JOptionPane.ERROR_MESSAGE);
					}else if(birthDate==null) {
						JOptionPane.showMessageDialog(null, "Le champ date de naissance n'est pas specifié","Erreur", JOptionPane.ERROR_MESSAGE);
					}else if(contractEndDate== null) {
						JOptionPane.showMessageDialog(null, "Le champ date de fin du contrat n'est pas specifié","Erreur", JOptionPane.ERROR_MESSAGE);
					}else if(image == null) {
						JOptionPane.showMessageDialog(null, "Il y a une erreur avec la photo","Erreur", JOptionPane.ERROR_MESSAGE);
					}else {
						try {
							ByteArrayOutputStream blob = new ByteArrayOutputStream();
							
							image = TypesImage.resize(image, 200, 300);
							try {
								ImageIO.write(image, "png", blob);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							InputStream is = new ByteArrayInputStream(blob.toByteArray());
							BufferedImage bf = ImageIO.read(is);
							types.TypesImage im = new types.TypesImage(image, "png");
							TypesPlayer joueur = new TypesPlayer(-1,name, firstname,im,birthDate,contractStartDate,contractEndDate,1,-1,((TypesStable)MasterFrame.getInstance().getUser().getInfo()).getId());
							TypesLogin l = new TypesLogin(jd.getTxtUsername().getText(), jd.getTxtPassword().getText());
							jd.getContainer().setPlayer(new TypesRegisterPlayer(joueur, l));
							jd.dispose();
							closeDialog();
						} catch (IOException e1) {
							fireError( new IllegalArgumentException("Il y a une erreur avec la photo"));
						} 
						
					}
					break;
				case "ADD_PLAYER_MORE1":
					final JFrame f = new JFrame();
					//set text which is collected by date picker i.e. set date 
					jd.getTxtBirthDate().setText(new DatePicker(f).setPickedDate());
					break;
				case "ADD_PLAYER_MORE2":
					//create frame new object  f
					final JFrame f1 = new JFrame();
					//set text which is collected by date picker i.e. set date 
					jd.getTxtEndContractDate().setText(new DatePicker(f1).setPickedDate());
					break;
				case "ADD_PLAYER_MORE3":
					//create frame new object  f
					final JFrame f2 = new JFrame();
					//set text which is collected by date picker i.e. set date 
					jd.getTxtStartContractDate().setText(new DatePicker(f2).setPickedDate());
					break;
					
				}
				break;
			case ADD_TEAM:
				switch(e.getActionCommand()) {
				case "ADD_TEAM_COMBOGAME":
					MasterFrame.getInstance().setPanel(AddTeam.class, ((AddTeam)MasterFrame.getCurrentPanel()).getComboBox().getSelectedItem());
					break;
				case "ADD_TEAM_VALIDATE":
					for (ContainerPlayer c : ((AddTeam)MasterFrame.getCurrentPanel()).getPlayerList()) {
						if (c.getPlayer()==null) {
							fireError(new ExceptionTeamNotFull("Erreur de creation de l'équipe"));
							return;
						}
					}
					ArrayList<TypesRegisterPlayer> players = new ArrayList<>();
					for (ContainerPlayer c : ((AddTeam)MasterFrame.getCurrentPanel()).getPlayerList()) {
						players.add(c.getPlayer());
					}
					JComboBox<TypesGame> jcombo = ((AddTeam)MasterFrame.getCurrentPanel()).getComboBox();
					TypesRegisterTeam team = new TypesRegisterTeam((TypesGame)jcombo.getSelectedItem(), ((TypesStable)MasterFrame.getInstance().getUser().getInfo()).getId(), players);
					MasterFrame.getInstance().getUser().addTeam(team);
					MasterFrame.getInstance().getUser().getWaiting().waitFor(Response.UPDATE_TEAM, Response.ERROR);
					if (MasterFrame.getInstance().getUser().getWaiting().getActualState()==Response.UPDATE_TEAM) {
						MasterFrame.getInstance().setPanel(vue.stable.TeamManagement.class, null);
					}
					break;
				}
				break;
			case ADD_TOURNAMENT:
				CreateTournament create = ((CreateTournament)MasterFrame.getCurrentPanel());
				switch(e.getActionCommand()) {
				case "ADD_TOURNAMENT_YES":
					try {
						if(create.getTxtDateStartTournament().getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Veuillez préciser la date de début du tournoi","Error", JOptionPane.ERROR_MESSAGE);
						}else if(create.getTxtTournamentName().getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Veuillez préciser le nom du tournoi","Error", JOptionPane.ERROR_MESSAGE);
						}else {
							Date tournamentStart = null;
							try {
								tournamentStart = Date.valueOf(create.getTxtDateStartTournament().getText());
							} catch (IllegalArgumentException e1) {
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, "Format de date invalide","Error", JOptionPane.ERROR_MESSAGE);
								return;
							}
							int n = JOptionPane.showConfirmDialog(null, "Confirmez vous l'ajout du tournoi ?","Confirmation", JOptionPane.YES_NO_OPTION);
							if (n == JOptionPane.YES_OPTION) {
								TypesTournament t = new TypesTournament(tournamentStart, create.getTxtTournamentName().getText(), 
										(TypesFame) create.getComboBoxFame().getSelectedItem(), (TypesGame) create.getComboBoxGame().getSelectedItem(), -1);
								if (MasterFrame.getInstance().getUser().getData().listSortedTournaments().contains(t)) { 
									JOptionPane.showMessageDialog(null, "Un tournoi à cette date existe déjà","Error", JOptionPane.ERROR_MESSAGE);
								}else{
									MasterFrame.getInstance().getUser().addTournament(t);
									MasterFrame.getInstance().setPanel(vue.organizer.Calendar.class, null);
									state = State.CALENDAR;
								}
							}
						}
					} catch (ExceptionInvalidPermission e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case "ADD_TOURNAMENT_DATE":
					//create frame new object  f
					final JFrame f = new JFrame();
					//set text which is collected by date picker i.e. set date 
					create.getTxtDateStartTournament().setText(new DatePicker(f).setPickedDate());
					break;
				case "ADD_TOURNAMENT_CANCEL":
					MasterFrame.getInstance().setPanel(vue.organizer.Calendar.class, null);
					state = State.CALENDAR;
					break;
				}
				break;
			case MODIFY_TOURNAMENT:
				break;
			case CALENDAR:
				vue.component.Calendar cal;
				if(MasterFrame.getCurrentPanel() instanceof vue.organizer.Calendar) {
					cal = ((vue.organizer.Calendar)MasterFrame.getCurrentPanel());
				} else {
					cal = ((Calendar)MasterFrame.getCurrentPanel());
				}
				
				switch(e.getActionCommand()) {
				case "CALENDAR_DATE":
					//create frame new object  f
					final JFrame f = new JFrame();
					//set text which is collected by date picker i.e. set date 
					cal.getTxtDate().setText(new DatePicker(f).setPickedDate());
					cal.createListTournament(Date.valueOf(cal.getTxtDate().getText()),cal.getGame());
	                ((JPanel)cal).repaint();
	                ((JPanel)cal).revalidate();
					break;
				case "CALENDAR_GAMECOMBO":
					if(((TypesGame)cal.getComboBoxFilterGame().getSelectedItem()) != cal.getGame()) {
		                cal.createListTournament(cal.getChosenDate(),(TypesGame)cal.getComboBoxFilterGame().getSelectedItem());
		                ((JPanel)cal).repaint();
		                ((JPanel)cal).revalidate();
					}
					break;
				case "CALENDAR_ADD":
					MasterFrame.getInstance().setPanel(vue.organizer.CreateTournament.class,null);
					state = State.ADD_TOURNAMENT;
					break;
				default:
					if(e.getActionCommand().contains("RENDERER")) {
						String model = null;
						if(e.getActionCommand().contains("MODIFY")) {
							model = "CALENDAR RENDERER MODIFY ";
						}else if(e.getActionCommand().contains("REMOVE")) {
							model = "CALENDAR RENDERER REMOVE ";
						} else if(e.getActionCommand().contains("INSCRIPTION")) {
							model = "CALENDAR RENDERER INSCRIPTION ";
						} else if(e.getActionCommand().contains("SCORE")) {
							model = "CALENDAR RENDERER SCORE ";
						} else if(e.getActionCommand().contains("POOL")) {
							model = "CALENDAR RENDERER POOL ";
						}
						int id = Integer.parseInt(e.getActionCommand().substring(model.length()));
						TypesTournament tournament;
						if(MasterFrame.getCurrentPanel() instanceof vue.organizer.Calendar) {
							tournament = ((vue.organizer.Calendar)MasterFrame.getCurrentPanel()).getRenderer(id).getTournament();
						} else {
							tournament = ((Calendar)MasterFrame.getCurrentPanel()).getRenderer(id).getTournament();
						}
						 
						//MasterFrame.getInstance().setPanel(vue.SeePlayerInfos.class, team);
						
						if(e.getActionCommand().contains("MODIFY")) {
							System.out.println("NOT YET IMPLEMENTED");
						}else if(e.getActionCommand().contains("REMOVE")) {
							int n = JOptionPane.showConfirmDialog (null, "Etes vous sur de vouloir supprimer le tournoi?","WARNING", JOptionPane.YES_NO_OPTION);
							if(n== JOptionPane.YES_OPTION) {
								MasterFrame.getInstance().getUser().deleteTournament(tournament);
							}
						} else if(e.getActionCommand().contains("INSCRIPTION")) {
							JDialog confirmation = new RegisterTournament(tournament.getId(), tournament);
							
						} else if(e.getActionCommand().contains("SCORE")) {
							System.out.println("NOT YET IMPLEMENTED");
						} else if(e.getActionCommand().contains("POOL")) {
							MasterFrame.getInstance().setPanel(vue.component.ProgramMatchs.class, tournament);
							state = State.POOL;
						}
					}
					break;
				}
				break;
			case INSCRIPTION:
				RegisterTournament reg = (RegisterTournament)lastDialog;
				switch(e.getActionCommand()) {
				case "INSCRIPTION_YES":
					if(!reg.getTournament().getRegistered().contains(((TypesPlayer)MasterFrame.getInstance().getUser().getInfo()).getIdTeam())){
						try {
							MasterFrame.getInstance().getUser().registerTournament(reg.getTournament().getId());
							reg.dispose();
						} catch (ExceptionInvalidPermission e1) {
							
							e1.printStackTrace();
						}
					}else {
						try {
							MasterFrame.getInstance().getUser().unregisterTournament(reg.getTournament().getId(), TypesGame.gameToInt(reg.getTournament().getGame()));
						} catch (ExceptionInvalidPermission e1) {
							e1.printStackTrace();
						};
						reg.dispose();
					}
					break;
				case "INSCRIPTION_NO":
					reg.dispose();
					break;
				}
				break;
			case ERROR:
				if(e.getActionCommand().equals("ERROR_CONTINUE")) {
					MasterFrame.getInstance().getError().setVisible(false);
					MasterFrame.getInstance().getError().setException(null);
					closeError();
				}
				break;
			case HOME_ORGANIZER:
				break;
			case HOME_PLAYER:
				break;
			case HOME_REFEREE:
				break;
			case HOME_STABLE:
				break;
			case HOME_VISITOR:
				break;
			case LOGIN:
				switch(e.getActionCommand()) {
				case "LOGIN_PROCEED":
					//requestFocus();
					MasterFrame master = MasterFrame.getInstance();
					LogIn logPage = master.getLoginPage();
			        try {
			            String identifiant = logPage.getTxtUsername().getText();
			            String psw = new String(logPage.getTxtPassword().getPassword());

			            master.getUser().login(identifiant, psw);
			            logPage.setVisible(false);
			            master.getMain().setVisible(true);
			        } catch (Exception e1) {
			            master.fireError(e1);
			        }
			        logPage.getTxtPassword().setText(null);
					break;
				case "LOGIN_CANCEL":
					MasterFrame.getInstance().getLoginPage().setVisible(false);
					MasterFrame.getInstance().getMain().setVisible(true);
					break;
				}
				
				break;
			case MODIFY_PLAYER:
				ModifyPlayer mp = (ModifyPlayer)lastDialog;
				switch(e.getActionCommand()) {
				case "MODIFY_PLAYER_VALIDATE":
					String name = mp.getTxtName().getText();
					String firstname = mp.getTxtFirstname().getText();
					Date contractStartDate = null;
					Date birthDate = null;
					Date contractEndDate = null;
					BufferedImage image = mp.getImage();
					try {
					contractStartDate= Date.valueOf(mp.getTxtStartContractDate().getText());
					birthDate= Date.valueOf(mp.getTxtBirthDate().getText());
					contractEndDate= Date.valueOf(mp.getTxtEndContractDate().getText());
					} catch (IllegalArgumentException e1){
						
					}
					

					if (name == null) {
						JOptionPane.showMessageDialog(null, "Le champ nom n'est pas specifié","Erreur", JOptionPane.ERROR_MESSAGE);
					}else if(firstname==null){
						JOptionPane.showMessageDialog(null, "Le champ prenom n'est pas specifié","Erreur", JOptionPane.ERROR_MESSAGE);
					}else if(contractStartDate==null){
						JOptionPane.showMessageDialog(null, "Le champ debut du contrat n'est pas specifié","Erreur", JOptionPane.ERROR_MESSAGE);
					}else if(birthDate==null) {
						JOptionPane.showMessageDialog(null, "Le champ date de naissance n'est pas specifié","Erreur", JOptionPane.ERROR_MESSAGE);
					}else if(contractEndDate== null) {
						JOptionPane.showMessageDialog(null, "Le champ date de fin du contrat n'est pas specifié","Erreur", JOptionPane.ERROR_MESSAGE);
					}else if(image == null) {
						JOptionPane.showMessageDialog(null, "Il y a une erreur avec la photo","Erreur", JOptionPane.ERROR_MESSAGE);
					}else {
						try {
							ByteArrayOutputStream blob = new ByteArrayOutputStream();
							
							image = TypesImage.resize(image, 200, 300);
							try {
								ImageIO.write(image, "png", blob);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							InputStream is = new ByteArrayInputStream(blob.toByteArray());
							BufferedImage bf = ImageIO.read(is);
							types.TypesImage im = new types.TypesImage(image, "png");
							TypesPlayer joueur = new TypesPlayer(mp.getContainer().getPlayer().getId(),name, firstname,im,birthDate,contractStartDate,contractEndDate,1,mp.getContainer().getPlayer().getIdTeam(),((TypesStable)MasterFrame.getInstance().getUser().getInfo()).getId());
							mp.getContainer().setPlayer(joueur);
							mp.dispose();
						} catch (IOException e1) {
							fireError( new IllegalArgumentException("Il y a une erreur avec la photo"));
						} 
					}
					break;
				case "ADD_PLAYER_MORE1":
					final JFrame f = new JFrame();
					//set text which is collected by date picker i.e. set date 
					mp.getTxtBirthDate().setText(new DatePicker(f).setPickedDate());
					break;
				case "ADD_PLAYER_MORE2":
					//create frame new object  f
					final JFrame f1 = new JFrame();
					//set text which is collected by date picker i.e. set date 
					mp.getTxtEndContractDate().setText(new DatePicker(f1).setPickedDate());
					break;
				case "ADD_PLAYER_MORE3":
					//create frame new object  f
					final JFrame f2 = new JFrame();
					//set text which is collected by date picker i.e. set date 
					mp.getTxtStartContractDate().setText(new DatePicker(f2).setPickedDate());
					break;			
					
				}
				break;
			case MODIFY_TEAM:
				switch(e.getActionCommand()) {
				case "MODIFY_TEAM_VALIDATE":
					for (ContainerModifyPlayer c : ((ModifyTeam)MasterFrame.getCurrentPanel()).getPlayerList()) {
						if (c.getPlayer()==null) {
							fireError(new ExceptionTeamNotFull("Erreur de modification de l'équipe"));
							return;
						}
					}
					HashMap<Integer,TypesPlayer> players = new HashMap<>();
					for (ContainerModifyPlayer c : ((ModifyTeam)MasterFrame.getCurrentPanel()).getPlayerList()) {
						System.out.println(c.getPlayer().getId());
						players.put(c.getPlayer().getId(),c.getPlayer());
					}
					TypesTeam previousTeam = ((ModifyTeam)MasterFrame.getCurrentPanel()).getTeam();
					TypesTeam newTeam = new TypesTeam(previousTeam.getGame(), previousTeam.getStable(), players, previousTeam.getId());
					MasterFrame.getInstance().getUser().modifyTeam(newTeam);
					MasterFrame.getInstance().getUser().getWaiting().waitFor(Response.UPDATE_TEAM, Response.ERROR);
					if (MasterFrame.getInstance().getUser().getWaiting().getActualState()==Response.UPDATE_TEAM) {
						MasterFrame.getInstance().setPanel(vue.stable.TeamManagement.class, null);
						state = State.STABLE_MANAGEMENT;
					}
					break;
				}
				break;
			case PLAYER_INFO:
				switch(e.getActionCommand()) {
				case "PLAYER_INFO_STABLE":
					MasterFrame.getInstance().setPanel(vue.Stables.class, null);
					state = State.STABLE_LIST;
					break;
				case "PLAYER_INFO_TEAM":
					MasterFrame.getInstance().setPanel(vue.StableInfo.class, ((SeePlayerInfos)MasterFrame.getCurrentPanel()).getTeam().getStable());
					state = State.STABLE_INFO;
					break;
				}
				break;
			case RANKING:
				break;
			case STABLE_INFO:
				if(e.getActionCommand().contains("RENDERER")) {
					String model = "STABLE_INFO RENDERER ";
					int id = Integer.parseInt(e.getActionCommand().substring(model.length()));
					TypesTeam team = ((StableInfo)MasterFrame.getCurrentPanel()).getRenderer(id).getTeam();
					MasterFrame.getInstance().setPanel(vue.SeePlayerInfos.class, team);
					state = State.PLAYER_INFO;
				}else {
					MasterFrame.getInstance().setPanel(vue.Stables.class, null);
					state = State.STABLE_LIST;
				}
				break;
			case STABLE_LIST:
				if(e.getActionCommand().contains("RENDERER")) {
					String model = "STABLE_LIST RENDERER ";
					int id = Integer.parseInt(e.getActionCommand().substring(model.length()));
					TypesStable stable = ((Stables)MasterFrame.getCurrentPanel()).getRenderer(id).getStable();
					MasterFrame.getInstance().setPanel(vue.StableInfo.class, stable);
					state = State.STABLE_INFO;
				}
				break;
			case STABLE_MANAGEMENT:
				switch(e.getActionCommand()) {
				case "STABLE_MANAGEMENT_ADDTEAM":
					MasterFrame.getInstance().setPanel(AddTeam.class, ((TeamManagement)MasterFrame.getCurrentPanel()).getComboBoxFilterGame().getSelectedItem());
					state = State.ADD_TEAM;
					break;
				case "STABLE_MANAGEMENT_COMBO":
					((TeamManagement)MasterFrame.getCurrentPanel()).setFilterGame((TypesGame)((TeamManagement)MasterFrame.getCurrentPanel()).getComboBoxFilterGame().getSelectedItem());
					break;
				default:
					if(e.getActionCommand().contains("RENDERER")) {
						String model = null;
						if (e.getActionCommand().contains("INFO")) {
							model = "STABLE_MANAGEMENT RENDERER INFO ";
						}else {
							model = "STABLE_MANAGEMENT RENDERER MODIFY ";
						}
						int id = Integer.parseInt(e.getActionCommand().substring(model.length()));
						TypesTeam team = ((TeamManagement)MasterFrame.getCurrentPanel()).getRenderer(id).getTeam();
						if (e.getActionCommand().contains("INFO")) {
							MasterFrame.getInstance().setPanel(vue.SeePlayerInfos.class, team);
							state = State.PLAYER_INFO;
						}else {
							MasterFrame.getInstance().setPanel(vue.stable.ModifyTeam.class, team);
							state = State.MODIFY_TEAM;
						}
					}
					break;
				}
				break;
			default:
				break;
			
			}
		}
		System.out.println(state);
		
	}

	
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////		 MOUSE LISTENER PART 		/////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		switch(state) {
		case ADD_PLAYER:
			//Si on a un mouse click sur ADD_PLAYER c'est que l'on clique sur un label
			AddPlayer jd = (AddPlayer)lastDialog;
			JFileChooser file = jd.getFileExplorer();
			int res = file.showOpenDialog(null);
	        //si l'utilisateur clique sur enregistrer dans Jfilechooser
	        if(res == JFileChooser.APPROVE_OPTION){
	        	File selFile = file.getSelectedFile();
	        	jd.setFile(selFile);
	        }

			break;
		case ADD_TEAM:
			if (e.getSource() instanceof ContainerPlayer) {
				AddPlayer ajout = new AddPlayer((ContainerPlayer)e.getSource());
				ajout.setVisible(true);
				ajout.setAlwaysOnTop(true);
				
			}
			break;
		case CALENDAR:
			break;
		case ERROR:
			break;
		case HOME_ORGANIZER:
			break;
		case HOME_PLAYER:
			break;
		case HOME_REFEREE:
			break;
		case HOME_STABLE:
			break;
		case HOME_VISITOR:
			break;
		case LOGIN:
			break;
		case MODIFY_PLAYER:
			//Si on a un mouse click sur MODIFY_PLAYER c'est que l'on clique sur un label
			ModifyPlayer mp = (ModifyPlayer)lastDialog;
			JFileChooser fileExplorer = mp.getFileExplorer();
			int result = fileExplorer.showOpenDialog(null);
	        //si l'utilisateur clique sur enregistrer dans Jfilechooser
	        if(result == JFileChooser.APPROVE_OPTION){
	        	File selFile = fileExplorer.getSelectedFile();
	        	mp.setFile(selFile);
	        }
			break;
		case MODIFY_TEAM:
			if(e.getSource() instanceof ContainerModifyPlayer) {
				ModifyPlayer ajout = new ModifyPlayer((ContainerModifyPlayer)e.getSource());
				ajout.setVisible(true);
				ajout.setAlwaysOnTop(true);
			}
			break;
		case PLAYER_INFO:
			break;
		case RANKING:
			break;
		case STABLE_INFO:
			break;
		case STABLE_LIST:
			break;
		case STABLE_MANAGEMENT:
			break;
		default:
			break;
		
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////			JDIALOG SUPPORT			/////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	
	
	public void closeDialog() {
		System.out.println("CLOSE");
		this.lastDialog=null;
		this.state = stateBefore;
	}
	
	public void openDialog(JDialog jdiag, State name) {
		System.out.println("OPEN");
		this.lastDialog=jdiag;
		this.stateBefore = this.state;
		this.state=name;
	}

	/////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////			KEY LISTENER PART			/////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(state) {
		case LOGIN:
			if (e.getKeyCode()==KeyEvent.VK_ENTER){
				MasterFrame master = MasterFrame.getInstance();
				LogIn logPage = master.getLoginPage();
		        try {
		            String identifiant = logPage.getTxtUsername().getText();
		            String psw = new String(logPage.getTxtPassword().getPassword());
	
		            master.getUser().login(identifiant, psw);
		            logPage.setVisible(false);
		            master.getMain().setVisible(true);
		        } catch (Exception e1) {
		            master.fireError(e1);
		        }
		        logPage.getTxtPassword().setText(null);
			}
			break;
		case ERROR:
			if (e.getKeyCode()==KeyEvent.VK_ENTER){
				MasterFrame.getInstance().getError().setVisible(false);
				MasterFrame.getInstance().getError().setException(null);
				closeError();
			}
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
