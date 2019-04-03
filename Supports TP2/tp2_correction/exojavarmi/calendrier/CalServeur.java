package exojavarmi.calendrier;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class CalServeur extends UnicastRemoteObject implements CalServeurInterface{
	
	private static final long serialVersionUID = 7272777485104201724L;

	HashMap<String, Cal> lesCals;
	
	public CalServeur() throws RemoteException {
		super();
		lesCals = new HashMap<String, Cal>();
	}
	
	public CalInterface createCal(String nom) throws RemoteException {
		Cal unCal = new Cal(nom);
		lesCals.put(nom, unCal);
		return unCal;
	}

	public Boolean intersectionLibre(String[] noms, int jour) throws RemoteException {
		boolean res = true;
		for(int i=0; i<noms.length; i++)
			res &= lesCals.get(noms[i]).estLibre(jour);
		return res;
	}
	
	public void reserve(String[] noms, int jour) throws RemoteException, ReservImpossible {
		if(intersectionLibre(noms, jour)) { 
			for(int i=0; i<noms.length; i++)
				lesCals.get(noms[i]).occupe(jour);
		}
	}
	// ATTENTION : dans cette version, il y a des problemes (concurrence, ...)
	
}

