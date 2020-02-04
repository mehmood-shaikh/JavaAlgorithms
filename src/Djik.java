import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


public class Djik {
	static int V;
	static List<Node>[] adjList;
	static Set<Integer> visited;
	static int[] shortestPath;
	static Queue<Node> pq=new PriorityQueue<Node>();
	
	public static class Node implements Comparable<Node>{
		int vertex;
		int weight;
		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + "]";
		}
		
		@Override
		public int compareTo(Node o) {
			if(this.weight>o.weight){
				return 1;
			}else if (this.weight<o.weight){
				return -1;
			}
			return 0;
		}
		
	}
	
	public static void main(String[] args) {
		V=6;
		adjList= new List[V];
		visited= new HashSet<Integer>();
		shortestPath=new int[V];
		for(int i=0;i<V;i++){
			adjList[i]=new ArrayList<Node>();
		}
		addEdge(0,1,4);
		addEdge(0,2,3);
		addEdge(1,2,1);
		addEdge(1,3,2);
		addEdge(2,3,4);
		addEdge(3,4,2);
		addEdge(4,2,6);
		
		for(int i=0;i<V;i++){
			shortestPath[i]=Integer.MAX_VALUE;
			for(Node n:adjList[i])
				System.out.println(i+" : "+n);
		}
		int source=0;
		shortestPath[source]=0;
		findShortestPath(source);
		System.out.println("Shortest Distance from "+ source);
		for(int i=0;i<V;i++){
			System.out.println(i+" : "+shortestPath[i]);
		}
	}

	private static void findShortestPath(int currentNode) {
		for(Node n:adjList[currentNode]){
			if(!visited.contains(n.vertex)){
				shortestPath[n.vertex]=Math.min((n.weight+shortestPath[currentNode]), shortestPath[n.vertex]);
				pq.offer(new Node(n.vertex,shortestPath[n.vertex]));
				
			}
		}
		visited.add(currentNode);
		if(visited.size()<V && !pq.isEmpty()){
			findShortestPath(pq.remove().vertex);
		}
	}

	private static void addEdge(int i, int vertex, int weight) {
		List<Node> list;
		if(adjList[i]==null)
			adjList[i]= new ArrayList<Node>();
		list=adjList[i];
		Node node= new Node(vertex,weight);
		list.add(node);
	}

}
