package sun.containers.set;
/*This is a custom class which will be used as element in Set Container*/
public class Element {
	public final int i;
	public Element(int n) {
		i=n;
	}
	@Override
	public String toString() {
		return ""+i ;
	}
	
}
