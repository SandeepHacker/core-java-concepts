package sun.containers.queue;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;

import sun.containers.array.filler.Generator;
import sun.containers.array.filler.RandomGenerator;
import sun.containers.array.filler.SerialGenerator;
/*You can see how the ordering of the items happens automatically because of the priority queue.
 *  While taking out elements the elements comes out based on priority
 *  Here we are filling our custom queue with Passenger which will be prioritized based on time*/
public class PassengerQueue extends PriorityQueue<Passenger> {
	
	
	private static class PassengerGenerator implements Generator<Passenger>{
		
		String [] names= "Affleck, Ben, Adams, Scott, Caesar, Julius, Sam, Ram, Hole, Senate, Dawn, Sandeep, Sambit, Mona, Pinky, Simmy, Ricky, Micky".split(", ");
		int i=names.length-1;
		@Override
		public Passenger next() {
			if(i<0)
				i=names.length-1;
			return new Passenger(names[i--]);
		}
	}
	
	public static void main(String[] args) {
		PassengerGenerator pg = new PassengerGenerator();
		PassengerQueue que =	new PassengerQueue();

		for(int i=0;i<900;i++){

		que.add(pg.next());
		}
		while(!que.isEmpty())
		System.out.println(que.poll());
			

	}
	

}
