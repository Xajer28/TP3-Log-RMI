package tp.GestionnaireAnneau;

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
public interface AnneauInterface extends Remote {


	public Donnees recupInfos(String adrIp) throws RemoteException;

}
