
import java.util.*;

public class BFSAdjList {

    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    // Function to add an edge
    static void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);   // Remove this line for a directed graph
    }

    // BFS Traversal
    static void BFS(int start, int V) {

        boolean[] visited = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        System.out.println("\nBFS Traversal:");

        while (!queue.isEmpty()) {

            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adj.get(current)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) 
	{

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        // Create adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        System.out.println("Enter the edges (u v):");

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            addEdge(u, v);
        }

        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        BFS(start, V);

        sc.close();
    }
}