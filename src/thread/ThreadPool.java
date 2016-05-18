package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 
 * run thread by thread pool
 * @author 朱素海
 *
 */
public class ThreadPool {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);
		for(int i=0;i<20;i++){
			es.submit(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println("The current thread name is :"+Thread.currentThread().getName());
				}
			});
		}
		es.shutdown();
	}

}
