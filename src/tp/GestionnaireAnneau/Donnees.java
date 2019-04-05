package tp.GestionnaireAnneau;

import java.io.Serializable;

public class Donnees implements Serializable{

  private static final long serialVersionUID = -6199402168457446943L;

  public int idmachine;
  public int idsuccesseur;
  public boolean lance_election;

  public Donnees(int idmachine, int idsuccesseur, boolean lance_election){
    this.idmachine=idmachine;
	this.idsuccesseur=idsuccesseur;
    this.lance_election=lance_election;
  }

}
