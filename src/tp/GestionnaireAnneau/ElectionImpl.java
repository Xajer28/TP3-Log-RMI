package tp.GestionnaireAnneau;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;
import java.util.concurrent.Semaphore;

public class ElectionImpl extends UnicastRemoteObject implements ElectionInterface  {


	int idsuccesseur;
	int idmachine;
	ElectionInterface objsuccesseur;
	public ElectionImpl(int idsuccesseur, int idmachine) throws RemoteException {
		super();
		this.idsuccesseur = idsuccesseur;
		this.idmachine = idmachine;

	}

	public void setSuivant(ElectionInterface elec)
	{
		objsuccesseur = elec;
	}

	public void elire(Liste liste) throws RemoteException {
		if(liste.li.get(0)==this.idmachine){
			int idmax=(int) Collections.max(liste.li);
			ProgrammeSite.idRelai = idmax;
			System.out.println("le relai défini est :"+ProgrammeSite.idRelai);
			objsuccesseur.coordinateur(liste,idmax);
		}
		else{
			liste.li.add(idmachine);
			objsuccesseur.elire(liste);

		}


	}

	public void coordinateur(Liste liste, int idmax) {
		System.out.println("je suis dans coordinateur");
		if(liste.li.get(0)!=this.idmachine){
			ProgrammeSite.idRelai = idmax;
			System.out.println("Bien reçu le relai: "+ProgrammeSite.idRelai);
			try {
				objsuccesseur.coordinateur(liste,idmax);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		System.out.println("coordinateur fini, je rentre plus dans la boucle");
	}

}
