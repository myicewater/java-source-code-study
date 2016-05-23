package basetype;

public class BaseTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Long.toHexString(System.currentTimeMillis()).toUpperCase());
		
		System.out.println(Long.toHexString(System.nanoTime()).toUpperCase());
		
		System.out.println(Long.toHexString(System.currentTimeMillis()).toUpperCase()+"-"+Long.toHexString(System.nanoTime()).toUpperCase());
	}

}
