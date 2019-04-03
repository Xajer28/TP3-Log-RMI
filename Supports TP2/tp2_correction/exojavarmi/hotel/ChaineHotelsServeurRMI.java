package exojavarmi.hotel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

/**
 * Applications reparties
 * TP - Exercice
 * Chaine d'hotels
 * 
 * Programme serveur RMI
 * 
 * @author Toto
 * @version 1.0
 */
public class ChaineHotelsServeurRMI {


	private static int DEFAULT_REGISTRY_PORT = 1099;


	/**
	 * Constructeur par defaut
	 */
	public ChaineHotelsServeurRMI() {
	}


	/**
	 * Programme principal
	 * args[0] Port du registre rmi
	 */
	public static void main(String[] args) {
		ChaineHotels hotels;
		int port = -1;

		if(args.length != 1) {
			System.out.println("Usage: java tp2corrige.hotel.ChaineHotelServeurRMI Port");
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
			hotels = new ChaineHotels();
			System.setSecurityManager(new RMISecurityManager()); 
			Naming.rebind("rmi://localhost:"+port+"/ChaineH", hotels);
			System.out.println("Serveur : OK");
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
