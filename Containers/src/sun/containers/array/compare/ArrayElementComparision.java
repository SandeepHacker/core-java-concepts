package sun.containers.array.compare;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import sun.containers.array.filler.ArrayGenerator;
import sun.containers.array.filler.Generator;
/*This class demonstrates Arrays.sort method which uses the Comparable compare method to sort the array but comparing elements of an array
If the element of the array doesn't implement Comparable then Arrays.sort method throws ClassCastException.
So, If we get a class that doesn't implement Comparable we need to go for Comparator interface
*/public class ArrayElementComparision {
	
	static CompareType[] getCompareTypes(int size){
		CompareType [] ct = ArrayGenerator.fillArray(CompareType.class,new Generator<CompareType>() {
			Random r = new Random();
			@Override
			public CompareType next() {
				// TODO Auto-generated method stub
				return new CompareType(r.nextInt(100), r.nextInt(100));
			}
		},size);
		return ct;
	}
	public static void main(String[] args) {
	
	CompareType[] ct=getCompareTypes(20);
	
	System.out.println("Original Array----------"+Arrays.toString(ct));
	//If the array elements doesn't implement Comparable the Arrays.sort() method throws java.lang.ClassCastException
	Arrays.sort(ct);
	
	System.out.println("After Sorting  Array----------"+Arrays.toString(ct));
	
	Arrays.sort(ct, Collections.reverseOrder());//Collections.reverseOrder() return a Comparator which is reverse of Comparable sort order
	
	System.out.println("After Collections.reverseOrder()  Array----------"+Arrays.toString(ct));
	
	Arrays.sort(ct, (x,y)->x.getJ()>y.getJ()?1:x.getJ()<y.getJ()?-1:0);//passed a Comparator using lamda expression comparing J as value
	
	System.out.println("After Sorting  Array using Comparator----------"+Arrays.toString(ct));
	}
	
	
	

}
