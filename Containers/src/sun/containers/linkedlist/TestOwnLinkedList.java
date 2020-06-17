package sun.containers.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import sun.containers.array.ArrayAutoboxing;
import sun.containers.array.filler.Generator;
import sun.containers.array.filler.RandomGenerator;
import sun.containers.array.filler.SerialGenerator;

public class TestOwnLinkedList {
private static final int SIZE=80000;
	public static void main(String[] args) {
/*		ClassicSingleLinkedList<String> linked = new ClassicSingleLinkedList<String>();
		System.out.println("TestOwnLinkedList.main()"+linked);
		ClassicSingleLinkedList<String> clist = loadClassicLinkedList(new RandomGenerator.CountryNames(), SIZE);
		LinkedList<String> list = loadLinkedList(new RandomGenerator.CountryNames(), SIZE);*/
	/*	ClassicDoubleLinkStorage<String> linked = new ClassicDoubleLinkStorage<String>();
		linked.add("Sun");
		linked.add("Moon");
		linked.add("Goon");
		linked.add("Loon");
		linked.add("Coon");
		linked.add("Doon");
		linked.add("Sun");
		System.out.println("TestOwnLinkedList.main() "+linked+"size:: "+linked.size());
	System.out.println("TestOwnLinkedList.main()"+linked.get(0));
	linked.remove(6);
	linked.remove(0);
	System.out.println("TestOwnLinkedList.main()"+linked);*/
	/*		System.out.println("TestOwnLinkedList.main()"+linked+" size:: "+linked.size());
		System.out.println("TestOwnLinkedList.main()"+linked+" size:: "+linked.indexOf("Sun"));
		System.out.println("TestOwnLinkedList.main()"+linked+" size:: "+linked.lastIndexOf("Sun"));
		System.out.println("TestOwnLinkedList.main()"+linked.remove("Sun"));
		System.out.println("TestOwnLinkedList.main()"+linked+" size:: "+linked.size());
		System.out.println("TestOwnLinkedList.main()"+linked.contains("CD"));*/
//		testPerformanceClassicSingleLinkedList();


		
		/*ClassicArrayList<String>list = new ClassicArrayList<String>();
		list.add("Sun");
		list.add("Moon");
		list.add("Goon");
		list.add("Loon");
		list.add("Coon");
		list.add("Doon");
		list.add("Sun");
		System.out.println("TestOwnLinkedList.main()"+list);
		System.out.println("TestOwnLinkedList.main()"+list.size());
		System.out.println("TestOwnLinkedList.main()"+list.get(3));
		System.out.println("TestOwnLinkedList.main()"+list.remove(3));
		System.out.println("TestOwnLinkedList.main()"+list);
		System.out.println("TestOwnLinkedList.main()"+list.size());*/
		
		
			long time=0;
				for(int i=0;i<10;i++){
		time =time+testPerformanceLinkedList();
				}
				System.out.println("Average Linked List ::"+(time/5));
				time=0;
				for(int i=0;i<10;i++)
					time =time+testPerformanceClassicDoubleLinkStorage();
				System.out.println("Average Classic Double Link ::"+(time/5));
				time=0;
		for(int i=0;i<10;i++)
			time =time+testPerformanceClassicArrayList();
		System.out.println("Average Classic Array List ::"+(time/5));
		time=0;
		for(int i=0;i<10;i++)
			time =time+testPerformanceArrayList();
		System.out.println("Average Array List ::"+(time/5));


}

	static long testPerformanceClassicArrayList() {
		
		long start = System.currentTimeMillis();
		ClassicArrayList<String> linked = loadClassicArrayList(new SerialGenerator.CountryNames(), SIZE);
//		ClassicArrayList<String> linked = loadClassicArrayList(new RandomGenerator.CountryNames(), SIZE);
		for (int i = 0; i < 100000; i++) {
			linked.get(13);
			linked.get(11);
			linked.get(SIZE-4);
			linked.get(SIZE-7);
			linked.get(SIZE/2);
			linked.get(SIZE/2+6);
			linked.get(3);
			linked.get(SIZE-(SIZE/4));

				linked.contains("India");
				linked.contains("United Kingdom");
				linked.contains("France");
				linked.contains("Germany");
				linked.indexOf("India");
				linked.indexOf("United Kingdom");
				linked.indexOf("France");
				linked.indexOf("Germany");
		}
		long end = System.currentTimeMillis();
		System.out.print((end - start)+" :: ");
		return end-start;
	}
	static long testPerformanceArrayList() {

		long start = System.currentTimeMillis();
		ArrayList<String> linked = loadArrayList(new SerialGenerator.CountryNames(), SIZE);
//		ArrayList<String> linked = loadArrayList(new RandomGenerator.CountryNames(), SIZE);
		for (int i = 0; i < 100000; i++) {
			linked.get(13);
			linked.get(11);
			linked.get(SIZE-4);
			linked.get(SIZE-7);
			linked.get(SIZE/2);
			linked.get(SIZE/2+6);
			linked.get(3);
			linked.get(SIZE-(SIZE/4));

			linked.contains("India");
				linked.contains("United Kingdom");
				linked.contains("France");
				linked.contains("Germany");
						linked.indexOf("India");
				linked.indexOf("United Kingdom");
				linked.indexOf("France");
				linked.indexOf("Germany");
		}
		long end = System.currentTimeMillis();
		System.out.print((end - start)+" :: ");
		return end-start;
	}
	
