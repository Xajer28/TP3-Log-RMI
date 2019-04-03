package exemples.javarmi.appelsretour;

import java.rmi.RemoteException;


public class Servant extends Thread {
	
	private int time ;
	private String param ;
	private ICallback callback ;
	
	public Servant(int time, String param, ICallback callback) {
		this.time = time ;
		this.param = param ;
		this.callback = callback ; }
	
	public void run() { /* thread separe */
		try { /* Action du serveur */
			Thread.sleep(1000*time) ;
		} catch(InterruptedException e) { }
		try {
			callback.doCallback(param) ;
		} catch(RemoteException e) { System.err.println("Echec : "+e) ; }
		callback = null ; /* nettoyage */
		System.gc() ;
	}

}
