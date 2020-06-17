package sun.containers.own;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import sun.containers.array.copy.ArrayCopying;



public class ClassicLinkedMap<K,V> {
	
  
   transient Pair<K,V> head;

   /**
    * The tail (youngest) of the doubly linked list.
    */
   transient Pair<K,V> tail;
	private  final int length=11;
	private int size;
	@SuppressWarnings("unchecked")
	private Pair<K, V>[] pair = new Pair[length];
/*private Pair<K,V> firstLink;
private Pair<K,V> lastLink;*/
	

	 static class Pair<K, V> implements Iterable<Pair<K, V>>{
		public final K key;
		public  V value;
		public  Pair<K,V> before;
		public  Pair<K,V> nextPair;
	
		public Pair(K k, V v, Pair<K,V> pair) {
			this.key=k;
			this.value=v;
			this.nextPair=pair;
		}
		
		public void setValue(V value) {
			this.value = value;
		}

		@Override
		public String toString() {
			StringBuilder out=new StringBuilder();
		
			for(Pair<K,V> n=this;n!=null;n=n.nextPair){
				if(n.end()){
					out.append(n.key).append("=").append(n.value);
				}else{
					out.append(n.key).append("=").append(n.value).append(", ");
				}
			}
			return new String(out);
		}

		public boolean end(){
			return this.nextPair==null;
		}

		@Override
		public Iterator<Pair<K, V>> iterator() {
			
			return new Iterator<Pair<K,V>>() {
				Pair<K,V> pair =Pair.this;
				@Override
				public boolean hasNext() {
					return pair!=null;
				}
				@Override
				public Pair<K, V> next() {
					Pair<K,V> next =pair;
					pair=pair.nextPair;
					return next;
				
				}
			};
		}

	}
	int i=0;
	public V put(K key, V value){
	int index =hash(key)%length;	
System.out.println("ClassicLinkedMap.put()"+index);
	V v;
	if(pair[index]!=null){
	
		Pair<K,V> current = pair[index];
		while(current!=null){
			if(hash(key)==hash(current.key) && (key==current.key || current.key.equals(key))){
				v=current.value;
			current.setValue(value);
				return v;
			}
				current=current.nextPair;
		}
		pair[index] = new Pair<K,V>(key, value, pair[index]);
		linkNodeLast(new Pair<K,V>(key,value,null));
			size++;

		return null;
		}

	
Pair<K,V> pp=new Pair<K,V>(key,value,null);
/*if(size==0){
	firstLink=pp;
	lastLink=pp;
}else{
	linkAtLAst(pp);
}*/

linkNodeLast(pp);
	size++;
	pair[index]=pp;
return null;
}
	
	/*void linkAtLAst(Pair<K, V> pair){
		System.out.println("ClassicLinkedMap.linkAtLAst()"+pair);
		Pair<K, V> first=null;
	
		for(first=firstLink;first.nextPair!=null;first=first.nextPair){
					
		}
	first.nextPair=pair;
	System.out.println("ClassicLinkedMap.linkAtLAst()");
	}*/
	
	public V get(K key){
		int index = hash(key)%length;	
		if(pair[index]!=null)
			for(Pair<K,V> p:pair[index])
				if(hash(key)==hash(p.key) &&(p.key==key || p.key.equals(key)))
						return p.value;
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder("{");
			for(Pair<K, V> pp : pair)
				if(pp!=null)
				sb.append(pp.toString()).append(", ");
			sb.deleteCharAt(sb.lastIndexOf(" "));
			sb.deleteCharAt(sb.lastIndexOf(","));
			sb.append("}");
	return sb.toString();
	}
	

	
	public Set<K> keys(){
		return new KeySet();
	}
	public Set<V> values(){
		return new ValueSet();
	}
	public boolean containsKey(K key){
		int index = hash(key)%length;	
		if(pair[index]!=null)
			for(Pair<K,V> p:pair[index])
				if(hash(key)==hash(p.key) &&(p.key==key || p.key.equals(key)))
			return true;			
		return false;
	}
	 Pair<K,V>[] tmp;
	public boolean containsValue(V value){			
		
		 V v;
	/*        if ((tab = pair) != null && size > 0) {
	            for (int i = 0; i < tab.length; ++i) {
	                for (Pair<K,V> e = tab[i]; e != null; e = e.nextPair) {
	                    if ((v = e.value) == value ||
	                        (value != null && value.equals(v)))
	                        return true;
	                }
	            }
	        }
	        
*/ 
		 if(tmp==null){
			 tmp=ArrayCopying.copyArrayRemovingNull(pair);
		 }
		 
		 
	        for(Pair<K,V> pa:tmp){
	        	 for (Pair<K,V> e = pa; e != null; e = e.nextPair) {
	                    if ((v = e.value) == value ||
	                        (value != null && value.equals(v)))
	                        return true;
	                }
	        }
				return false;
			
	}
	
	
	class KeySet extends AbstractSet<K>{
		
