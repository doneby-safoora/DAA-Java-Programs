//Algorithm
/*
BFS(Graph G, Start Vertex S)

1. Mark S as visited.
2. Create an empty Queue.
3. Enqueue S.

4. While Queue is not empty
      a. Dequeue a vertex V.
      b. Print V.
      c. For every adjacent vertex U of V
            If U is not visited
                 Mark U as visited.
                 Enqueue U.
*/

import java.util.*;

public class BFSGraph {

    // Function to perform BFS traversal
    static void bfs(ArrayList<ArrayList<Integer>> graph, int start, int vertices) {

        // Keeps track of visited vertices
        boolean[] visited = new boolean[vertices];

        // Queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Mark the starting vertex as visited
        visited[start] = true;

        // Insert starting vertex into the queue
        queue.offer(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {

            // Remove the front vertex from the queue
            int current = queue.poll();

            System.out.print(current + " ");

            // Visit all adjacent vertices
            for (int neighbour : graph.get(current)) {

                if (!visited[neighbour]) {

                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
    }

    public static void main(String[] args) {

        int vertices = 5;

        // Creating adjacency list
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

        bfs(graph, 0, vertices);
    }
}