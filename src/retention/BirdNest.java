package retention;

public enum BirdNest {

	Sparrow;
	
	public Bird reproduct(){
		Desc desc = Sparrow.getClass().getAnnotation(Desc.class);
		
		return desc == null ?new Sparrow():new Sparrow(desc.c());
	}
}
