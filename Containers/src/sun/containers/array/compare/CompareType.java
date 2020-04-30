package sun.containers.array.compare;

import java.util.Comparator;

/*This a object which will compared*/
public class CompareType implements Comparable<CompareType> {

	private int i;
	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}


	private int j;
	
	public CompareType(int i,int j) {
		this.i=i;
		this.j=j;
	}

	@Override
	public String toString() {
		return "CompareType [i=" + i + ", j=" + j + "]";
	}

	@Override
	public boolean equals(Object obj) {
	
		return (((CompareType)obj).getI()==this.i && ((CompareType)obj).getJ()==this.j ? true:false);
	}
	
	
	@Override
	public int compareTo(CompareType o) {
	
		return (o.getI()>this.i ? -1 :(o.getI()<this.i)?1:0);
	}
	
	
	
	
}
