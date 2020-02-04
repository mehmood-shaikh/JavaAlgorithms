import java.util.PriorityQueue;
import java.util.Queue;


public class RatMaze {
	static Queue<String> pq=new PriorityQueue();
	public static void main(String args[]){
		int a[][]= {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
		boolean visited[][]=new boolean[4][4];
		
		visited[0][0]=true;
		nextStep(a,visited,0,0,"");
		while(!pq.isEmpty()){
			System.out.println(pq.poll());
		}
	}

	private static void nextStep(int[][] a, boolean[][] visited, int i, int j, String pathStr) {
		if(i==3 && j==3){
			pq.add(pathStr);
			return;
		}
		
		if(i<3 && a[i+1][j]==1 && !visited[i+1][j]){
			visited[i+1][j]=true;
			nextStep(a,visited,i+1,j,pathStr+"D");
			visited[i+1][j]=false;
		}
		if(j<3 && a[i][j+1]==1 && !visited[i][j+1]){
			visited[i][j+1]=true;
			nextStep(a,visited,i,j+1,pathStr+"R");
			visited[i][j+1]=false;
		}
		if(i>0 && a[i-1][j]==1 && !visited[i-1][j]){
			visited[i-1][j]=true;
			nextStep(a,visited,i-1,j,pathStr+"U");
			visited[i-1][j]=false;
		}
		if(j>0 && a[i][j-1]==1 && !visited[i][j-1]){
			visited[i][j-1]=true;
			nextStep(a,visited,i,j-1,pathStr+"L");
			visited[i][j-1]=false;
		}
			
		
	}
}
