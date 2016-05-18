package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/**
 *  Executors  提供了异步执行器的能力， 通过Future 返回结果，监控结果是否返回
 * @author 朱素海
 *
 */
public class TxCalculator implements Callable<Integer> {

	private int seedMoney;
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		TimeUnit.MILLISECONDS.sleep(5000);
		return seedMoney/10;
	}
	public TxCalculator(int seedMoney){
		this.seedMoney = seedMoney;
	}
	public static void main(String[] args) throws Exception{
		ExecutorService  es = Executors.newSingleThreadExecutor();
		Future<Integer> future = es.submit(new TxCalculator(100));
		while(!future.isDone()){
			TimeUnit.MILLISECONDS.sleep(200);
			System.out.print("#");
			
		}
		System.out.println();
		System.out.println("the result is :"+future.get());
		es.shutdown();
	}

}
