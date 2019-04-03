package exemples.javarmi.hellomsg;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;


/**
 * 
 * @author Toto
 * @version 1.0
 */
public class HelloServer {
	
	public static void main(String args[])
	{
		System.setSecurityManager (new RMISecurityManager ()); 
		
		HelloImpl obj;
		try {
			obj = new HelloImpl();
			//Enregistrer cet objet dans l'annuaire Java RMI.
			Naming.rebind("UnHello", obj);
			
			System.out.println("Server: OK");
		} 
		catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

