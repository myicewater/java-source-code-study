/**
 * 演示rmi远程调用，
 */
package rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RmiServer {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		LocateRegistry.createRegistry(9976);
		AddServer as = new AddServerImp();
		Naming.bind("rmi://localhost:9976/plus", as);
		System.out.println("rmi server is ready");
		
	}

}
