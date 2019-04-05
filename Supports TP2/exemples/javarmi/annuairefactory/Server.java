package exemples.javarmi.annuairefactory;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;


public class Server {
	public static void main (String [ ] argv) {
		
		System.setSecurityManager (new RMISecurityManager ()); 
		
		try {
			Naming.rebind("Fabrique", new FabAnnuaire()) ;
			System.out.println ("Serveur pret.") ;
		} catch (Exception e) {
			System.out.println("Erreur serveur : " + e) ;
		}
	}
}

