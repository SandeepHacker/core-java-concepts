package sun.containers.performance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class FastTraversalLinkedList<E> {
	private LinkedList<E> lList = new LinkedList<E>();
	private ArrayList<E> aList = new ArrayList<E>();
	private ArrayList<E> toArrayList(LinkedList<E> lList) {
		aList.clear();
		aList.addAll(lList);
		lList.clear();
		return aList;
	}
	private LinkedList<E> toLinkedList(ArrayList<E> aList) {
		lList.clear();
		lList.addAll(aList);
		aList.clear();
		return lList;
	}
	public int size() {
		return aList.size() < lList.size() ? lList.size() : aList.size();
	}
	public void clear() {
		if(aList.size() < lList.size())
			lList.clear();
		else
			toLinkedList(aList).clear();	
	}
	public void add(E e) {
		if(aList.size() < lList.size())
			lList.add(e);
		else
			toLinkedList(aList).add(e);	
	}
	public void add(int i, E e) {
		if(aList.size() < lList.size())
			lList.add(i, e);
		else
			toLinkedList(aList).add(i, e);	
	}
	public boolean addAll(Collection<? extends E> c) {
		if(aList.size() < lList.size()) 
			return lList.addAll(c);			 
		else
			return toLinkedList(aList).addAll(c);
	}
	public void addFirst(E e) {
		if(aList.size() < lList.size())
			lList.addFirst(e);
		else
			toLinkedList(aList).addFirst(e);	
	}
	public void addLast(E e) {
		if(aList.size() < lList.size())
			lList.addLast(e);
		else
			toLinkedList(aList).addLast(e);	
	}
	public E set(int i, E e) {
		if(lList.size() < aList.size()) 
			return aList.set(i,e);
		else
			return toArrayList(lList).set(i,e);
	}
	public E remove(int i) {
		if(aList.size() < lList.size())
			return lList.remove(i);
		else
			return toLinkedList(aList).remove(i);	
	}
	public E removeFirst() {
		if(aList.size() < lList.size())
			return lList.removeFirst();
		else
			return toLinkedList(aList).removeFirst();	
	}
	public E removeLast() {
		if(aList.size() < lList.size())
			return lList.removeLast();
		else
			return toLinkedList(aList).removeLast();	
	}
	public E get(int i) {
		if(lList.size() < aList.size()) 
			return aList.get(i);
		else
			return toArrayList(lList).get(i);
	}
	public Iterator<E> iterator() {
		if(lList.size() < aList.size()) 
			return aList.iterator();
		else
			return toArrayList(lList).iterator();
	}
	public ListIterator<E> listIterator() {
		if(aList.size() < lList.size()) 
			return lList.listIterator();
		else
			return toLinkedList(aList).listIterator();
	}
	public ListIterator<E> listIterator(int i) {
		if(aList.size() < lList.size()) 
			return lList.listIterator(i);
		else
			return toLinkedList(aList).listIterator(i);
	}
	public String toString() {
		return aList.size() > lList.size() ? aList.toString() : 
			lList.size() == 0 ? aList.toString() : lList.toString();		
	}	
}