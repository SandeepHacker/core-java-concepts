package sun.enumeration.complex;

import java.util.EnumSet;

/*A Set is a kind of collection that only allows one of each type of object to be added. Of course,
an enum requires that all its members be unique, so it would seem to have set behavior, but
since you can’t add or remove elements it’s not very useful as a set. The EnumSet was added
to Java SE5 to work in concert with enums to create a replacement for traditional int-based
"bit flags." Such flags are used to indicate some kind of on-off information, but you end up
manipulating bits rather than concepts, so it’s easy to write confusing code.
The EnumSet is designed for speed, because it must compete effectively with bit flags
(operations will be typically much faster than a HashSet).*/
public class UsingEnumSet {
	
	
	public static void main(String[] args) {
		EnumSet<Cards> eni = EnumSet.allOf(Cards.class);
	
		eni.remove(Cards.TWO);
		eni.remove(Cards.THREE);
		eni.remove(Cards.FOUR);
		eni.remove(Cards.FIVE);
		System.out.println(eni);
	}
	
	enum Cards{
		ACE, TWO,THREE, FOUR, FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JAGGI,QUEEN, KING
	}

}
