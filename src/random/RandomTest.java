package random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/**
 * 
 * 生成随机数 打乱
 * 
 * @author 朱素海
 *
 */
public class RandomTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> numbers = new ArrayList<Integer>(20);
		Random random = new Random();
		
		for(int i=0;i<20;i++){
			int randomNum = random.nextInt(20);//不包括20
			//System.out.println(randomNum);
			numbers.add(i, randomNum);
		}
		
		for(int i=0;i<20;i++){
			System.out.print(numbers.get(i)+" ");
		}
		
		Collections.shuffle(numbers);
		System.out.println();
		for(int i=0;i<20;i++){
			System.out.print(numbers.get(i)+" ");
		}
	}

}
