package exemples.javarmi.hellomsg;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/**
 * 
 * @author Toto
 * @version 1.0
 */
public class HelloImpl extends UnicastRemoteObject implements HelloInterface
{
	private static final long serialVersionUID = 8099712235228394474L;
	
	protected Message leDernierMessage;

	public HelloImpl() throws RemoteException
	{
		//Appel du constructeur java.rmi.server.UnicastRemoteObject.
		//Peut soulever l'exception java.rmi.RemoteException.
		super();
		leDernierMessage = new Message("");
	}

	public void afficher(String chaine) throws RemoteException
	{
		System.out.println("Invocation de HelloImpl.afficher(chaine="
				+ chaine +")");
		leDernierMessage = new Message( chaine);
	}

	public Message getDernierMessage() throws RemoteException
	{
		System.out.println("Invocation de HelloImpl.getDernierMessage()");
		return leDernierMessage;
	}

}
