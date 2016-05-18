package reflect;

import java.lang.reflect.Method;
/**
 * 反射简单例子
 * @author 朱素海
 *
 */
public class ReTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			
			Class.forName("reflect.Student");
			System.out.println("7777");
			
			Method[] m = Student.class.getMethods();
			for(Method m1 :m){
				//System.out.println(m1);
			}
			
			Method method = Student.class.getMethod("intruductSelf", String.class);//获取方法 
			System.out.println(method);
			
			System.out.println(method+" accessible:"+method.isAccessible());
			
			method.invoke(new Student("Bill"), "Happy");
			
			
		}catch(Exception e){
			
		}
		
		
	}

}
