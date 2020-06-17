package sun.containers.performance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.WeakHashMap;

import sun.containers.array.filler.Generator;
import sun.containers.array.filler.SerialGenerator;
import sun.containers.fillers.Pair;
import sun.containers.fillers.PairGenerator;
import sun.containers.linkedlist.ClassicArrayList;
import sun.containers.own.ClassicMap;
import sun.containers.own.GreatMap;
import sun.containers.own.LinkedGreatMap;
import sun.containers.own.GreatSet;

public class CollectionPerformanceTest {
public static void main(String[] args) throws Exception {
	Generator<Integer> gen = new SerialGenerator.Integer();
	Generator<Pair<Long,Long>> gen1 = new PairGenerator.NumberSquareCube();
	
	TestParameters<Integer> testParams = new TestParameters<Integer>(gen, 3000, 20, "ListTest");
	TestParameters<Integer> testParams3 = new TestParameters<Integer>(gen, 3000, 20, "FastTraversalLinkedListTest");
	TestParameters<Integer> testParams1 = new TestParameters<Integer>(gen, 3000, 20, "ClassicArrayListTest");
	TestParameters<Integer> testParams2 = new TestParameters<Integer>(gen, 3000, 20, "SetTest");
	TestParameters<Integer> testParams7 = new TestParameters<Integer>(gen, 3000, 20, "UniqueContainerTest");
	TestParameters<Pair<Long, Long>> testParams4 = new TestParameters<Pair<Long, Long>>(gen1, 100000, 2, "MapTest");
	TestParameters<Pair<Long, Long>> testParams5 = new TestParameters<Pair<Long, Long>>(gen1, 100000, 2, "ClassicMapTest");
	TestParameters<Pair<Long, Long>> testParams6 = new TestParameters<Pair<Long, Long>>(gen1, 100000, 2, "GreatMapTest");
	TestRunner.runPerformanceTest(testParams, ArrayList.class);
		TestRunner.runPerformanceTest(testParams, LinkedList.class);
	TestRunner.runPerformanceTest(testParams3, FastTraversalLinkedList.class);
		TestRunner.runPerformanceTest(testParams, Vector.class);
	TestRunner.runPerformanceTest(testParams1, ClassicArrayList.class);
	TestRunner.runPerformanceTest(testParams2, HashSet.class);
	TestRunner.runPerformanceTest(testParams2, LinkedHashSet.class);
	TestRunner.runPerformanceTest(testParams2, TreeSet.class);
	TestRunner.runPerformanceTest(testParams7, GreatSet.class);

	TestRunner.runPerformanceTest(testParams4, TreeMap.class);
	TestRunner.runPerformanceTest(testParams4, IdentityHashMap.class);
	TestRunner.runPerformanceTest(testParams4, WeakHashMap.class);
	TestRunner.runPerformanceTest(testParams5, ClassicMap.class);
	TestRunner.runPerformanceTest(testParams4, HashMap.class);
	TestRunner.runPerformanceTest(testParams4, LinkedHashMap.class);
	TestRunner.runPerformanceTest(testParams6, GreatMap.class);





//System.out.println("CollectionPerformanceTest.main()"+((44<<2)<<2));

//	TestRunner.runPerformanceTest(testParams4, LinkedHashMap.class);


//	TestRunner.runPerformanceTest(testParams6, LinkedGreatMap.class);
	LinkedGreatMap<Integer,String> map =new LinkedGreatMap<Integer	, String>();
	map.put(1, "One");
	map.put(2, "Two");
	map.put(3, "Three");
	map.put(4, "Four");
	map.put(5, "One");
	map.put(6, "Two");
	map.put(7, "Three");
	map.put(8, "Four");
	map.put(9, "Two");
	map.put(10, "Three");
	map.put(11, "Four");
	map.put(12, "Two");
	map.put(13, "Three");
	map.put(14, "Four");
	map.put(15, "Two");
	map.put(16, "Three");
	map.put(17, "Four");
	map.put(18, "Two");
	map.put(18, "Twoooooooooooooooo");
	map.put(19, "Three");
	map.put(20, "Four");
/*	System.out.println("CollectionPerformanceTest.main()"+map.containsKey(2));
	map.remove(7);*/
//map.print();

}

}
