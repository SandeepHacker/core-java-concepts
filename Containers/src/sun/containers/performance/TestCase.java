package sun.containers.performance;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import sun.containers.fillers.Pair;
import sun.containers.linkedlist.ClassicArrayList;
import sun.containers.own.ClassicMap;
import sun.containers.own.PairContainer;
import sun.containers.own.UniqueContainer;

public class TestCase<E>{
	
	private E[] params;
	
	private static final String  value="Sun"; 
	
	
	public TestCase(E[] params) {
		this.params=params;
	}
	 
	 public class ListTest{
			
			
			public class Add implements Test<List<E>>{


				@Override
				public void test(List<E> test, int size) {
								for(int i=0;i<size;i++)
									test.add(params[i]);
				}
				
			}
			
			public  class Get implements Test<List<E>>{

				@Override
				public void test(List<E> test, int size) {
								for(int i=0;i<size;i++)
									test.get(i);
				}
				
			}
			
			public  class Contains implements Test<List<E>>{

				@Override
				public void test(List<E> test, int size) {
								for(int i=0;i<size;i++)
									test.contains(params[i]);
					
				}
				
			}
			
			public  class IndexOf implements Test<List<E>>{

				@Override
				public void test(List<E> test, int size) {
								for(int i=0;i<size;i++)
									test.indexOf(params[i]);
					
				}
				
			}
			
			public  class IteratorAdd implements Test<List<E>>{

				@Override
				public void test(List<E> test, int size) {
					ListIterator<E> ir = test.listIterator(test.size()/2);
								for(int i=0;i<size;i++)
									ir.add(params[i]);
					
				}
				
			}
			
/*			public  class IteratorRemove implements Test<List<E>>{

				@Override
				public void test(List<E> test, int size) {
					ListIterator<E> ir = test.listIterator();
							while(ir.hasNext()){
								ir.next();
								ir.remove();
							}
					
				}
				
			}*/
			
			public  class Remove implements Test<List<E>>{

				@Override
				public void test(List<E> test, int size) {
					for(int i=0;i<size;i++)
						test.remove(params[i]);
					
				}
				
			}
			
			public  class RemoveByIndex implements Test<List<E>>{

				@Override
				public void test(List<E> test, int size) {
					for(int i=0;(i<size/20-1);i++)
						test.remove(i);
					
				}
				
			}
			
			public  class Insert implements Test<List<E>>{

				@Override
				public void test(List<E> test, int size) {
								for(int i=0;i<size;i++)
									test.add(i,params[i]);
					
				}
				
			}

			
		
			public  class Set implements Test<List<E>>{

				@Override
				public void test(List<E> test, int size) {
								for(int i=0;i<size;i++)
									test.set(i,params[i]);
				}
				
			}
			
			
		}
	   
	 
	 public  class SetTest{
			
			
		 public	 class Add implements Test<Set<E>>{

			@Override
			public void test(Set<E> test, int size) {
							for(int i=0;i<size;i++)
								test.add(params[i]);
			}
			
		}
		
		 public class Get implements Test<Set<E>>{

			@Override
			public void test(Set<E> test, int size) {
		
							for(int i=0;i<size;i++){
								Iterator<E> itr = test.iterator();
								while(itr.hasNext()){
									if(params[i].equals(itr.next()))
											break;
								}
							}
				
			}
			
		}
		 
		 public class Contains implements Test<Set<E>>{

				@Override
				public void test(Set<E> test, int size) {
			
								for(int i=0;i<size;i++)
									test.contains(params[i]);
					
				}
				
			}
			
		
		
	} 
	 public class FastTraversalLinkedListTest{
			
			
			public class Add implements Test<FastTraversalLinkedList<E>>{


				@Override
				public void test(FastTraversalLinkedList<E> test, int size) {
								for(int i=0;i<size;i++)
									test.add(params[i]);
				}
				
			}
			
			public  class Get implements Test<FastTraversalLinkedList<E>>{

				@Override
				public void test(FastTraversalLinkedList<E> test, int size) {
								for(int i=0;i<size;i++)
									test.get(i);
				}
				
			}
					
			public  class IteratorAdd implements Test<FastTraversalLinkedList<E>>{

				@Override
				public void test(FastTraversalLinkedList<E> test, int size) {
					ListIterator<E> ir = test.listIterator(test.size()/2);
								for(int i=0;i<size;i++)
									ir.add(params[i]);
					
				}
				
			}
			
