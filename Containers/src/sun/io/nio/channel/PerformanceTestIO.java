package sun.io.nio.channel;
/*Although the performance of "old" stream I/O has been improved by implementing it with nio, mapped file access tends to be dramatically faster. 
 * This program does a simple performance comparison:*/
public class PerformanceTestIO {
	
	
	public static void main(String[] args) {
TestReadWrite.getAllTest().stream().forEach(t->t.runPerformanceTest());
	}

}
