package tp.GestionnaireAnneau;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.concurrent.Semaphore;

public class ProgrammeSite {

public static void main (String[] args) {
	
	String ipgestionnaire = args[0];
	String mon_ip = args[1];
	
	AnneauInterface objgestionnaire = null;
	ElectionInterface objsuccesseur = null;
	ElectionImpl election = null;
	
	try {
		//1 - Je récupère le Serializable Données du GestionnaireAnneau
		objgestionnaire = (AnneauInterface) Naming.lookup("rmi://"+ipgestionnaire+":3000/anneau");
		Donnees data = objgestionnaire.recupInfos(mon_ip);
		
		System.out.println("Machine "+data.idmachine+" lancée !");
		System.out.println("-----------------------------------------");
		System.out.println("Mon IP: " +mon_ip);
		System.out.println("Mon ID: " +data.idmachine);
		System.out.println("IP de mon successeur: " +data.adrIpsucesseur);		
		System.out.println("ID de mon successeur: " +data.idsucesseur);
		System.out.println("Lancer l'élection ? " +data.lance_election);	
		System.out.println("-----------------------------------------");
		
		//2 - Je forme l'anneau en fonction de ce que GestionnaireAnneau m'a envoyé
		
		//définition de mon service d'élection
		election = new ElectionImpl();
		Naming.rebind("rmi://localhost:3000/election"+data.idmachine, election);
		
		//attente que tous les autres sites (enregistrement des objets serveurs)
		Thread.sleep(6000);
		
		//recuperation de la ref distante de l'objet serveur du successeur	
		objsuccesseur = (ElectionInterface) Naming.lookup("rmi://"+data.adrIpsucesseur+":3000/election"+data.idsucesseur);
		System.out.println("site"+data.idmachine+" : a récupéré ref distante de "+"site"+data.idsucesseur);
		
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NotBoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	
	
	
}
