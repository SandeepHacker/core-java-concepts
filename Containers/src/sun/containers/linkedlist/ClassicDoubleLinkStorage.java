package sun.containers.linkedlist;


public class ClassicDoubleLinkStorage<E> {
	
	
	private Link<E> lastLink,firstLink=null;
	private int SIZE=0;

	private class Link<E>{
		
		private E e;
		private Link<E> prevLink;
		private Link<E> nextLink;
		
		public Link(Link<E> prevLink,E e ,Link<E> nextLink) {
			this.e = e;
			this.prevLink = prevLink;
			this.nextLink = nextLink;
		}

		/*public void setElement(E e) {
			this.e = e;
		}

		public void changePrevLink(Link<E> prevLink) {
			this.prevLink = prevLink;
		}

		public void changeNextLink(Link<E> nextLink) {
			this.nextLink = nextLink;
		}*/

		@Override
		public String toString() {
			Link<E> lin;
			StringBuilder sb =new StringBuilder("[");
			if(nextLink==null){
				sb.append(e).append("]");
			return new String(sb);
			}
				for(lin=this;lin.nextLink!=null;lin=lin.nextLink)
					sb.append(lin.e).append(", ");
				
				sb.append(lin.e).append("]");
				return new String(sb);
		}
		
	}
	
	
	public void add(E e){
		linkLast(e);
	}
	
	
	private void linkLast(E e){
		Link<E> tmp=lastLink;
		lastLink=new Link<E>(tmp,e,null);
		if(tmp!=null)
			tmp.nextLink=lastLink;
		else
			firstLink=lastLink;
		SIZE++;
	}
	
	private E unlink(Link<E> link){
		E e =link.e;
		Link<E> head = link.prevLink;
		Link<E> tail = link.nextLink;
		SIZE--;
		if(head==null){
			tail.prevLink=null;
			firstLink=tail;
			return e;
		}
		
		if(tail==null){
			head.nextLink=null;
			lastLink=head;
			return e;
		}
		head.nextLink=tail;
		return e;
	}
	private Link<E> link(int index){
		Link<E> head=null;
		
		if(index<(SIZE>>1)){
			head=firstLink;
			for(int i=0;i<index;i++)
				head=head.nextLink;
		}else{
			head=lastLink;
			for(int i=(SIZE-1);i>index;i--)
				head=head.prevLink;
		}
		return head;		
	}
	public  boolean remove (E e){
		
		   for (Link<E> x = firstLink; x != null; x = x.nextLink) {
               if (e.equals(x.e)) {
                   unlink(x);
                   return true;
               }
	}
		   return false;
	}
	
public int size(){
	return SIZE;
}


@Override
public String toString() {
	return  firstLink.toString();
}

public E get(int index){
	if(!checkIfValidIndex(index))
		throw new IndexOutOfBoundsException("Index Out of Range::"+index +"size::"+SIZE);
			return link(index).e;
}


public void remove(int index){
	if(!checkIfValidIndex(index))
		throw new IndexOutOfBoundsException("Index Out of Range::"+index +"size::"+SIZE);
	unlink(link(index));
}

private boolean checkIfValidIndex(int index){
	return index>=0 && index<SIZE;
}

public boolean contains(E e){
	
	   return indexOf(e)!=-1;
}


public int indexOf(E e){
	int index=0;
	 for (Link<E> x = firstLink; x != null; x = x.nextLink) {
         if (e.equals(x.e)) {
      	   return index;
         }
         index++;
	   }
	 return -1;
}

public int lastIndexOf(E e){
	int index=SIZE-1;
	 for (Link<E> x = lastLink; x != null; x = x.prevLink) {
         if (e.equals(x.e)) {
      	   return index;
         }
         index--;
	   }
	 return -1;
}

}
