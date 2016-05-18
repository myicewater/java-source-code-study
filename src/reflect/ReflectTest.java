package reflect;

import java.awt.Button;
import java.lang.reflect.Field;

public class ReflectTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = "abc";
		Button b = new Button();
		Class bc = b.getClass();
		System.out.println(bc);
		Class bcc = bc.getSuperclass();
		System.out.println(bcc);
		
		
		Student s = new Student("d");
		Object o;
		try {
			o = getProperty(s, "address");
			System.out.println(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println("abcdef".substring(0,4));
		
	}
	
	public static Object getProperty(Object owner, String fieldName) throws Exception {
	     Class ownerClass = owner.getClass();
	 
	     Field field = ownerClass.getField(fieldName);
	 
	     Object property = field.get(owner);
	 
	     return property;
	}

}
