package sun.containers.array.filler;

import java.lang.reflect.Array;
/*The biggest disavantage of this ArrayGenerator is we cannot work with primitive array we have to work with Wrapper arrays
If we pass a primitive array to this method compiler will complain as primitive array doesn't support generics
*/public class ArrayGenerator {
	
	/*This method takes an array and generator as argument and fill the array*/
	public static<T>  void fillArray(T[] arr, Generator<T> gen){
		for(int i=0;i<arr.length;i++)
			arr[i]=gen.next();
	}
	
	/*This method take the Class as argument and create the array with the specified size and fill the Array using Generator*/
	@SuppressWarnings("unchecked")
	public static <T>T[] fillArray(Class<?> clazz, Generator<T> gen,int size){
		
		T[] arr = (T[])Array.newInstance(clazz, size);
		for(int i=0;i<arr.length;i++)
			arr[i]=gen.next();
		return arr;
	}
	

}
