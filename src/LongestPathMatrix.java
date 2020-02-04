
public class LongestPathMatrix {
	 // driver program 
    public static void main(String[] args) 
    { 
        int mat[][] = { { 1, 10, 9 }, 
                        { 5, 11, 8 }, 
                        { 4, 6, 7 } }; 
        int n=3;
        System.out.println("Length of the longest path is " + finLongestOverAll(mat,n)); 
    }

	private static int finLongestOverAll(int[][] mat, int n) {
		int[][] dp=new int[n][n];
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(dp[i][j]==0){
					findDist(mat,dp,i,j,n);
				}
				System.out.print(dp[i][j]+"  ");
				if(max<dp[i][j])
					max=dp[i][j];
			}
			System.out.println();
		}
		return max;
	}

	private static int findDist(int[][] mat, int[][] dp, int i, int j, int n) {
		if(i<0||i>=n||j<0||j>n)
			return 0;
		if(dp[i][j]!=0)
			return dp[i][j];
		int x=0,y=0,z=0,w=0;
		if(i>0 && mat[i][j]+1==mat[i-1][j])
			x=1+findDist(mat,dp,i-1,j,n);
		if(i<n-1 && mat[i][j]+1==mat[i+1][j])
			y=1+findDist(mat,dp,i+1,j,n);
		if(j>0 && mat[i][j]+1==mat[i][j-1])
			z=1+findDist(mat,dp,i,j-1,n);
		if(j<n-1 && mat[i][j]+1==mat[i][j+1])
			w=1+findDist(mat,dp,i,j+1,n);
		dp[i][j]=Math.max(z, Math.max(w, Math.max(x, Math.max(1,y))));
		return dp[i][j];
	} 
}
