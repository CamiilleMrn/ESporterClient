package model.user;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;

import controleur.Controler;
import model.data.Data;
import model.socket.Response;
import types.TypesTeam;
import types.Types;
import types.TypesMatch;
import types.TypesMenu;
import types.TypesPlayer;
import types.TypesPermission;
import types.TypesRegisterTeam;
import types.TypesTournament;
import types.WaitingFor;
import types.exception.ExceptionLogin;
import types.exception.ExceptionInvalidPermission;

public class User {

	private volatile TypesPermission permission;
	private CommunicationServer com;
	private Thread t;
	private Types info;
	private WaitingFor waiting;
	private volatile static Data data;

	public User() throws UnknownHostException, IOException {
		this.permission = TypesPermission.VISITOR;
		this.com = new CommunicationServer(this);
		this.waiting = new WaitingFor();
		this.t = new Thread(com);
		t.setDaemon(true);
		t.start();
		com.initializeApp();
		waiting.waitFor(Response.UPDATE_ALL);

	}

	public Data getData() {
		synchronized (data) {
			return data;
		}
	}

	public void setData(Data data) {
		synchronized (data) {
			User.data = data;
		}

	}

	public CommunicationServer getCom() {
		return com;
	}

	public void setPermission(TypesPermission permission) {
		this.permission = permission;
	}

	public TypesPermission getPermission() {
		return permission;
	}

	public void login(String username, String password) throws ExceptionLogin {
		com.sendLogin(username, password);
		Response[] r = { Response.LOGIN, Response.ERROR_LOGIN };
		waiting.waitFor(r);
		switch (waiting.getActualState()) {
		case ERROR_LOGIN:
			throw new ExceptionLogin("Erreur de login");
		case LOGIN:
			switch (permission) {
			case REFEREE:
				Controler.getInstance().setMenu(TypesMenu.REFEREE);
				break;
			case STABLE:
				Controler.getInstance().setMenu(TypesMenu.STABLE);
				break;
			case PLAYER:
				Controler.getInstance().setMenu(TypesMenu.PLAYER);
				break;
			case ORGANIZER:
				Controler.getInstance().setMenu(TypesMenu.ORGANIZER);
				break;
			case VISITOR:
				Controler.getInstance().setMenu(TypesMenu.VISITOR);
				break;
			default:
				break;

			}
			break;
		default:
			break;
		}
	}

	public void logout() {
		setInfo(null);
		setPermission(TypesPermission.VISITOR);
		com.logout();
	}

	public WaitingFor getWaiting() {
		return waiting;
	}

	public Types getInfo() {
		return info;
	}

	public void setInfo(Types info) {
		this.info = info;
	}

	public int voirInfosEcurie() {
		return -1;
	}

	public void registerTournament(int id) throws ExceptionInvalidPermission {
		if (permission != TypesPermission.PLAYER) {
			throw new ExceptionInvalidPermission("Vous n'avez pas la permission de faire cette action");
		}
		com.registerTournament(id);
	}

	public void unregisterTournament(int idTournament, int idGame) throws ExceptionInvalidPermission {
		if (permission != TypesPermission.PLAYER) {
			throw new ExceptionInvalidPermission("Vous n'avez pas la permission de faire cette action");
		}
		com.unregisterTournament(idTournament, idGame);
	}

	public void addTeam(TypesRegisterTeam team) {
		if (permission != TypesPermission.STABLE) {
			Controler.getInstance()
					.fireError(new ExceptionInvalidPermission("Vous n'avez pas la permission de faire cette action"));
		} else {
			com.addTeam(team);
		}
	}

	public void modifyTeam(TypesTeam team) {
		if (permission != TypesPermission.STABLE) {
			Controler.getInstance()
					.fireError(new ExceptionInvalidPermission("Vous n'avez pas la permission de faire cette action"));
		} else {
			com.modifyTeam(team);
		}
	}
	
	public void changeScore(TypesMatch match, int idTournament, int idPool) {
		com.changeScore(match,idTournament,idPool);
	}

	public void deleteTournament(TypesTournament tournament) {
		com.deleteTournament(tournament.getId());
	}

	public void addTournament(TypesTournament t) throws ExceptionInvalidPermission {
		if (permission != TypesPermission.ORGANIZER) {
			throw new ExceptionInvalidPermission("Vous n'avez pas la permission de faire cette action");
		}
		com.addTournament(t);
	}

	public void modifyTournament(TypesTournament t) throws ExceptionInvalidPermission {
		if (permission != TypesPermission.ORGANIZER) {
			throw new ExceptionInvalidPermission("Vous n'avez pas la permission de faire cette action");

		}
		com.modifyTournament(t);
	}

}
