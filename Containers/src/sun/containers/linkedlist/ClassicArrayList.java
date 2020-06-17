package sun.containers.linkedlist;

import java.util.Arrays;
import java.util.RandomAccess;

public class ClassicArrayList<E>  implements RandomAccess{
	
	E[] list = (E[])new Object[5]; 
	int size=0;
	
	public void add(E e){
		if(list.length-size==2)
			list=Arrays.copyOf(list, list.length*2);
		
		list[size]=e;
		size++;
	}
	
	public E get(int index){
		if(index>=size)
			throw new IndexOutOfBoundsException();
		return list[index];
	}
	
	public E remove(int index){
		E e =list[index];
		System.arraycopy(list, index+1, list, index, size-index-1);
		list[--size]=null;
		return e;
	}
	
	private void removeWithoutRangeCheck(int index){
		System.arraycopy(list, index+1, list, index, size-index-1);
		list[--size]=null;	
	}
	
	private boolean checkRange(int index){
		return index>=0 && index<size;
	}
	
	public boolean remove(E e){
		int index=indexOf(e);
		if(index==-1)
			return false;
		removeWithoutRangeCheck(indexOf(e));
		return true;
	}
	
	public boolean contains(E e){
		return indexOf(e)!=-1;
	}
	
	public int indexOf(E e){
		for(int i=0; i<size;i++){
			if(e.equals(list[i]))
				return i;
		}
		return -1;
	}
	public int lastIndexOf(E e){
		for(int i=size-1; i>=0;i--){
			if(e.equals(list[i]))
				return i;
		}
		return -1;
	}
	
	public void clear(){
		Arrays.fill(list, null);
	}
	
	public int size(){
		return size;
	}
	
	@Override
	public String toString() {
	StringBuilder sb =new StringBuilder("[");
	for(E e :list){
		if(e==null)
			break;
		sb.append(e).append(", ");
	}
	
	sb.deleteCharAt(sb.lastIndexOf(",")).deleteCharAt(sb.lastIndexOf(" ")).append("]");
	return new String(sb);
	}
	

}
