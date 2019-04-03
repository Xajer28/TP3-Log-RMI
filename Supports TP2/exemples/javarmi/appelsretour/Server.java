package exemples.javarmi.appelsretour;

import java.rmi.RMISecurityManager;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Server extends UnicastRemoteObject implements IServer {

	private static final long serialVersionUID = -6065504281058240409L;

	
	public Server() throws RemoteException {
		super();   
	}

	public static void main(String[ ] args) throws Exception {
		try {
			System.setSecurityManager (new RMISecurityManager());
			Naming.rebind("Server", new Server()) ;
			System.out.println("Serveur pret"); 
		} 
		catch (Exception e) {
			System.out.println("Erreur serveur : " + e) ;
		}  
	}

	public void callMeBack(int time, String param, ICallback callback) throws RemoteException {
		Servant servant = new Servant(time, param, callback) ;
		servant.start();   
	}
}

