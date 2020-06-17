package sun.enumeration.chain;

import sun.enumeration.chain.Mail.GeneralDelivery;
/*The Chain of Responsibility is expressed in enum ValidateMail, and the order of the
enum definitions determines the order in which the strategies are attempted on each piece
of mail. Each strategy is tried in turn until one succeeds or they all fail, in which case you
have a dead letter. The chain of validate() method is called one after another as a chain*/
public class PostOffice {
	
	enum ValidateMail{
		
		CHECK_GENERALDELIVERY{
			@Override
			boolean validate(Mail m) {
			switch(m.generalDelivery){
			case  YES:
				System.out
						.println("PostOffice. After Validating  General Delivery");
			return true;
			default : return false;
			}
			}
		},
		
		SCANNER{
			@Override
			boolean validate(Mail m) {
				switch(m.scannability){
				case UNSCANNABLE:
				return false;
	
				default : 
					switch(m.address){
					case INCORRECT:
						return false;
						default : 
							System.out.println("PostOffice. After Validating  Delivering Mail automatically");
							return true;
					}
				}
			}
		},
		READER{
			@Override
			boolean validate(Mail m) {
				switch(m.readability){
				case ILLEGIBLE:
				return false;
	
				default : 
					switch(m.address){
					case INCORRECT:
						return false;
						default : 
							System.out.println("PostOffice. After Validating  Delivering Mail normally ");
							return true;
					}
				}
			}
		},
		VALIDATE_RETURNADDRESS{
			@Override
			boolean validate(Mail m) {
				switch(m.returnAddress){
				case MISSING:
					return false;
					default : 
						System.out.println("PostOffice. After Validating  Mail returned to return address");
						return true;
				}
			}
		}
		;
		
		
		
		abstract boolean validate(Mail m);
		
	}
	
	
	static void  validateMail(Mail mail){
		for(ValidateMail val : ValidateMail.values()){
			if(val.validate(mail))
			return;
		}
		System.out.println("This Mail is a dead mail.......");
	}

}
