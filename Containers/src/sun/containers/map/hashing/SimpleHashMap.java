package sun.containers.map.hashing;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class SimpleHashMap<K,V> extends AbstractMap<K, V>{
	
	@SuppressWarnings("unchecked")
	private LinkedList<Map.Entry<K, V>>[] DATA = new LinkedList[997];

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K,V>> set= new HashSet<Map.Entry<K,V>>();
		for(LinkedList<Map.Entry<K,V>> bucket : DATA) {
		if(bucket == null) continue;
		for(Map.Entry<K,V> mpair : bucket)
		set.add(mpair);
		}
		return set;
	}
	@Override
	public V get(Object key) {
		int  index = Math.abs(key.hashCode())%997;
	
		if(DATA[index]!=null){
				for(Map.Entry<K, V> en : DATA[index])
					if(en.getKey().equals(key))
						return en.getValue();
		}
		return null;
	}
	
	
	@Override
	public V put(K key, V value) {
		int  index = Math.abs(key.hashCode())%997;
	
		V oldValue=null;
		LinkedList<Map.Entry<K, V>> linked=null;
		if(index>=0 && index<=997 ){
			if(DATA[index]==null){
				DATA[index]=new LinkedList<Map.Entry<K,V>>();
			DATA[index].add(new MapEntry<K, V>(key, value));
			}else{
				linked=DATA[index];
				Iterator<Map.Entry<K, V>> itr = linked.listIterator();
				while(itr.hasNext()){
					Entry<K, V> entry = itr.next();
					if(entry.getKey().equals(key))
						oldValue=entry.getValue();
						entry.setValue(value);
				}
			}
			
			}
		return oldValue;
	}

}
