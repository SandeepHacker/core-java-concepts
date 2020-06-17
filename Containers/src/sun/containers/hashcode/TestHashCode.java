package sun.containers.hashcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import sun.containers.hashcode.ToDoList.ComparableToDoList;
import sun.containers.hashcode.ToDoList.EqualsToDoList;
import sun.containers.hashcode.ToDoList.HashCodeToDoList;
import sun.containers.hashcode.ToDoList.NormalToDoList;
import sun.containers.hashcode.ToDoList.WrongHashCodeToDoList;
import sun.containers.own.ClassicSet;

public class TestHashCode {

	 static String[] todo = "Wakeup Tea Washroom Bath Breakfast Smoke Login Code Lunch Nap Tea Smoke Play Code Play Dinner Sleep"
			.split(" ");
	static 	List<Class> claz = Arrays.asList(NormalToDoList.class,
			EqualsToDoList.class, WrongHashCodeToDoList.class,
			HashCodeToDoList.class,ComparableToDoList.class);

	public static void main(String[] args) throws Exception {
		System.out.println("Test HashSet Implementation Behaviour to ToDoList");
		System.out.println("==============================================");
		 testSetImplementation(new HashSet<ToDoList>());
			System.out.println("Test TreeSet Implementation Behaviour to ToDoList");
			System.out.println("==============================================");
		 testSetImplementation(new TreeSet<ToDoList>());
		System.out
				.println("Test ClassicSet Implementation Behaviour to ToDoList");
		System.out.println("==============================================");
		testOwnSetImplementation(new ClassicSet<ToDoList>());

	}

	static <E> void testSetImplementation(Set<E> set) throws Exception {
	
		for (Class cz : claz) {
			System.out.println(cz.getSimpleName());
			try{
			fillSet(set, cz, 152);
			}
			catch(Exception e){
				System.out.println("Cannot work with Tree Set");
			}
			System.out.println(set);
			System.out.println("SIZE::" + set.size());
			set.clear();
		}
	}

	static <E> void testOwnSetImplementation(ClassicSet<E> set)
			throws Exception {

		for (Class cz : claz) {
			System.out.println(cz.getSimpleName());
			fillSet(set, cz, 152);
			System.out.println(set);
			System.out.println("SIZE::" + set.size());
			set.clear();
		}
	}

	static <E> void fillSet(Set<E> set, Class<E> clazz, int size)
			throws Exception {
		int index = todo.length - 1;
		for (int i = 0; i < size; i++) {
			E e = clazz.getConstructor(String.class).newInstance(todo[index--]);
			set.add(e);
			if (index == -1)
				index = todo.length - 1;
		}

	}

	static <E> void fillSet(ClassicSet<E> set, Class<E> clazz, int size)
			throws Exception {
		int index = todo.length - 1;
		for (int i = 0; i < size; i++) {
			E e = clazz.getConstructor(String.class).newInstance(todo[index--]);
			set.add(e);
			if (index == -1)
				index = todo.length - 1;
		}

	}

	static <E> void fillList(List<E> set, Class<E> clazz, int size)
			throws Exception {
		int index = todo.length - 1;
		for (int i = 0; i < size; i++) {
			E e = clazz.getConstructor(String.class).newInstance(todo[index--]);
			set.add(e);
			if (index == -1)
				index = todo.length - 1;
		}
	}

	static <K> void fillMap(Map<K, Object> set, Class<K> clazz, int size)
			throws Exception {
		int index = todo.length - 1;
		for (int i = 0; i < size; i++) {
			K e = clazz.getConstructor(String.class).newInstance(todo[index--]);
			set.put(e, "dummy");
			if (index == -1) {
				index = todo.length - 1;
			}
		}
	}

}
