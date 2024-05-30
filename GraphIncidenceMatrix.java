import java.util.Scanner;

/*
MORDEN, Jhouvann S.
BSCS - A121
CS100-2: Discrete Structures 2
9:30AM - 10:45AM (MWF)
Week 7 (May 13-17, 2024)
Plate #6: Representing Graphs, Graph Isomorphism and Connectivity

Question 7:
Write a java program that accepts vertex pairs associated to the edges of an undirected graph and the number of times
each edge appears. The program should construct an incidence matrix for the graph
*/

public class GraphIncidenceMatrix {
    private int[][] incidenceMatrix; // Incidence matrix for graph
    private int vertices, edges; // Number of vertices and edges

    // Constructor to initialize the graph with given number of vertices and edges
    public GraphIncidenceMatrix(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        this.incidenceMatrix = new int[vertices][edges]; // Initialize the incidence matrix
    }

    // Method to add an edge to the incidence matrix
    public void addEdge(int edgeIndex, int source, int destination, int count) {
        // Increment the count for the source vertex
        incidenceMatrix[source][edgeIndex] += count;
        // If not loop
        if (source != destination) {
            incidenceMatrix[destination][edgeIndex] += count;
        }
    }

    // Method to print the incidence matrix
    public void printIncidenceMatrix() {
        for (int[] row : incidenceMatrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of vertices in the graph
        System.out.print("Enter the number of vertices: ");
        int vertices = sc.nextInt();

        // Input: number of edges in the graph
        System.out.print("Enter the number of edges: ");
        int edges = sc.nextInt();

        // Create a graph with the specified number of vertices and edges
        GraphIncidenceMatrix graph = new GraphIncidenceMatrix(vertices, edges);

        // Input: pairs of vertices and count of edges
        System.out.println("Enter the pairs of vertices associated with the edges and the number of times each edge appears:");
        for (int i = 0; i < edges; i++) {
            int source = sc.nextInt(); // Source vertex
            int destination = sc.nextInt(); // Destination vertex
            int count = sc.nextInt(); // Number of times the edge appears
            graph.addEdge(i, source, destination, count); // Add the edge to the incidence matrix
        }

        // Output the incidence matrix
        graph.printIncidenceMatrix();

        sc.close();
    }
}

/*
Test Case 1:
Input:
3
3
Pairs of vertices and counts:
0 1 1
1 2 1
2 0 1
Output:
Incidence Matrix:
1 0 1
1 1 0
0 1 1

Test Case 2:
Input:
4
5
Pairs of vertices and counts:
0 1 2
1 2 1
2 3 1
3 0 1
0 2 1
Output:
Incidence Matrix:
2 0 0 1 1
2 1 0 0 0
0 1 1 0 1
0 0 1 1 0

Test Case 3:
Input:
3
3
Pairs of vertices and counts:
0 1 2
1 2 1
2 0 1
Output:
Incidence Matrix:
2 0 1
2 1 0
0 1 1

Test Case 4:
Input:
3
4
Pairs of vertices and counts:
0 0 1
0 1 2
1 2 1
2 0 1
Output:
Incidence Matrix:
1 2 0 1
0 2 1 0
0 0 1 1

Test Case 5:
Input:
4
4
Pairs of vertices and counts:
0 0 2
0 1 1
1 2 1
2 3 1
Output:
Incidence Matrix:
2 1 0 0
0 1 1 0
0 0 1 1
0 0 0 1
*/
