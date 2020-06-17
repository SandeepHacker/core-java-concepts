package sun.enumeration.complex;

import sun.enumeration.mystery.RandomEnumSelector;

public class Meal {
	
	public static void main(String[] args) {
		for(int i=0;i<5;i++){
		for(Course c : Course.values()){
			System.out.println(RandomEnumSelector.random(c.getValues()));
		}
		System.out.println("==============================");
		}
	}

}
