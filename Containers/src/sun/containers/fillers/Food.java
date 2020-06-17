package sun.containers.fillers;

public class Food {
private final String name;	
	public Food(String name) {
		this.name=name;
	}
	@Override
	public String toString() {
		return super.toString()+ ":::Food [name=" + name + "]";
	}
	

}
