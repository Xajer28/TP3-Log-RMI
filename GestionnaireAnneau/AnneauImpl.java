

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.Semaphore;

/**
 * Exclusion mutuelle sur un anneau a jeton
 *
 * Classe de l'objet serveur au niveau d'un site
 * Gere le jeton
 *
 * @author nicolas
 *
 */
public class AnneauImpl extends UnicastRemoteObject implements AnneauInterface {

	private static final long serialVersionUID = -869416918176853L;



	public AnneauImpl() throws RemoteException {
		super();
	}


	public Donnees recupInfos(String adrIp) throws RemoteException {
		//l'id du site est son ordre d'arrivée lorsqu'il appelle le service
		int id = Main.compteur;
		Main.compteur--;
		Main.nbr_presents_rdv;
		Donnees result;

		//l'adresse ip du site et son id sont mis dans une map

		//si le nombre de machines max n'est pas depasse
		if(Main.compteur>=1){
			Main.hm.put(id,adrIp);

			//rendez vous entre tous les threads
			Main.mutex.acquire();

			Main.nbr_presents_rdv++;
			if(Main.nbr_presents_rdv== Main.nbmachines)
				Main.rdv.release();

			Main.mutex.release();

			Main.rdv.acquire();
			Main.rdv.release();

			//envoi des données sous forme d'ip et d'id
			//si c'est la première machine arrivee son successeur est celui qui
			// a l'id 1, il doit aussi lancer l'algorithme d'election

			if(id ==Main.nbmachines){
				result= new Donnees(1,
				Main.hm.get(1),true);
			}
			else{
				result = new Donnees(id+1,Main.hm.get(id+1),false);
			}

		}
		else{
			result =(-1,"erreur",false);
			System.out.println("Nombre max de machines depasse.");
		}

		return result;
	}

}
