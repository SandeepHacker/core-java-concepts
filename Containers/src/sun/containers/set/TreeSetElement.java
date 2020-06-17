package sun.containers.set;

public class TreeSetElement extends HashSetElement implements Comparable<TreeSetElement>{
	
	public TreeSetElement(int n) {
	super(n);
	}

	@Override
	public int compareTo(TreeSetElement o) {
		return o.i>this.i?1:o.i<this.i?-1:0;
	}
	
	
	

	
	
	
}
