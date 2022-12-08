package types;


import vue.Calendar;
import vue.Ranking;
import vue.Stables;
import vue.component.MenuButton;

public enum TypesMenu {
	
	
	VISITOR(new MenuButton[] {new MenuButton(true, "Accueil",  vue.visitor.Home.class, null),
								new MenuButton(false, "Calendrier", vue.Calendar.class, TypesPermission.VISITOR),
								new MenuButton(false, "Classement",  vue.Ranking.class, null),
								new MenuButton(false, "Ecuries",  vue.Stables.class, null)}),
	
	STABLE(new MenuButton[] {	new MenuButton(true, "Accueil",  vue.stable.Home.class, null),
								new MenuButton(false, "Calendrier",  vue.Calendar.class, TypesPermission.STABLE),
								new MenuButton(false, "Classement",  vue.Ranking.class, null),
								new MenuButton(false, "Ecuries",  vue.Stables.class, null),
								new MenuButton(false, "Gestion des equipes",  vue.stable.TeamManagement.class, null)}),
	
	PLAYER(new MenuButton[] {	new MenuButton(true, "Accueil",  vue.player.Home.class, null),
								new MenuButton(false, "Calendrier",  vue.Calendar.class, TypesPermission.PLAYER),
								new MenuButton(false, "Classement",  vue.Ranking.class, null),
								new MenuButton(false, "Ecuries",  vue.Stables.class, null)}),
	
	ORGANIZER(new MenuButton[] {new MenuButton(true, "Accueil",  vue.organizer.Home.class, null),
									new MenuButton(false, "Calendrier",  vue.organizer.Calendar.class, null),
									new MenuButton(false, "Classement",   vue.Ranking.class, null),
									new MenuButton(false, "Ecuries",   vue.Stables.class, null)}),
	
	REFEREE(new MenuButton[] {	new MenuButton(true, "Accueil",   vue.visitor.Home.class, null),
								new MenuButton(false, "Calendrier",   vue.Calendar.class, TypesPermission.REFEREE),
								new MenuButton(false, "Classement",   vue.Ranking.class, null),
								new MenuButton(false, "Ecuries",   vue.Stables.class, null)});	
	
	private MenuButton[] menu;
	
	
	private TypesMenu(MenuButton[] menu) {
		this.menu = menu;
	}
	
	public MenuButton[] getMenu() {
		return menu;
	}
}
