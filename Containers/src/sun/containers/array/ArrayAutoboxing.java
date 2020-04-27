package sun.containers.array;

import java.util.Arrays;
/*
 * There is a flaw in Autoboxing and unboxing while it comes to array and
 * wrapper Demonstration primitive array and wrapper array doesn't support
 * autoboxing and unboxing
 */

public class ArrayAutoboxing {
	
		public static void main(String[] args) {
		
//		Integer[] res = getArrayLoaded();
		int[] res1 = getArrayLoaded();
		passArrayLoaded(new int[] {2,3,4,5});
//		passWrapperArrayLoaded(new int[] {2,34,4,5});
	}
	
	
	/*
	 * this method returns a primitive array which cannot be hold by corresponding
	 * wrapper array
	 */
	static int[] getArrayLoaded() {
		return new int[] {2,5,7,8,9};
	}
	
	/*
	 * this method take primitive array as parameter passing wrapper array cause
	 * compilation error
	 */
	static void passArrayLoaded(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	

	/*
	 * this method take wrapper array as parameter passing primitive array cause
	 * compilation error
	 */
	static void passWrapperArrayLoaded(Integer[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	

}
