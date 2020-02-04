import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class ColoringGraph {
	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency List

	// Constructor
	ColoringGraph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v); // Graph is undirected
	}

	public static void main(String args[]) {

		ColoringGraph g1 = new ColoringGraph(5);
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(1, 2);
		g1.addEdge(1, 3);
		g1.addEdge(2, 3);
		g1.addEdge(3, 4);
		System.out.println("Coloring of graph 1");
		g1.greedyColoring();

		System.out.println();
		ColoringGraph g2 = new ColoringGraph(5);
		g2.addEdge(0, 1);
		g2.addEdge(0, 2);
		g2.addEdge(1, 2);
		g2.addEdge(1, 4);
		g2.addEdge(2, 4);
		g2.addEdge(4, 3);
		System.out.println("Coloring of graph 2 ");
		g2.greedyColoring();
	}

	private void greedyColoring() {
		int colors[] = new int[V];
		Arrays.fill(colors,-1);
		colors[0]=0;
		for(int i=1;i<V;i++){
			Set<Integer> hs=new HashSet<>();
			LinkedList<Integer> ll=adj[i];
			Iterator<Integer> it=ll.listIterator();
			while(it.hasNext()){
				hs.add(colors[it.next()]);
			}
			boolean notFound=true;
			int cInt=0;
			while(notFound){
				if(hs.contains(cInt))
					cInt++;
				else
					notFound=false;
			}
			colors[i]=cInt;	
		}
		for(int i=0;i<V;i++){
			System.out.print(colors[i]+" ");
		}
		System.out.println();
	}
}
