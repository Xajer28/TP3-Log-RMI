package exemples.javarmi.hellomsg;

import java.util.Date;


/**
 * 
 * @author Toto
 * @version 1.0
 */
public class Message implements java.io.Serializable
{
	private static final long serialVersionUID = -6365931003415826530L;
	
	protected Date date;
	
	protected String texte;
	
	//Le constructeur avec un texte.
	public Message(String texte)
	{
		this.date = new java.util.Date();
		this.texte = texte;
	}
	
	//Pour afficher le message.
	public String toString()
	{
		return "Message[date=" + date + ",texte=" + texte + "]";
	}
}
