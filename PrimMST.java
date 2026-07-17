import java.util.Arrays;

public class PrimMST
{
    static final int V = 5;

    // Find the vertex with the minimum key value
    int minKey(int key[], boolean mstSet[])
    {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++)
        {
            if (!mstSet[v] && key[v] < min)
            {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // Print the Minimum Spanning Tree
    void printMST(int parent[], int graph[][])
    {
        int totalCost = 0;

        System.out.println("Edge\tWeight");

        for (int i = 1; i < V; i++)
        {
            System.out.println(parent[i] + " - " + i +
                               "\t" + graph[i][parent[i]]);

            totalCost += graph[i][parent[i]];
        }

        System.out.println("\nTotal Cost = " + totalCost);
    }

    // Prim's Algorithm
    void primMST(int graph[][])
    {
        int parent[] = new int[V];
        int key[] = new int[V];
        boolean mstSet[] = new boolean[V];

        // Step 1: Initialize all keys as infinity
        Arrays.fill(key, Integer.MAX_VALUE);

        // Step 2: Start from vertex 0
        key[0] = 0;
        parent[0] = -1;

        // Step 3: Construct MST
        for (int count = 0; count < V - 1; count++)
        {
            // Select the minimum key vertex
            int u = minKey(key, mstSet);

            // Include the selected vertex in MST
            mstSet[u] = true;

            // Update key values of adjacent vertices
            for (int v = 0; v < V; v++)
            {
                if (graph[u][v] != 0 &&
                    !mstSet[v] &&
                    graph[u][v] < key[v])
                {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print the MST
        printMST(parent, graph);
    }

    public static void main(String[] args)
    {
        int graph[][] =
        {
            {0, 4, 2, 5, 0},
            {4, 0, 0, 0, 3},
            {2, 0, 0, 1, 0},
            {5, 0, 1, 0, 6},
            {0, 3, 0, 6, 0}
        };

        PrimMST graphObj = new PrimMST();
        graphObj.primMST(graph);
    }
}

/*
Algorithm: Prim's Minimum Spanning Tree (MST):

PRIM(G)
1. Initialize the key value of every vertex as ∞.
2. Choose any vertex as the starting vertex.
   Set its key value to 0.
3. Repeat until all vertices are included in the MST:
      a. Select the unvisited vertex having the minimum key value.
      b. Mark it as visited.
      c. For every adjacent vertex:
            i. If the edge exists,
           ii. The adjacent vertex is unvisited, and
          iii. The edge weight is smaller than its current key value,
               update its key value and parent.
4. Print all edges stored in the parent array.
5. The selected edges form the Minimum Spanning Tree.

Representation	                        Time Complexity
Adjacency Matrix	                    O(V²)
Adjacency List + Priority Queue     	O(E log V)

*/