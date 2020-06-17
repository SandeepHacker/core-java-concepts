package sun.containers.own;

import java.util.Iterator;
import java.util.LinkedHashMap;

import sun.containers.own.GreatMap.PairLink;

public class LinkedGreatMap<K,V> extends GreatMap<K,V>{

	
	private LinkedPairLink<K,V> head;
	
	private LinkedPairLink<K,V> tail;
	
	static class LinkedPairLink<K,V> extends GreatMap.PairLink<K, V>{
		
		private K key;
		private V value;
		LinkedPairLink<K, V> prevLink;
		LinkedPairLink<K, V> nextLink;

		
		public LinkedPairLink(K key, V value,LinkedPairLink<K, V> nextLink) {
			super(key,value,nextLink);
			this.key = key;
			this.value = value;
			this.nextLink = nextLink;

		}


		@Override
		public K getKey() {
			return this.key;
		}


		@Override
		public V getValue() {
			return this.value;
		}


		@Override
		public V setValue(V value) {
			V v =this.value;
			this.value=value;
			return v;
		}
		
	

}


	
	@Override
	protected sun.containers.own.GreatMap.PairLink<K, V> newNode(K key,
			V value, sun.containers.own.GreatMap.PairLink<K, V> next) {
		LinkedPairLink<K, V> p = new LinkedPairLink<K, V>(key, value, null);
		linkNodeLast(p);
		SIZE++;
		return p;
	}
	
	 private void linkNodeLast(LinkedPairLink<K,V> p) {
		 LinkedPairLink<K,V> last = tail;
	        tail = p;
	        if (last == null)
	            head = p;
	        else {
	            p.prevLink = last;
	            last.nextLink = p;
	        }
	    }
	 
	 @Override
	public Iterator<sun.containers.own.PairContainer.Pairs<K, V>> iterator() {
	
		return new Iterator<PairContainer.Pairs<K,V>>() {
			 LinkedPairLink<K, V> temp=head;
			@Override
			public boolean hasNext() {
			
				return temp!=null;
			}
			
			@Override
			public sun.containers.own.PairContainer.Pairs<K, V> next() {
				LinkedPairLink<K, V> tmp = temp;
				temp=temp.nextLink;
				return tmp;
			}
		};
	}
	 
	 
	 
	 
	public void print(){
	
		for(LinkedPairLink<K, V> n=tail; n!=null;n=n.prevLink){
		System.out.println(n.getKey()+"---"+n.getValue());
		}
	}
}