	static long testPerformanceLinkedList() {
		long start = System.currentTimeMillis();
//		LinkedList<String> linked = loadLinkedList(new RandomGenerator.CountryNames(), SIZE);
		LinkedList<String> linked = loadLinkedList(new SerialGenerator.CountryNames(), SIZE);
		for (int i = 0; i < 100000; i++) {
			linked.get(13);
			linked.get(11);
			linked.get(SIZE-4);
			linked.get(SIZE-7);
			linked.get(SIZE/2);
			linked.get(SIZE/2+6);
			linked.get(3);
			linked.get(SIZE-(SIZE/4));

		linked.contains("India");
			linked.contains("United Kingdom");
			linked.contains("France");
			linked.contains("Germany");
					linked.indexOf("India");
			linked.indexOf("United Kingdom");
			linked.indexOf("France");
			linked.indexOf("Germany");
		
		}

		long end = System.currentTimeMillis();
		System.out.print((end - start)+" :: ");
		return end-start;
	}

	static long testPerformanceClassicDoubleLinkStorage() {
		Random r = new Random();
		long start = System.currentTimeMillis();
//		ClassicDoubleLinkStorage<String> linked = loadClassicDoubleLinkStorage(new RandomGenerator.CountryNames(), SIZE);
		ClassicDoubleLinkStorage<String> linked = loadClassicDoubleLinkStorage(new SerialGenerator.CountryNames(), SIZE);
		for (int i = 0; i < 100000; i++) {
			linked.get(13);
			linked.get(11);
			linked.get(SIZE-4);
			linked.get(SIZE-7);
			linked.get(SIZE/2);
			linked.get(SIZE/2+6);
			linked.get(3);
			linked.get(SIZE-(SIZE/4));
			linked.contains("India");
			linked.contains("United Kingdom");
			linked.contains("France");
			linked.contains("Germany");
			linked.indexOf("India");
			linked.indexOf("United Kingdom");
			linked.indexOf("France");
			linked.indexOf("Germany");

		}
		long end = System.currentTimeMillis();
		System.out.print((end - start)+" :: ");
		return end-start;
	}

	static void testPerformanceClassicSingleLinkedList() {
		long start = System.currentTimeMillis();
//		ClassicSingleLinkedList<String> linked = loadClassicLinkedList(new RandomGenerator.CountryNames(), SIZE);
		ClassicSingleLinkedList<String> linked = loadClassicLinkedList(new SerialGenerator.CountryNames(), SIZE);
		
		for (int i = 0; i < 100000; i++) {
			linked.get(13);
			linked.get(11);
			linked.get(SIZE-4);
			linked.get(SIZE-7);
			linked.get(SIZE/2);
			linked.get(SIZE/2+6);
			linked.get(3);
			linked.get(SIZE-(SIZE/4));

			linked.contains("India");
			linked.contains("United Kingdom");
			linked.contains("France");
			linked.contains("Germany");
				linked.indexOf("India");
			linked.indexOf("United Kingdom");
			linked.indexOf("France");
			linked.indexOf("Germany");

		}

		long end = System.currentTimeMillis();
		System.out.println("Classic Linked List:::" + (end - start));
	}
	
	static <E> LinkedList<E> loadLinkedList(Generator<E> gen, int size){
		LinkedList<E> list = new LinkedList<E>();
		for(int i=0;i<size;i++){
			list.add(gen.next());
		}
		return list;
	}
	
	static <E> ClassicSingleLinkedList<E> loadClassicLinkedList(Generator<E> gen, int size){
		ClassicSingleLinkedList<E> list = new ClassicSingleLinkedList<E>();
		for(int i=0;i<size;i++){
			list.add(gen.next());
		}
		return list;
	}
	
	static <E> ClassicDoubleLinkStorage<E> loadClassicDoubleLinkStorage(Generator<E> gen, int size){
		ClassicDoubleLinkStorage<E> list = new ClassicDoubleLinkStorage<E>();
		for(int i=0;i<size;i++){
			list.add(gen.next());
		}
		return list;
	}
	
	static <E> ClassicArrayList<E> loadClassicArrayList(Generator<E> gen, int size){
		ClassicArrayList<E> list = new ClassicArrayList<E>();
		for(int i=0;i<size;i++){
			list.add(gen.next());
		}
		return list;
	}

	static <E> ArrayList<E> loadArrayList(Generator<E> gen, int size){
		ArrayList<E> list = new ArrayList<E>();
		for(int i=0;i<size;i++){
			list.add(gen.next());
		}
		return list;
	}

}
