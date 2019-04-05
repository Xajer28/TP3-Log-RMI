package tp.GestionnaireAnneau;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ProgrammeSite {

public static void main (String[] args) {
	
	String ipgestionnaire = args[0];
	String mon_ip = args[1];
	AnneauInterface obj = null;
	
	try {
		//1 - Je récupère le Serializable Données du GestionnaireAnneau
		obj = (AnneauInterface) Naming.lookup("rmi://"+ipgestionnaire+":3000/anneau");
		Donnees data = obj.recupInfos(mon_ip);
		System.out.println("IP de mon successeur:" +data.adrIpsucesseur);		
		System.out.println("ID de mon successeur:" +data.idsucesseur);
		System.out.println("Lancer l'élection ?" +data.lance_election);	
		
		//2 - Je forme l'anneau en fonction de ce que GestionnaireAnneau m'a envoyé

	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NotBoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	
	
	
}
