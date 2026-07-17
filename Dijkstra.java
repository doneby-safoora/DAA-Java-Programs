import java.util.Arrays;

public class Dijkstra
{
    static final int V = 5;

    // Find the vertex with the minimum distance
    int minDistance(int dist[], boolean visited[])
    {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < V; i++)
        {
            if (!visited[i] && dist[i] < min)
            {
                min = dist[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    // Dijkstra's Algorithm
    void dijkstra(int graph[][], int source)
    {
        int dist[] = new int[V];
        int prev[] = new int[V];
        boolean visited[] = new boolean[V];

        // Step 1: Initialize arrays
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);

        dist[source] = 0;

        // Step 2: Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++)
        {
            // Select the unvisited vertex with minimum distance
            int u = minDistance(dist, visited);

            // Mark the selected vertex as visited
            visited[u] = true;

            // Step 3: Update distances of adjacent vertices
            for (int v = 0; v < V; v++)
            {
                // Relaxation
                if (!visited[v] &&
                    graph[u][v] != 0 &&
                    dist[u] != Integer.MAX_VALUE &&
                    dist[u] + graph[u][v] < dist[v])
                {
                    dist[v] = dist[u] + graph[u][v];
                    prev[v] = u;
                }
            }
        }

        // Step 4: Print the result
        System.out.println("Vertex\tDistance\tPrevious");

        for (int i = 0; i < V; i++)
        {
            if (prev[i] == -1)
            {
                System.out.printf("%c\t%d\t\t-\n",
                        (char)(i + 65), dist[i]);
            }
            else
            {
                System.out.printf("%c\t%d\t\t%c\n",
                        (char)(i + 65),
                        dist[i],
                        (char)(prev[i] + 65));
            }
        }
    }

    public static void main(String[] args)
    {
        // Adjacency Matrix
        int graph[][] =
        {
            {0, 7, 3, 0, 0},
            {7, 0, 1, 2, 6},
            {3, 1, 0, 2, 0},
            {0, 2, 2, 0, 4},
            {0, 6, 0, 4, 0}
        };

        Dijkstra d = new Dijkstra();

        // Source Vertex = A (0)
        d.dijkstra(graph, 0);
    }
}

/*
Algorithm: Dijkstra's Shortest Path Algorithm: 

DIJKSTRA(G, Source)
1. Set the distance of the source vertex to 0.
2. Set the distance of all other vertices to Infinity.
3. Mark all vertices as unvisited.
4. Repeat (V − 1) times:
      a. Select the unvisited vertex with the minimum distance.
      b. Mark the selected vertex as visited.
      c. For every adjacent vertex:
            i. If the vertex is unvisited,
           ii. There is an edge between them, and
          iii. The new distance is smaller than the current distance,
               update the distance and previous vertex.
5. Print the shortest distance from the source to every vertex.

| Representation                             | Time Complexity      |
| ------------------------------------------ | -------------------- |
| Adjacency Matrix                           |   O(V²)              |
| Adjacency List + Priority Queue (Min Heap) |   O((V + E) log V)   |

*/