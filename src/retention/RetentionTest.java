package retention;

import retention.Desc.Color;

public class RetentionTest {

	
	
	public static void main(String[] args) {
		Bird bird = BirdNest.Sparrow.reproduct();
		
		Color color = bird.getColor();
		
		System.out.println(color);
	}
	
}
