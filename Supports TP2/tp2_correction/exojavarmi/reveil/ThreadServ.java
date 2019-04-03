package exojavarmi.reveil;

import java.rmi.RemoteException;

public class ThreadServ extends Thread {

	private int nbsec;
	private CallBackInterface callback;

	public ThreadServ(int nbsec, CallBackInterface callback) {
		this.nbsec = nbsec;
		this.callback = callback;
	}

	public void run() { 
		try {
			Thread.sleep(1000*nbsec);
			callback.doCallBack("Debout !");
		} catch(InterruptedException e) { 
			System.err.println("Serveur : erreur\n"+e.getMessage());
		} catch (RemoteException re) {
			System.err.println("Serveur : erreur\n"+re.getMessage());
			re.printStackTrace();
		}
		callback = null ; /* nettoyage */
		System.gc();
	} 
}
