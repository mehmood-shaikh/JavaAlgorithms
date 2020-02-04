
public class ShortestCommonSubsequence {
	public static void main(String[] args)
	{
		String X = "ABCBDAB", Y = "BDCABA";
		int m = X.length(), n = Y.length();

		System.out.println("The length of shortest Common supersequence is "
						+ SCSLengthRec(X, Y, m, n));
		System.out.println("The length of shortest Common supersequence DP is "
				+ SCSLengthDP(X, Y, m, n));
	}

	private static int SCSLengthDP(String x, String y, int m, int n) {
		int dp[][]=new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0)
					dp[i][j]=j;
				else if(j==0)
					dp[i][j]=i;
				else{
					if(x.charAt(i-1)==y.charAt(j-1))
						dp[i][j]=dp[i-1][j-1]+1;
					else
						dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+1;
				}
				
			}
		}
		return dp[m][n];
	}

	private static int SCSLengthRec(String x, String y, int m, int n) {
		if(m==0)
			return n;
		if(n==0)
			return m;
		if(x.charAt(m-1)==y.charAt(n-1))
			return SCSLengthRec(x,y,m-1,n-1)+1;
		else
			return Math.min(SCSLengthRec(x,y,m-1,n),SCSLengthRec(x,y,m,n-1))+1;
	}
}
