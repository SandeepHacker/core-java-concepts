package sun.containers.fillers;

import java.util.HashMap;

import sun.containers.array.filler.Generator;

public class MapContainer<K,V> extends HashMap<K, V> {
	
	//One Generator generates pair
	public MapContainer(Generator<Pair<K, V>> gen, int size) {
		for(int i=0;i<size;i++){
			Pair<K,V> pair = gen.next();
			put(pair.k,pair.v);
		}
	}
	// Two separate Generators:
	public MapContainer(Generator<K> key,Generator<V> val, int size) {
		for(int i=0;i<size;i++){
			put(key.next(),val.next());
		}
	}
	// A key Generator and a single value:
	public MapContainer(Generator<K> key,V val, int size) {
		for(int i=0;i<size;i++){
			put(key.next(),val);
		}
	}
	// An Iterable and a single value:
	public MapContainer(Iterable<K> key,V val) {
		for(K k: key)
			put(k, val);
	}
	// An Iterable and a value Generator:
	public MapContainer(Iterable<K> key,Generator<V> val) {
		for(K k: key)
			put(k, val.next());
	}
	
	
	
	
	public static <K,V>MapContainer<K, V> loadMap(Generator<Pair<K, V>> gen,int size){
		return new MapContainer<K, V>(gen, size);
	}
	public static <K,V>MapContainer<K, V> loadMap(Generator<K> gen,Generator<V> val,int size){
		return new MapContainer<K, V>(gen, val,size);
	}
	
	public static <K,V>MapContainer<K, V> loadMap(Generator<K> gen,V val,int size){
		return new MapContainer<K, V>(gen, val,size);
	}
	
	public static <K,V>MapContainer<K, V> loadMap(Iterable<K> gen,V val){
		return new MapContainer<K, V>(gen, val);
	}
	
	public static <K,V>MapContainer<K, V> loadMap(Iterable<K> gen,Generator<V> val){
		return new MapContainer<K, V>(gen, val);
	}

}
