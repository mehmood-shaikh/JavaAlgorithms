
public class CountSteps {
	 public static void main (String[] args)  
	 { 
	        int dist = 4; 
	        System.out.println(printCountRec(dist)); 
	        System.out.println(printCountDP(dist)); 
	 }

	private static int printCountDP(int dist) {
		int dp[]=new int[dist+1];
		dp[0]=1;
		for(int j=1;j<=dist;j++){
			for(int i=1;i<=3;i++){
				if(j>=i)
					dp[j]+=dp[j-i];				
			}
			
		}
		for(int j=0;j<=dist;j++){
			System.out.print(dp[j]+"  ");
		}
		System.out.println();
		return dp[dist];
	}

	private static int printCountRec(int dist) {
		if(dist==0)
			return 1;
		if(dist<0)
			return 0;
		return printCountRec(dist-3)+printCountRec(dist-2)+printCountRec(dist-1);
	} 
}
