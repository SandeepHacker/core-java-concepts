package sun.containers.linkedlist;

import java.util.LinkedList;

/*Instead of using LinkedList, we can implement our own internal linked storage mechanism.
 * This example makes use of an end sentinel to determine when the stack is empty. 
 * The end sentinel/method is created when the LinkedStack is constructed, and each time you call push( ) 
 * a new Node<T> is created and linked to the previous Node<T>. When you call pop( ), you always return the top.item, 
 * and then you discard the current Node<T> and move to the next one— except when you hit the end sentinel, 
 * in which case you don’t move. That way, if the client keeps calling pop( ), they keep getting null back to indicate that the stack is empty
This class can be used as a Stack, and it behaves like stack al
*/
public class CustomLinkedList<E> {

	
	private  Node<E> node=new Node<E>();
	
	private static class Node<U>{
		
		 U u;
		 Node<U> nextNode;
		public Node() {
		
		}
		public Node(U u, Node<U> node) {
			this.u=u;
			this.nextNode=node;
		}
		@Override
		public String toString() {
			if(nextNode.u==null)
				return ""+u;
			return ""+u+",";
		}
		
		public boolean end(){
			return u==null && nextNode==null;
		}

	}	
		
		public void push(E u){
			node=new Node<E>(u,node);
		}
		
		public E pop(){
			E e =node.u;		
			if(!node.end())
				node=node.nextNode;
			return e;
		}
		
		public E peek(){
			E e =node.u;		
			return e;
		}

		
		
		
		@Override
		public String toString() {
			StringBuilder out=new StringBuilder("[");
			for(Node n=this.node;n.u!=null;n=n.nextNode){
				out.append(n);
			}
			out.append("]");
			return new String(out);
		}




		public static void main(String[] args) {
			CustomLinkedList<String> ll = new CustomLinkedList<String>();
			ll.push("SS");
			ll.push("SA");
			ll.push("SCX");
			ll.push("SSS");
			System.out.println("CustomLinkedList.main()"+ll);
			System.out.println("CustomLinkedList.main()"+ll.peek());
			System.out.println("CustomLinkedList.main()"+ll.peek());
			System.out.println("CustomLinkedList.main()"+ll.pop());
			System.out.println("CustomLinkedList.main()"+ll.pop());
	
		}
		
		
	}

