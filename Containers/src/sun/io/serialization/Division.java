package sun.io.serialization;

import java.io.Serializable;

public class Division implements Serializable{
	
	private String division;
	public Division(String division) {
		this.division=division;
	}
	@Override
	public String toString() {
		return "Division [division=" + division 
				+ super.toString() + "]";
	}
	
}
