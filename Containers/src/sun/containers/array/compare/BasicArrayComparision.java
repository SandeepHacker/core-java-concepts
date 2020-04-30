package sun.containers.array.compare;

import java.util.Arrays;
/*Arrays class provides the equals( ) method to compare entire arrays for equality, which is overloaded for all the primitives and for Object.
 *  To be equal, the arrays must have the same number of elements, and each element must be equivalent to each corresponding element in the 
 *  other array, using the equals( ) for each element. The first array element will be compared with first element of second array and so on till last 
 *  element if all are true it returns true*/
public class BasicArrayComparision {
	
	public static void main(String[] args) {
		int [] i = new int[10];
		Arrays.fill(i, 19);
		int [] j = new int[10];
		Arrays.fill(j, 19);
		System.out.println(Arrays.equals(i, j));
		j[3]=2;//modified the array
		System.out.println(Arrays.equals(i, j));
		String [] s = new String[4];
		Arrays.fill(s, "HI");
		String[] s1 = new String[]{new String("HI"),new String("HI"),new String("HI"),new String("HI")};
		System.out.println(Arrays.equals(s, s1));
		
		
		/*Using deep equals to compare multidimensional array*/
		int[][] arr1 = buildMultidimensionalArray(3, 9);
		int[][] arr2 =  buildMultidimensionalArray(3, 9);
		
		System.out.println(Arrays.deepEquals(arr1, arr2));
		
	}
	
	
    static<T> boolean compareArray(T[] first, T[] second){
    	return Arrays.equals(first, second);
    	
    }
    
    static int[][]  buildMultidimensionalArray(int base,int value){
    	int[][] arr =new int[base][base];
    	for(int i=0;i<arr.length-1;i++){
    		Arrays.fill(arr[i],value);
    	}
    	return arr;
    }

}
