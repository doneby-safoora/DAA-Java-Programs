import java.util.*;

// Edge class
class Edge implements Comparable<Edge>
{
    int src, dest, weight;

    // Constructor
    Edge(int src, int dest, int weight)
    {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    // Sort edges based on weight
    @Override
    public int compareTo(Edge other)
    {
        return this.weight - other.weight;
    }
}

public class KruskalMST
{
    int V;                      // Number of vertices
    ArrayList<Edge> edges;      // List of all edges

    // Constructor
    KruskalMST(int V)
    {
        this.V = V;
        edges = new ArrayList<>();
    }

    // Add an edge to the graph
    void addEdge(int src, int dest, int weight)
    {
        edges.add(new Edge(src, dest, weight));
    }

    // Find operation (Path Compression)
    int find(int parent[], int i)
    {
        if (parent[i] != i)
        {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    // Union operation (Union by Rank)
    void union(int parent[], int rank[], int x, int y)
    {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rank[rootX] < rank[rootY])
        {
            parent[rootX] = rootY;
        }
        else if (rank[rootX] > rank[rootY])
        {
            parent[rootY] = rootX;
        }
        else
        {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    // Kruskal's Algorithm
    void kruskalMST()
    {
        // Step 1: Sort all edges
        Collections.sort(edges);

        int parent[] = new int[V];
        int rank[] = new int[V];

        // Step 2: Initialize parent and rank arrays
        for (int i = 0; i < V; i++)
        {
            parent[i] = i;
            rank[i] = 0;
        }

        int edgeCount = 0;
        int totalCost = 0;

        System.out.println("Edges in the Minimum Spanning Tree:");

        // Step 3: Process edges in sorted order
        for (Edge edge : edges)
        {
            int root1 = find(parent, edge.src);
            int root2 = find(parent, edge.dest);

            // If adding this edge doesn't create a cycle
            if (root1 != root2)
            {
                System.out.println(edge.src + " -- " +
                                   edge.dest + " == " +
                                   edge.weight + " ---> ACCEPTED");

                totalCost += edge.weight;

                union(parent, rank, root1, root2);

                edgeCount++;

                // Stop when MST has (V - 1) edges
                if (edgeCount == V - 1)
                {
                    break;
                }
            }
            else
            {
                System.out.println(edge.src + " -- " +
                                   edge.dest + " == " +
                                   edge.weight + " ---> REJECTED");
            }
        }

        System.out.println("\nTotal Cost = " + totalCost);
    }

    public static void main(String[] args)
    {
        KruskalMST graph = new KruskalMST(5);

        // Adding edges
        graph.addEdge(0, 1, 4);   // A-B
        graph.addEdge(0, 2, 2);   // A-C
        graph.addEdge(0, 3, 5);   // A-D
        graph.addEdge(1, 4, 3);   // B-E
        graph.addEdge(2, 3, 1);   // C-D
        graph.addEdge(3, 4, 6);   // D-E

        graph.kruskalMST();
    }
}

/*
Algorithm: Kruskal's Minimum Spanning Tree (MST): 

KRUSKAL(G)
1. Sort all edges in non-decreasing order of weight.
2. Create a separate set for every vertex.
3. For each edge (u, v) in sorted order:
      a. Find the parent of u.
      b. Find the parent of v.
      c. If both parents are different:
            i. Include the edge in the MST.
           ii. Union the two sets.
      d. Otherwise, reject the edge.
4. Stop when the MST contains (V − 1) edges.
5. Print the MST and its total cost.

Union-Find (Disjoint Set) Summary: 

parent[] stores the representative (root) of each set.
rank[] stores an estimate of the height of each tree.
During Union, the tree with the smaller rank is attached under the tree with the larger rank.
If both trees have the same rank, one tree becomes the parent and its rank is increased by 1.
Path Compression updates the parent of every visited node directly to the root, making future find() operations faster.
Using Union by Rank + Path Compression makes the Union-Find operations almost constant time.

Time Complexity: O(E log E)

*/

