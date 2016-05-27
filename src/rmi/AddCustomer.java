/**
 * 演示rmi远程调用，
 */
package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
/**
 * 远程调用客户端演示
 * @author 朱素海
 *
 */
public class AddCustomer {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		// TODO Auto-generated method stub
		String url = "rmi://localhost:9976/plus";
		
		AddServer as = (AddServer)Naming.lookup(url);
		System.out.println(as.add(5, 6));
	}

}
