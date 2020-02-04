
public class LIS {
	public static void main(String[] args)
	{
		int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

		System.out.println("Length of LIS is " + LISRec(A,0,Integer.MIN_VALUE));
		System.out.println("Count : "+count);
		count=0;
		System.out.println("Length of LIS is " + LISDp(A));
		//System.out.println("Count : "+count);
	}
	private static int LISDp(int[] a) {
		int n=a.length;
		if(n==0)
			return 0;
		int dp[]=new int[n+1];
		dp[0]=0;
		String[] subseq=new String[n+1];
		subseq[0]="";
		
		for(int i=1;i<=n; i++){
			int max=dp[0];
			int index=0;
			for(int j=1;j<i;j++){
				if(a[j-1]<a[i-1] && max<dp[j]){
					max=dp[j];
					index=j;
				}
			}
			dp[i]=max+1;
			subseq[i]=subseq[index]+" "+a[i-1];
		}
			
		for(int i=1;i<=n; i++)
			System.out.println(a[i-1]+" ----- "+dp[i] + " ----- "+ subseq[i]);
		System.out.println();
		return dp[n];
	}
	static int count=0;

	private static int LISRec(int[] a, int i, int prev) {
		count++;
		//System.out.println("Calculating for i: "+i+" , prev : "+prev);
		if(i>=a.length){
			return 0;
		}
		if(prev<=a[i]){
			return Math.max(1+LISRec(a,i+1,a[i]),LISRec(a,i+1,prev));
		}else
			return LISRec(a,i+1,prev);	
	}
}
