package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型说白了目的就是 类型限制，提高安全性， 把类型做了参数
 * @author 朱素海
 *
 */
public class GenericTest {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box<String> b1 = new Box<String>("hello box");
		
		Box<Integer> b2 = new Box<Integer>(1233);
		Box<Float> b3 = new Box<Float>(12.5f);
		Box<Double> b4 = new Box<Double>(22.33);
		
		
		getData(b1);
		getData(b3);
		
		getNumberData(b2);
		getNumberData(b3);
		getNumberData(b4);
		
		List< Number> list = new ArrayList< Number>();
		list.add(2233);
		list.add(677.23);
		list.add(13223L);
		list.add(0x67);
		
		System.out.println("Read list: ");
		for(int i=0;i<list.size();i++){
			System.out.println(listRead(list,i));
		}
		
		
	}

	public static void getData(Box<?> box){
		System.out.println(box.getData());
	}
	/**
	 * 继承Number的子类都可以作为参数
	 * @param box
	 */
	public static void getNumberData(Box<? extends Number> box){
		System.out.println(box.getData());
	}
	
	/**
	 * write operation need super(down limit)
	 * @param list
	 * @param data
	 */
	public static void listAdd(List<? super Number> list ,Number data){
		list.add(data);
	}
	
	/**
	 * read operation need extents(up limit)
	 * @param list
	 * @param i
	 * @return
	 */
	public static Number listRead(List<? extends Number > list,int i){
		return list.get(i);
	}
}
