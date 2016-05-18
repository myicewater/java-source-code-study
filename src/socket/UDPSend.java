package socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/**
 * 通过udp发送内容
 * @author 朱素海
 *
 */
public class UDPSend {

	public static void main(String[] args) {
		try{
			DatagramSocket ds = null;
			DatagramPacket dp = null;
			ds = new DatagramSocket();
			
			byte[] data = "Hello UDP..".getBytes();
			
			dp = new DatagramPacket(data, data.length);
			dp.setAddress(InetAddress.getLocalHost());
			dp.setPort(2000);
			ds.send(dp);
			ds.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
