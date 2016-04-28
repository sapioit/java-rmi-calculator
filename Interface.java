package calculator;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {
	public double add(double a, double b) throws RemoteException;
	public double subtract(double a, double b) throws RemoteException;
	public double multiply(double a, double b) throws RemoteException;
	public double divide(double a, double b) throws RemoteException;
	public double invert(double a) throws RemoteException;
	public double power(double a, double b) throws RemoteException;
	public double factorial(double a) throws RemoteException;
	public double sqareroot(double a) throws RemoteException;
} 
