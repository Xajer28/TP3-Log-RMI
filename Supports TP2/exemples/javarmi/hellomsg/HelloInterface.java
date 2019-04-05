package exemples.javarmi.hellomsg;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * 
 * @author Toto
 * @version 1.0
 */
public interface HelloInterface extends Remote
{
	public void afficher(String chaine) throws RemoteException;
	public Message getDernierMessage() throws RemoteException;
}
