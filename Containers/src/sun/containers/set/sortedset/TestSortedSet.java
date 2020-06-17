package sun.containers.set.sortedset;

import java.util.TreeSet;

import sun.containers.array.filler.RandomGenerator;
import sun.containers.array.filler.RandomGenerator.CountryNames;
import sun.containers.fillers.ContainerGenerator;

/*The elements in a SortedSet are guaranteed to be in sorted order, which allows additional functionality to be provided with the following methods that are in the SortedSet interface:
Comparator comparator( ): Produces the Comparator used for this Set, or null for natural ordering.
Object first( ): Produces the lowest element.
Object last( ): Produces the highest element.
SortedSet subSet(fromElement, toElement): Produces a view of this Set with elements from fromElement, inclusive, to toElement, exclusive.
SortedSet headSet(toElement): Produces a view of this Set with elements less than toElement.
SortedSet tailSet(fromElement): Produces a view of this Set with elements greater than or equal to fromElement.
Here’s a simple demonstration:*/
public class TestSortedSet {
	
	
	public static void main(String[] args) {
		TreeSet<String> set = ContainerGenerator.loadTreeSet(new RandomGenerator.CountryNames(), 16);
		System.out.println(set);
		String low = set.first();
		String high =set.last();
		System.out.println(low);
		System.out.println(high);
		System.out.println(set.subSet("Ecuador","Spain"));
		System.out.println(set.subSet("Ecuador",false,"Spain",true));

	}

}
