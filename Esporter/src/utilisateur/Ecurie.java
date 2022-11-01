package utilisateur;


import types.EcurieInfo;
import types.EquipeInfo;
import types.JoueurInfo;
import types.Permission;
import types.exception.InvalidPermission;

public class Ecurie extends User{

	private EcurieInfo info;

	public Ecurie(Permission permission, EcurieInfo info) throws InvalidPermission{
		super(permission);
		if (permission != Permission.ECURIE) {
			throw new InvalidPermission("Vous ne possedez pas les permissions pour faire ceci");
		}
		this.info = info;
	}
	
	public EcurieInfo getInfo() {
		return info;
	}

	
	@Override
	public int makeConnection() {
		return -1;
	}
	
	public int AjouterEquipe(EquipeInfo equipe)  {
		return -1;
	}
	
	public int AjouterJoueur(JoueurInfo joueur)  {
		return -1;
	}
	
	
}
