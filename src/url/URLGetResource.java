package url;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * 通过url获取内容
 * 
 * @author 朱素海
 *
 */
public class URLGetResource {

	public static void main(String[] args) throws Exception{
		URL url = new URL("http://www.baidu.com");
		URLConnection con = url.openConnection();
		con.connect();
		System.out.println("encoding:"+con.getContentEncoding());
		for(int i=0;i<50;i++){
			System.out.println(i+":"+con.getHeaderField(i));
		}
		System.out.println();
		
		Map ma = con.getHeaderFields();
		System.out.println(ma);
		System.out.println();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8")) ;
		
		String line = null;
		
		while((line = br.readLine()) != null){
			System.out.println(line);
		}
		
	}

}
