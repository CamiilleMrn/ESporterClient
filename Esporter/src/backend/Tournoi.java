package backend;

import types.TypesTeam;
import types.TypesTournament;
import types.exception.ExceptionInvalidPermission;
import types.exception.ExceptionTournamentFull;
import vue.MasterFrame;

public class Tournoi {

	public static void inscrire(TypesTournament tournoi) throws ExceptionTournamentFull, ExceptionInvalidPermission{
		if (tournoi.getRegistered().size()>=16) {
			throw new ExceptionTournamentFull("Le tournoi est plein");
		}
		MasterFrame.getInstance().getUser().registerTournament(tournoi.getId());
		
	}
}
