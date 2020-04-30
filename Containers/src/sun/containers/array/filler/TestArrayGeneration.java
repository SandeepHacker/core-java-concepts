package sun.containers.array.filler;

import java.util.Arrays;

public class TestArrayGeneration {
	
	public static void main(String[] args) throws Exception{
	
		Integer[] arr= new Integer[10];
		int[] parr =new int[10];
	
		/*The most important thing here we cannot pass primitive int array but we can pass Wrapper Array 
		 * as the method is generic and primitive array doesn;t work with generics*/
		
		
		/*================Error=================*/
//		ArrayGenerator.fillArray(parr, new SerialGenerator.Integer());
		
		ArrayGenerator.fillArray(arr, new SerialGenerator.Integer());
		System.out.println(Arrays.toString(arr));
		
		/*The most important thing here we cannot pass primitive class i.e char.class but we can pass Wrapper Array class
		 * as the method is generic class we cannot use primitive class*/
		
		/*=======Error=====*/
//		Character[] pcarr =	ArrayGenerator.fillArray(Character.class,new SerialGenerator.Character(true), 26);
		
	Character[] carr =	ArrayGenerator.fillArray(Character.class,new SerialGenerator.Character(true), 26);
	System.out.println(Arrays.toString(carr));
	
	
	String[] sarr =	ArrayGenerator.fillArray(String.class,new RandomGenerator.String(), 26);
	System.out.println(Arrays.toString(sarr));
	
	String[] conarr =	ArrayGenerator.fillArray(String.class,new RandomGenerator.CountryNames(), 50);
	System.out.println(Arrays.toString(conarr));
	
//	==================Error======================
//	char[] alphabets = ArrayGenerator.fillArray(Character.class,new SerialGenerator.Character(true), 26);
	
	char[] alphabets = ConvertTo.primitive(ArrayGenerator.fillArray(Character.class,new SerialGenerator.Character(), 26));
	
//		generateAlltypeArrays(SerialGenerator.class);
	}
	
	
	//Using a class like SerialGenerator printing all generators generating elements
	static void generateAlltypeArrays(Class<?> clazz)throws Exception{
		for(Class<?> clz : clazz.getClasses()){
			Generator<?> gen = (Generator<?>)clz.newInstance();
			System.out.println(clz.getSimpleName());
			System.out.print("[");
			for(int i=0;i<10;i++){
				System.out.print(gen.next());
				if(i<9)
					System.out
							.print(", ");
			}
	System.out.println("]");
		}
			
	}

}
