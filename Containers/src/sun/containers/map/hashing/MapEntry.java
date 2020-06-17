package sun.containers.map.hashing;

import java.util.Map;

public class MapEntry<K, V> implements Map.Entry<K, V> {
	private K k;
	private V v;
	
	public MapEntry(K k, V v) {
		this.k=k;
		this.v=v;
	}

	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return k;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return v;
	}

	@Override
	public V setValue(V value) {
		V v = this.v;
	this.v=value;
		return v;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return k.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		@SuppressWarnings("unchecked")
		Map.Entry<K, V> entry = (Map.Entry<K, V>)obj;
		
		return k.equals(entry.getKey());
	}

	@Override
	public String toString() {
		return "MapEntry [k=" + k + ", v=" + v + "]";
	}
	

}
