/**
 * 演示rmi远程调用，
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AddServerImp extends UnicastRemoteObject implements AddServer {

	protected AddServerImp() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(int a, int b)  throws RemoteException{
		// TODO Auto-generated method stub
		return a+b;
	}

}
