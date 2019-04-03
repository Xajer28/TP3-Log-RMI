package anneauexclurmi;

import java.rmi.RemoteException;
import java.util.concurrent.Semaphore;

/**
 * Exclusion mutuelle sur un anneau a jeton
 * 
 * Classe du thread charge de faire les actions lorsque le jeton est recu au niveau du site
 * 
 * @author nicolas
 *
 */
public class GestionJeton extends Thread {

	Semaphore debutsc;
	Semaphore finsc;

	int numerosite;
	int numerosuccesseur;

	public Jeton lejeton = null;
	public SiteInterface objsuccesseur;

	Semaphore alejeton;
	

	public GestionJeton(Semaphore debutsc, Semaphore finsc, int numero, int numerosuccesseur, Semaphore alejeton) {
		this.debutsc = debutsc;
		this.finsc = finsc;
		this.numerosite = numero;
		this.numerosuccesseur = numerosuccesseur;
		this.alejeton = alejeton;
	}


	public void run() {
		try {
			while(true) {				
				System.out.println(this.getName()+" : attend le jeton");
				alejeton.acquire();
				
				System.out.println(this.getName()+" : a recu le jeton : "+lejeton);
				
				if(ProgrammeSite.veutentrer == true) {
					debutsc.release();
					finsc.acquire();
				}
				
				//envoyer le jeton au successeur
				Thread.sleep(3000); // 3 secondes
				this.objsuccesseur.envoyer(lejeton);
				System.out.println(this.getName()+" : a envoye le jeton a site"+this.numerosuccesseur);
			}
		} catch (InterruptedException e) {
			System.out.println("Erreur\nSite"+this.numerosite+"\n"+e.getMessage());
			e.printStackTrace();
		} catch (RemoteException e) {
			System.out.println("Erreur\nSite"+this.numerosite+"\n"+e.getMessage());
			e.printStackTrace();
		}
	}
}
