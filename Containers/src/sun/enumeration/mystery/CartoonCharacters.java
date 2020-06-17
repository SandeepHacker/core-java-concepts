package sun.enumeration.mystery;

import java.util.Random;

import sun.containers.array.filler.Generator;
/*We’ve established that all enums extend java.lang.Enum. Since Java does not support multiple inheritance, this means that you cannot create an enum via inheritance:*/
public enum CartoonCharacters implements Generator<CartoonCharacters> {
	
	TOM, JERRY, SCOOBYDOO,DONALD_DUCK, MICKEY_MOUSE, GOOFY, GOKU,VEGETA;

	@Override
	public CartoonCharacters next() {
		Random r = new Random();
		return values()[r.nextInt(values().length-1)];
	}
	
}
