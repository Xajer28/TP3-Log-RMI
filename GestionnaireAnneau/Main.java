

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.concurrent.Semaphore;


public class Main {

//compteur est un compteur du nombre de machines
  public static int compteur;
//nombre total de machines
  public static int nbmachines;
//nombre de machines presentes au rendez vous de threads dans AnneauImpl
  public static int nbr_presents_rdv;
//Semaphore sur la modification de nbr_presents_rdv
  public static Semaphore mutex;
//Semaphore pour confirmer que toutes les machines ont appelé le service
  public static Semaphore rdv;
//Hashmap des id et ip de chaque machine
  public static HashMap<Integer,String> hm;


	public static void main(String[] args) {


    mutex= new Semaphore(1);
    rdv = new Semaphore(0);
    nbmachines =args[0];
    compteur = nbmachines;
    nbr_presents_rdv=0;
    hm=new HashMap<Integer,String>();

    AnneauImpl anneau;


		try {
			anneau = new AnneauImpl();
			Naming.rebind("rmi://localhost:1099"+"/anneau",anneau);

			//attente que tous les autres sites (enregistrement des objets serveurs)
			Thread.sleep(6000); // 6 secondes




		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
