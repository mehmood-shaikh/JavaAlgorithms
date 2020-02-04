import java.util.Arrays;


public class KnightMovementWarnsdorffs {
	public static void main(String args[]) {
		int  N=5;
		
		int sol[][]=new int [N][N];
		for(int i=0;i<N;i++)
			Arrays.fill(sol[i],-1);
		boolean notFound=true;
		for(int i=0;i<N&&notFound;i++){
			
			for(int j=0;j<N&&notFound;j++){
				sol[i][j]=0;
				if(KMUtil(sol,i,j,1,N)){
					System.out.println("-----------------------------------------------------");
					System.out.println("Found");
					disp(sol,N);
					notFound=false;
				}else
					System.out.println(i+", "+j+": No");
				sol[i][j]=-1;
			}
		}

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
		/*if(k==(N*N)-1)
			disp(sol,N);*/
		if(k==N*N)
			return true;
		
		Cell nextCell=findNext(sol,x,y,N);
		
		
		
			if(nextCell!=null){
				sol[nextCell.x][nextCell.y]=k;
				if(KMUtil(sol, nextCell.x, nextCell.y, k+1, N))
					return true;
				else {
					sol[nextCell.x][nextCell.y]=-1;
					//continue;
				}
			}
		
		return false;
	}
	 private static Cell findNext(int[][] sol, int x, int y, int N) {
		int min=N;
		int minx=0,miny=0;
		for(int i=0;i<8;i++)
		{
			int newx=x+movex[i], newy=y+movey[i];
			if(isSafe(sol,newx,newy,N)){
				int adj=findAdj(sol,newx,newy,N);
				if(adj<min){
					minx=newx;
					miny=newy;
					min=adj;
				}
			}
		}
		if(min<N)
			return new Cell(minx,miny);
		 
		return null;
	}
	private static int findAdj(int[][] sol, int x, int y, int N) {
		int count=0;
		for(int i=0;i<8;i++)
		{
			int newx=x+movex[i], newy=y+movey[i];
			if(isSafe(sol,newx,newy,N)){
				count++;
			}
			
		}
		return count;
	}
	

	private static boolean isSafe(int[][] sol, int i, int j, int N) {
		return i>=0&&i<N&&j>=0&&j<N&&(sol[i][j]==-1);
	}
}
class Cell{
	 int x;
	 int y;
	 Cell(int x,int y){
		 this.x=x;
		 this.y=y;
	 }
	 
}
