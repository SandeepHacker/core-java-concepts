package sun.containers.own;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import sun.containers.own.GreatMap;
import sun.containers.own.PairContainer;

public class GreatSet<E> implements UniqueContainer<E>{

	private GreatMap<E, Object> map = new GreatMap<E, Object>();
	
	private Object VALUE=null;

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean contains(E o) {
		return map.containsKey(o);
	}

	@Override
	public Iterator iterator() {
		
		return map.getUniqueKeys().iterator();
	}

	@Override
	public E[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E[] toArray(E[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return map.put(e, VALUE)!=null;
	}

	@Override
	public boolean remove(E o) {
		// TODO Auto-generated method stub
		return map.remove(o)!=null;
	}

	@Override
	public void clear() {
		map.clear();
		
	}


}
