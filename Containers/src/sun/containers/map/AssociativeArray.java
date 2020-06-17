package sun.containers.map;

import java.util.ArrayList;
import java.util.Arrays;

import sun.containers.array.copy.ArrayCopying;
import sun.containers.array.filler.Generator;
import sun.containers.fillers.Pair;

/*So you can gain a deeper understanding of Maps, it is helpful to look at how an associative array is constructed.
 * This class acts like a map which uses associative arrays.
 * We had made some changes in our class it has a constructor which has length if we give length at object creation we cannot have autogrowable nature
 * */
public class AssociativeArray<K,V> {

	private Object[][] DATA;
	private int index;
	private boolean flag;
	
	public AssociativeArray() {
		DATA = new Object[11][2];
	}
	
	public <K,V> AssociativeArray(Generator<Pair<K, V>> gen) {
		DATA = new Object[11][2];
		for(int i=0;i<DATA.length;i++){
			Pair<K,V> p =gen.next(); 
			DATA[i]=new Object[]{p.k,p.v};
		}
	}
	public <K,V> AssociativeArray(Generator<Pair<K, V>> gen,int size) {
		DATA = new Object[size][2];
		for(int i=0;i<size;i++){
			Pair<K,V> p =gen.next(); 
			DATA[i]=new Object[]{p.k,p.v};
		}
	}
	
	public AssociativeArray(int length) {
		DATA = new Object[length][2];
		flag=!flag;
	}
	
	public void put(K k,V v){
		if(index>=DATA.length){
			if(flag)
				throw new ArrayIndexOutOfBoundsException();
				DATA=copyArray(DATA);
		}

		DATA[index++]=new Object[]{k,v};
	}
	
	
	@SuppressWarnings("unchecked")
	public V get(K k){
		for(int i=0;i<DATA.length;i++){
			if(DATA[i][0]!=null && DATA[i][0].equals(k))
				try{
				return (V) DATA[i][1];
				}catch(ClassCastException cce){
					throw cce;
				}
		}
		
		return null;
	}
	
	private Object[][] copyArray(Object[][] pair){
		Object[][] newDATA = new Object[pair.length*2][2];
		for(int i =0;i<pair.length;i++)
		newDATA[i]=ArrayCopying.copyArray(pair[i], newDATA[i]);
		return newDATA;
		
	}


	@Override
	public String toString() {
		return Arrays.deepToString(DATA);
	}
	
	
	
	
}
