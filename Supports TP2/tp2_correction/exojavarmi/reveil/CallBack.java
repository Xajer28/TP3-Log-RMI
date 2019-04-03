package exojavarmi.reveil;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Applications reparties
 * TP - Exercice
 * 
 * Classe CallBack (implemente interface CallBackInterface)
 * (cote du client)
 * 
 * Definition de la methode que l'objet serveur pourra rappeller sur le client
 * 
 * @author Toto
 * @version 1.0
 */
public class CallBack extends UnicastRemoteObject implements CallBackInterface {

	private static final long serialVersionUID = -775598153293533520L;

	public Object obj;

	/**
	 * Constructeur
	 * @param lock
	 * @throws RemoteException
	 */
	public CallBack(Object obj) throws RemoteException {
		super();
		this.obj = obj;
	}

	/**
	 * Methode qui peut etre appellee par l'objet serveur
	 * @param message Message a afficher
	 * @throws RemoteException
	 */
	public void doCallBack(String message) throws RemoteException {
		synchronized(obj) {
			obj.notify(); // reveil, sortie de l'attente
		}
		System.out.println(message);
	}

}
