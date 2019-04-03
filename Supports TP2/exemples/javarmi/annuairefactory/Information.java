package exemples.javarmi.annuairefactory;

import java.io.Serializable;


public class Information implements Serializable  {

	private static final long serialVersionUID = 992385887247041796L;

	public String adresse = "";
	public int numtel = 0;
	
	public Information(String ad, int num) {
		this.adresse = ad;
		this.numtel = num;
	}
	
	public String toString() {
		String s = "";
		s += this.adresse;
		s += ":"+this.numtel;
		return s;
	}
	
}
