package sun.containers.array.copy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
/*The Java standard library provides a static method, System.arraycopy( ), 
 * which can copy arrays far more quickly than if you use a for loop to perform the copy by hand.
 *  System.arraycopy( ) is overloaded to handle all types.*/
public class ArrayCopying {
	
    public static<T> T[] copyArrayRemovingNull(T[] src){
    	List<T>list = new ArrayList<T>();
  int index=0;
  	  for(int i=0;i<src.length;i++)
  		  if(src[i]!=null ){
  			  list.add(src[i]);
  			 index++;
  		  }
  	  @SuppressWarnings("unchecked")
			T[] res = (T[])(Array.newInstance(list.get(0).getClass(), index));
  	  
	  return list.toArray(res);
    }	
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

        	  /*Character[] darr = new Character[30];
        	  Generator<Character> gem=new SerialGenerator.Character();
        	  for(int i=0;i<=25;i++)
        		  darr[i]=gem.next();
        	  

        	  Character[]carr =	ArrayGenerator.fillArray(Character.class,new SerialGenerator.Character(true), 26);
          	  Character[] arr =	ArrayGenerator.fillArray(Character.class,new SerialGenerator.Character(), 26);
       
          	System.out.println("ArrayCopying.main()"+Arrays.toString(copyArray(arr, carr)));
        	  System.out.println("ArrayCopying.main()"+Arrays.toString(darr));
          	System.out.println("ArrayCopying.main()"+Arrays.toString(copyArray(carr, darr)));
        	  
          	  System.out.println("ArrayCopying.main()"+Arrays.toString(arr));
          	  
          	  test(20,11);*/
//             	ClassicMap<String,String> cmap = ClassicMap.laodClassicMap(new PairGenerator.CountryCapital(), 20);
       
		}

          
          
    
          
          static void  test(int x ,int y){
        		long start=System.currentTimeMillis();
        	  for(int i=0;i<=100000;i++){
        		  if(x>20 && y<17){
        			  if(x>20 && y<17){
        				  if(x>20 && y<17){
        	        			 
                		  }
            		  }
        		  }
        	  }
        	  long end=System.currentTimeMillis();
      		
      		System.out.println("Total time taken by classicmap::"+(end-start));
          }
          static void  test1(int x ,int y){
      		long start=System.currentTimeMillis();
      	  for(int i=0;i<=100000;i++){
      		  if(x>20 && y<17){
      			  
      		  }
      	  }
      	  long end=System.currentTimeMillis();
    		
    		System.out.println("Total time taken by classicmap::"+(end-start));
        }

}
class Person{
	   
	   String name;
	   int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	   
	   
	   
	   
}
