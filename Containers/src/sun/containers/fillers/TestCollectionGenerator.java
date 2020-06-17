package sun.containers.fillers;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import sun.containers.array.filler.RandomGenerator;
import sun.containers.array.filler.SerialGenerator;

/*CollectionData is an example of the Adapter design pattern  it adapts a Generator to the
constructor for a Collection.All the generators defined in the Arrays chapter are now available via the CollectionData adapter.*/
public class TestCollectionGenerator {
	
	
public static void main(String[] args) throws Exception{
	Set<Integer> set =new HashSet( new CollectionContainer<Integer>(new SerialGenerator.Integer(), 100));
	
	System.out.println("TestCollectionGenerator.main()"+set);
	
	System.out.println(CollectionContainer.loadContainer(new RandomGenerator.String(), 20));
	
	
Map<Character,String> map = new MapContainer<Character, String>(new PairGenerator.AlpahtesWords(), 20);
System.out.println(map);
System.out.println(MapContainer.loadMap(new SerialGenerator.Integer(), new SerialGenerator.Character(), 60));
System.out.println(MapContainer.loadMap(new PairGenerator.AlpahtesCountry(), 40));
	
}	
	

}
