// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package exemples.javarmi.annuairefactory;

public final class FabAnnuaire_Stub
    extends java.rmi.server.RemoteStub
    implements exemples.javarmi.annuairefactory.FabAnnuaireInterface, java.rmi.Remote
{
    private static final long serialVersionUID = 2;
    
    private static java.lang.reflect.Method $method_newAnnuaire_0;
    
    static {
	try {
	    $method_newAnnuaire_0 = exemples.javarmi.annuairefactory.FabAnnuaireInterface.class.getMethod("newAnnuaire", new java.lang.Class[] {java.lang.String.class});
	} catch (java.lang.NoSuchMethodException e) {
	    throw new java.lang.NoSuchMethodError(
		"stub class initialization failed");
	}
    }
    
    // constructors
    public FabAnnuaire_Stub(java.rmi.server.RemoteRef ref) {
	super(ref);
    }
    
    // methods from remote interfaces
    
    // implementation of newAnnuaire(String)
    public exemples.javarmi.annuairefactory.AnnuaireInterface newAnnuaire(java.lang.String $param_String_1)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_newAnnuaire_0, new java.lang.Object[] {$param_String_1}, 9116088503251858347L);
	    return ((exemples.javarmi.annuairefactory.AnnuaireInterface) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
}
