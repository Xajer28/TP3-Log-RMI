package exemples.javarmi.hellomsg;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;


/**
 * 
 * @author Toto
 * @version 1.0
 */
public class HelloClient {
	public static void main (String[] args) throws Exception
	{
		System.setSecurityManager (new RMISecurityManager ()) ; 
		
		//Obtenir la souche sur l'objet distant via l'annuaire Java	RMI.
		HelloInterface helloDistant = (HelloInterface) Naming.lookup("rmi://localhost/UnHello");
		helloDistant.afficher("Hello World!");
		Message message = helloDistant.getDernierMessage();
		System.out.println("Client: "+message);
	}
}
