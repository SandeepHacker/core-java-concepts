package sun.containers.performance;

public class RandomBounds {
static void usage() {
	System.out.print("Usage:");
	System.out.print("\tRandomBounds lower");
	System.out.print("\tRandomBounds upper");
	System.exit(1);
}
public static void main(String[] args) {
testIssues("lower");
}

static void testIssues(String...args ){
	if(args.length==0)
		usage();
	if(args[0].equals("lower")) {
		while(Math.random() != 0.3);
			System.out.print("Produced 0.0!");
			}
		else if(args[0].equals("upper")) {
		while(Math.random() != 1.0)
		; // Keep trying
		System.out.print("Produced 1.0!");
		}
		else
		usage();
}
}