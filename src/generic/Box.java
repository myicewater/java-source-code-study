package generic;
/**
 * 泛型测试类
 * @author 朱素海
 *
 * @param <T>
 */
public class Box<T> {

	private T data;
	
	public Box(){
		
	}
	
	public Box(T data){
		this.data =  data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
