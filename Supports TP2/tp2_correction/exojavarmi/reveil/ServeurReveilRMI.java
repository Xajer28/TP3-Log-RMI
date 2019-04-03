package exojavarmi.reveil;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

/**
 * Applications reparties
 * TP - Exercice
 * 
 * Reveil
 * 
 * Programme serveur RMI
 * 
 * @author Toto
 * @version 1.0
 */
public class ServeurReveilRMI {

	private static int DEFAULT_REGISTRY_PORT = 1099;

	/**
	 * Programme principal
	 * args[0] Port du registre rmi
	 */
	public static void main(String[] args) throws Exception {
		int port = -1;

		if(args.length != 1) {
			System.out.println("Usage: java tp2corrige.reveil.ServeurReveilRMI Port");
			System.out.println("Utilisation du port par defaut ("+DEFAULT_REGISTRY_PORT+")");
			port = DEFAULT_REGISTRY_PORT;
		}
		else { 
			try {
				port = Integer.parseInt(args[0]);
			}
			catch(NumberFormatException nfe) {
				nfe.printStackTrace();
				System.exit(1);
			}
		}

		try {
			System.setSecurityManager(new RMISecurityManager());
			Naming.rebind("rmi://localhost:"+port+"/Reveil", new Reveil());			
			System.out.println("Serveur pret.");
		}
		catch (RemoteException e) {
			System.err.println("Serveur : erreur\n"+e.getMessage());
			e.printStackTrace();
		} 
		catch (MalformedURLException e) {
			System.err.println("Serveur : erreur\n"+e.getMessage());
			e.printStackTrace();
		}

	}

}
