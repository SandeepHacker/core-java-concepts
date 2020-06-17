package sun.io.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Blip4 implements Externalizable{
	private int i;
	private String s;
	
	
	public Blip4() {
		// TODO Auto-generated constructor stub
	}
	public Blip4(int i, String s) {
		this.i = i;
		this.s = s;
	}
	@Override
	public String toString() {
		return "Blip4 [i=" + i + ", s=" + s + "]";
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(s);
		out.writeInt(i);
		
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
	s=(String) in.readObject();
		i=in.readInt();
	}

}
