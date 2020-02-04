
public class LongestPalindromeSubsequence {

	public static void main(String[] args) {
		String s="abdagh";
		dlps(s);
		int c=lps(s);
		System.out.println(c);

	}

	private static void dlps(String s) {
		int n=s.length();
		int dp[][]=new int [n+1][n+1];
		for(int i=0; i<=n;i++){
			for(int j=0; j<=n-i+1;j++){
				if(i==0&&j==n+1)
					continue;
				if(i==0||j==0)
					dp[i][j]=0;
				else if(i==1)
					dp[i][j]=1;
				else{
					//System.out.println("i : "+i+", j : "+j);
					if(s.charAt(j-1)==s.charAt(i+j-2))
						dp[i][j]=dp[i-2][j+1]+2;
					else
						dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j+1]);
				}
				
			}
		}
		for(int i=0; i<=n;i++){
			for(int j=0; j<=n;j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println( dp[n][1]);
		
	}

	private static int lps(String s) {
		//System.out.println(s);
		int c=0;
		if(s.length()==0)
			return 0;
		if(s.length()==1)
			return 1;
		if(s.charAt(0)==s.charAt(s.length()-1)){
			c=2+lps(s.substring(1,s.length()-1));
		}else{
			c=Math.max(lps(s.substring(1)),lps(s.substring(0,s.length()-1)));
		}
		return c;
	}

}
