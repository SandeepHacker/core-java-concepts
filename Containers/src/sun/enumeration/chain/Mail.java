package sun.enumeration.chain;

import java.util.Iterator;

import sun.enumeration.mystery.RandomEnumSelector;

public class Mail {
	
	static int counter=0;

		@Override
	public String toString() {
		return "Mail-"+counter+" [generalDelivery=" + generalDelivery + ", scannability="
				+ scannability + ", readability=" + readability + ", address="
				+ address + ", returnAddress=" + returnAddress + "]";
	}

		// The NO’s lower the probability of random selection:
		enum GeneralDelivery {NO1,YES,NO2,NO3,NO4,NO5}
		enum Scannability {UNSCANNABLE,YES1,YES2,YES3,YES4}
		enum Readability {ILLEGIBLE,YES1,YES2,YES3,YES4}
		enum Address {INCORRECT,OK1,OK2,OK3,OK4,OK5,OK6}
		enum ReturnAddress {MISSING,OK1,OK2,OK3,OK4,OK5}
		
		GeneralDelivery generalDelivery;
		Scannability scannability;
		Readability readability;
		Address address;
		ReturnAddress returnAddress;
		
		public static Mail randomMail(){
			Mail m = new Mail();
			m.generalDelivery = RandomEnumSelector.randomSelect(GeneralDelivery.class);
			m.scannability =  RandomEnumSelector.randomSelect(Scannability.class);
			m. readability = RandomEnumSelector.randomSelect(Readability.class);
			m.address = RandomEnumSelector.randomSelect(Address.class);
			m. returnAddress = RandomEnumSelector.randomSelect(ReturnAddress.class);
			counter++;
			return m;
		}
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public static  Iterable<Mail> generator(int count){
			
			return new Iterable() {
				int countz =count;
				@Override
				public Iterator iterator() {
					// TODO Auto-generated method stub
					return new Iterator<Mail>() {

						@Override
						public boolean hasNext() {
							// TODO Auto-generated method stub
							return countz>0;
						}

						@Override
						public Mail next() {
							countz--;
							return randomMail();
						}
					};
				}
		
		};
}
}
