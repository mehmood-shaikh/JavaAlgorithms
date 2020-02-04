import java.util.Arrays;


public class Partition {
	public static boolean partition(int[] A)
	{
		int sum = Arrays.stream(A).sum();

		// return true if sum is even and array can can be divided into
		// two sub-arrays with equal sum
		return (sum & 1) == 0 && subsetSum(A, A.length, sum/2);
	}

	private static boolean subsetSum(int[] a, int n, int s) {
		
		boolean dp[][]= new boolean[n+1][s+1];
		for(int i=0;i<=n;i++){
			dp[i][0]=true;
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=s;j++){
				/*if(j==0){
					dp[i][j]=true;
				}*/
				if(a[i-1]>j)
					dp[i][j]=dp[i-1][j];
				else
					dp[i][j]=dp[i-1][j]||dp[i-1][j-a[i-1]];
			}
		}
		
		for(int i=0;i<=n;i++){
			for(int j=0;j<=s;j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
		return dp[n][s];
	}

	// main function
	public static void main(String[] args)
	{
		// Input: set of items
		int[] A = { 7, 3, 1, 5, 4, 8 };

		if (partition(A)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
