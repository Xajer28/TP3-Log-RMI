public class Donnees implements Serializable{

  private static final long serialVersionUID = -6199402168457446943L;

  public int idsucesseur;
  public String adrIpsucesseur;
  public boolean lance_election;

  public Donnees(int idsucesseur, String adrIpsucesseur, boolean lance_election){
    this.idsucesseur=idsucesseur;
    this.adrIpsucesseur=adrIpsucesseur;
    this.lance_election=lance_election;
  }

}
