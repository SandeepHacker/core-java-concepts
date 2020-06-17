package sun.containers.array.searching;

import java.util.Arrays;
import java.util.Random;

import sun.containers.array.copy.ArrayCopying;
import sun.containers.array.filler.ArrayGenerator;
import sun.containers.array.filler.ConvertTo;
import sun.containers.array.filler.Generator;
import sun.containers.array.filler.RandomGenerator;
/*Once an array is sorted, you can perform a fast search for a particular item by using Arrays.binarySearch( ). 
 * However, if you try to use binarySearch() on an unsorted array the results will be unpredictable.
 * To see this behaviour you can see searchArray()*/
public class ArraySearching {
	
	
	public static void main(String[] args) {
		Generator<Integer> gen = new RandomGenerator.Integer();
		
		
		int[] arr = ConvertTo.primitive(ArrayGenerator.fillArray(Integer.class,gen , 30));
		
		System.out.println("Original Array--"+Arrays.toString(arr));
		
//		searchArray(ConvertTo.wrapper(arr), arr[15]);
		
		//Generating random numbers and searching those in a array
		Random r = new Random();
		Arrays.sort(arr);
	while(true){
		int z=r.nextInt(100000);
		int location = Arrays.binarySearch(arr,z);
		if(location>0){
			System.out.println(location+"--------"+arr[location]+"======"+z);
			break;
		}
	}
		
	
	String [] countires = new String[200];
	//searching a country in countries
//	String [] countires = ArrayGenerator.fillArray(String.class,new RandomGenerator.CountryNames(),150);
	ArrayGenerator.fillArray(countires, new RandomGenerator.CountryNames(),150);
	System.out.println("ArraySearching.main()"+Arrays.toString(countires));
//	searchArray(countires, "India");
	
	String[] s = ArrayCopying.copyArrayRemovingNull(countires);
	System.out.println("ArraySearching.main()"+Arrays.toString(s));
	
	}
	
	//if we comment Arrays.sort the Arrays.binarchsearch behaves improperly and gives negative value here if we comment Arrays.sort and print location
	//we can see the improper behaviour
	static <T> boolean searchArray(T[] arr, T value){
		Arrays.sort(arr);
		System.out.println("ArraySearching.searchArray()"+Arrays.toString(arr));
		int location =Arrays.binarySearch(arr,value);
		System.out.println("ArraySearching.searchArray()"+location);
		return Arrays.binarySearch(arr,value)>0?true:false;
	}
	
	

}
