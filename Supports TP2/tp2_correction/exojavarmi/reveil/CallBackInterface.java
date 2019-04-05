package exojavarmi.reveil;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Applications reparties
 * TP - Exercice
 * 
 * Interface CallBackInterface
 * (cote du client)
 * 
 * Declaration de la methode que l'objet serveur pourra rappeller au niveau du client
 * 
 * @author Toto
 * @version 1.0
 */
public interface CallBackInterface extends Remote {
	
	/**
	 * 
	 * @param message Message a afficher
	 * @throws RemoteException
	 */
	public void doCallBack(String message) throws RemoteException;	
	
}
