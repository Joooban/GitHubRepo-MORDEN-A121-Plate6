import java.util.Scanner;

/*
MORDEN, Jhouvann S.
BSCS - A121
CS100-2: Discrete Structures 2
9:30AM - 10:45AM (MWF)
Week 7 (May 13-17, 2024)
Plate #6: Representing Graphs, Graph Isomorphism and Connectivity

Question 6:
Write a java program that receives the vertex pairs associated to the edges of a graph. The program should construct an
adjacency matrix for the graph. (Produce a version that works when loops, multiple edges, or directed edges are present.)
*/

public class GraphAdjacencyMatrix {
    private int[][] adjacencyMatrix; // Adjacency matrix to represent the graph

    // Constructor to initialize the graph with a given number of vertices
    public GraphAdjacencyMatrix(int vertices) {
        adjacencyMatrix = new int[vertices][vertices]; // Initialize the adjacency matrix
    }

    // Method to add an edge to the adjacency matrix
    public void addEdge(int source, int destination, boolean isDirected) {
        adjacencyMatrix[source][destination]++; // Add edge count for the source to destination
        if (!isDirected) { // If the graph is undirected, increment the edge count for the destination to source
            adjacencyMatrix[destination][source]++;
        }
    }

    // Method to print the adjacency matrix
    public void printAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int[] row : adjacencyMatrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of vertices in the graph
        System.out.print("Enter the number of vertices: ");
        int vertices = sc.nextInt();

        // Create a graph with the specified number of vertices
        GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(vertices);

        // Input: number of edges in the graph
        System.out.print("Enter the number of edges: ");
        int edges = sc.nextInt();

        // Input: edges with their source, destination, and whether they are directed
        System.out.println("Enter edges (source destination directed[1/0]):");
        for (int i = 0; i < edges; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            boolean isDirected = sc.nextInt() == 1; // Directed (1 for true, 0 for false)
            graph.addEdge(source, destination, isDirected); // Add the edge to the adjacency matrix
        }

        // Output the adjacency matrix
        graph.printAdjacencyMatrix();

        sc.close();
    }
}

/*
Test Case 1:
Vertices: 3
Edges: 3
Pairs of vertices and edge types:
0 1 0
1 2 0
2 0 0
Output:
Adjacency Matrix:
0 1 1
1 0 1
1 1 0

Test Case 2:
Vertices: 4
Edges: 5
Pairs of vertices and edge types:
0 1 1
1 2 1
2 3 1
3 0 1
0 2 1
Output:
Adjacency Matrix:
0 1 1 0
0 0 1 0
0 0 0 1
1 0 0 0

Test Case 3:
Vertices: 2
Edges: 2
Pairs of vertices and edge types:
0 1 0
0 1 0
Output:
Adjacency Matrix:
0 2
2 0

Test Case 4:
Vertices: 3
Edges: 4
Pairs of vertices and edge types:
0 0 1
0 1 0
1 2 0
2 0 1
Output:
Adjacency Matrix:
1 1 1
1 0 1
1 1 0

Test Case 5:
Vertices: 3
Edges: 2
Pairs of vertices and edge types:
0 1 0
1 1 1
Output:
Adjacency Matrix:
0 1 0
1 1 0
0 0 0
*/
