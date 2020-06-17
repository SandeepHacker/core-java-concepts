package sun.enumeration.complex;

import java.util.EnumSet;
import static sun.enumeration.complex.SaloonFaclitity.*;
public class Saloon {
	
	EnumSet<SaloonFaclitity> only = EnumSet.of(HAIRCUT);
	EnumSet<SaloonFaclitity> base = EnumSet.of(HAIRCUT,BEARDCUT);
	EnumSet<SaloonFaclitity> customer;
	public Saloon() {
		customer=only;
	}
	
	public Saloon(boolean flag) {
		customer=base;
	}
	
	
	public void addService(SaloonFaclitity e){
		customer.add(e);
	}
	
	public void printBill(){
		int total=0;
		for(SaloonFaclitity s : customer){
			System.out.println(s.name()+"========="+s.price());
			total+=s.price();
		}
		System.out.println("Final Bill::::"+total);
	}
	
	
	public static void main(String[] args) {
		Saloon s = new Saloon(false);
		s.addService(SCRUB);
		for(SaloonFaclitity ss :s.customer){
			ss.action();
		}
		s.printBill();
	}
	

}
