package exemples.javarmi.annuairefactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class FabAnnuaire extends UnicastRemoteObject implements FabAnnuaireInterface {

	private static final long serialVersionUID = -4633918571942437445L;

	public FabAnnuaire() throws RemoteException {
	}

	public AnnuaireInterface newAnnuaire(String titre) throws RemoteException {
		return  new Annuaire(titre); 
	}

}

