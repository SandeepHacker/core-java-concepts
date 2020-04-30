package sun.containers.array.selector;

import java.util.Arrays;
import java.util.Random;

public class SelectRandomElements {
	static String[] teams;	

	static{
	
teams =( "CHENNAI SUPER KINGS:MUMBAI INDIANS:KINGS XI PUNJAB:RAJASTHAN ROYALS:DEHLI DAREDEVILS:"
		+ "BANGALORE ROYAL CHALLENGERS:KOLKATA KNIGHT RIDERS:SUNRISERS HYDERABAD").split(":");

//		System.out.println(Arrays.toString(teams));


			
	}
	public static void main(String[] args) {
		System.out.println("SelectRandomElements.main()"+Arrays.toString(selectfourRandomTeams()));
	}
	
	//select random elements from array
	//the do while is used here to select unique element everytime not repeated elements
	//Here this method will always return four different teams
	
	static String[] selectfourRandomTeams(){
		Random r=new Random();
		boolean b[] = new boolean[teams.length-1];
		String[] result = new String[4];
		for(int i=0;i<4;i++){
			int tmp=0;
		do
			tmp=r.nextInt(teams.length-1);
		while(b[tmp]);
		result[i]=teams[tmp];
		b[tmp]=true;
		}
		return result;
	}
	
	


}
