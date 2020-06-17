package sun.enumeration.mystery;

import java.util.Random;

public class RandomEnumSelector {
	
	static Random r = new Random(47);
	public static <T extends Enum> T randomSelect(Class<T> clazz){
		
		return random(clazz.getEnumConstants());
	}
	
	
	public static <T> T random(T[] values)
	{
		
	return	values[r.nextInt(values.length-1)];
	
	}
	
	public static void main(String[] args) {
		for(int i=1;i<=10;i++){
			System.out.println(i+" -- "+randomSelect(Activity.class));
		}
	}
}
