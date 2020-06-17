package sun.containers.functionality;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import sun.containers.array.filler.CountriesName;
import sun.containers.array.filler.RandomGenerator;
import sun.containers.fillers.ContainerGenerator;

/* :::::: boolean add(T)
 Ensures that the container holds the argument which is of generic type T.
 Returns false if it doesn’t add the argument. (This is an "optional" method, described in the next section.)
 ::::::::: boolean addAll( Collection<? extends T>)
 Adds all the elements in the argument. Returns true if any elements were added. ("Optional.")
 ::::::::: void clear( )
 Removes all the elements in the container. ("Optional.")
 ::::::::: boolean contains (T)
 true if the container holds the argument which is of generic type T.
 ::::::::: Boolean containsAll(Collection<?>)
 true if the container holds all the elements in the argument.
 ::::::::: boolean isEmpty( )
 true if the container has no elements.
 ::::::::: Iterator<T> iterator( )
 Returns an Iterator<T> that you can use to move through the elements in the container.
 :::::::::Boolean remove(Object)
 If the argument is in the container, one instance of that element is removed. Returns true if a removal occurred. ("Optional")
 ::::::::: boolean removeAll(Collection<?>)
 Removes all the elements that are contained in the argument. Returns true if any removals occurred. ("Optional.")
 ::::::::: Boolean retainAll(Collection<?>)
 Retains only elements that are contained in the argument (an "intersection," from set theory). Returns true if any changes occurred. ("Optional.")
 ::::::::: int size( )
 Returns the number of elements in the container.
 :::::::::Object[] toArray( )
 Returns an array containing all the elements in the container.
 :::::::::<T>T[] toArray(T[] a)
 Returns an array containing all the elements in the container. The runtime type of the result is that of the argument array a rather than plain Object.*/
public class CollectionsMethods {

	public static void main(String[] args) {

		// testCollectionMethods();
		asListVsUnmodifiableList();
	}

	/*
	 * From the output, it’s OK to modify the elements in the List returned by
	 * Arrays.asList( ), because this would not violate the "fixed-sized" nature
	 * of that List. But clearly, the result of unmodifiableList( ) should not
	 * be modifiable in any way. If interfaces were used, this would have
	 * required two additional interfaces, one with a working set( ) method and
	 * one without. Additional interfaces would be required for various
	 * unmodifiable subtypes of Collection.
	 */

	static void asListVsUnmodifiableList() {
		List<String> asList = Arrays.asList("ONE", "TWO", "THREE", "FOUR",
				"FIVE");

		List<String> unmodifiableList = Collections
				.unmodifiableList(new ArrayList<String>(asList));
System.out.println("========================Arrays.asList()===================");
		operateLists(asList);
		System.out.println("========================unmodifiableList()===================");
		operateLists(unmodifiableList);

	}

	static void operateLists(List<String> list) {
		ArrayList<String> prop = new ArrayList<String>();
		prop.add("ONE");
		prop.add("TWO");
		prop.add("TEN");
		prop.add("SIX");
		try {
			list.add("SIX");
			System.out.println("add() Success");
		} catch (UnsupportedOperationException uoe) {
			System.out.println("add() :: java.lang.UnsupportedOperationException");
		}
		try {
			list.add(2, "SIX");
			System.out.println("add(-,-) Success");
		} catch (UnsupportedOperationException uoe) {
			System.out.println("add(-,-)  :: java.lang.UnsupportedOperationException");

		}
		try {
			list.addAll(prop);
			System.out.println("addAll Success");
		} catch (UnsupportedOperationException uoe) {
			System.out.println("addAll() :: java.lang.UnsupportedOperationException");

		}
		try {
			list.set(3, "SIX");
			System.out.println("set(-,-) Success");
		} catch (UnsupportedOperationException uoe) {
			System.out.println("set(-,-) :: java.lang.UnsupportedOperationException");
		}
		try {
			list.remove("ONE");
			System.out.println("remove Success");
		} catch (UnsupportedOperationException uoe) {
			System.out.println("remove()  :: java.lang.UnsupportedOperationException");
		}
		try {
			list.clear();
			System.out.println("clear Success");
		} catch (UnsupportedOperationException uoe) {
			System.out.println("clear() :: java.lang.UnsupportedOperationException");
		}
		try {
			list.removeAll(prop);
			System.out.println("removeAll Success");
		} catch (UnsupportedOperationException uoe) {
			System.out.println("removeAll() :: java.lang.UnsupportedOperationException");
		}
		try {
			list.retainAll(prop);
			System.out.println("retainAll Success");
		} catch (UnsupportedOperationException uoe) {
			System.out.println("retainAll() :: java.lang.UnsupportedOperationException");
		}
		try {
			list.contains("SIX");
			System.out.println("contains() Success");
		} catch (UnsupportedOperationException uoe) {
			System.out.println("contains() :: java.lang.UnsupportedOperationException");
		}
		try {
			list.containsAll(prop);
			System.out.println("containsAll() Success");
		} catch (UnsupportedOperationException uoe) {
			System.out.println("containsAll() :: java.lang.UnsupportedOperationException");
		}
		try {
			list.subList(2, 4);
			System.out.println("subList() Success");
		} catch (UnsupportedOperationException uoe) {
			System.out.println("subList() :: java.lang.UnsupportedOperationException");
		}
	

	}

	static void testCollectionMethods() {
		Random rand = new Random();
		Collection<String> arr = ContainerGenerator.loadArrayList(
				new RandomGenerator.CountryNames(), 70);
		arr.add("India");
		// Make an array from the List:
		Object[] array = arr.toArray();
		// Make a String array from the List:
		String[] str = arr.toArray(new String[0]);

		// Find max and min elements; this means
		// different things depending on the way
		// the Comparable interface is implemented:
		System.out.print("Collections.max(c) = " + Collections.max(arr));
		System.out.print("Collections.min(c) = " + Collections.min(arr));

		// Add a Collection to another Collection
		Collection<String> arr2 = ContainerGenerator.loadArrayList(
				new RandomGenerator.String(), 20);

		arr.addAll(arr2);// Union as in Set Theory Concepts
		System.out.println(arr);

		arr.remove(CountriesName.getCountriesNames()[rand.nextInt(150)]);
		System.out.println(arr);
		;
		arr.remove(CountriesName.getCountriesNames()[rand.nextInt(160)]);
		System.out.println(arr);
		;
		// Remove all components that are
		// in the argument collection:
		arr.removeAll(arr2);
		System.out.println(arr);
		arr.addAll(arr2);
		System.out.println(arr);
		// Is an element in this Collection?
		String val = CountriesName.getCountriesNames()[rand.nextInt(150)];
		System.out.println("arr.contains(" + val + ") = " + arr.contains(val));
		// Is a Collection in this Collection?
		System.out.println("arr.containsAll(arr2) = " + arr.containsAll(arr2));
		Collection<String> arr3 = ((List<String>) arr).subList(3, 5);
		// Keep all the elements that are in both
		// c2 and c3 (an intersection of sets):
		arr2.retainAll(arr3);
		System.out.println(arr2);
		// Throw away all the elements
		// in c2 that also appear in c3:
		arr2.removeAll(arr3);
		System.out.println("arr2.isEmpty() = " + arr2.isEmpty());
		arr = ContainerGenerator
				.loadArrayList(new RandomGenerator.String(), 20);

		System.out.println(arr);
		arr.clear(); // Remove all elements
		System.out.print("after arr.clear():" + arr);

	}

}
