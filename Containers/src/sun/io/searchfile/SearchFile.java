package sun.io.searchfile;

import java.io.File;
import java.util.Arrays;

public class SearchFile {
		
	
	public static void main(String[] args) {
/*		File f = new File("./src/sun/containers");
		System.out.println("SearchFile.main()"+Arrays.toString(f.list()));
		System.out.print(Arrays.toString(f.list(new DirectoryFilter("[a-z]*e"))));*/
		System.out.println("SearchFile.main()"+isAnagram("MonaSandeepSambit", "SaMbitMonaSandeep"));
	}
	
	
	
	static boolean isAnagram(String a, String b){
		if(a.length()!=b.length()){
			return false;
		}
		a=a.toLowerCase();
		b=b.toLowerCase();
		boolean[] flags = new boolean[a.length()];
		
		for(int i=0;i<a.length();i++){
			if(flags[i]==false){
			int oneCount=1; 
			int twoCount=0;
			char tmp=a.charAt(i);
			for(int z=i+1;z<a.length();z++){
				if(tmp==a.charAt(z)){
					flags[z]=true;
					oneCount++;
				}
			}
			
			for(int j=0;j<b.length();j++){
				if(tmp==b.charAt(j)){
					twoCount++;
				}
			}

			if(oneCount!=twoCount)
				return false;
		}
		}
		return true;
	}
	
	
}
