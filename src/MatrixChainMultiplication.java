
public class MatrixChainMultiplication {
	public static void main(String[] args)
	{
		// Matrix M[i] has dimension dims[i-1] x dims[i] for i = 1..n
		// input is 10 × 30 matrix, 30 × 5 matrix, 5 × 60 matrix
		int[] dims = { 10,  5};

		System.out.println("Minimum cost is rec  " +
				MatrixChainMultiplicationRec(dims, 0, dims.length - 1));
		
		System.out.println("Minimum cost is DP  " +
				MatrixChainMultiplicationDP(dims, dims.length));
	}

	private static int MatrixChainMultiplicationDP(int[] dims, int n) {
		int dp[][]= new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=i+2;j<n;j++){
				int min=Integer.MAX_VALUE;
				for(int k=i+1;k<j;k++){
					int cost=dp[i][k]+dp[k][j]+(dims[i]*dims[j]*dims[k]);
					if(cost< min)
						min=cost;
				}
				dp[i][j]=min;
			}
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(dp[i][j]+"   ");
			}
			System.out.println();
		}
		return dp[0][n-1];
	}

	private static int MatrixChainMultiplicationRec(int[] dims, int i, int j) {
		if(j==i+1)
			return 0;
		int min=Integer.MAX_VALUE;
		for(int k=i+1;k<j;k++){
			int cost=0;
			
			cost+=MatrixChainMultiplicationRec(dims,i,k);
			cost+=MatrixChainMultiplicationRec(dims,k,j);
			cost+=dims[i]*dims[k]*dims[j];
			if(cost<min)
				min=cost;
		}
		
		
		return min;
	}
}
