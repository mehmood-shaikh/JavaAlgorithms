import java.util.LinkedList;
import java.util.Stack;

public class SortedWDAG {
	int V;
	LinkedList<Edge> adj[];

	SortedWDAG(int V) {
		this.V = V;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	class Edge {
		int v;
		int w;

		Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	public static void main(String[] args) {
		SortedWDAG g = new SortedWDAG(6);
		g.addEdge(0, 1, 5);
		g.addEdge(0, 2, 3);
		g.addEdge(1, 3, 6);
		g.addEdge(1, 2, 2);
		g.addEdge(2, 4, 4);
		g.addEdge(2, 5, 2);
		g.addEdge(2, 3, 7);
		g.addEdge(3, 4, -1);
		g.addEdge(4, 5, -2);

		int s = 1;
		System.out.println("Following are shortest distances " + "from source "
				+ s);
		g.shortestPath(s);

	}

	private void shortestPath(int s) {
		Stack<Integer> st = topologicalSort();
		int dist[] = new int[V];
		for (int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;
		dist[s] = 0;
		while (!st.empty()) {
			int i = st.pop();

			if (dist[i] != Integer.MAX_VALUE) {
				for (Edge e : adj[i]) {
					dist[e.v] = Math.min(dist[e.v], dist[i] + e.w);
				}
			}
		}
		for (int i = 0; i < V; i++)
			System.out.println("Distance to " + i + " : " + dist[i]);

	}

	private Stack<Integer> topologicalSort() {
		Stack<Integer> st = new Stack<>();
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i])
				topSort(i, visited, st);
		}
		return st;
	}

	private void topSort(int i, boolean[] visited, Stack<Integer> st) {
		for (Edge e : adj[i]) {
			if (!visited[e.v]) {
				visited[e.v] = true;
				topSort(e.v, visited, st);
			}
		}
		st.add(i);

	}

	private void addEdge(int i, int v, int w) {
		adj[i].add(new Edge(v, w));

	}
}
