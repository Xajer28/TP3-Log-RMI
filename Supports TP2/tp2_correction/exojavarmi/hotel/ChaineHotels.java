package exojavarmi.hotel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;


/**
 * Applications reparties
 * TP - Exercice 
 * Chaine d'hotels
 * 
 * Classe d'un futur objet serveur (servant) de l'application chaine d'hotels
 * 
 * @author Toto
 * @version 1.0
 */
public class ChaineHotels extends UnicastRemoteObject implements ChaineHotelsInterface {

	private static final long serialVersionUID = -2066714609302506667L;
	
	HashMap<Integer, Infos> lesReservations = null;
	Integer numLibre;
	
	public ChaineHotels() throws RemoteException {
		this.lesReservations = new HashMap<Integer, Infos>();
		this.numLibre = 0;
	}

	public void annuler(int numReservation) throws RemoteException, ExceptionNumReservation {
		if(this.lesReservations.containsKey(new Integer(numReservation))==false) 
			throw new ExceptionNumReservation();
		else this.lesReservations.remove(new Integer(numReservation));
	}

	public Infos lister(int numReservation) throws RemoteException, ExceptionNumReservation {
		if(this.lesReservations.containsKey(new Integer(numReservation))==false) 
			throw new ExceptionNumReservation();
		else return this.lesReservations.get(new Integer(numReservation));
	}

	public synchronized int reserver(String nomClient, String nomHotel, String date, int nbchambres) throws RemoteException, ExceptionChambresIndispo {
		//TODO verifier que les chambres sont disponibles...
		Infos infos = new Infos(nomClient, nomHotel, date, nbchambres);
		this.numLibre++;
		if(this.lesReservations.put(new Integer(this.numLibre), infos) == null) return 0;
		else return this.lesReservations.size();
	}
	
}

