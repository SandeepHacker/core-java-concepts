package sun.containers.hashcode;

import java.util.Random;

import sun.containers.array.filler.Generator;
import sun.containers.array.filler.SerialGenerator.AlphaNumeric;

public class ToDoList {
	
	public static class NormalToDoList extends ToDoList{
		static Generator<String> gen = new AlphaNumeric(1);
		private String id;
		private String toDo;
		public NormalToDoList(String toDo) {
		this.toDo = toDo;
		this.id=gen.next();
		}
		@Override
		public String toString() {
			return  id + "::" + toDo ;
		}

	}
	
	public  static class EqualsToDoList extends ToDoList{
		static Generator<String> gen = new AlphaNumeric(1);
		private String id;
		private String toDo;
		public EqualsToDoList(String toDo) {
		this.toDo = toDo;
		this.id=gen.next();
		}
		@Override
		public String toString() {
			return  id + "::" + toDo ;
		}
		
		@Override
		public boolean equals(Object obj) {
			EqualsToDoList todo =(EqualsToDoList)obj;
			return this.id.equals(todo.id);
		}

	}
	
	/*Even if we have implemented equals and hashcodes the object behave weird in set Implementations bcoz hashcode
	 *  implementation doesn't suites Set implementations*/	
	public  static class WrongHashCodeToDoList extends ToDoList{
		static Generator<String> gen = new AlphaNumeric(1);
		private String id;
		private String toDo;
		public WrongHashCodeToDoList(String toDo) {
		this.toDo = toDo;
		this.id=gen.next();
		}
		@Override
		public String toString() {
			return  id + "::" + toDo ;
		}
		
		@Override
		public boolean equals(Object obj) {
			WrongHashCodeToDoList todo =(WrongHashCodeToDoList)obj;
			return this.id.equals(todo.id);
		}
		
		@Override
		public int hashCode() {
			Random r = new Random();
			int x =r.nextInt(2);
			return x;
			
		}

	}	
	
	public static class HashCodeToDoList extends ToDoList{
		static Generator<String> gen = new AlphaNumeric(1);
		private String id;
		private String toDo;
		public HashCodeToDoList(String toDo) {
		this.toDo = toDo;
		this.id=gen.next();
		}
		@Override
		public String toString() {
			return  id + "::" + toDo ;
		}
		
		@Override
		public boolean equals(Object obj) {
			HashCodeToDoList todo =(HashCodeToDoList)obj;
			return this.id.equals(todo.id);
		}
		@Override
		public int hashCode() {
			int result =17;
			return (result*id.charAt(0))*Math.abs(id.charAt(1));
		}

	}	
	
	public static class ComparableToDoList extends ToDoList implements Comparable<ComparableToDoList>{
		static Generator<String> gen = new AlphaNumeric(1);
		private String id;
		private String toDo;
		public ComparableToDoList(String toDo) {
		this.toDo = toDo;
		this.id=gen.next();
		}
		@Override
		public String toString() {
			return  id + "::" + toDo ;
		}
		
		@Override
		public boolean equals(Object obj) {
			ComparableToDoList todo =(ComparableToDoList)obj;
			return this.id.equals(todo.id);
		}
		@Override
		public int hashCode() {
			int result =17;
			return (result*id.charAt(0))*Math.abs(id.charAt(1));
		}
		
		@Override
		public int compareTo(ComparableToDoList o) {
			if(o.id.charAt(0)>this.id.charAt(0)){
				return -1;
			}else if(o.id.charAt(0)<this.id.charAt(0)){
				return 1;
			}else{
				return o.id.charAt(1)>this.id.charAt(1)?-1:o.id.charAt(1)<this.id.charAt(1)?1:0;
			}
		}

	}	

}
