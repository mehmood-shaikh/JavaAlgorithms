import java.util.Arrays;


public class CoinGameVariation {
	static int K=2;
	public static void main(String[] args) {
		int c[]={10, 15, 20, 9, 2, 5};
		int n=c.length;
		
		int s=Arrays.stream(c).sum();
		dp=new int[n][n][K];
		int m=find(c,2,0,n-1,1);
		
		System.out.println(m);
		System.out.println("{10, 15, 20, 9, 2, 5}");
		// m=findDP(c,n,s,K);
		//	System.out.println(m);

	}

	private static int findDP(int[] c, int n, int s, int K) {
		int[][][] dp=new int[n+1][n][K];
		for(int i=0;i<=n;i++){
			for(int j=0;j<=n-i;j++){
				for(int k=0;k<K;k++){
					if(i==0){
						if(j!=n)
							dp[i][j][k]=0;
					}
					else if(i==1)
						dp[i][j][k]=c[j];
					else if(i==2){
						if(k==0)
							dp[i][j][k]=Math.max(c[j], c[j+1]);
						else 
							dp[i][j][k]=c[j]+ c[j+1];
					}
					else{
						int x=0,y=0,z=0,w=Integer.MAX_VALUE;
						if(k==0){
							x=dp[i-3][j][K-1];
							y=dp[i-3][j+1][K-1];
							z=dp[i-3][j+2][K-1];
							if(j+3<n)
								w=dp[i-3][j+3][K-1];
							dp[i][j][k]=Math.max(c[j]+Math.min(Math.min(y, z),w), c[j+i-1]+Math.min(Math.min(y, x),z));
						}else {
							x=dp[i-1][j][k-1];
							y=dp[i-1][j+1][k-1];
							dp[i][j][k]=Math.max(c[j]+y, c[j+i-1]+x);
							
						}
							
						
					}
				}
			}
		}
		
		for(int i=0;i<=n;i++){
			for(int j=0;j<n;j++){
				for(int k=0;k<K;k++){
					System.out.print(dp[i][j][k]+"  ");
				}
				System.out.print(" , ");
			}
			System.out.println();
		}
				
		return dp[n][0][K-1];
	}
	static int dp[][][];
	private static int find(int[] c, int k, int l, int r, int maxMin) {
		System.out.println("l : "+ l + ", r : "+r+", k : "+k);
		if(dp[l][r][k-1]!=0)
			return dp[l][r][k-1];
		else if(r<l){
			if(maxMin==0)
				return dp[l][r][k-1]=Integer.MAX_VALUE;
			else
				return dp[l][r][k-1]=0;
		}
		if(r==l)
			return dp[l][r][k-1]=c[l];
		if(r-l<k)
			return dp[l][r][k-1]=Arrays.stream(c,l,r+1).sum();
		if(l+1==r)
			return dp[l][r][k-1]=Math.max(c[l], c[r]);
		if(k==1){
			int lMin=Integer.MAX_VALUE;
			int rMin=Integer.MAX_VALUE;
			for(int i=0;i<=K;i++){
				int lCount=find(c,2,l+K+1-i,r-i,0);
				if(lMin>lCount)
					lMin=lCount;
				int rCount=find(c,2,l+i,r-K-1+i,0);
				if(rMin>rCount)
					rMin=rCount;
			}
			return dp[l][r][k-1]=Math.max(c[l]+lMin,
					c[r]+rMin);
		}else if(k>1)	
			return dp[l][r][k-1]=Math.max(c[l]+find(c,1,l+1,r,k-1), c[r]+find(c,1,l,r-1,k-1));
		return 0;
	}
}
