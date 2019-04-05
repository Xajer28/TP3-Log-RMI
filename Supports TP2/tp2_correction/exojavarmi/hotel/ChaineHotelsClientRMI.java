package exojavarmi.hotel;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;


/**
 * Applications reparties
 * TP - Exercice
 * Chaine d'hotels
 * 
 * Programme client RMI
 * 
 * @author Toto
 * @version 1.0
 */
public class ChaineHotelsClientRMI {


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
	public static void main(String[] args) {
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

			ChaineHotelsInterface chaine = (ChaineHotelsInterface) Naming.lookup("rmi://"+server+":"+port+"/ChaineH");

			chaine.reserver("toto", "hotelNum1", "27/04/2011", 1);

			Infos inf = chaine.lister(1);
			System.out.println(inf.toString());
			
			chaine.annuler(1);
			
			inf = chaine.lister(1);

		} catch (ExceptionChambresIndispo ec) {
			System.err.println("Erreur : "+ec);
		} catch (ExceptionNumReservation en) {
			System.err.println("Erreur : "+en);
		} catch (IOException ioe) { 
			System.err.println("Erreur : "+ioe);
			ioe.printStackTrace();
		} catch (NotBoundException nbe) {
			System.err.println("Erreur : "+nbe);
			nbe.printStackTrace();
		}
	}

}
