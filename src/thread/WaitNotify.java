package thread;

/**
 * 让线程等待和唤醒线程
 * @author 朱素海
 *
 */
public class WaitNotify extends Thread{

	
	
	
	@Override
	public void run() {
		try{
			System.out.println("Press the enter to continue..");
			System.in.read();
		}catch(Exception e){
			e.printStackTrace();
		}
		synchronized(this){
			System.out.println("notifyall");
			notifyAll();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WaitNotify wn = new WaitNotify();
		wn.start();
		try {
			synchronized(wn){
				System.out.println("Thread wait..");
				wn.wait();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("exit");
	}

}
