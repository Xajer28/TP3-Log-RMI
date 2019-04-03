package exemples.javarmi.annuairefactory;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface AnnuaireInterface extends Remote  {
	
	public String titre = "";
	
	public boolean inserer(String nom, Information info) throws RemoteException, ExisteDeja ;
	
	public boolean supprimer(String nom) throws RemoteException, PasTrouve ;
	
	public Information rechercher(String nom) throws RemoteException, PasTrouve ; 
	
}

