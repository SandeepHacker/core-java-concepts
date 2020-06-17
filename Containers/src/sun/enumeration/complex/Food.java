package sun.enumeration.complex;

public interface Food {
	
	enum Appetizer implements Food{
		SALAD,JUICE,SOUP,SPRING_ROLLS,COLDDRINKS;
	}
	
	enum MainCourse implements Food{
		MUTTON,CHICKEN,FISH,RICE,DAL,MUSHROOM,PANEER;
	}
	
	enum Dessert implements Food{
		ICE_CREAM, CAKE, SPICE, SWEETS;
	}
	
	enum Coffee implements Food {
		BLACK_COFFEE, DECAF_COFFEE, ESPRESSO,
		LATTE, CAPPUCCINO, TEA, HERB_TEA;
		}

}
