import java.util.*;

/*
MORDEN, Jhouvann S.
BSCS - A121
CS100-2: Discrete Structures 2
9:30AM - 10:45AM (MWF)
Week 7 (May 13-17, 2024)
Plate #6: Representing Graphs, Graph Isomorphism and Connectivity

Question 1:
Write a java program that receives a list of edges of a simple graph, the program should determine whether it is connected
and find the number of connected components if it is not connected
*/

public class GraphConnectivity {

    // Adjacency list to represent the graph
    private static Map<Integer, List<Integer>> adjacencyList;

    // Visited array to keep track of visited vertices during DFS
    private static boolean[] visited;

    // Depth-First Search (DFS) method to traverse the graph
    private static void dfs(int vertex) {
        // Mark the current vertex as visited
        visited[vertex] = true;
        // Recursively visit all the adjacent vertices that haven't been visited yet
        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of vertices in the graph
        System.out.print("Enter the number of vertices in the graph: ");
        int numVertices = sc.nextInt();

        // Edge case: if the number of vertices is zero or negative, the graph is invalid
        if (numVertices <= 0) {
            System.out.println("Graph must have at least one vertex.");
            return;
        }

        // Initialize the adjacency list for the graph
        adjacencyList = new HashMap<>();
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }

        // Input: edges of the graph
        System.out.println("Enter the edges (u v) of the graph (enter -1 -1 to finish):");
        while (true) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            // Break condition: if the user inputs -1 -1, stop reading edges
            if (u == -1 && v == -1) break;

            // Validation: check if the input edge is valid
            if (u < 0 || v < 0 || u >= numVertices || v >= numVertices || u == v) {
                System.out.println("Invalid edge. Please enter valid vertices and no self-loops.");
                continue;
            }

            // Check for duplicate edges in a simple graph
            if (adjacencyList.get(u).contains(v)) {
                System.out.println("This is not a simple graph. The edge already exists.");
                continue;
            }

            // Add the edge to the adjacency list (undirected graph)
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        // Initialize the visited array
        visited = new boolean[numVertices];
        int connectedComponents = 0;

        // Perform DFS for each vertex to count connected components
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                dfs(i);
                connectedComponents++;
            }
        }

        // Output the result: check if the graph is connected
        if (connectedComponents == 1) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + connectedComponents);
        }

        sc.close();
    }
}

/*
Sample Input and Output:

Vertices: 4
Pairs of vertices and edge types:
0 1
1 2
2 3
-1 -1
The graph is connected.

Vertices: 4
Pairs of vertices and edge types:
0 1
2 3
-1 -1
The graph is not connected.
Number of connected components: 2

Vertices: 3
Pairs of vertices and edge types:
0 1
1 1
1 2
-1 -1
Invalid edge. Please enter valid vertices and no self-loops.
The graph is connected.

Vertices: 4
Pairs of vertices and edge types:
0 1
1 2
1 2
2 3
-1 -1
This is not a simple graph. The edge already exists.
The graph is connected.

Vertices: 3
Pairs of vertices and edge types:
0 1
1 3
-1 -1
Invalid edge. Please enter valid vertices and no self-loops.
The graph is connected.
 */
