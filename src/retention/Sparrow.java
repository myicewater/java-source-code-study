package retention;

import retention.Desc.Color;

public class Sparrow extends Bird {
	
	private Color color;
	
	public Sparrow(){
		color = Color.Gray;
	}
	
	public Sparrow(Color color){
		this.color  = color;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

}
