import java.util.Scanner;

/*
MORDEN, Jhouvann S.
BSCS - A121
CS100-2: Discrete Structures 2
9:30AM - 10:45AM (MWF)
Week 7 (May 13-17, 2024)
Plate #6: Representing Graphs, Graph Isomorphism and Connectivity

Question 3:
Write a java program that will determine if a graph has a cycle or not.
*/

public class GraphCycleDetection {
    private int numVertices;  // Number of vertices in the graph
    private int[][] adjMatrix;  // Adjacency matrix to represent the graph
    private boolean[] visited;  // Visited array to keep track of visited vertices during DFS

    // Constructor to initialize the graph with a given number of vertices
    public GraphCycleDetection(int numVertices) {
        this.numVertices = numVertices;
        this.adjMatrix = new int[numVertices][numVertices];
        this.visited = new boolean[numVertices];
    }

    // Method for DFS traversal to detect cycles
    private boolean isCyclicUtil(int v, int parent, int depth, int start) {
        visited[v] = true;  // Mark the current vertex as visited

        // Traverse all adjacent vertices
        for (int i = 0; i < numVertices; i++) {
            if (adjMatrix[v][i] == 1) {  // Check if there is an edge between v and i
                if (i == start && depth >= 3) {  // Check for a cycle (at least 3 edges)
                    return true;
                }
                if (!visited[i]) {  // Recur for all the vertices adjacent to this vertex
                    if (isCyclicUtil(i, v, depth + 1, start)) {
                        return true;
                    }
                }
            }
        }

        // Backtrack: unmark the current vertex as visited
        visited[v] = false;
        return false;
    }

    // Method to check if the graph contains a cycle
    public boolean isCyclic() {
        // Call the CyclicUtil
        for (int i = 0; i < numVertices; i++) {
            if (isCyclicUtil(i, -1, 1, i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of vertices in the graph
        System.out.print("Enter the number of vertices: ");
        int vertices = sc.nextInt();

        // Create a graph with the specified number of vertices
        GraphCycleDetection graph = new GraphCycleDetection(vertices);

        // Input: adjacency matrix of the graph
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph.adjMatrix[i][j] = sc.nextInt();
            }
        }

        // Output the result: check if the graph contains a cycle
        if (graph.isCyclic()) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }

        // Close the scanner
        sc.close();
    }
}

/*
Test Case 1:
Input:
3
0 1 1
1 0 1
1 1 0
Output: The graph contains a cycle.

Test Case 2:
Input:
4
0 1 0 0
1 0 1 0
0 1 0 1
0 0 1 0
Output: The graph does not contain a cycle.

Test Case 3:
Input:
4
0 1 0 1
1 0 1 0
0 1 0 1
1 0 1 0
Output: The graph contains a cycle.

Test Case 4:
Input:
2
0 1
1 0
Output: The graph does not contain a cycle.

Test Case 5:
Input:
5
0 1 0 0 1
1 0 1 0 0
0 1 0 1 0
0 0 1 0 1
1 0 0 1 0
Output: The graph contains a cycle.
*/
