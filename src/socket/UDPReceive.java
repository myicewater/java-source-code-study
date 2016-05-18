package socket;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 创建UDP socket 监听 2000 端口，接收嘻嘻
 * @author 朱素海
 *
 */
public class UDPReceive {

	public static void main(String[] args) {
		try{
			DatagramSocket ds = null;
			DatagramPacket dp = null;
			ds = new DatagramSocket(2000);
			System.out.println("Bingding to port 2000..");
			dp = new DatagramPacket(new byte[256], 256);
			ds.receive(dp);
			System.out.println(dp.getPort()+","+dp.getAddress());
			byte[] data = dp.getData();
			InputStream  is  = new ByteArrayInputStream(data);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
			br.close();
			is.close();
			ds.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
