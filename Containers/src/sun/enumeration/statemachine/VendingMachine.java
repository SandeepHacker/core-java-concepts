package sun.enumeration.statemachine;

public class VendingMachine {
	
	private static int amount;
	private static State machineState=State.RESTING;
	private static Input selection;
	
	public enum StateDuration{TRANSITION}
	public enum State{
	
		RESTING{
			@Override
			void next(Input input) {
			switch(Category.getCategory(input)){
			case MONEY:
				amount+=input.amount;
				System.out.println("VendingMachine Adding Money ::::::::::"+input.amount);
				machineState=ADDING_MONEY;
			break;
			case SHUTDOWN:
				machineState=TERMINAL;
				System.out.println("Vending Machine Shutting Down.............");
				default:
			}
			}
		},
		ADDING_MONEY{
			@Override
			void next(Input input) {
				switch(Category.getCategory(input)){
				case MONEY:
					amount+=input.amount;
					System.out.println("Vending Machine Adding Money......................"+input.amount);
				break;
				case ITEM_SELECTION:
					selection=input;
					if(amount < selection.amount){
						System.out.println("Insufficient money for " + selection);
					}
					else
					machineState=DISPENSING;
					break;
				case QUIT_TRANSACTION:
					System.out
							.println("Vending Machine Aborting Transaction............................");
					machineState=GIVINGCHANGE;
					break;
				case SHUTDOWN:
					machineState=TERMINAL;
					System.out.println("VendingMachine Shutting Down.............");
					default:
				
				}
			}
		},
		
		DISPENSING(StateDuration.TRANSITION){
			@Override
			void next() {
					System.out
							.println("VendingMachine. DISPENSING................................"+selection.name());
					amount-=selection.amount;
					machineState=GIVINGCHANGE;
							}
		},
		GIVINGCHANGE(StateDuration.TRANSITION){
			@Override
			void next() {
				if(amount>0)
				System.out.println("VendingMachine. Returning amount  :::: "+amount);
machineState=RESTING;
							}
		},
		TERMINAL{
			void output(){
				System.out.println("Halted..............");
			}
		}
		;
		private boolean isTranstion=false;
		private State() {
			// TODO Auto-generated constructor stub
		}
		private State(StateDuration state) {
			this.isTranstion=true;
		}
		
		
	 void next(Input input){
		 
	 }
	 void next(){
		 
	 }
	 
	 void output(){
		 
	 }
	}
	
	
	static void runVendingMachine(Input... in){
		int i=0;
		while(machineState!=State.TERMINAL){
			machineState.next(in[i]);
			i++;
			while(machineState.isTranstion)
				machineState.next();
		}
		machineState.output();
		
	}
	
	public static void main(String[] args) {
		runVendingMachine(Input.RUPEES50,Input.CHIPS,Input.STOP);
	}

}
