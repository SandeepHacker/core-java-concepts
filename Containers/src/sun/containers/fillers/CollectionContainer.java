package sun.containers.fillers;

import java.util.ArrayList;

import sun.containers.array.filler.Generator;
/*Virtually all Collection subtypes have a constructor that takes another Collection object, 
 * from which it can fill the new container. In order to easily create test data, then, all we need to do is build a class that takes 
 * constructor arguments of a Generator
 * 
 * CollectionContainer is an example of the Adapter design pattern  it adapts a Generator to the
constructor for a Collection.All the generators defined in the Arrays chapter are now available via the CollectionData adapter.*/
public class CollectionContainer <E> extends ArrayList<E> {

	public CollectionContainer(Generator<E> gen, int size) {
		for(int i=0;i<size;i++)
			add(gen.next());
	}
	
	public static  <E> CollectionContainer<E> loadContainer(Generator<E> gen,int size)throws Exception{	
		return new CollectionContainer<E>(gen, size);
	}
	
}
