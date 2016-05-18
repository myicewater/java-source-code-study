package retention;

import java.util.List;

public class FanUtil {
	
	
	public static <E> void read(List<? extends E> list){
		for(Object o : list){
			
		}
	}
	

	public static void write(List<? super Number> list){
		list.add(11);
		list.add(5.3);
		list.add(null);
	}
	
	public static <T> void copy(List<? super T> dest,List<? extends T> src){
		for(int i=0;i<src.size();i++){
			dest.set(i, src.get(i));
		}
	}
	
}
