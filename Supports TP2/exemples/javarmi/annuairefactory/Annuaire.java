package exemples.javarmi.annuairefactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;


public class Annuaire extends UnicastRemoteObject implements AnnuaireInterface {

	private static final long serialVersionUID = -5741376232001998132L;

	private String letitre ;

	private HashMap<String, Information> table;
	
	
	public Annuaire(String titre) throws RemoteException { 
		this.letitre=titre;
		table = new HashMap<String, Information>();
		System.out.println("Creation de : Annuaire "+this.letitre);
	}

	public String titre( ) { 
		return letitre; 
	}

	public boolean inserer(String nom, Information info) throws RemoteException, ExisteDeja {
		table.put(nom, info);
		System.out.println("Annuaire "+this.letitre+" : insertion de "+nom+", "+info.toString());
		return true;
	}

	public boolean supprimer(String nom) throws RemoteException, PasTrouve {
		return false;
	}

	public Information rechercher(String nom) throws RemoteException, PasTrouve {
		return null;
	}
	
}
