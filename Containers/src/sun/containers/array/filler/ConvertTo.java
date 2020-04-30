package sun.containers.array.filler;

/*Generics don’t work with primitives, and we want to use the generators to fill primitive arrays. 
 * To solve the problem, we create a converter that takes any array of wrapper objects and converts it to an array of the associated primitive types.
 *  Without this tool, we would have to create separate special case generators for all the primitives.*/

/*This class does autoboxing and autounboxing for arrays primitive to wrapper and vice-versa*/
public class ConvertTo {

	public static boolean[] primitive(Boolean[] in) {
		boolean[] result = new boolean[in.length];
		for (int i = 0; i < in.length; i++)
			result[i] = in[i]; // Autounboxing
		return result;
	}

	public static char[] primitive(Character[] in) {
		char[] result = new char[in.length];
		for (int i = 0; i < in.length; i++)
			result[i] = in[i];
		return result;
	}

	public static byte[] primitive(Byte[] in) {
		byte[] result = new byte[in.length];
		for (int i = 0; i < in.length; i++)
			result[i] = in[i];
		return result;
	}

	public static short[] primitive(Short[] in) {
		short[] result = new short[in.length];
		for (int i = 0; i < in.length; i++)
			result[i] = in[i];
		return result;
	}

	public static int[] primitive(Integer[] in) {
		int[] result = new int[in.length];
		for (int i = 0; i < in.length; i++)
			result[i] = in[i];
		return result;
	}

	public static long[] primitive(Long[] in) {
		long[] result = new long[in.length];
		for (int i = 0; i < in.length; i++)
			result[i] = in[i];
		return result;
	}

	public static float[] primitive(Float[] in) {
		float[] result = new float[in.length];
		for (int i = 0; i < in.length; i++)
			result[i] = in[i];
		return result;
	}

	public static double[] primitive(Double[] in) {
		double[] result = new double[in.length];
		for (int i = 0; i < in.length; i++)
			result[i] = in[i];
		return result;
	}
	
	public static Boolean[] wrapper(boolean[] in) {
		Boolean[] result = new Boolean[in.length];
		for (int i = 0; i < in.length; i++)
			result[i] = in[i]; // Autoboxing
		return result;
	}
	public static Character[] wrapper(char[] in) {
		Character[] result = new Character[in.length];
		for (int i = 0; i < in.length; i++)
			result[i] = in[i];
		return result;
	}

	public static Byte[] wrapper(byte[] in) {
		Byte[] result = new Byte[in.length];
		for (int i = 0; i < in.length; i++)
			result[i] = in[i];
		return result;
	}

	public static Short[] wrapper(short[] in) {
		Short[] result = new Short[in.length];
		for (int i = 0; i < in.length; i++)
			result[i] = in[i];
		return result;
	}

	public static Integer[] wrapper(int[] in) {
		Integer[] result = new Integer[in.length];
		for (int i = 0; i < in.length; i++)
			result[i] = in[i];
		return result;
	}

	public static Long[] wrapper(long[] in) {
		Long[] result = new Long[in.length];
		for (int i = 0; i < in.length; i++)
			result[i] = in[i];
		return result;
	}

	public static Float[] wrapper(float[] in) {
		Float[] result = new Float[in.length];
		for (int i = 0; i < in.length; i++)
			result[i] = in[i];
		return result;
	}

	public static Double[] wrapper(double[] in) {
		Double[] result = new Double[in.length];
		for (int i = 0; i < in.length; i++)
			result[i] = in[i];
		return result;
	}
	

}
