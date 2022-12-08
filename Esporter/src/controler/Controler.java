package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.UnknownHostException;

import model.data.Data;
import model.utilisateur.User;
import vue.MasterFrame;

public class Controler implements ActionListener, MouseListener{

	private static Controler instance;
	private User user;
	private Data data;
	private State state;
	
	
	private Controler(){
		try {
			user = new User();
		} catch (UnknownHostException e) {
			MasterFrame.getInstance().fireError(e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Controler getInstance() {
		if (instance==null)
			instance = new Controler();
		return instance;
	}
	
	public Data getData() {
		return data;
	}
	
	public User getUser() {
		return user;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().contains("menu")) {
			//BOUTON DU MENU
		} else {
			switch(state) {
			case ADD_PLAYER:
				break;
			case ADD_TEAM:
				break;
			case CALENDAR_ORGANIZER:
				break;
			case CALENDAR_PLAYER:
				break;
			case CALENDAR_REFEREE:
				break;
			case CALENDAR_STANDARD:
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
				break;
			case MODIFY_TEAM:
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
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

}
