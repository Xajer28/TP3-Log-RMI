package exemples.javarmi.annuairefactory;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;


public class Client {
	public static void main (String args []) {
		
		System.setSecurityManager (new RMISecurityManager ());
		
		try {  
			/* trouver une reference vers la fabrique */
			FabAnnuaireInterface fabrique = (FabAnnuaireInterface) Naming.lookup("rmi://localhost/Fabrique");
			/* creer et utiliser des annuaires */
			AnnuaireInterface annuaireESIL = (AnnuaireInterface) fabrique.newAnnuaire("ESIL");   
			annuaireESIL.inserer("Toto", new Information("rue machin", 01234));
			AnnuaireInterface annuaireLSIS = (AnnuaireInterface) fabrique.newAnnuaire("LSIS");
			annuaireLSIS.inserer("Toto", new Information("rue machin", 01234));
		} catch (Exception e) {
			System.out.println("Erreur client : " + e) ;
		}
	}
}
