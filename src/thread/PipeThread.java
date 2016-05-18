package thread;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

/**
 * 管道线程
 * 
 * 暗送秋波
 * 
 * @author 朱素海
 *
 */
public class PipeThread extends Thread{

	private PipedOutputStream pos;
	
	
	
	public PipeThread(PipedOutputStream p){
		this.pos = p;
	}
	
	
	
	@Override
	public void run() {
		PrintStream ps = new PrintStream(pos);
		
		ps.print("Hello from piped...");
		ps.close();
	}
	public static void main(String[] args) {
		PipedOutputStream po = new PipedOutputStream();
		try {
			PipedInputStream pi = new PipedInputStream(po);
			PipeThread pt = new PipeThread(po);
			pt.start();
			int data = pi.read();
			while(data != -1){
				System.out.print((char)data);
				data = pi.read();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
