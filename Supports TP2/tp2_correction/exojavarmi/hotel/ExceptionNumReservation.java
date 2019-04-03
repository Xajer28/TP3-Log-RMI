package exojavarmi.hotel;


/**
 * Applications reparties
 * TP - Exercice 
 * Chaine d'hotels
 * 
 * Exception liee a un numero de reservation inexistant
 * 
 * @author Toto
 * @version 1.0
 */
public class ExceptionNumReservation extends Exception {

	private static final long serialVersionUID = -6656122783469441587L;

	String message;
	
	public ExceptionNumReservation() {
		super();
		message = "Erreur: numero de reservation incorrect";
	}
	
	public String toString() {
		return message;
	}
	
}
