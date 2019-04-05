package anneauexclurmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.concurrent.Semaphore;

/**
 * Exclusion mutuelle sur un anneau a jeton
 * 
 * Programme principal d'un site
 * 
 * @author nicolas
 *
 */
public class ProgrammeSite {

	public static boolean veutentrer = false;


	/**
	 * @param args[0] adresse IP du serveur central
	 * @param args[1] numero de port du serveur central
	 * @param args[2] int numero identifiant le site
	 * @param args[3] adresse IP de la machine annuaire du successeur
	 * @param args[4] numero de port de l'annuaire du successeur
	 * @param args[5] booleen indiquant si le jeton doit etre cree
	 * @param args[6] int numero identifiant le site successeur
	 */
	public static void main(String[] args) {
		Semaphore debutsc = new Semaphore(0);
		Semaphore finsc = new Semaphore(0);

		Semaphore alejeton = new Semaphore(0);
		
		String serveur = args[0];
		int portserveurcentral = Integer.parseInt(args[1]);
		int numerosite = Integer.parseInt(args[2]);
		String ipsuccesseur = args[3];
		int portregistresuccesseur = Integer.parseInt(args[4]);
		boolean initjeton = Boolean.parseBoolean(args[5]);
		int numerosuccesseur = Integer.parseInt(args[6]);

		Traitement calculsite = new Traitement(debutsc,finsc,serveur,portserveurcentral);
		GestionJeton gestionjetonsite = new GestionJeton(debutsc, finsc, numerosite, numerosuccesseur, alejeton);
		
		SiteImpl site;
		SiteInterface objsuccesseur = null;

		try {
			site = new SiteImpl(numerosite,gestionjetonsite,alejeton);
			Naming.rebind("rmi://localhost:1099"+"/site"+site.numerosite, site);

			//attente que tous les autres sites (enregistrement des objets serveurs)
			Thread.sleep(6000); // 6 secondes
			
			//recuperation de la ref distante de l'objet serveur du successeur
			objsuccesseur = (SiteInterface) Naming.lookup("rmi://"+ipsuccesseur+":"+portregistresuccesseur+"/site"+numerosuccesseur);
			System.out.println("site"+site.numerosite+" : a recupere ref distante de "+"site"+numerosuccesseur);
			
			site.objsuccesseur = objsuccesseur;	
			gestionjetonsite.objsuccesseur = objsuccesseur;		
			
			calculsite.setName("site"+numerosite+"calcul");
			gestionjetonsite.setName("site"+numerosite+"gestion");
			calculsite.start();
			gestionjetonsite.start();

			//attente que tous les autres connexions sont bien effectuees (anneau construit)
			Thread.sleep(5000); // 5 secondes

			Jeton lejeton;		
			if(initjeton==true) {
				System.out.println("site"+site.numerosite+" : cree et envoi le jeton");
				lejeton = new Jeton();
				site.objsuccesseur.envoyer(lejeton);
				initjeton=false;
			}
		} catch (RemoteException e) {
			System.err.println("Erreur\nSite"+numerosite+"\n"+e.getMessage());
			e.printStackTrace();
		} catch (MalformedURLException e) {
			System.err.println("Erreur\nSite"+numerosite+"\n"+e.getMessage());
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println("Erreur\nSite"+numerosite+"\n"+e.getMessage());
			e.printStackTrace();
		} catch (NotBoundException e) {
			System.err.println("Erreur\nSite"+numerosite+"\n"+e.getMessage());
			e.printStackTrace();
		}
	}

}
