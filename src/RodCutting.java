
public class RodCutting {
	public static void main(String[] args)
	{
		// length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int price [] = { 1, 5, 8, 9, 10, 17, 17, 20 };

		// rod length
		int n = 5;

		System.out.println("Profit is " + rodCut(price, n));
	}

	private static int rodCut(int[] price, int n) {
		int dp[]=new int[n+1];
		dp[0]=0;
		dp[1]=price[0];
		for(int i=2;i<=n;i++){
			int k=0;
			for(int j=0;j<i;j++){
				int currPrice=dp[i-j-1]+price[j];
				if(k<currPrice)
					k=currPrice;
			}
			dp[i]=k;
		}
		return dp[n];
	}
}
