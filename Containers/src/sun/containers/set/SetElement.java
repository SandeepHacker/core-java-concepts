package sun.containers.set;

public class SetElement extends Element{
	
	public SetElement(int n) {
		super(n);
	}
	
	@Override
	public boolean equals(Object obj) {
		 boolean flag = obj instanceof SetElement && super.i==((SetElement)obj).i;
//		 System.out.println("SetElement.equals()"+flag);
		return flag;
	}

}
