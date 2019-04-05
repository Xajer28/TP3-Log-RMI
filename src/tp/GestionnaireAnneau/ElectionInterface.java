package tp.GestionnaireAnneau;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ElectionInterface extends Remote {

	public void elire(Liste liste) throws RemoteException;
	public void coordinateur(Liste liste, int idmax) throws RemoteException;

}
