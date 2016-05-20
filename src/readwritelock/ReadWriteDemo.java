package readwritelock;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * 运行结果大致如下：
 * begin time:1463716049814
	................end time:1463716053308
	putCount:500000
	read write lock time:3494
	map begin time:1463716053308
	...........................map end time:1463716059081
	putCount:500000
	map time:5773
 * 
 * 由此可见，在读操作比较高的情况下，通过读写锁来同步Map 要比synchronized 关键字效率要高
 * 
 * 当把读操作注释掉后，运行结果如下：
 * 
 * begin time:1463716300446
	........end time:1463716302165
	putCount:500000
	read write lock time:1719
	map begin time:1463716302165
	........map end time:1463716304156
	putCount:500000
	map time:1991

 * 两者的时间差别并不大
 * 
 * @author 朱素海
 *
 */
public class ReadWriteDemo implements Runnable{

	
	private final Map m = new TreeMap();
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock r = lock.readLock();
	private final Lock w = lock.writeLock();

	
	
	private final Map m2 = new HashMap();
	
	

	
	
	public Object get(String key){
		r.lock();
		try{
			return m.get(key);
		}finally{
			r.unlock();
		}
		
	}
	
	public Object[] allKeys(){
		r.lock();
		try{
			return m.keySet().toArray();
		}finally{
			r.unlock();
		}
	}
	
	public Object put(String key,Object obj){
		w.lock();
		try{
			return m.put(key, obj);
		}finally{
			w.unlock();
		}
	}
	
	public void clear(){
		w.lock();
		try{
			m.clear();
		}finally{
			w.unlock();
		}
	}
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String threadName = Thread.currentThread().getName();
		for(int i=0;i<100000;i++){
			
			put("key_"+threadName+"_"+i,i);
		}
		//Object[] keys = allKeys();
		//for(int i=0;i<keys.length;i++){
		//	get((String)keys[i]);
		//}
	}
	
	
	class MapTest implements Callable{
		private Map m = Collections.synchronizedMap(new TreeMap());
		private int  putCount =0;

		public void  put(String key , Object obj){
			m.put(key, obj);
			
				putCount++;
		}
		
		public Object get(String key){
			return m.get(key);
		}
		
		public Object[] allKeys(){
			Set s = m.keySet();
			return s.toArray();
		}
		
		@Override
		public Object call() throws Exception {
			// TODO Auto-generated method stub
			
			String threadName = Thread.currentThread().getName();
			for(int i=0;i<100000;i++){
				
				this.put("key_"+threadName+"_"+i,i);
			}
//			Object[] keys = this.allKeys();
//			for(int i=0;i<keys.length;i++){
//				get((String)keys[i]);
//			}
			return null;
		}
		
		
		
	}
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ReadWriteDemo d = new ReadWriteDemo();
		long startTime = System.currentTimeMillis();
		System.out.println("begin time:"+startTime);
		ExecutorService es = Executors.newCachedThreadPool();
		Future f1 = es.submit(d);
		
		Future f2= es.submit(d);
		
		Future f3= es.submit(d);
		
		Future f4= es.submit(d);
		
		Future f5= es.submit(d);
		
		while(!f1.isDone() || !f2.isDone() || !f3.isDone() || !f4.isDone() || !f5.isDone()){
			System.out.print(".");
			TimeUnit.MILLISECONDS.sleep(200);
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("end time:"+endTime);
		System.out.println("putCount:"+d.m.size());
		System.out.println("read write lock time:"+(endTime-startTime));
		
		es.shutdown();
		
		
		startTime = System.currentTimeMillis();
		System.out.println("map begin time:"+startTime);
		ExecutorService es2 = Executors.newCachedThreadPool();
		ReadWriteDemo.MapTest mt =new ReadWriteDemo().new MapTest();
		f1 = es2.submit(mt);
		f2 = es2.submit(mt);
		f3 = es2.submit(mt);
		f4 = es2.submit(mt);
		f5 = es2.submit(mt);
		
		while(!f1.isDone() || !f2.isDone() || !f3.isDone() || !f4.isDone() || !f5.isDone()){
			System.out.print(".");
			TimeUnit.MILLISECONDS.sleep(200);
		}
		
		
		endTime = System.currentTimeMillis();
		System.out.println("map end time:"+endTime);
		System.out.println("putCount:"+mt.m.size());
		System.out.println("map time:"+(endTime-startTime));
		
	}

	

}
