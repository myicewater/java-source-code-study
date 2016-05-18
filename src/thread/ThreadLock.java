package thread;

/**
 * 线程加锁的一个简单实例
 * @author 朱素海
 *
 */
public class ThreadLock implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		fun(100);
	}
	/**
	 * 有 synchronized 和没有 打印出来的 完全是两个东西
	 * @param i
	 */
	public synchronized void fun(int i){
		if(--i > 0){
			for(int j =0;j<i;j++){
				System.out.print("*");
			}
			System.out.println(i);
			fun(i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadLock r =new ThreadLock();
		Thread t = new Thread(r);
		t.start();
		new Thread(r).start();
	}

}
