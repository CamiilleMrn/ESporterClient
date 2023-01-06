package vue.component;

import java.sql.Date;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import types.TypesGame;

public interface Calendar {
 
	
	public JTextField getTxtDate();
	
	public TypesGame getGame();
	
	public Date getChosenDate();
	
	public JComboBox<TypesGame> getComboBoxFilterGame();
	
	public void setGame(TypesGame game);
	
	public void setChosenDate(Date chosenDate);
	
	public RendererCalendar getRenderer(int id); 
	public void createListTournament(Date date, TypesGame jeu);
}
