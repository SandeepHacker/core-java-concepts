package sun.containers.dequeue;

import java.util.Deque;
import java.util.LinkedList;
/*A deque (double-ended queue) is like a queue, but you can add and remove elements from either end. 
 * There are methods in LinkedList that support deque operations, but there is no explicit interface for a deque in the Java standard libraries.
 * It’s less likely that you’ll put elements in and take them out at both ends, so Deque is not as
commonly used as Queue*/
public class TestDequeBehaviour {
	
	
	
	static void testAndfill(Deque<Integer> deque){
		for(int i=19;i>0;i--)
			deque.addLast(i);
		for(int i=20;i>0;i--)
			deque.addFirst(i);
		System.out.println(deque);
		
		deque.removeFirst();
		System.out.println(deque);
		deque.removeLast();
		System.out.println(deque);
		deque.removeFirstOccurrence(11);
		System.out.println(deque);
		deque.removeLastOccurrence(15);
		System.out.println(deque);
	}
	
	
	public static void main(String[] args) {
		testAndfill(new LinkedList<Integer>());
		testAndfill(new CustomDeque<Integer>());
	}

}
