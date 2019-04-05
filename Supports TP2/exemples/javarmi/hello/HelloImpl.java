package exemples.javarmi.hello;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class HelloImpl extends UnicastRemoteObject implements HelloInterface {

	private static final long serialVersionUID = 6586708515447619453L;

	private String message;

	// Il faut indiquer RemoteException au niveau du constructeur
	public HelloImpl (String s) throws RemoteException {
		message = s; 
	}

	public String sayHello () throws RemoteException {
		return message ;
	}

}
