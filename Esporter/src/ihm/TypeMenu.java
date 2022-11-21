package ihm;


import ihm.component.boutonMenu;
import types.Permission;

public enum TypeMenu {
	
	
	Visiteurs(new boutonMenu[] {new boutonMenu(true, "Accueil",  ihm.visiteur.Accueil.class, null),
								new boutonMenu(false, "Calendrier", ihm.Calendrier.class, Permission.VISITEUR),
								new boutonMenu(false, "Classement",  ihm.Classement.class, null),
								new boutonMenu(false, "Ecuries",  ihm.Ecuries.class, null)}),
	
	Ecuries(new boutonMenu[] {	new boutonMenu(true, "Accueil",  ihm.ecurie.Accueil.class, null),
								new boutonMenu(false, "Calendrier",  ihm.Calendrier.class, Permission.ECURIE),
								new boutonMenu(false, "Classement",  ihm.Classement.class, null),
								new boutonMenu(false, "Ecuries",  ihm.Ecuries.class, null),
								new boutonMenu(false, "Gestion des equipes",  ihm.ecurie.GestionEquipe.class, null)}),
	
	Joueurs(new boutonMenu[] {	new boutonMenu(true, "Accueil",  ihm.joueur.Accueil.class, null),
								new boutonMenu(false, "Calendrier",  ihm.Calendrier.class, Permission.JOUEUR),
								new boutonMenu(false, "Classement",  ihm.Classement.class, null),
								new boutonMenu(false, "Ecuries",  ihm.Ecuries.class, null)}),
	
	Organisateurs(new boutonMenu[] {new boutonMenu(true, "Accueil",  ihm.organisateur.Accueil.class, null),
									new boutonMenu(false, "Calendrier",  ihm.organisateur.Calendrier.class, null),
									new boutonMenu(false, "Classement",   ihm.Classement.class, null),
									new boutonMenu(false, "Ecuries",   ihm.Ecuries.class, null)}),
	
	Arbitres(new boutonMenu[] {	new boutonMenu(true, "Accueil",   ihm.visiteur.Accueil.class, null),
								new boutonMenu(false, "Calendrier",   ihm.Calendrier.class, Permission.ARBITRE),
								new boutonMenu(false, "Classement",   ihm.Classement.class, null),
								new boutonMenu(false, "Ecuries",   ihm.Ecuries.class, null)});	
	
	private boutonMenu[] menu;
	
	
	private TypeMenu(boutonMenu[] menu) {
		this.menu = menu;
	}
	
	public boutonMenu[] getMenu() {
		return menu;
	}
}
