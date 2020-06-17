package sun.enumeration.chain;

import sun.enumeration.chain.PostOffice.ValidateMail;

public class TestChainResponsbility {
	
	public static void main(String[] args) {
		/*for(Mail m : Mail.generator(20))
			System.out.println(m);*/
		validateMailsAndProcess(150);
	}
	
	
	static void validateMailsAndProcess(int count){
		for(Mail m : Mail.generator(count)){
			System.out.println(m);
	PostOffice.validateMail(m);
		}
		for(Mail m : Mail.generator(count)){
			System.out.println(m);
	PostOffice.validateMail(m);
		}
	}

}
