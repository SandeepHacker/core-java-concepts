package sun.annotations.processor;
@Simple
public class SimpleTest{
	
	@Simple
private String s;	

	@SuppressWarnings("finally")
	@Simple
public static String m1(){
			try {
				throw new RuntimeException();
			}
			catch(Exception e) {
				throw new RuntimeException();
			}
			finally {
				return "SAndeep";
			}
}
	
	public static void main(String[] args) {

	}


}
