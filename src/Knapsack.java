import java.util.Arrays;


public class Knapsack {

	public static void main(String[] args) {
		int W[]= {1,2,3};
		int C[]={60,100,120};
		int S=5;
		knapsack(W,C,S);
		System.out.println("Recursive knapsack : "+knapsackRec(W,C,0,S));
	}

	private static int knapsackRec(int[] w, int[] c, int i, int s) {
		if(s<=0 || i==w.length)
			return 0;
		if(s>=w[i])
			return Math.max(c[i]+knapsackRec(w,c,i+1,s-w[i]), knapsackRec(w,c,i+1,s));
		else
			return knapsackRec(w,c,i+1,s);
	}

	private static void knapsack(int[] w, int[] c, int s) {
		int dp[][]=new int[s+1][w.length+1];
		Arrays.fill(dp[0], 0);
		for(int i=0;i<=w.length;i++)
			dp[i][0]=0;
		
		for(int i=1;i<=s;i++){
			for(int j=1;j<=w.length;j++){
				if(i>=w[j-1])
				dp[i][j]=Math.max(dp[i][j-1], c[j-1]+dp[i-w[j-1]][j-1]);
				else
					dp[i][j]=dp[i][j-1];
			}
		}
		
		for(int i=0;i<=s;i++){
			for(int j=0;j<=w.length;j++){
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}
		System.out.println(dp[s][w.length]);
	}
	

}
