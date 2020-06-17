package sun.io.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Blip2 implements Externalizable{
	
	
	
	 Blip2() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
	System.out.println("Blip2.readExternal()");
		
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip2.writeExternal()");
		
	}

}
