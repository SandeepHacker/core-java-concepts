package sun.containers.own;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import sun.containers.array.copy.ArrayCopying;
import sun.containers.own.ClassicMap.Pair;
import sun.containers.own.UniqueContainer;

public class GreatMap<K,V> implements PairContainer<K,V>
{
	 int INITIAL_CAPACITY=16;
	
	private float LOAD_FACTOR=0.75f;
	
 long THRESHOLD=(long) (INITIAL_CAPACITY*LOAD_FACTOR);
	
	 int SIZE;

	
	private int MAXIMUM_CAPACITY=1<<30;
	
	
	
	 PairLink<K, V> [] buckets = new PairLink[INITIAL_CAPACITY];
	
	static class PairLink<K,V> implements PairContainer.Pairs<K, V>,Iterator<PairLink<K, V>>{

		private K key;
		
		private V value;
		
		PairLink<K, V> nextLink;

		
		public PairLink(K key, V value, PairLink<K, V> nextLink) {
			this.key = key;
			this.value = value;
			this.nextLink = nextLink;
		}

		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return this.key;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return this.value;
		}

		@Override
		public V setValue(V value) {
		V v= this.value;
		this.value=value;
			return v;
		}

		public boolean end(){
			return this.nextLink==null;
		}

	@Override
	public String toString() {
			StringBuilder out=new StringBuilder();
		
			for(PairLink<K,V> n=this;n!=null;n=n.nextLink){
				if(n.end()){
					out.append(n.key).append("=").append(n.value);
				}else{
					out.append(n.key).append("=").append(n.value).append(", ");
				}
			}
			return new String(out);
		
	}

	@Override
	public boolean hasNext() {
			return end();
	}

	@Override
	public PairLink<K, V> next() {
		PairLink<K,V> n=this;
		PairLink<K,V> tmp =n;
		n=n.nextLink;
		return tmp;
	}
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return SIZE;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return SIZE==0;
	}

	@Override
	public boolean containsKey(K key) {
		return get(key)!=null;
	}
	PairLink<K, V>[] tmp;
	@Override
	public boolean containsValue(V value) {
		if(tmp==null || tmp.length!=SIZE)
		tmp =ArrayCopying.copyArrayRemovingNull(buckets);
		for(PairLink<K, V> head:tmp){
			for(PairLink<K, V> h = head;h!=null;h=h.nextLink){
				if(h.getValue()==value || h.getValue().equals(value))
					return true;
			}
		}
		return false;
	}

	@Override
	public V get(K key) {
		PairLink<K, V>[] data=buckets;
		PairLink<K, V> head;
		if((head=data[((INITIAL_CAPACITY-1) & hash(key))]) !=null){
			do{
				if(head.key!=key || hash(key)!=hash(head.key) && head.key.equals(key))
					return head.getValue();
				head=head.nextLink;
			}while(head!=null);
		}
		return null;
	}
	
	public void print(){
		for(PairLink<K, V> link:buckets){
			System.out.println(link);
		}
	}
	int count=0;
@SuppressWarnings("unchecked")
void resize(){
	if(INITIAL_CAPACITY>MAXIMUM_CAPACITY)
		INITIAL_CAPACITY=Integer.MAX_VALUE;
	
	INITIAL_CAPACITY=Prime.firstPrimeAfter(INITIAL_CAPACITY<<2);
	THRESHOLD=(long) (INITIAL_CAPACITY*LOAD_FACTOR);
	SIZE=0;
	PairLink<K, V>[] tmp=buckets;
	 buckets = new PairLink[INITIAL_CAPACITY] ;	
	for(PairLink<K, V> cc :tmp){
		for(PairLink<K, V> t =cc;t!=null;t=t.nextLink){
		put(t.key, t.value);
		}
	}
}
	@Override
	public V put(K key, V value) {
		if(SIZE>THRESHOLD){
			resize();
		}
		PairLink<K, V>[] tmp = buckets;
		PairLink<K, V> head,prev=null;
		if((head=tmp[((INITIAL_CAPACITY-1) & hash(key))])==null){
			tmp[((INITIAL_CAPACITY-1) & hash(key))]=newNode(key,value,null);
		}else{
			do{
				prev=head;
				if(head.getKey()==key || hash(head.getKey())==hash(key) && head.getKey().equals(key))
					return head.setValue(value);
				head=head.nextLink;
			}while(head!=null);
			prev.nextLink=newNode(key,value,null);
		}

		return null;
	}
	
	protected PairLink<K,V> newNode(K key, V value,PairLink<K, V> next){
		SIZE++;
		return new PairLink<K,V>(key, value, next);
	}
	
	protected V removeNode(PairLink<K, V> head,K key){
		PairLink<K, V> temp =head;
		PairLink<K, V>[] tmp = buckets;
		PairLink<K, V> prev=null,next=null;
		if(temp.getKey()==key || hash(key)==hash(temp.key) && temp.getKey().equals(key)){
			tmp[hash(key)]=temp.nextLink;
			SIZE--;
			return temp.getValue();
		}
		
		for(next =temp;next!=null;next=next.nextLink){
			if(next.getKey()==key || hash(key)==hash(next.key) && next.getKey().equals(key)){
				prev.nextLink=next.nextLink;
				SIZE--;
				return temp.getValue();
			}
			prev=next;
		}
		
		return null;
	}

	@Override
	public V remove(K key) {
		int index = hash(key);
		PairLink<K, V>[] tmp = buckets;
			if(tmp[index]!=null)
		return removeNode(tmp[index], key);
		return null;
	}

	@Override
	public void putAll(PairContainer map) {
	
		
	}

	@Override
	public void clear() {
		buckets=null;
		
	}
	
	
	static final int hash(Object key) {
	    int h;
	    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}
@Override
public Iterator<sun.containers.own.PairContainer.Pairs<K, V>> iterator() {
	return new PairsIterator();
}

class PairsIterator extends PairLinkIterator implements Iterator<sun.containers.own.PairContainer.Pairs<K, V>>{

	@Override
	public sun.containers.own.PairContainer.Pairs<K, V> next() {
		// TODO Auto-generated method stub
		return nextPairLink();
	}
	
}


	class PairLinkIterator{
		PairLink<K, V>[] tmp =ArrayCopying.copyArrayRemovingNull(buckets);

		PairLink<K, V> current,temp;
		int index=0;
		
		public boolean hasNext(){
			
				return index<tmp.length;
		}
		
		PairLink<K, V> nextPairLink(){
			if(current==null){
			current=tmp[index];
			temp=current;
			current=current.nextLink;
			index++;
			return temp;
			}
			temp=current;
			current=current.nextLink;
			return temp;
		}

		
		
	}
	class KeyIterator extends PairLinkIterator implements Iterator<K>{

		@Override
		public K next() {
			return nextPairLink().getKey();
		}


		
	}
	public UniqueContainer<K> getUniqueKeys(){
		return new Keys<K>();
	}

	
	class Keys <E>implements UniqueContainer<E>{

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean contains(E o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterator iterator() {
			// TODO Auto-generated method stub
			return new KeyIterator();
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
			return false;
		}

		@Override
		public boolean remove(E o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}
		
	}

	
	
}
class Prime {
	public static int firstPrimeAfter(int n) {
		for(int i = n + 1; i > n; i++) {
			int factors = 0;
			for(int j = 1; j < (i + 2)/2; j++) {
				if((i % j) == 0) factors++;
			}
			if(factors < 2) return i;
		}
		return 0;
	}
}