package model.user;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.SwingUtilities;

import controleur.Controler;
import model.data.Data;
import model.socket.Command;
import model.socket.CommandName;
import model.socket.Response;
import model.socket.ResponseObject;
import types.TypesStable;
import types.TypesInteger;
import types.TypesTeam;
import types.TypesID;
import types.Types;
import types.TypesPlayer;
import types.TypesRanking;
import types.TypesLogin;
import types.TypesMatch;
import types.TypesPermission;
import types.TypesRegisterTeam;
import types.TypesTournament;
import types.exception.ExceptionError;
import types.exception.ExceptionInvalidPermission;
import vue.MasterFrame;

public class CommunicationServer implements Runnable{
	
	private User user;
	private Socket s;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private int reconnect = 1;
	private int reconnectTime = 1;
	private boolean run=true;
	private static final String IP = "144.24.206.118"; //144.24.206.118
	private static final int PORT = 4000;
	
	public CommunicationServer(User user) throws UnknownHostException, IOException {
		this.user = user;
		connect();
	}
	
	private void connect() throws UnknownHostException, IOException{

		System.out.println("Tentative de connexion au server "+IP+":"+PORT);
		
		try {
			s = new Socket(IP,PORT);
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(s.getInputStream());
		} catch (IOException e) {
			reconnect();
		}
		
		System.out.println("Done");
		reconnect=1;
		reconnectTime=1;
	}
	
	private void reconnect() throws IOException,UnknownHostException {
		reconnect++;
		if (reconnect>5) {
			run=false;
			throw new IOException("Impossible de joindre le serveur");
		}
		reconnectTime*=2;
		String s = "Reconnecting number "+reconnect+" in "+reconnectTime+"s....";
		System.out.println(s);
		try {
			Thread.sleep(reconnectTime*1000);
		} catch (InterruptedException e) {
		}
		try {
			connect();
			reconnect=1;
			reconnectTime=1;
		} catch (IOException e2) {
			reconnect();
			
		}
	}
	
