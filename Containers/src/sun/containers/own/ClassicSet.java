package sun.containers.own;

import java.util.Arrays;
import java.util.Iterator;

import sun.containers.own.ClassicMap;

public class ClassicSet<E> {
	
	private ClassicMap<E, Object> map; 
	
	private final Object VALUE=null;
	
	public ClassicSet() {
	map=new ClassicMap<E, Object>();
	}

	
	
	public boolean add(E e) {
		return map.put(e,VALUE)==null;
	}
	

	public boolean contains(E e) {
		return map.containsKey(e);
	}
	
	public boolean remove(E e) {
		return map.remove(e);
	}
	
	public Iterator<E> iterator(){
		return  map.keys().iterator();
	}
	 public void clear(){
		map.clear();
	 }

	
	public int size(){
		return map.size();
	}
	public String toString() {
		return map.keys().toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	


}
