import java.util.Scanner;

/*
MORDEN, Jhouvann S.
BSCS - A121
CS100-2: Discrete Structures 2
9:30AM - 10:45AM (MWF)
Week 7 (May 13-17, 2024)
Plate #6: Representing Graphs, Graph Isomorphism and Connectivity
Question 4:
Write a java program, given the pair of vertex associated to the edges of an undirected graph,
it will output the degree of vertex.
 */

public class GraphDegreeCalculation {
    private int[][] adjacencyMatrix;
    private int vertices;

    // Constructor to initialize the graph with the given number of vertices
    public GraphDegreeCalculation(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1; // Since the graph is undirected
    }

    // Method to calculate the degree of a given vertex
    public int getDegree(int vertex) {
        int degree = 0;
        for (int i = 0; i < vertices; i++) {
            degree += adjacencyMatrix[vertex][i];
        }
        return degree;
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices and edges
        System.out.print("Enter the number of vertices: ");
        int vertices = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int edges = sc.nextInt();

        // Initialize the graph with the given number of vertices
        GraphDegreeCalculation graph = new GraphDegreeCalculation(vertices);

        // Input pairs of vertices that form the edges
        System.out.println("Enter the pairs of vertices associated with the edges:");
        for (int i = 0; i < edges; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            graph.addEdge(source, destination);
        }

        // Input the vertex whose degree is to be calculated
        System.out.print("Enter the vertex to find the degree: ");
        int vertex = sc.nextInt();

        // Output the degree of the specified vertex
        System.out.println("The degree of vertex " + vertex + " is: " + graph.getDegree(vertex));

        sc.close();
    }
}
/*
Test Case 1:
Vertices: 4
Edges: 3
Pairs of vertices:
0 1
0 2
0 3
Vertex to find degree: 0
Output: The degree of vertex 0 is: 3

Test Case: 2
Vertices: 5
Edges: 4
Pairs of vertices:
1 2
2 3
3 4
4 1
Vertex to find degree: 2
Output: The degree of vertex 2 is: 2

Test Case 3:
Vertices: 3
Edges: 3
Pairs of vertices:
0 1
1 2
2 0
Vertex to find degree: 1
Output: The degree of vertex 1 is: 2

Test Case 4:
Vertices: 6
Edges: 5
Pairs of vertices:
0 1
0 2
2 3
3 4
4 5
Vertex to find degree: 3
Output: The degree of vertex 3 is: 2

Test Case 5:
Vertices: 3
Edges: 1
Pairs of vertices:
0 1
Vertex to find degree: 2
Output: The degree of vertex 2 is: 0


 */