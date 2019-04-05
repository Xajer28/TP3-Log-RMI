package exojavarmi.reveil;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;

/**
 * Applications reparties
 * TP - Exercice
 * 
 * Reveil
 * 
 * Programme client RMI
 * 
 * @author Toto
 * @version 1.0
 */
public class ClientReveilRMI {

	/**
	 * Nom par dsfaut de la machine ou tourne le registre RMI
	 */
	private static String DEFAULT_HOST = "localhost";

	/**
	 * Port par defaut du registre RMI distant
	 */
	private static int DEFAULT_REGISTRY_PORT = 1099;


	/**
	 * Programme principal (les arguments sont optionnels)
	 * @param args[0] Nom du serveur
	 * @param args[1] Port du serveur
	 */
	public static void main (String args []) {
		String server = null;
		int port = -1;

		if(args.length != 2) {
			System.out.println("Usage: java tp2corrige.hotel.ChaineHotelsClientRMI NomServeur PortServeur");
			System.out.println("Utilisation du nom de serveur et du port par defaut ("+DEFAULT_HOST+":"+DEFAULT_REGISTRY_PORT+")");
			server = DEFAULT_HOST;
			port = DEFAULT_REGISTRY_PORT;
		}
		else {
			try {
				server = args[0];
				port = Integer.parseInt(args[1]);
			}
			catch(NumberFormatException nfe) {
				nfe.printStackTrace();
				System.exit(1);
			}
		}

		try {
			System.setSecurityManager(new RMISecurityManager()); 
			ReveilInterface r = (ReveilInterface) Naming.lookup("rmi://"+server+":"+port+"/Reveil");

			Object obj = new Object(); // creation d'un objet simple pour utiliser son moniteur
			CallBack callback = new CallBack(obj);
			
			r.reveilleMoi(5,callback); // demande a l'objet serveur r de rappeller le client avec la methode "reveilleMoi"
			
			System.out.println("Je vais dormir pendant 5 secondes...");
			synchronized (obj) {
				obj.wait(); // mise en attente (on utilise la file d'attente du moniteur de l'objet obj)
			}
			
			System.out.println("Je suis reveille.");
			
			System.exit(1);
			
		} catch (IOException ioe) { 
			System.err.println("Erreur : "+ioe);
			ioe.printStackTrace();
		} catch (NotBoundException nbe) {
			System.err.println("Erreur : "+nbe);
			nbe.printStackTrace();
		} catch (InterruptedException ie) {
			System.err.println("Erreur : "+ie);
			ie.printStackTrace();
		}

	}

} 
