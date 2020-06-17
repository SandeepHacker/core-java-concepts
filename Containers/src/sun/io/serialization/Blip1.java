package sun.io.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Blip1 implements Externalizable{
	int x;
	{
		System.out.println(x);
	}
public Blip1() {
	// TODO Auto-generated constructor stub
}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
System.out.println("Blip1.readExternal()");
		
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
	System.out.println("Blip1.writeExternal()");
		
	}

}
