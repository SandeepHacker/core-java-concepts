package sun.enumeration.statemachine;

public enum Input {
COIN(5), RUPEES10(10),RUPEES20(20),RUPEES50(50),RUPEES100(100),
TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
 STOP_TRANSACTION{
		public int getAmount() {
		throw new RuntimeException("Damage...........");
		}
 }, STOP{
		public int getAmount() {
		throw new RuntimeException("Shutting Down...........");
		}
};
 
 
 int amount;	
	Input(int amount){
		this.amount=amount;
	}
	private Input() {
		// TODO Auto-generated constructor stub
	}
	public int getAmount() {
		return amount;
	}
	
}
