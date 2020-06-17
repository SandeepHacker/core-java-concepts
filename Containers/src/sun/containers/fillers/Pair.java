package sun.containers.fillers;
/*We can take the same approach for a Map, 
 * but that requires a Pair class since a pair of objects (one key and one value) must be produced by each call to a Generator’s next( )
 *  in order to populate a Map:*/
public class Pair<K,V> {
	
	@Override
	public String toString() {
		return "Pair [k=" + k + ", v=" + v + "]";
	}

	public final K k;
	public final V v;
	
	public Pair(K k, V v) {
	this.k=k;
	this.v=v;
	}

}
