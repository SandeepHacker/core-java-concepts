package sun.containers.own;

import java.util.Collection;
import java.util.Set;

public interface PairContainer<K,V> extends Iterable<PairContainer.Pairs<K, V>>{
	
public interface Pairs<K,V>{

	public K getKey();

	public V getValue();

	public V setValue(V value);

}

	public int size();


	public boolean isEmpty() ;


	public boolean containsKey(K key) ;

	
	public boolean containsValue(V value) ;

	
	public V get(K key);


	public V put(K key, V value);


	public V remove(K key);



	public void putAll(PairContainer map);


	public void clear();



/*	public Set keySet();



	public Collection values();



	public Set entrySet();
*/
}
