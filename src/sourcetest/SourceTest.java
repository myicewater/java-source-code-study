package sourcetest;

import java.math.BigDecimal;

public class SourceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = new String("hello");
		System.out.println(str);
		
		System.out.println("***************Int 类型的有关数据**********");
		System.out.println("int 的最大值："+Integer.MAX_VALUE);
		System.out.println("int 的最小值："+Integer.MIN_VALUE);
		System.out.println("int 表示的长度："+Integer.SIZE);
		
		
		System.out.println("***************Long 类型的有关数据**********");
		System.out.println("long 的最大值："+Long.MAX_VALUE);
		System.out.println("long 的最小值："+Long.MIN_VALUE);
		System.out.println("long 表示的长度："+Long.SIZE);
		
		
		System.out.println("***************Float 类型的有关数据**********");
		System.out.println("float 的最大值："+Float.MAX_VALUE);
		System.out.println("float 的最大指数："+Float.MAX_EXPONENT);
		System.out.println("float 的最小值："+Float.MIN_VALUE);
		System.out.println("float 的最小指数："+Float.MIN_EXPONENT);
		System.out.println("float 的最大值："+Float.MAX_VALUE);
		System.out.println("float 表示的长度："+Float.SIZE);
		System.out.println("float 表示的长度："+Float.NEGATIVE_INFINITY);
		
		System.out.println(BigDecimal.ONE);;

	}

}
