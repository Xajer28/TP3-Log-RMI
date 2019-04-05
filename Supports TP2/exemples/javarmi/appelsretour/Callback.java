package exemples.javarmi.appelsretour;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Callback extends UnicastRemoteObject implements ICallback {

	private static final long serialVersionUID = -6568328667061586483L;

	public Callback() throws RemoteException {
		super() ;
	}

	public void doCallback(String message) throws RemoteException {
		System.out.println(message) ;
	}
	
}
