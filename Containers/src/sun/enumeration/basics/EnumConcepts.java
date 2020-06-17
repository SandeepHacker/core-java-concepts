package sun.enumeration.basics;
import static sun.enumeration.basics.Spiciness.*;
import static sun.enumeration.basics.Signal.*;

import java.io.ObjectStreamException;
public class EnumConcepts {
	
	
	
	public static void main(String[] args) {
//		enumBasics();
//		enumStaticImport();
//		addMethodsInEnum();
enumInSwitch();
	}
	
	/*The ordinal( ) method produces an int indicating the declaration order of each enum
	instance, starting from zero. You can always safely compare enum instances using ==, and
	equals( ) and hashCode( ) are automatically created for you. The Enum class is
	Comparable, so there’s a compareTo( ) method, and it is also Serializable.*/
	static void enumBasics(){
		for(Directions d: Directions.values()){
			System.out.println(d.name());
			System.out.println(d.ordinal());
			System.out.println(d.toString());
			System.out.println(d.getDeclaringClass());
			System.out.println(d.compareTo(Directions.UP));
			System.out.println("============================");
			
		}
		
	}
	/*The static import brings all the enum instance identifiers into the local namespace, so
	they don’t need to be qualified. Is this a good idea, or is it better to be explicit and qualify all
	enum instances? It probably depends on the complexity of your code. The compiler certainly
	won’t let you use the wrong type, so your only concern is whether the code will be confusing
	to the reader. In many situations it will probably be fine but you should evaluate it on an
	individual basis.*/
	static void enumStaticImport(){		
	class Burrito{		
		private Spiciness spiciness;

		public Burrito(Spiciness spiciness) {
			this.spiciness = spiciness;
		}
		@Override
		public String toString() {
			return "Burrito is " + spiciness;
		}	
	}
	System.out.println(new Burrito(FLAMING));
	System.out.println(new Burrito(MILD));
	System.out.println(new Burrito(HOT));	
	}
/*	Notice that if you are going to define methods you must end the sequence of enum instances
	with a semicolon. Also, Java forces you to define the instances as the first thing in the enum.
	You’ll get a compile-time error if you try to define them after any of the methods or fields.*/
	static void addMethodsInEnum(){
	for(OzWitch oz: OzWitch.values()){
		System.out.println(oz.name());
		System.out.println(oz.getDescription());
	}
	}
	
	
	static void enumInSwitch(){
		class TrafficLight{
			Signal traffic = RED;
			
			 public void change(Signal traffic){
				 switch(traffic){
				 case RED:this.traffic = GREEN;return;
				 case GREEN:this.traffic = YELLOW;return;
				 case YELLOW:this.traffic = RED;return;
				 }
			 }
			 
			 @Override
			public String toString() {
			
				return "The traffic light is "+this.traffic;
			}
			
		}
		TrafficLight tl = new TrafficLight();
		for(int u=1;u<10;u++){
			System.out.println(tl);
			tl.change(tl.traffic);
		}
	}
	
	

}
