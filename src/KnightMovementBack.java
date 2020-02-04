import java.util.Arrays;


public class KnightMovementBack {
	public static void main(String args[]) {
		int  N=8;
		
		int sol[][]=new int [N][N];
		for(int i=0;i<N;i++)
			Arrays.fill(sol[i],-1);
		sol[0][0]=0;
		if(KMUtil(sol,0,0,1,N)){
			System.out.println("-----------------------------------------------------");
			System.out.println("Found");
			disp(sol,N);
		}else
			System.out.println("No");

	}
	private static void disp(int[][] sol, int  N) {
		System.out.println("-----------------------------------------------------");
		for(int j=0;j<N;j++){
			for(int k=0;k<N;k++)
				System.out.print(sol[j][k]+ " ");
			System.out.println();
		}
		
	}
	static int movex[]={2, 1, -1, -2, -2, -1, 1, 2}; 
	static int movey[]={1, 2, 2, 1, -1, -2, -2, -1}; 
	
	private static boolean KMUtil(int[][] sol, int x, int y, int k, int N) {
		//System.out.println("x : "+x+", y :"+y+", k :"+k);
		if(k==63)
			disp(sol,N);
		if(k==N*N)
			return true;
		for(int i=0;i<8;i++)
		{
			int newx=x+movex[i], newy=y+movey[i];
			if(isSafe(sol,newx,newy,N)){
				sol[newx][newy]=k;
				if(KMUtil(sol, newx, newy, k+1, N))
					return true;
				else {
					sol[newx][newy]=-1;
					//continue;
				}
			}
		}
		
		return false;
	}

	private static boolean isSafe(int[][] sol, int i, int j, int N) {
		return i>=0&&i<N&&j>=0&&j<N&&(sol[i][j]==-1);
	}
}
