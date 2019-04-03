package exemples.javarmi.appelsretour;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ICallback extends Remote {
	public void doCallback(String message) throws RemoteException ;
}
