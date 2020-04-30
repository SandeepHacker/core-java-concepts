package sun.containers.array.filler;

import java.util.Arrays;

/*This class demonstrates the Arrays.fill method which take an array and value as argument
 *  but the  disadvantage of this is that the value filled for all elements in array is same which 
 *  makes it less useful*/
//To overcome this we go for generators
public class DefaultFiller {

	
	public static void main(String[] args) {
		int size = 6;
		boolean[] a1 = new boolean[size];
		byte[] a2 = new byte[size];
		char[] a3 = new char[size];
		short[] a4 = new short[size];
		int[] a5 = new int[size];
		long[] a6 = new long[size];
		float[] a7 = new float[size];
		double[] a8 = new double[size];
		String[] a9 = new String[size];
		
		Arrays.fill(a1, true);
		Arrays.fill(a2,(byte)22);
		Arrays.fill(a3, 'z');
		Arrays.fill(a4, (short)11);
		Arrays.fill(a5, 124);
		Arrays.fill(a6, 99L);
		Arrays.fill(a7,21.33f);
		Arrays.fill(a8, 20.34d);
		Arrays.fill(a9,"Sun");
		
		System.out.println("Boolean---------->"+Arrays.toString(a1));
		System.out.println("Byte--------->"+Arrays.toString(a2));
		System.out.println("Character---------->"+Arrays.toString(a3));
		System.out.println("Short---------->"+Arrays.toString(a4));
		System.out.println("Integer---------->"+Arrays.toString(a5));
		System.out.println("Long---------->"+Arrays.toString(a6));
		System.out.println("Float---------->"+Arrays.toString(a7));
		System.out.println("Double---------->"+Arrays.toString(a8));
		System.out.println("String---------->"+Arrays.toString(a9));
		
	}
	
	
	
	
}
