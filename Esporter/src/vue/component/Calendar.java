package vue.component;

import java.sql.Date;
import java.sql.Timestamp;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import types.TypesGame;

public interface Calendar {
 
	
	public JTextField getTxtDate();
	
	public TypesGame getGame();
	
	public Timestamp getChosenDate();
	
	public JComboBox<TypesGame> getComboBoxFilterGame();
	
	public void setGame(TypesGame game);
	
	public void setChosenDate(Timestamp chosenDate);
	
	public RendererCalendar getRenderer(int id); 
	public void createListTournament(Timestamp date, TypesGame jeu);
}
