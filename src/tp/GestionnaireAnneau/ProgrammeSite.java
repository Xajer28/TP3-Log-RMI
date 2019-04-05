package tp.GestionnaireAnneau;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.concurrent.Semaphore;

public class ProgrammeSite {

	static int idRelai;
	
	
public static void main (String[] args) {

	String ipgestionnaire = args[0];
	String mon_ip = args[1];

	AnneauInterface objgestionnaire = null;
	ElectionInterface objsuccesseur = null;
	ElectionImpl election = null;


	try {
		//1 - Je r�cup�re le Serializable Donn�es du GestionnaireAnneau
		objgestionnaire = (AnneauInterface) Naming.lookup("rmi://"+ipgestionnaire+":3000/anneau");
		Donnees data = objgestionnaire.recupInfos(mon_ip);

		System.out.println("Machine "+data.idmachine+" lancée !");
		System.out.println("-----------------------------------------");
		System.out.println("Mon IP: " +mon_ip);
		System.out.println("Mon ID: " +data.idmachine);
		System.out.println("ID de mon successeur: " +data.idsuccesseur);
		System.out.println("Lancer l'élection ? " +data.lance_election);
		System.out.println("-----------------------------------------");

		//2 - Je forme l'anneau en fonction de ce que GestionnaireAnneau m'a envoy�

		//d�finition de mon service d'�lection
		election = new ElectionImpl(data.idsuccesseur, data.idmachine );
		Naming.rebind("rmi://"+ipgestionnaire+":3000/election"+data.idmachine, election);

		//attente que tous les autres sites (enregistrement des objets serveurs)
		Thread.sleep(6000);

		//recuperation de la ref distante de l'objet serveur du successeur
		objsuccesseur = (ElectionInterface) Naming.lookup("rmi://"+ipgestionnaire+":3000/election"+data.idsuccesseur);
		election.setSuivant(objsuccesseur);

		System.out.println("site"+data.idmachine+" : a recupere ref distante de "+"site"+data.idsuccesseur);

		//lancement de l'algo d'election
		if(data.lance_election==true){
			Liste listeinit=new Liste();
			listeinit.li.add(data.idmachine);
			objsuccesseur.elire(listeinit);
			data.lance_election=false;
		}
		
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
