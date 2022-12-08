package types;


import ihm.Calendar;
import ihm.Ranking;
import ihm.Stables;
import ihm.component.MenuButton;

public enum TypesMenu {
	
	
	VISITOR(new MenuButton[] {new MenuButton(true, "Accueil",  ihm.visitor.Home.class, null),
								new MenuButton(false, "Calendrier", ihm.Calendar.class, TypesPermission.VISITOR),
								new MenuButton(false, "Classement",  ihm.Ranking.class, null),
								new MenuButton(false, "Ecuries",  ihm.Stables.class, null)}),
	
	STABLE(new MenuButton[] {	new MenuButton(true, "Accueil",  ihm.stable.Home.class, null),
								new MenuButton(false, "Calendrier",  ihm.Calendar.class, TypesPermission.STABLE),
								new MenuButton(false, "Classement",  ihm.Ranking.class, null),
								new MenuButton(false, "Ecuries",  ihm.Stables.class, null),
								new MenuButton(false, "Gestion des equipes",  ihm.stable.TeamManagement.class, null)}),
	
	PLAYER(new MenuButton[] {	new MenuButton(true, "Accueil",  ihm.player.Home.class, null),
								new MenuButton(false, "Calendrier",  ihm.Calendar.class, TypesPermission.PLAYER),
								new MenuButton(false, "Classement",  ihm.Ranking.class, null),
								new MenuButton(false, "Ecuries",  ihm.Stables.class, null)}),
	
	ORGANIZER(new MenuButton[] {new MenuButton(true, "Accueil",  ihm.organizer.Home.class, null),
									new MenuButton(false, "Calendrier",  ihm.organizer.Calendar.class, null),
									new MenuButton(false, "Classement",   ihm.Ranking.class, null),
									new MenuButton(false, "Ecuries",   ihm.Stables.class, null)}),
	
	REFEREE(new MenuButton[] {	new MenuButton(true, "Accueil",   ihm.visitor.Home.class, null),
								new MenuButton(false, "Calendrier",   ihm.Calendar.class, TypesPermission.REFEREE),
								new MenuButton(false, "Classement",   ihm.Ranking.class, null),
								new MenuButton(false, "Ecuries",   ihm.Stables.class, null)});	
	
	private MenuButton[] menu;
	
	
	private TypesMenu(MenuButton[] menu) {
		this.menu = menu;
	}
	
	public MenuButton[] getMenu() {
		return menu;
	}
}
