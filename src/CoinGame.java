import java.util.Arrays;


public class CoinGame {

	public static void main(String[] args) {
		int c[]={5,3,7,10};
		int n=c.length;
		int s=Arrays.stream(c).sum();
		int m=find(c,0,n-1,s);
		System.out.println(m);
		 m=findDP(c,n,s);
			System.out.println(m);

	}

	private static int findDP(int[] c, int n, int s) {
		int dp[][]=new int [n+1][n];
		for(int i=0;i<=n;i++){
			for(int j=0;j<=n-i;j++){
				
				if(i==0&&j==n)
					continue;
				else if(i==0)
					dp[i][j]=0;
				else if(i==1)
					dp[i][j]=c[j];
				else if(i==2)
					dp[i][j]=Math.max(c[j],c[j+1]);
				else{
					int x=dp[i-2][j+1];
					int y=dp[i-2][j+2];
					int z=dp[i-2][j];
					System.out.println("i :"+i+", j :"+j);
					System.out.println("x :"+x+", y :"+y+", z :"+z);
					dp[i][j]=Math.max(c[j]+Math.min(x,y), c[j+i-1]+Math.min(x,z));
				}
			}
		}
		for(int i=0;i<=n;i++){
			for(int j=0;j<n;j++){
				System.out.print(dp[i][j] +  "  ");
			}
			System.out.println();
		}
		return dp[n][0];
	}

	private static int find(int[] c, int i, int j, int s) {
		if(i+1==j)
			return Math.max(c[i], c[j]);
		return Math.max(s-find(c,i+1,j,s-c[i]), s-find(c,i,j-1,s-c[j]));
	}

}
