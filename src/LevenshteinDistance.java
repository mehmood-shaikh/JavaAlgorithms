
public class LevenshteinDistance {
	public static void main(String[] args)
	{
		String X = "kitten", Y = "sitting";

		System.out.print("The Levenshtein Distance is " +
				dist(X, X.length(), Y, Y.length()));
	}

	private static int dist(String a, int n, String b, int m) {
		int dp[][]=new int[n+1][m+1];
		for(int i=0;i<=n;i++){
			for(int j=0;j<=	m;j++){
				if(j==0)
					dp[i][j]=i;
				else if(i==0)
					dp[i][j]=j;
				else{
					if(a.charAt(i-1)==b.charAt(j-1))
						dp[i][j]=dp[i-1][j-1];
					else{
						dp[i][j]=Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1])+1;
					}
				}
			}
		}
		
		
		return dp[n][m];
	}
}
