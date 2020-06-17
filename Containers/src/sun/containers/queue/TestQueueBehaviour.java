package sun.containers.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.PriorityBlockingQueue;

import sun.containers.array.filler.Generator;

/*Other than concurrency applications, the only two Java SE5 implementations of Queue are
LinkedList and PriorityQueue, which are differentiated by ordering behavior rather than
performance.*/
public class TestQueueBehaviour {
	static String[] anum = "ONE TWO THREE FOUR FIVE SIX SEVEN EIGHT NINE TEN".split(" ");
	public static void main(String[] args) {
		class Gen implements Generator<String>{
			int i=0;
			@Override
			public String next() {
				// TODO Auto-generated method stub
				return anum[i++];
			}
		}
		
		/*You can see from output that, with the exception of the priority queues, a Queue will produce elements in
		exactly the same order as they are placed in the Queue.*/
	
	
		testQueue(new LinkedList<String>(),new Gen(), 10);
		testQueue(new PriorityQueue<String>(),new Gen(), 10);
		testQueue(new ArrayBlockingQueue<String>(10), new Gen(),10);
		testQueue(new ConcurrentLinkedQueue<String>(), new Gen(),10);
		testQueue(new LinkedBlockingQueue<String>(), new Gen(),10);
		testQueue(new PriorityBlockingQueue<String>(), new Gen(),10);
		testQueue(new LinkedTransferQueue<String>(), new Gen(),10);
	
		
		
	}
	
	
	static<E> void testQueue(Queue<E>que, Generator<E> gen, int size){
	for(int i=0; i<size;i++){
		que.offer(gen.next());
	}
	
	System.out.println(que.getClass().getSimpleName()+":::::::"+que);
		
	}

}
