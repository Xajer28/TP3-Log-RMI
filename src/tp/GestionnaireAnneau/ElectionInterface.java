package tp.GestionnaireAnneau;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ElectionInterface extends Remote {

	public void elire() throws RemoteException;
	
}
