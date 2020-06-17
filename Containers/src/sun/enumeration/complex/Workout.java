package sun.enumeration.complex;

import sun.enumeration.mystery.RandomEnumSelector;

public enum Workout {
	
	
CARDIO(Excercise.Cardio.class),
LEGS(Excercise.Legs.class),
CHEST(Excercise.Chest.class);

Excercise[] values;
private Workout(Class<? extends Excercise> clazz) {
	this.values=clazz.getEnumConstants();
}
public interface Excercise{
	enum Cardio implements Excercise{
		JOGGING, MOUNTAIN_CLIMBER,JUMPINGJACKS, NINJA_JUMP, WRESTLING
	}
	enum Legs implements Excercise{
		SQUATS, LUNGES;
	}
	
	enum Chest implements Excercise{
		BENCHPRESS, DIPS, DUMBELL_PRESS;
	}
	
	
}

public static void main(String[] args) {
	 for(int i=0;i<7;i++){
		 for(Workout e : Workout.values()){
			 System.out.println(RandomEnumSelector.random(e.values));
		 }
	 }
}

}
