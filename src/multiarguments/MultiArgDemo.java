package multiarguments;

public class MultiArgDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test("a","b","c","tyuioi");
	}
	
	public static void test(String...arg){
		System.out.println(arg.length);
	}

}
