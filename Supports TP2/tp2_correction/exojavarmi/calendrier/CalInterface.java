package exojavarmi.calendrier;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalInterface extends Remote {
	public Boolean estLibre(int jour) throws RemoteException;
	public Boolean libere(int jour) throws RemoteException;
	public Boolean occupe(int jour) throws RemoteException;
}

