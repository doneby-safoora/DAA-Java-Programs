import java.util.*;

public class BFS {

    private int vertices;
    private LinkedList<Integer>[] adj;

    // Constructor
    BFS(int v) {
        vertices = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    void addEdge(int source, int destination) {
        adj[source].add(destination);

        // Uncomment the next line for an undirected graph
        // adj[destination].add(source);
    }

    // Breadth First Search
    void bfs(int startVertex) {

        boolean[] visited = new boolean[vertices];

        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.offer(startVertex);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {

            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adj[current]) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        BFS graph = new BFS(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        graph.bfs(0);
    }
}