package exemples.javarmi.annuairefactory;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface FabAnnuaireInterface extends Remote  {
	public AnnuaireInterface newAnnuaire(String titre) throws RemoteException ;   
}

