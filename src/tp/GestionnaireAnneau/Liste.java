package tp.GestionnaireAnneau;

import java.io.Serializable;
import java.util.ArrayList;

public class Liste implements Serializable{

  private static final long serialVersionUID = -6199402168457446943L;

  public ArrayList<Integer> li = null;


  public Liste(){
	  li = new ArrayList<Integer>();
  }

}
