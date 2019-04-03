package exojavarmi.calendrier;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Cal extends UnicastRemoteObject implements CalInterface {
	
	private static final long serialVersionUID = -4431774123905065233L;
	
	String nom;
	Boolean[] jourLibre;
	int nbjours = 365;
	
	public Cal() throws RemoteException {
		super();
		initialisation();
	}
	
	public Cal(String nom) throws RemoteException {
		this.nom = nom;
		initialisation();
	}
	
	private void initialisation() {
		this.jourLibre = new Boolean[this.nbjours+1];
		for(int i=0; i<=this.nbjours; i++)
			jourLibre[i]= true;
	}
	
	public Boolean estLibre(int jour) throws RemoteException {
		return jourLibre[jour];
	}

	public Boolean libere(int jour) throws RemoteException {
		return (jourLibre[jour] = true);
	}

	public Boolean occupe(int jour) throws RemoteException {
		return (jourLibre[jour] = false);
	}

}

