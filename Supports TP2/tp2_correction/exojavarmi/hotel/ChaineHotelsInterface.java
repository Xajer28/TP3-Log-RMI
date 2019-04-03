package exojavarmi.hotel;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * Applications reparties
 * TP - Exercice
 * Chaine d'hotels
 * 
 * Interface de la chaine d'hotel
 * 
 * @author Toto
 * @version 1.0
 */
public interface ChaineHotelsInterface extends Remote {

	public int reserver(String nomClient, String nomHotel, String date, int nbchambres) throws RemoteException, ExceptionChambresIndispo;
	
	public void annuler(int numReservation)	throws RemoteException, ExceptionNumReservation;
	
	public Infos lister(int numReservation)	throws RemoteException, ExceptionNumReservation;
	
}
