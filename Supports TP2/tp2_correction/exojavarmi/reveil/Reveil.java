package exojavarmi.reveil;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Applications reparties
 * TP - Exercice
 * 
 * Classe Reveil (implemente interface ReveilInterface)
 * (cote du serveur)
 * 
 * @author Toto
 * @version 1.0
 */
public class Reveil extends UnicastRemoteObject implements ReveilInterface {

	private static final long serialVersionUID = -846516002060206656L;

	/**
	 * Constructeur
	 * @throws RemoteException
	 */
	public Reveil() throws RemoteException {
		super();
	}
	
	/**
	 * 
	 * @param nbsec Nombre de secondes
	 * @param callback Reference distante de l'objet a rappeler cote client
	 * @throws RemoteException
	 */
	public void reveilleMoi(int nbsec, CallBackInterface callback) throws RemoteException {
		ThreadServ th = new ThreadServ(nbsec, callback);
		th.start();
	}
	
}
