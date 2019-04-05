package exojavarmi.reveil;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Applications reparties
 * TP - Exercice
 * 
 * Interface ReveilInterface
 * (du cote du serveur)
 * 
 * @author Toto
 * @version 1.0
 */
public interface ReveilInterface extends Remote {
	
	/**
	 * 
	 * @param time Nombre de secondes
	 * @param callback Reference distante de l'objet a rappeler cote client
	 * @throws RemoteException
	 */
	public void reveilleMoi(int nbsec, CallBackInterface callback) throws RemoteException;

 }
