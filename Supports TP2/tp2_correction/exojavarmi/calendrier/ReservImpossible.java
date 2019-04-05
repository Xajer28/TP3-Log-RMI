package exojavarmi.calendrier;

public class ReservImpossible extends Exception {
	
	private static final long serialVersionUID = -220409133608547831L;
	
	public ReservImpossible() {
		super("Reservation impossible!");
	}
	
}