		/*	public  class IteratorRemove implements Test<FastTraversalLinkedList<E>>{

				@Override
				public void test(FastTraversalLinkedList<E> test, int size) {
					ListIterator<E> ir = test.listIterator();
							while(ir.hasNext()){
								ir.next();
								ir.remove();
							}
					
				}
				
			}*/
		
			
			public  class Insert implements Test<FastTraversalLinkedList<E>>{

				@Override
				public void test(FastTraversalLinkedList<E> test, int size) {
								for(int i=0;i<size;i++)
									test.add(i,params[i]);
					
				}
				
			}

			
		
			public  class Set implements Test<FastTraversalLinkedList<E>>{

				@Override
				public void test(FastTraversalLinkedList<E> test, int size) {
								for(int i=0;i<size;i++)
									test.set(i,params[i]);
				}
				
			}
			
			
		}
	   
	 
	 
	 
	 
	 public class ClassicArrayListTest{
		 
		 public	 class Add implements Test<ClassicArrayList<E>>{

			@Override
			public void test(ClassicArrayList<E> test, int size) {
				for(int i=0;i<size;i++)
					test.add(params[i]);
			}

			}
		 
		 public class Get implements Test<ClassicArrayList<E>>{

				@Override
				public void test(ClassicArrayList<E> test, int size) {
			
								for(int i=0;i<size;i++)
									test.get(i);
					
				}
				
			}
			 
			 public class Contains implements Test<ClassicArrayList<E>>{

					@Override
					public void test(ClassicArrayList<E> test, int size) {
				
									for(int i=0;i<size;i++)
										test.contains(params[i]);
						
					}
					
				}
			 public class IndexOf implements Test<ClassicArrayList<E>>{

					@Override
					public void test(ClassicArrayList<E> test, int size) {
				
									for(int i=0;i<size;i++)
										test.indexOf(params[i]);
						
					}
					
				}

	 }
	 
	 
	 public class MapTest{
		 
			Random r=new Random();
		 public class Put<V> implements Test<Map<E, V>>{

			@Override
			public void test(Map<E, V> test, int size) {
				for(int i=0;i<size;i++){
					Pair<E, V> pair = (Pair<E, V>) params[i];
					test.put(pair.k, pair.v);
				}
				
			}
			 
		 }
		 
		 public class Get<V> implements Test<Map<E, V>>{

				@Override
				public void test(Map<E, V> test, int size) {
					for(int i=0;i<size;i++){
						Pair<E, V> pair = (Pair<E, V>) params[r.nextInt(params.length-1)];
						test.get(pair.k);
					}
					
				}
				 
			 }
		 
		 public class ContainsKey<V> implements Test<Map<E, V>>{

				@Override
				public void test(Map<E, V> test, int size) {
				
					for(int i=0;i<size;i++){
						@SuppressWarnings("unchecked")
						Pair<E, V> pair = (Pair<E, V>) params[r.nextInt(params.length-1)];
						test.containsKey(pair.k);
					}
					
				}
				 
			 }
		 
/*		 public class ContainsValue<V> implements Test<Map<E, V>>{

				@Override
				public void test(Map<E, V> test, int size) {
				
					for(int i=0;i<size;i++){
						@SuppressWarnings("unchecked")
						Pair<E, V> pair = (Pair<E, V>) params[r.nextInt(params.length-1)];
						test.containsValue(pair.v);
					}
					
				}
				 
			 }*/
		 
		 public class Iterate<V> implements Test<Map<E, V>>{

				@Override
				public void test(Map<E, V> test, int size) {
					Iterator iz = test.entrySet().iterator();
					for(int i=0;i<size;i++){
					
					while(iz.hasNext()){
						iz.next();
					}
					}
					
				}
				 
			 }
	 }
	 
	 public class ClassicMapTest{
		 
			Random r=new Random();
		 public class Put<V> implements Test<ClassicMap<E, V>>{

			@Override
			public void test(ClassicMap<E, V> test, int size) {
				for(int i=0;i<size;i++){
					Pair<E, V> pair = (Pair<E, V>) params[i];
					test.put(pair.k, pair.v);
				}
				
			}
			 
		 }
		 
		 public class Get<V> implements Test<ClassicMap<E, V>>{

