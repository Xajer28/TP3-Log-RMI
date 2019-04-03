package anneauexclurmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Exclusion mutuelle sur un anneau a jeton
 * 
 * Interface distante de l'objet serveur au niveau d'un site
 * (pour la gestion du jeton)
 * 
 * @author nicolas
 *
 */
public interface SiteInterface extends Remote {
	
	public void envoyer(Jeton lejeton) throws RemoteException;
	
}
