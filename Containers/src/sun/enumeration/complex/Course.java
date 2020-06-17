package sun.enumeration.complex;

public enum Course {

	APPETIZER(Food.Appetizer.class),
	MAINCOURSE(Food.MainCourse.class),
	DESERT(Food.Dessert.class),
	COFFEE(Food.Coffee.class);
	Food[] values;
Course(Class<? extends Food> clazz){
		values=clazz.getEnumConstants();
	}
	
	public Food[] getValues(){
		return values;
	}

}
