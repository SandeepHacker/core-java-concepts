package sun.enumeration.complex;

public class UsingConstantSpecificMethod {
	
	public static void main(String[] args) {
		for(Info i : Info.values()){
			System.out.println(i.getInfo());
		}
	}

}
