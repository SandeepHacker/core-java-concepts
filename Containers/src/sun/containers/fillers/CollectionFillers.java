package sun.containers.fillers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*There are two ways we can fill collection 
a)nCopies---return a immutable list 
	b)fill-The fill( ) method is made even less useful by the fact that it can only replace elements that are already
	 in the List and will not add new elements*/
public class CollectionFillers {
	
	
	
	public static void main(String[] args) {
		
	List<Food> list = 	Collections.nCopies(5, new Food("Lamb"));
	
	System.out.println("Original::::"+list);
	List<Food> list1 = new ArrayList<Food>(list);
	
	/*This throws Exception because ncopies returns a immotable list*/
//	Collections.fill(list, new Food("Eggs"));//java.lang.UnsupportedOperationException
	
	Collections.fill(list1, new Food("Fish"));
	System.out.println("After fill :: "+list1);
	
	
	}

}
