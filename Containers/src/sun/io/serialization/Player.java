package sun.io.serialization;

import java.io.Serializable;

public class Player implements Serializable{
	
	private String name;
	private Division division;

	public Player(String name,Division division) {
		this.name = name;
		this.division=division;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", division=" + division
			 + super.toString() + "]";
	}





}
