package sun.io.nio.channel;

public abstract class IOTest {
	public static int Num = 10_00_000;
	private String testName;
	public IOTest(String testName) {
		this.testName=testName;
	}
	
	public void runPerformanceTest(){
		long start = System.currentTimeMillis();
		test();
		long end = System.currentTimeMillis();
		System.out.println("Total Time Taken by test ::: "+testName+" ::: "+(end-start));
	}
	
	
	public abstract void test();
	

}
