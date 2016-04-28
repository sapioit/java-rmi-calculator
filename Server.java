package calculator;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
 
public class Server 
    implements Interface {
 
    public Server() throws RemoteException {
    	/**/
    }
 
    public double add(double a, double b) throws RemoteException {
        return a+b;
    }
    public double subtract(double a, double b) throws RemoteException {
        return a-b;
    }
    public double multiply(double a, double b) throws RemoteException {
        return a*b;
    }
    public double divide(double a, double b) throws RemoteException {
        if(b==0)
            throw new IllegalArgumentException("One cannot simply divide by 0...");
        return a/b;
    }
    public double invert(double a) throws RemoteException {
        return 1/a;
    }
    public double power(double a, double b) throws RemoteException {
        return Math.pow(a, b);
    }
    public double factorial(double a) throws RemoteException {
        double result=1;
        for(int i=1;i<=a;i++)
            result *= (double)i;
        return result;
    }
    public double sqareroot(double a) throws RemoteException {
        if(a<0)
            throw new IllegalArgumentException("You are imaginating things...");
        return Math.sqrt(a);
    }
 
    public static void main(String args[]) throws Exception {

//    	if(System.getSecurityManager()==null){
//            System.setSecurityManager(new RMISecurityManager());
//    	}
        System.out.println("RMI server started");
        
        //Instantiate RmiServer
        Server obj = new Server();
 
        try { //special exception handler for registry creation
        	
            Interface stub = (Interface) UnicastRemoteObject.exportObject(obj,0);
            Registry reg;
            try {
            	reg = LocateRegistry.createRegistry(1099);
                System.out.println("java RMI registry created.");

            } catch(Exception e) {
            	System.out.println("Using existing registry");
            	reg = LocateRegistry.getRegistry();
            }
        	reg.rebind("Server", stub);

        } catch (RemoteException e) {
        	e.printStackTrace();
        }
    }
}
