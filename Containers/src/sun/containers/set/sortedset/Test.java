package sun.containers.set.sortedset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {

	static int countPairs(int arr[], int n) 
    { 
        int ans = 0; 
      
        // for each index i and j 
        for (int i = 0; i < n; i++) 
            for (int j = i+1; j < n; j++) 
      
                // finding the index with same 
                // value but different index. 
                if (arr[i] == arr[j]) 
                    ans++; 
        return ans; 
    } 
	
	static int getTeams(List<Integer> skills, int minPlayer, int minlevel, int maxlevel){
		
		List<Integer> skill = skills.stream().filter(s->s>=minlevel && s<=maxlevel).collect(Collectors.toList());
		return getCombinations(skill, minPlayer).size();
	}
	
	public static void main(String[] args) {
/*		 int teamCount = getTeams(Arrays.asList(1,2,3,4,5,6,7,8),2,3,7);
		 System.out.println("No of teams --"+teamCount);*/

		long start = System.currentTimeMillis();
		for(int i=0;i<=90000000;i++)
getAllValidSocksPair(new int[]{1,1,1,2,5,3,2,4,4,3,1,1,5,1,4,1,5,2,1,4,2,8,7,9,4,9,4,1,4,8,9,6,4,7,5,});
long end = System.currentTimeMillis();

System.out.println("Test.main(1)"+((end-start)/1000));

start = System.currentTimeMillis();
for(int i=0;i<=90000000;i++)
 getAllValidSocksPair2(new int[]{1,1,1,2,5,3,2,4,4,3,1,1,5,1,4,1,5,2,1,4,2,8,7,9,4,9,4,1,4,8,9,6,4,7,5,});
end = System.currentTimeMillis();
System.out.println("Test.main(2)"+(end-start));
	}
	
	static long getPrimeNumber(int Number){

		return Number;
	}
	
	
	
	static boolean isPresent(int[] src, int num){
		for(int s:src)
			if(num==s)
				return true;
		return false;
	}
	
	static int getAllValidSocksPair2(int[] socks){
		Arrays.sort(socks);
		int totalPairs=0;
		for(int i=0;i<socks.length;i++){
			int count=1;
									for(int j=i+1;j<socks.length;j++){
										if(socks[i]==socks[j]){
								
											count++;
										}
										else{
											i=j-1;
											totalPairs+=count/2;
											break;
										}
									}
									
		}
		return totalPairs;
	}
	
	static int getAllValidSocksPair(int[] socks){//1,1,1,2,5,3,2,4,4,3,1,1
		int totalPairs=0;
			boolean[] arr = new boolean[socks.length];
				for(int index=0;index<socks.length;index++){
				int count=1;
							if(arr[index]){
								continue;
							}	
							for(int i=index+1;i<socks.length;i++){				
										if(socks[i]==socks[index]){
											count++;
											arr[i]=true;				
										}
							}
							totalPairs+=(count/2);
			}
							return totalPairs;
	}
	
	
static	List<int[]> getCombinations(List<Integer> src, int num){
	
		int pointer=0;
		List<int[]> arr = new ArrayList<int[]>();
		int n=num;
		while(pointer<(src.size()-(num-1))){
			int[] tmp = new int[num];
			int index=0;
		for(int i=pointer;i<n;i++){
					tmp[index++]=src.get(i);
		}
		arr.add(tmp);

		for(int j=n;j<src.size();j++){
			int [] temp =tmp.clone();
			temp[temp.length-1]=src.get(j);
			arr.add(temp);
			
		}
		String s = "sandeep";
		String remake = s.substring(0, 1).toUpperCase().concat(s.substring(1));
		StringBuilder sv = new StringBuilder(s).reverse();
		
		
		pointer++;
		n+=1;
		}
	
		return arr;
	}
	
	
}
