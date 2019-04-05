package exojavarmi.hotel;


/**
 * Applications reparties
 * TP - Exercice
 * Chaine d'hotels
 * 
 * Exception liee a la non disponibilite
 * 
 * @author Toto
 * @version 1.0
 */
public class ExceptionChambresIndispo extends Exception {

	private static final long serialVersionUID = 5269715160970930660L;

	String message;
	
	public ExceptionChambresIndispo() {
		super();
		message = "Erreur: chambre(s) indisponible(s)";
	}
	
	public String toString() {
		return message;
	}
	
}
