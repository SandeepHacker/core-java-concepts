package sun.containers.own;

import java.util.Collection;
import java.util.Iterator;

public interface UniqueContainer<E> {


	public int size();

	public boolean isEmpty();


	public boolean contains(E o);

	
	public Iterator iterator();


	public E[] toArray();


	public E[] toArray(E[] a);


	public boolean add(E e);

	public boolean remove(E o) ;


	/*public boolean containsAll(Collection c);

	public boolean addAll(Collection c) ;


	public boolean retainAll(Collection c) ;

	public boolean removeAll(Collection c) ;*/

	public void clear() ;


}
