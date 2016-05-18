package thread;

/**
 * 结束循环线程推荐的方法，添加循环结束标识符
 * 
 * 不推荐使用线程的stop,interrupt 等方法，可能会造成意向不到的结果
 * 
 * @author 朱素海
 *
 */
public class InterruptThread extends Thread{

	
	volatile boolean isExit = false;
	
	@Override
	public void run() {
		int num = 0;
		
		while(!isExit){
			System.out.println("num is :"+(num++));
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(num > 5){
				isExit = true;
			}
		}
		System.out.println("线程结束。。");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterruptThread it = new InterruptThread();
		
		it.start();
		System.out.println("主线程结束。");
		//不推荐使用方法
		//it.stop();
	}

}
