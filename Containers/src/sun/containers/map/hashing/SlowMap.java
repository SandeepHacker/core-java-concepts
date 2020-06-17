package sun.containers.map.hashing;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SlowMap<K, V> extends AbstractMap<K, V> {

	private ArrayList<K> keys = new ArrayList<K>();
	private ArrayList<V> values = new ArrayList<V>();
	
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
	
		return new EntrySet();
	}
	
	
	@Override
	public V remove(Object key) {
		V v=null;
		
	if(keys.contains(key)){
		int index=keys.indexOf(key);
	v=values.get(index);
	values.remove(index);
	keys.remove(index);
	}
	
		return v;
	}

	@Override
	public V put(K key, V value) {
		if (keys.contains(key)) {
			return values.set(keys.indexOf(key), value);
		}
		keys.add(key);
		values.add(value);
		return null;

	}

	@Override
	public V get(Object key) {
		if (!keys.contains(key))
			return null;
		return values.get(keys.indexOf(key));
	}

	@Override
	public void clear() {
		keys.clear();
		values.clear();
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		KeySet ks = new KeySet();

		return ks;
	}
	


	class KeySet extends AbstractSet<K> {

		int i = keys.size()-1;

		@Override
		public Iterator<K> iterator() {
			// TODO Auto-generated method stub
			return new Iterator<K>() {

				@Override
				public boolean hasNext() {
					return i >= 0;
				}

				@Override
				public K next() {
					
					return keys.get((i--));
				}

			};
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return keys.size();
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			Iterator<?> itr = c.iterator();
			while (itr.hasNext()) {
				K k = (K) itr.next();
				if (keys.contains(k)) {
					values.remove(keys.indexOf(k));
					keys.remove(keys.indexOf(k));
				}
			}
			return false;
		}

	}
	
	class EntrySet extends AbstractSet<Map.Entry<K, V>>{
		int index = keys.size();
		@Override
		public Iterator<Map.Entry<K, V>> iterator() {
			return new Iterator<Map.Entry<K, V>>() {

				@Override
				public boolean hasNext() {
					return index>0;
				}

				@Override
				public Map.Entry<K, V> next() {
					index--;
					return new MapEntry<K,V>(keys.get(index), values.get(index));
				}
			};
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return keys.size();
		}

		@Override
		public boolean add(java.util.Map.Entry<K, V> e) {
			if(entrySet().contains(e))
				return false;
			if(keys.contains(e.getKey()))
				values.set(keys.indexOf(e.getKey()),e.getValue());
			
			keys.add(e.getKey());
			values.add(e.getValue());
			return true;
		}
		
		@Override
		public boolean addAll(Collection<? extends java.util.Map.Entry<K, V>> c) {
			Iterator<? extends java.util.Map.Entry<K, V>> itr = c.iterator();
			
			while(itr.hasNext()){
				Map.Entry<K, V> entry = itr.next();
				add(entry);
			}
			return true;
		}
		
	}

	


}