		@Override
		public int size() {
			return size;
		}

		@Override
		public Iterator<K> iterator() {
			return new KeyIterator();
		}
		
		
	}
class ValueSet extends AbstractSet<V>{
		
		@Override
		public int size() {
			return size;
		}

		@Override
		public Iterator<V> iterator() {
			return new ValueIterator();
		}
		
		
	}



class EntrySet extends AbstractSet<Pair<K, V>>{

	@Override
	public Iterator<Pair<K, V>> iterator() {

		return new Iterator<Pair<K,V>>() {
						PairIterator pr = new PairIterator();
			@Override
			public boolean hasNext() {
				return pr.hasNext();
			}

			@Override
			public Pair<K, V> next() {
				return pr.nextPair();
			}
		};
	}

	@Override
	public int size() {
		return size;
	}
	
}

class PairIterator {
		 int index=-1;
		 Pair<K,V> current = null;
		public final boolean hasNext() {

			while(current==null){
		int index  = findNextPair();
		if(index>=pair.length)
			break;
		current = pair[index];
}
			return index<pair.length;

		}
		
		public Pair<K,V> nextPair() {
			Pair<K,V> nextPair = current;
			current=current.nextPair;
			return nextPair;
		}
		
		int findNextPair(){
			do
				index++;
			while(index < pair.length && pair[index]==null);
		return index;
		}
		
	}
	
	class KeyIterator extends PairIterator implements Iterator<K>{
		@Override
		public K next() {			
			return nextPair().key;
		}
	
	}
	class ValueIterator extends PairIterator implements Iterator<V>{
		@Override
		public V next() {			
			return nextPair().value;
		}
	
	}
	
	
	
	public int size(){
		return size;
	}
	
 final int hash(Object key) {
	        /*int h;
	        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> length);*/
	 return Math.abs(key.hashCode());
	    }
 
 public Set<Pair<K, V>> entrySet(){
		return new EntrySet();
	}
 
 private void linkNodeLast(Pair<K,V> p) {
     Pair<K,V> last = tail;
     tail = p;
     if (last == null)
         head = p;
     else {
         p.before = last;
         last.nextPair = p;
     }
 }
 public boolean  remove(Object key){
		int index =hash(key)%length;	
		if(pair[index]!=null)
	return	deleteNode(pair[index],index,key);
	
		return false;
 }
 /* Given a key, deletes the first occurrence of key in linked list */
 boolean deleteNode(Pair<K,V> head,int  index,Object key) 
 { 
     // Store head node 
     Pair<K,V> temp = head, prev = null; 

     // If head node itself holds the key to be deleted 
     if (temp != null && temp.key.equals(key)) 
     { 
         pair[index] = temp.nextPair; // Changed head
         return true; 
     } 
     // Search for the key to be deleted, keep track of the 
     // previous node as we need to change temp.nextPair 
     while (temp != null && !temp.key.equals(key)) 
     { 
         prev = temp;
         temp = temp.nextPair; 
  
     }     
     // If key was not present in linked list 
     if (temp == null) return false; 
     // Unlink the node from linked list 
     prev.nextPair = temp.nextPair;
     return true;
 } 
 
 public void clear(){
	 Arrays.fill(pair, null);
	 this.size=0;
 }

void print(){
	for(Pair<K, V> first=head;first!=null;first=first.nextPair){
		System.out.println("ClassicLinkedMap.print()"+first.key+"==="+first.value);
	}
	
}


public static void main(String[] args) {
	ClassicLinkedMap<Integer, String> map = new ClassicLinkedMap<Integer, String>();
	
	map.put(2, "das");
	map.put(3, "das");
	map.put(4, "das");
	map.put(5, "das");
	map.print();
}
	
}
