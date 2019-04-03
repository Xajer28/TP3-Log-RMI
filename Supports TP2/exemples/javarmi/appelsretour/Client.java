package exemples.javarmi.appelsretour;

import java.rmi.RMISecurityManager;
import java.rmi.Naming;


public class Client {
	public static void main(String[] args) throws Exception {
	  try {
		System.setSecurityManager (new RMISecurityManager ()); 
		Callback callback = new Callback() ;
		IServer serveur=(IServer)Naming.lookup("rmi://localhost:1099/Server") ;
		System.out.println("demarrage de l'appel") ;
		serveur.callMeBack(5, "coucou", callback) ;
		for (int i=0 ; i<=5 ; i++) {
			System.out.println(i) ;
			try {
				Thread.sleep(2000) ;
			} catch (InterruptedException e) { }
		}
		System.out.println("fin du main") ;
	  }
	  catch (Exception e) {
			System.out.println("Erreur serveur : " + e) ;
		}  
	}
}

/*
demarrage de l'appel
0
1
2
coucou
3
4
5
fin du main
*/
