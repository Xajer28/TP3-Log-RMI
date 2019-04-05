package exemples.javarmi.appelsretour;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IServer extends Remote {
	public void callMeBack(int time, String param, ICallback callback) throws RemoteException ;
} 
