package sun.containers.set;

public class HashSetElement extends SetElement {
	
	public HashSetElement(int n) {
		super(n);
	}
	
	@Override
	public int hashCode() {
		return i;
	}

}