				@Override
				public void test(ClassicMap<E, V> test, int size) {
					for(int i=0;i<size;i++){
						Pair<E, V> pair = (Pair<E, V>) params[r.nextInt(params.length-1)];
						test.get(pair.k);
					}
					
				}
				 
			 }
		 
		 public class ContainsKey<V> implements Test<ClassicMap<E, V>>{

				@Override
				public void test(ClassicMap<E, V> test, int size) {
				
					for(int i=0;i<size;i++){
						@SuppressWarnings("unchecked")
						Pair<E, V> pair = (Pair<E, V>) params[r.nextInt(params.length-1)];
						test.containsKey(pair.k);
					}
					
				}
				 
			 }
		/* public class ContainsValue<V> implements Test<ClassicMap<E, V>>{

				@Override
				public void test(ClassicMap<E, V> test, int size) {
				
					for(int i=0;i<size;i++){
						@SuppressWarnings("unchecked")
						Pair<E, V> pair = (Pair<E, V>) params[r.nextInt(params.length-1)];
						test.containsValue(pair.v);
					}
					
				}
				 
			 }*/
		 
		 public class Iterate<V> implements Test<ClassicMap<E, V>>{

				@Override
				public void test(ClassicMap<E, V> test, int size) {
					Iterator iz = test.entrySet().iterator();
					for(int i=0;i<size;i++){
			
					while(iz.hasNext()){
						iz.next();
					}
					}
					
				}
				 
			 }
		 
	 }
	 
	 public class GreatMapTest{
		 
			Random r=new Random();
		 public class Put<V> implements Test<PairContainer<E, V>>{

			@Override
			public void test(PairContainer<E, V> test, int size) {
				for(int i=0;i<size;i++){
					@SuppressWarnings("unchecked")
					Pair<E, V> pair = (Pair<E, V>) params[i];
					test.put(pair.k, pair.v);
				}
				
			}
			 
		 }
		 
		 public class Get<V> implements Test<PairContainer<E, V>>{

				@Override
				public void test(PairContainer<E, V> test, int size) {
					for(int i=0;i<size;i++){
						@SuppressWarnings("unchecked")
						Pair<E, V> pair = (Pair<E, V>) params[r.nextInt(params.length-1)];
						test.get(pair.k);
					}
					
				}
				 
			 }
/*		 
		 public class ContainsValue<V> implements Test<PairContainer<E, V>>{

				@Override
				public void test(PairContainer<E, V> test, int size) {
				
					for(int i=0;i<size;i++){
						@SuppressWarnings("unchecked")
						Pair<E, V> pair = (Pair<E, V>) params[r.nextInt(params.length-1)];
						test.containsValue(pair.v);
					}
					
				}
				 
			 }*/
		 
		 public class ContainsKey<V> implements Test<PairContainer<E, V>>{

				@Override
				public void test(PairContainer<E, V> test, int size) {
				
					for(int i=0;i<size;i++){
						@SuppressWarnings("unchecked")
						Pair<E, V> pair = (Pair<E, V>) params[r.nextInt(params.length-1)];
						test.containsKey(pair.k);
					}
					
				}
				 
			 }
		 
		 public class Iterate<V> implements Test<PairContainer<E, V>>{

				@Override
				public void test(PairContainer<E, V> test, int size) {
					Iterator iz = test.iterator();
					for(int i=0;i<size;i++){
						
					while(iz.hasNext()){
						iz.next();
					}
					}
					
				}
				 
			 }
		 
		 
		 
	 }
	 
	 public  class UniqueContainerTest{
			
			
		 public	 class Add implements Test<UniqueContainer<E>>{

			@Override
			public void test(UniqueContainer<E> test, int size) {
							for(int i=0;i<size;i++)
								test.add(params[i]);
			}
			
		}
		
		 public class Get implements Test<UniqueContainer<E>>{

			@Override
			public void test(UniqueContainer<E> test, int size) {
		
							for(int i=0;i<size;i++){
								Iterator<E> itr = test.iterator();
								while(itr.hasNext()){
									if(params[i].equals(itr.next()))
											break;
								}
							}
				
			}
			
		}
		 
		 public class Contains implements Test<UniqueContainer<E>>{

				@Override
				public void test(UniqueContainer<E> test, int size) {
			
								for(int i=0;i<size;i++)
									test.contains(params[i]);
					
				}
				
			}
			
		
		
	} 
	  
	
}
