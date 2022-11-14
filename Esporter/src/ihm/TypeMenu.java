package ihm;


import ihm.component.boutonMenu;

public enum TypeMenu {
	
	
	Visiteurs(new boutonMenu[] {new boutonMenu(true, "Accueil",  new ihm.visiteur.Accueil()),
								new boutonMenu(false, "Calendrier", new ihm.visiteur.Calendrier()),
								new boutonMenu(false, "Classement",  new ihm.Classement()),
								new boutonMenu(false, "Ecuries",  new ihm.Ecuries())}),
	
	Ecuries(new boutonMenu[] {	new boutonMenu(true, "Accueil",  new ihm.ecurie.Accueil()),
								new boutonMenu(false, "Calendrier",  new ihm.ecurie.Calendrier()),
								new boutonMenu(false, "Classement",  new ihm.Classement()),
								new boutonMenu(false, "Ecuries",  new ihm.Ecuries()),
								new boutonMenu(false, "Gestion des equipes",  new ihm.ecurie.GestionEquipe())}),
	
	Joueurs(new boutonMenu[] {	new boutonMenu(true, "Accueil",  new ihm.joueur.Accueil()),
								new boutonMenu(false, "Calendrier",  new ihm.joueur.Calendrier()),
								new boutonMenu(false, "Classement",  new ihm.Classement()),
								new boutonMenu(false, "Ecuries",  new ihm.Ecuries())}),
	
	Organisateurs(new boutonMenu[] {new boutonMenu(true, "Accueil",  new ihm.organisateur.Accueil()),
									new boutonMenu(false, "Calendrier",  new ihm.organisateur.Calendrier()),
									new boutonMenu(false, "Classement",  new ihm.Classement()),
									new boutonMenu(false, "Ecuries",  new ihm.Ecuries())}),
	
	Arbitres(new boutonMenu[] {	new boutonMenu(true, "Accueil",  new ihm.visiteur.Accueil()),
								new boutonMenu(false, "Calendrier",  new ihm.visiteur.Calendrier()),
								new boutonMenu(false, "Classement",  new ihm.Classement()),
								new boutonMenu(false, "Ecuries",  new ihm.Ecuries())});	
	
	private boutonMenu[] menu;
	
	
	private TypeMenu(boutonMenu[] menu) {
		this.menu = menu;
	}
	
	public boutonMenu[] getMenu() {
		return menu;
	}
}
