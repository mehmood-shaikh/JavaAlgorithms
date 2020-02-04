import java.util.Arrays;


public class DifferencePartitionSubset {
	public static void main(String[] args)  
    { 
        int arr[] = {3,8,2,15}; 
        int n = arr.length; 
        System.out.println("The rec minimum difference"+ 
                        " between two sets is " +  
                         findMinRec(arr, n,0,0)); 
        
        int sum=Arrays.stream(arr).sum();
        System.out.println("The dp minimum difference"+ 
                " between two sets is " +  
                 findMinDp(arr, n,sum)); 
    }

	private static int findMinDp(int[] a, int n, int sum) {
		System.out.println("sum : "+sum);
		int dp[][]=new int[n+1][sum+1];
		for(int i=0;i<=n;i++){
			for(int j=0;j<=sum;j++){
				if(j==0)
					dp[i][j]=1;
				else if(i==0)
					dp[i][j]=0;
				else{
					if(dp[i-1][j]==1 || (j>=a[i-1] && dp[i-1][j-a[i-1]]==1))
						dp[i][j]=1;
					else 
						dp[i][j]=0;
				}
			}
		}
		for(int i=0;i<=n;i++){
			for(int j=0;j<=sum;j++){
				System.out.print(dp[i][j]+"  ");
			}
			System.out.println();
		}
		int k=sum/2;
		int diff=Integer.MAX_VALUE;
		for(int j=sum/2;j>=0;j--){
			if(dp[n][j]==1 )
				return(sum-j*2);
		}
		return sum;
		
		
	}

	private static int findMinRec(int[] arr, int n, int i, int j) {
		if(n==0){
			System.out.println("i : "+i+",   j : "+j);
			return Math.abs(i-j);
		}
		return Math.min(findMinRec(arr,n-1,i+arr[n-1],j), findMinRec(arr,n-1,i,j+arr[n-1]));
	} 
}
