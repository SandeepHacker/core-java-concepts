package sun.containers.array.copy;

import java.lang.reflect.Array;
import java.util.Arrays;

import sun.containers.array.filler.ArrayGenerator;
import sun.containers.array.filler.Generator;
import sun.containers.array.filler.RandomGenerator;
import sun.containers.array.filler.SerialGenerator;
import sun.containers.array.filler.RandomGenerator.Integer;
/*The Java standard library provides a static method, System.arraycopy( ), 
 * which can copy arrays far more quickly than if you use a for loop to perform the copy by hand.
 *  System.arraycopy( ) is overloaded to handle all types.*/
public class ArrayCopying {
	
	
	/*But one thing to note here is we cannot use System.arrayCopy() for primitive Arrays*/
          public static<T> T[] copyArray(T[] src, T[] dest){
        	  int i=0;
        	  while(i<=dest.length-1){
        		  if(dest[i]==null)
        			  break;
        		i++;  
        	  }
        	  		@SuppressWarnings("unchecked")
					T[] res = (T[])(Array.newInstance(src[0].getClass(), src.length+i));
        	  		
              	  System.arraycopy(dest, 0, res, 0, i);
        	  	
        	  System.arraycopy(src, 0, res, i, src.length);
        	  return res;
          }
          
          
          public static void main(String[] args) {
        	  Character[] darr = new Character[30];
        	  Generator<Character> gem=new SerialGenerator.Character();
        	  for(int i=0;i<=25;i++)
        		  darr[i]=gem.next();
        	  

        	  Character[]carr =	ArrayGenerator.fillArray(Character.class,new SerialGenerator.Character(true), 26);
          	  Character[] arr =	ArrayGenerator.fillArray(Character.class,new SerialGenerator.Character(), 26);

          	System.out.println("ArrayCopying.main()"+Arrays.toString(copyArray(arr, carr)));
        	  System.out.println("ArrayCopying.main()"+Arrays.toString(darr));
          	System.out.println("ArrayCopying.main()"+Arrays.toString(copyArray(carr, darr)));
        	  
          	  System.out.println("ArrayCopying.main()"+Arrays.toString(arr));
		}

}
