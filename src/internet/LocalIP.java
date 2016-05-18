package internet;

import java.net.InetAddress;

/**
 * 根据域名获取ip地址
 * 
 * 获取本地ip
 * 
 * @author 朱素海
 *
 */
public class LocalIP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			InetAddress ia = InetAddress.getByName("www.baidu.com");
			System.out.println(ia.getHostAddress()+"("+ia.getHostName()+")");
			
			 ia = InetAddress.getByName("localhost");
			System.out.println(ia.getHostAddress()+"（"+ia.getHostName()+"）");
			
			System.out.println("本地ip："+ia.getLocalHost());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