	@Override
	public void run() {
		while (run) {
			try {
				processInput((ResponseObject)in.readObject());
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				try {
					reconnect();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	public void deleteTournament(int t) {
		HashMap<TypesID, Types> m = new HashMap<>();
		m.put(TypesID.TOURNAMENT, new TypesInteger(t));
		Command c = new Command(CommandName.DELETE_TOURNAMENT, m);
		send(c);
	}
	
	
	public void sendLogin(String username, String password) {
		HashMap<TypesID, Types> m = new HashMap<>();
		m.put(TypesID.LOGIN, new TypesLogin(username, password));
		Command c = new Command(CommandName.LOGIN, m);
		send(c);
	}
	
	public void registerTournament(int idTournament) {
		HashMap<TypesID, Types> m = new HashMap<>();
		m.put(TypesID.TOURNAMENT, new TypesInteger(idTournament));
		m.put(TypesID.PLAYER, new TypesInteger(((TypesPlayer)user.getInfo()).getId()));
		Command c = new Command(CommandName.REGISTER_TOURNAMENT, m);
		send(c);
	}
	
	public void unregisterTournament(int idTournament, int idGame) {
		HashMap<TypesID, Types> m = new HashMap<>();
		m.put(TypesID.TOURNAMENT, new TypesInteger(idTournament));
		m.put(TypesID.PLAYER, new TypesInteger(((TypesPlayer)user.getInfo()).getId()));
		m.put(TypesID.GAME, new TypesInteger(idGame));
		Command c = new Command(CommandName.UNREGISTER_TOURNAMENT ,m);
		send(c);
	}
	
	public void addTeam(TypesRegisterTeam team) {
		HashMap<TypesID, Types> m = new HashMap<>();
		m.put(TypesID.TEAM, team);
		Command c = new Command(CommandName.ADD_TEAM, m);
		send(c);
	}
	
	public void modifyTeam(TypesTeam team) {
		HashMap<TypesID, Types> m = new HashMap<>();
		m.put(TypesID.TEAM, team);
		Command c = new Command(CommandName.MODIFY_TEAM, m);
		send(c);
	}
	
	public void addTournament(TypesTournament t) {
		HashMap<TypesID, Types> m = new HashMap<>();
		m.put(TypesID.TOURNAMENT, t);
		Command c = new Command(CommandName.ADD_TOURNAMENT, m);
		send(c);
	}
	
	public void logout() {
		Command c = new Command(CommandName.LOGOUT, null);
		send(c);
	}
	
	public void receiveLogin(ResponseObject r) {
		TypesPermission perm = TypesPermission.VISITOR;
		if (r.getInfo().containsKey(TypesID.PERMISSION)) {
			perm = (TypesPermission) r.getInfoByID(TypesID.PERMISSION);
		}
		setPermission(perm);
		if (r.getInfo().containsKey(TypesID.STABLE)) {
			user.setInfo(r.getInfoByID(TypesID.STABLE));

		}
		if (r.getInfo().containsKey(TypesID.PLAYER)) {
			user.setInfo(r.getInfoByID(TypesID.PLAYER));
		}
	}
	
	public void send (Command c) {
		try {
			out.writeObject(c);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public void initializeApp() {
		Command c = new Command(CommandName.INIT, null);
		send(c);
	}
	
	
	public void setPermission(TypesPermission perms) {
		user.setPermission(perms);
	}
	
	public void processInput(ResponseObject r) {
		System.out.println(r.getName());
		switch(r.getName()) {
		case ERROR_LOGIN:
			user.getWaiting().setActualState(Response.ERROR_LOGIN);
			break;
		case ERROR_PERMISSION:
			MasterFrame.getInstance().fireError(new ExceptionInvalidPermission("Vous n'avez pas la permission d'effectuer ceci"));
			System.out.println("ERREUR PERMISSION");
			user.getWaiting().setActualState(Response.ERROR_PERMISSION);
			break;
		case LOGIN:
			receiveLogin(r);
			user.getWaiting().setActualState(r.getName());
			break;
		case UPDATE_CALENDAR:
			//ok
			break;
		case UPDATE_STABLE:
			TypesStable stable = (TypesStable)r.getInfoByID(TypesID.STABLE);
			user.getData().getStables().put(stable.getId(), stable);
			MasterFrame.getInstance().dataUpdate();
			break;
		case UPDATE_TEAM:
			TypesTeam team = (TypesTeam)r.getInfoByID(TypesID.TEAM);
			user.getData().getStables().get(team.getStable().getId()).getTeams().put(team.getId(), team);
			if (((TypesStable)user.getInfo()).getId() == team.getStable().getId()) {
				((TypesStable)user.getInfo()).addTeam(team);
			}
			user.getData().getTeams().put(team.getId(), team);
			MasterFrame.getInstance().dataUpdate();
			break;
		case UPDATE_TOURNAMENT:
			TypesTournament tournament = (TypesTournament)r.getInfoByID(TypesID.TOURNAMENT);
			user.getData().getCalendar().put(tournament.getId(), tournament);
			MasterFrame.getInstance().dataUpdate();
			break;
		case UPDATE_ALL:
			user.setData((Data)r.getInfo().get(TypesID.ALL));
			user.getWaiting().setActualState(Response.UPDATE_ALL);
			
			break;
		case ERROR:
			MasterFrame.getInstance().fireError(new ExceptionError(r.getError()));;
			System.out.println("ERREUR");
			break;
		case DELETE_TOURNAMENT:
			user.getData().getCalendar().remove(((TypesInteger)r.getInfoByID(TypesID.TOURNAMENT)).getInteger());
			MasterFrame.getInstance().dataUpdate();
		case UPDATE_MATCH:
			int idTournoi = ((TypesInteger)r.getInfoByID(TypesID.TOURNAMENT)).getInteger();
			int Pool = ((TypesInteger)r.getInfoByID(TypesID.POOL)).getInteger();
			TypesMatch match = ((TypesMatch)r.getInfoByID(TypesID.MATCH));
			
			for(TypesMatch m : user.getData().getCalendar().get(idTournoi).getPool().get(Pool).getMatchs()) {
				if(m.equals(match)) {
					m.setPoint(match.getTeam1Score(), match.getTeam2Score());
					break;
				}
			}
			MasterFrame.getInstance().dataUpdate();
		case UPDATE_RANKING:
			TypesRanking ranking = ((TypesRanking)r.getInfoByID(TypesID.RANKING));
			Controler.getInstance().getData().getRanking().put(ranking.getId(), ranking);
			MasterFrame.getInstance().dataUpdate();
		default:
			break;
		
		
		}
		user.getWaiting().setActualState(r.getName());
	}

	public void modifyTournament(TypesTournament t) {
		HashMap<TypesID, Types> m = new HashMap<>();
		m.put(TypesID.TOURNAMENT, t);
		Command c = new Command(CommandName.MODIFY_TOURNAMENT, m);
		send(c);
	}
	
	
	public void changeScore(TypesMatch match, int idTournament, int idPool) {
		HashMap<TypesID, Types> m = new HashMap<>();
		m.put(TypesID.MATCH, match);
		m.put(TypesID.TOURNAMENT, new TypesInteger(idTournament));
		m.put(TypesID.POOL, new TypesInteger(idPool));
		Command c = new Command(CommandName.SCORE, m);
		send(c);
	}


	
}
