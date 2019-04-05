package exojavarmi.hotel;

import java.io.Serializable;


/**
 * Applications reparties
 * TP - Exercice 
 * Chaine d'hotels
 * 
 * Classe regroupant les informations d'une reservation
 * 
 * @author Toto
 * @version 1.0
 */
public class Infos implements Serializable {

	private static final long serialVersionUID = -6199402168457446943L;

	private String nomClient;
	private String nomHotel;
	private String date;
	private int nbchambres;
	
	public Infos() {
		this.nomClient = "";
		this.nomHotel = "";
		this.date = "";
		this.nbchambres = 0;
	}
	
	public Infos(String client, String hotel, String date, int nb) {
		this.nomClient = client;
		this.nomHotel = hotel;
		this.date = date;
		this.nbchambres = nb;
	}
		
	public String getNomClient() {
		return this.nomClient;
	}
	
	public void setNomClient(String nom) {
		this.nomClient = nom;
	}
	
	public String getNomHotel() {
		return this.nomHotel;
	}
	
	public void setNomHotel(String nom) {
		this.nomHotel = nom;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public void setDate(String d) {
		this.date = d;
	}
	
	public int getNbChambres() {
		return this.nbchambres;
	}
	
	public void setNbChambres(int nb) {
		this.nbchambres = nb;
	}
	
	public String toString() {
		String str = "";
		str = str + this.nomClient + " " + this.nomHotel + " " + this.date + " " + this.nbchambres;
		return str;
	}
	
}
