// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package exemples.javarmi.appelsretour;

public final class Server_Stub
    extends java.rmi.server.RemoteStub
    implements exemples.javarmi.appelsretour.IServer, java.rmi.Remote
{
    private static final long serialVersionUID = 2;
    
    private static java.lang.reflect.Method $method_callMeBack_0;
    
    static {
	try {
	    $method_callMeBack_0 = exemples.javarmi.appelsretour.IServer.class.getMethod("callMeBack", new java.lang.Class[] {int.class, java.lang.String.class, exemples.javarmi.appelsretour.ICallback.class});
	} catch (java.lang.NoSuchMethodException e) {
	    throw new java.lang.NoSuchMethodError(
		"stub class initialization failed");
	}
    }
    
    // constructors
    public Server_Stub(java.rmi.server.RemoteRef ref) {
	super(ref);
    }
    
    // methods from remote interfaces
    
    // implementation of callMeBack(int, String, ICallback)
    public void callMeBack(int $param_int_1, java.lang.String $param_String_2, exemples.javarmi.appelsretour.ICallback $param_ICallback_3)
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_callMeBack_0, new java.lang.Object[] {new java.lang.Integer($param_int_1), $param_String_2, $param_ICallback_3}, 7076466444970734669L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
}
