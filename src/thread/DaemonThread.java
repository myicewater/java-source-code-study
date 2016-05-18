package thread;
/**
 * 当进程中只剩守护进程后，守护进程会自动结束
 * @author 朱素海
 *
 */
public class DaemonThread extends Thread {

private int num;
	
	
	public DaemonThread(int n){
		this.num = n;
	}
	
	
	@Override
	public void run() {
		System.out.println("I am the thread:"+num);
		try{
			Thread.sleep(5000);
		}catch(Exception e){
			e.printStackTrace();
		}
		//这句话能否执行到，取决于主进程是否在子进程（守护进程）前结束，还是后结束
		System.out.println(num+" finished..");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DaemonThread t1 = new DaemonThread(1);
		DaemonThread t2 = new DaemonThread(2);
		
		t2.setPriority(MAX_PRIORITY);
		t1.setPriority(NORM_PRIORITY);
		
		t1.setDaemon(true);
		t2.setDaemon(true);
		
		t1.start();
		t2.start();
		
		try{
			Thread.sleep(3000);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("main exit..");
	}
	
}
