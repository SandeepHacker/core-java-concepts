package sun.containers.fillers;

import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import sun.containers.array.filler.Generator;
/*This class had multiple static method to get appropiate Collection class which take generator and size as parameters*/
public class ContainerGenerator {
	
	
public static <E> ArrayList<E> loadArrayList(Generator<E> gen, int size){
	return new ArrayList<E>(new List<E>(gen,size));
}

public static <E> LinkedList<E> loadLinkedList(Generator<E> gen, int size){
	return new LinkedList<E>(new List<E>(gen,size));
}


public static <E> HashSet<E> loadHashSet(Generator<E> gen, int size){
	return new HashSet<E>(new Set<E>(gen,size));
}

public static <E> LinkedHashSet<E> loadLinkedHashSet(Generator<E> gen, int size){
	return new LinkedHashSet<E>(new Set<E>(gen,size));
}

public static <E> TreeSet<E> loadTreeSet(Generator<E> gen, int size){
	return new TreeSet<E>( new Set<E>(gen,size));
}

public static <K,V> HashMap<K,V> loadHashMap(Generator<Pair<K, V>> gen, int size){
	return new MapContainer<K,V>(gen, size);
}

public static <K,V> HashMap<K,V> loadHashMap(Generator<K> key,Generator<V> val, int size){
	return new MapContainer<K,V>(key,val, size);
}
public  static <K,V> LinkedHashMap<K,V> loadLinkedHashMap(Generator<Pair<K, V>> gen, int size){
	return new LinkedHashMap<K, V>( new MapContainer<K,V>(gen, size));
}
public static <K,V> LinkedHashMap<K,V> loadLinkedHashMap(Generator<K> key,Generator<V> val, int size){
	return new LinkedHashMap<K, V>( new MapContainer<K,V>(key,val, size));
}
public static <K,V> TreeMap<K,V> loadTreeMap(Generator<Pair<K, V>> gen, int size){
	return new TreeMap<K, V>( new MapContainer<K,V>(gen, size));
}
public static <K,V> TreeMap<K,V> loadTreeMap(Generator<K> key,Generator<V> val, int size){
	return new TreeMap<K, V>( new MapContainer<K,V>(key,val, size));
}

public static <K,V> Hashtable<K,V> loadHashtable(Generator<Pair<K, V>> gen, int size){
	return new Hashtable<K, V>( new MapContainer<K,V>(gen, size));
}
public static <K,V> Hashtable<K,V> loadHashtable(Generator<K> key,Generator<V> val, int size){
	return new Hashtable<K, V>( new MapContainer<K,V>(key,val, size));
}
	
	
public static  <K,V> Map<K,V> loadReadOnlyMap(Generator<Pair<K, V>> gen, int size){
	return  new ReadOnlyMap<K, V>(gen, size);
}

public static <E> java.util.List<E> loadReadOnlyList(Generator<E> gen, int size){
	return  new ReadOnlyList<E>(gen, size);
}

public static <E> java.util.Set<E> loadReadOnlySet(Generator<E> gen, int size){
	return  new ReadOnlySet<E>(gen, size);
}
	
	
	


private static class List<E> extends ArrayList<E>{
	
	
	public List(Generator<E> gen, int size) {
		for(int i=0;i<size;i++)
			add(gen.next());
	}
	
	
}

private static class Set<E> extends HashSet<E>{
	
	
	public Set(Generator<E> gen, int size) {
		for(int i=0;i<size;i++)
			add(gen.next());
	}
	
	
}
	

	private static class ReadOnlyMap<K, V> extends AbstractMap<K, V> {

		Generator<Pair<K, V>> gen;
		private int size;

		public ReadOnlyMap(Generator<Pair<K, V>> gen, int size) {
			this.gen = gen;
			this.size = size;
		}

		@Override
		public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
			java.util.Set<java.util.Map.Entry<K, V>> set = new LinkedHashSet<java.util.Map.Entry<K, V>>();
			for (int i = 0; i < size; i++)
				set.add(new Entry<K, V>(gen));
			return set;
		}

		private static class Entry<K, V> implements java.util.Map.Entry<K, V> {
			private Pair<K, V> pair;

			public Entry(Generator<Pair<K, V>> gen) {
				this.pair = gen.next();
			}

			@Override
			public K getKey() {

				return pair.k;
			}

			@Override
			public V getValue() {
				// TODO Auto-generated method stub
				return pair.v;
			}

			@Override
			public V setValue(V value) {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException();
			}

			@Override
			public int hashCode() {
				// TODO Auto-generated method stub
				return pair.k.hashCode();
			}

		}

	}

	private static class ReadOnlySet<V> extends AbstractSet<V> {

		private Generator<V> gen;
		private int size;

		public ReadOnlySet(Generator<V> gen, int size) {
			this.gen = gen;
			this.size = size;
		}

		@Override
		public Iterator<V> iterator() {

			return new Iterator<V>() {
				int length = size;

				@Override
				public boolean hasNext() {
					// TODO Auto-generated method stub
					return size < 0;
				}

				@Override
				public V next() {

					length--;
					return gen.next();
				}

			};
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return size;
		}

	}

	private static class ReadOnlyList<E> extends AbstractList<E> {
		private int size;
		private Generator<E> gen;

		public ReadOnlyList(Generator<E> gen, int size) {
			this.size = size < 0 ? 0 : size;
		}

		@Override
		public E get(int index) {
			return gen.next();
		}

		@Override
		public int size() {
			return size;
		}

	}

	public static <T,E>T loadContainer(Class<T> type, Generator<E> gen, int size){
					T tmp=null;
					try {
						tmp  = type.newInstance();

						Method m = tmp.getClass().getMethod("add", Object.class);
						for(int i=0;i<size;i++)
							m.invoke(tmp, gen.next());
					}
					catch (NoSuchMethodException npe) {
						try {
							Method[] m1 = tmp.getClass().getMethods();
							for(Method m : m1){
								if(m.getName().equals("put") && m.getParameterCount()==2){
									for(int i=0;i<size;i++){
							Pair pair = (Pair) gen.next();
							m.invoke(tmp, pair.k,pair.v);
									}
								}
						
							}				
						} catch (Exception e) {

							throw new RuntimeException("Loading Container failed",e);
						} 
					}
					catch (Exception e) {
						
						throw new RuntimeException("Loading Container failed",e);
					} 
	
		return tmp;
	}

}
