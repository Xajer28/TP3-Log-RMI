package anneauexclurmi;

import java.io.Serializable;

/**
 *  Le jeton
 *  
 *  @author nicolas
 *
 */
public class Jeton implements Serializable {

	private static final long serialVersionUID = 80608973554383338L;

	int compteur;
	
	public Jeton() {
		this.compteur = 0;
	}
	
	public void incremente() {
		this.compteur = this.compteur + 1;
	}
	
	public String toString() {
		return "compteur="+this.compteur;
	}
}
