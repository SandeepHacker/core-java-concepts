package sun.io.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Scoreboard implements Serializable {
	
	private int score;
	private int wickets;
	private int overs;
	private transient int fours;
	private transient int sixs;
	
	public Scoreboard(int... data) {
		System.out.println("Scoreboard.Scoreboard()");
		if(data.length!=5)
			throw new RuntimeException();
		this.score = data[0];
		this.wickets = data[1];;
		this.overs = data[2];;
		this.fours = data[3];;
		this.sixs = data[4];;
	}
	
	
	
	
	private void writeObject(ObjectOutputStream oos)throws IOException{
		oos.defaultWriteObject();
		oos.writeInt(fours);
		oos.writeInt(sixs);
	
	}
	
	private void readObject(ObjectInputStream oos)throws IOException, ClassNotFoundException{
		oos.defaultReadObject();
		this.fours = oos.readInt();
		this.sixs = oos.readInt();
	}




	@Override
	public String toString() {
		return "Scoreboard [score=" + score + ", wickets=" + wickets
				+ ", overs=" + overs + ", fours=" + fours + ", sixs=" + sixs
				+ "]";
	}




	
	
	
	
	
	

}
