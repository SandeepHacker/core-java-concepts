package sun.containers.performance;

import sun.containers.array.filler.Generator;

public class TestParameters<E> {
	
	private Generator<E> gen;
	private int size;
	private int loops;
	private String testClassName;
	public TestParameters(Generator<E> gen, int size, int loops) {
		super();
		this.gen = gen;
		this.size = size;
		this.loops = loops;
	}
	
	public TestParameters(Generator<E> gen, int size, int loops, String testClassName) {
		super();
		this.gen = gen;
		this.size = size;
		this.loops = loops;
		this.testClassName=testClassName;
	}

	public Generator<E> getGen() {
		return gen;
	}

	public int getSize() {
		return size;
	}

	public int getLoops() {
		return loops;
	}

	public String getTestClassName() {
		return testClassName;
	}
	
	

}
