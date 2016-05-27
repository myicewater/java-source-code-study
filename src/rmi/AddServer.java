/**
 * 演示rmi远程调用，
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddServer extends Remote {

	public int add(int a,int b) throws RemoteException;
}
