package anneauexclurmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.Semaphore;

/**
 * Exclusion mutuelle sur un anneau a jeton
 * 
 * Classe de l'objet serveur au niveau d'un site
 * Gere le jeton
 * 
 * @author nicolas
 *
 */
public class SiteImpl extends UnicastRemoteObject implements SiteInterface {

	private static final long serialVersionUID = -869416918176853L;

	int numerosite;
	SiteInterface objsuccesseur;
	
	GestionJeton gestionjeton;
	Semaphore alejeton;
	Jeton lejeton;
	

	public SiteImpl(int numero, GestionJeton gestionjeton, Semaphore alejeton) throws RemoteException {	
		super();
		this.numerosite = numero;
		this.gestionjeton = gestionjeton;
		this.alejeton = alejeton;
	}


	public void envoyer(Jeton lejeton) throws RemoteException {
		lejeton.incremente();
		gestionjeton.lejeton = lejeton;
		alejeton.release();
	}

}
