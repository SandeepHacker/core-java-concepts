package sun.containers.array.compare;

import java.util.Arrays;

import sun.containers.array.copy.ArrayCopying;
import sun.containers.array.filler.ArrayGenerator;
import sun.containers.array.filler.RandomGenerator;
import sun.containers.array.filler.SerialGenerator;
/*One thing you’ll notice about the output in the String sorting algorithm is that it’s lexicographic, so it puts all the words starting with
 * numbers followed by  uppercase letters first, followed by all the words starting with lowercase letters. (Telephone books are typically sorted this way.) 
 *  If you want to group the words together regardless of case, use String.CASE_INSENSITIVE_ORDER as shown in the last call to sort( )
 *   in the above example.*/
public class StringSorting {
	
	
	public static void main(String[] args) {
	String[] initial = ArrayCopying.copyArray(ArrayGenerator.fillArray(String.class, new RandomGenerator.String(), 10),
		ArrayGenerator.fillArray(String.class, new SerialGenerator.String(), 10));

	System.out.println("Original Array:::"+Arrays.toString(initial));
	Arrays.sort(initial);
	System.out.println("After Norma Sorting:::"+Arrays.toString(initial));
	Arrays.sort(initial,String.CASE_INSENSITIVE_ORDER);
	System.out.println("CASE_INSENSETIVE_ORDER Sorting:::"+Arrays.toString(initial));
	}
	
	

}
