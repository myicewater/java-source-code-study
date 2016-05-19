package file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 复制文件
 * 
 * 通过字节流 和字符串
 * 
 * 获取项目绝对路径
 * 
 * @author 朱素海
 *
 */
public class ReadFile {

	public static void main(String[] args) {
		
		
		String path = new File("").getAbsolutePath();//获取项目绝对路径
		System.out.println(path);
		
		InputStream fis = null;
		OutputStream os = null;
		BufferedReader bi  = null;
		BufferedInputStream bis = null;
		try{
			fis = new FileInputStream("source.txt");
			os = new FileOutputStream("back.txt");
			bi = new BufferedReader(new FileReader("source.txt"));
			bis = new BufferedInputStream(fis);
			
			String line = null;
			while((line = bi.readLine()) != null){
				System.out.println(line);
			}
			
			int data = fis.read();
			while(data != -1){
				System.out.println(data);
				os.write(data);
				data = fis.read();
			}
			bis.close();
			fis.close();
			os.close();
			bi.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
