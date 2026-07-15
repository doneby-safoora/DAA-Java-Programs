//Algorith
/*
Visit the current vertex.
Mark it as visited.
Visit the first unvisited neighbour.
Continue going deeper until no unvisited neighbour exists.
Then backtrack to the previous vertex.
Continue until all vertices are visited.
 */

import java.util.*;

public class DFSGraph {

    // Function to perform DFS traversal
    static void dfs(ArrayList<ArrayList<Integer>> graph, int vertex, boolean[] visited) {

        // Mark the current vertex as visited
        visited[vertex] = true;

        // Print the current vertex
        System.out.print(vertex + " ");

        // Visit all adjacent vertices
        for (int neighbour : graph.get(vertex)) {

            if (!visited[neighbour]) {
                dfs(graph, neighbour, visited);
            }
        }
    }

    public static void main(String[] args) {

        int vertices = 5;

        // Creating the adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Adding edges
        graph.get(0).add(1);
        graph.get(0).add(2);

        graph.get(1).add(0);
        graph.get(1).add(3);

        graph.get(2).add(0);
        graph.get(2).add(4);

        graph.get(3).add(1);
        graph.get(3).add(4);

        graph.get(4).add(2);
        graph.get(4).add(3);

        // Visited array
        boolean[] visited = new boolean[vertices];

        System.out.print("DFS Traversal: ");

        // Start DFS from vertex 0
        dfs(graph, 0, visited);
    }
}