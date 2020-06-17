package sun.io.serialization;

import java.io.Serializable;
import java.util.Random;

public class Worm  implements Serializable{
	
	
	public final char x;
	public Worm nextWorm;
	public static Data[] data;
	private static Random r=new Random(47);
	
	public Worm(int  i ,char x) {
		if(data==null){
			data=new Data[i];
		for(int z=0;z<i;z++)
			data[z]=new Data(r.nextInt(299));
		}
		this.x = x;
		if(--i>0){
			nextWorm = new Worm(i, (char)(x+1));
		}
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int length=data.length;
		for(Worm w = this;w!=null;w=w.nextWorm)
			sb.append(w.x).append("(").append(data[--length]).append(")");
		return sb.toString();
	}
}
