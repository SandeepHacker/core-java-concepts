package sun.io.serialization;

import java.io.Serializable;

//If class doesnt implements Serializable Interface and we try to serialize the object we get following error java.io.NotSerializableException
public class Data implements Serializable{
	
	
	public final int num;

	public Data(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return  Integer.toString(num);
	}
	

}
