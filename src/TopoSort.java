import java.util.LinkedList;
import java.util.Stack;


public class TopoSort {
	int V;
	LinkedList<Integer> adj[];
	TopoSort(int V){
		this.V=V;
		adj=new LinkedList[V];
		for(int i=0;i<V;i++){
			adj[i]=new LinkedList<>();
		}	
	}
	
	void addEdge(int v,int w) { adj[v].add(w); }
	
	

	public static void main(String[] args) {
		TopoSort g = new TopoSort(6); 
	        g.addEdge(5, 2); 
	        g.addEdge(5, 0); 
	        g.addEdge(4, 0); 
	        g.addEdge(4, 1); 
	        g.addEdge(2, 3); 
	        g.addEdge(3, 1); 
	  
	        System.out.println("Following is a Topological " + 
	                           "sort of the given graph"); 
	        g.topologicalSort(); 

	}

	private void topologicalSort() {
		Stack<Integer> st=new Stack<>();
		boolean visited[]=new boolean[V];
		for(int i=0;i<V;i++){
			if(!visited[i])
				topUtil(i,visited,st);
		}
		
		while(!st.empty()){
			System.out.print(st.pop()+" ");
		}
		
	}

	private void topUtil(int i, boolean[] visited, Stack<Integer> st) {
		visited[i]=true;
		for(Integer neighbour:adj[i]){
			if(!visited[neighbour]){
				
				topUtil(neighbour,visited,st);
			}
		}
		st.add(i);
		
	}

}
