package sun.containers.linkedlist;

public class ClassicSingleLinkedList<E> {
	

	private Link<E> data;
	private Link<E> lastLink;
	private int size=0;
	private static class Link<E>{
		
		E e;
		Link<E> nextLink;

		public Link(E e, Link<E> nextLink) {
		this.e=e;
		this.nextLink=nextLink;
		}
		
		Link<E> nextLink(){
			return this.nextLink;
		}
		

		@Override
		public String toString() {

			Link<E> lin;
		StringBuilder sb =new StringBuilder("[");
		if(nextLink()==null){
			sb.append(e).append("]");
		return new String(sb);
		}
			for(lin=this;lin.nextLink!=null;lin=lin.nextLink)
				sb.append(lin.e).append(", ");
			
			sb.append(lin.e).append("]");
			return new String(sb);
		}
	
	
		
	}
	
	
	public boolean add(E e){
		if(data==null){
			data=new Link<E>(e, null);
			lastLink=data;
			size++;
			return true;
		}
		Link<E> tmp=lastLink;
		lastLink=new Link<E>(e, null);
		tmp.nextLink=lastLink;
		size++;
		return true;
	}

	@Override
	public String toString() {
		if(size==0)
			return "[]";
		return data.toString();
	}

	public E get(int index){
		return getLink(index);
	}
	
	public int indexOf(E e){
		Link<E> head=data;
		
		for(int i=0;head!=null;i++){
					if(e==head.e || e.hashCode()==head.e.hashCode() && e.equals(head.e))
						return i;
					head=head.nextLink();
		}
		return -1;
	}
	
	public int lastIndexOf(E e){
	Link<E> head=data;
		int index=-1;
		for(int i=0;head!=null;i++){
					if(e==head.e || e.hashCode()==head.e.hashCode() && e.equals(head.e))
						index=i;
					head=head.nextLink();
		}
		return index;
	}
	
	private E getLink(int index){
		if(!checkIfValidIndex(index))
			throw new IndexOutOfBoundsException("Invalid index::"+index);
		Link<E> tmp=data;
		int i=0;
			while(i!=index){
				tmp=tmp.nextLink();
				i++;
			}
			return tmp.e;
		}
	

	
	public boolean remove(int index){
		Link<E> head=data;
		Link<E> prev=null;
		if(!checkIfValidIndex(index))
			throw new IndexOutOfBoundsException("Index out of bound:: "+index);
		if(index==0){
			size--;
			head=head.nextLink();
		return true;
		}
		for(int i=0;i<index;i++){
				prev=head;
				head=head.nextLink();
		}
size--;
prev.nextLink=head.nextLink;
		return true;
	}
	
	public boolean remove(E e){
		Link<E> head=data;
		Link<E> prev=null;
	
	boolean flag=false;
		for(int i=0;head!=null;head=head.nextLink()){
			
			if(head.e==e || head.e.hashCode()==e.hashCode() && head.e.equals(e)){
				if(prev==null){
					data=head.nextLink();
					size--;	
					return true;
				}
				flag=!flag;
				break;		
			}
		
				prev=head;
		}
	
		
if(flag){
prev.nextLink=head.nextLink;
size--;
}
		return flag;
	}
	
	
	
	public int size(){
		return size;
	}
	
	public void clear(){
		data=null;
	}
	
	public boolean contains(E e){
		Link<E> head=data;
		boolean flag=false;
		for(int i=0;head!=null;head=head.nextLink()){
			if(head.e==e || head.e.hashCode()==e.hashCode() && head.e.equals(e)){
				flag=!flag;
				break;
			}
	}
		return flag;
	}
	
	private boolean checkIfValidIndex(int index){
		return index>=0 && index<size;
	}
	
}
