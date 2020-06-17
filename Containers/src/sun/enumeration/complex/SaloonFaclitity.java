package sun.enumeration.complex;

import java.util.EnumSet;

public enum SaloonFaclitity {
	
	HAIRCUT{
		@Override
				void action() {
					System.out.println("Cutting Hair");
					
				}
		@Override
		int price() {
			// TODO Auto-generated method stub
			return 150;
		}
	},
	CLEANSHAVE{
		@Override
				void action() {
			System.out.println("Clean Shaving Beard");
				}
		@Override
		int price() {
			// TODO Auto-generated method stub
			return 100;
		}
	},
	
	BEARDCUT{
		@Override
				void action() {
			System.out.println("Trimming Beard");
				}
		@Override
		int price() {
			// TODO Auto-generated method stub
			return 100;
		}
	},
	FACIAL{
		@Override
				void action() {
					System.out.println("Doing Facial");
					
				}
		@Override
		int price() {
			// TODO Auto-generated method stub
			return 700;
		}
	},
	
	SCRUB{
		@Override
				void action() {
					System.out.println("Doing Scrub");
					
				}
		@Override
		int price() {
			// TODO Auto-generated method stub
			return 300;
		}
	},
	HAIRCOLOR{
		@Override
				void action() {
					System.out.println("Color the Hair");
					
				}
		@Override
		int price() {
			// TODO Auto-generated method stub
			return 300;
		}
	},
	MASSAGE{
		@Override
				void action() {
					System.out.println("Doing Massage");
					
				}
		@Override
		int price() {
			// TODO Auto-generated method stub
			return 200;
		}
	};
	
	abstract void action();
	abstract int price();
	
	

}
