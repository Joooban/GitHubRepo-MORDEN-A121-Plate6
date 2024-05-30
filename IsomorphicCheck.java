import java.util.*;

/*

MORDEN, Jhouvann S.
BSCS - A121
CS100-2: Discrete Structures 2
9:30AM - 10:45AM (MWF)
Week 7 (May 13-17, 2024)
Plate #6: Representing Graphs, Graph Isomorphism and Connectivity
Question 8:
Write a Java program that checks whether two graphs are isomorphic or not, given a set of vertices.
*/
public class IsomorphicCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask for user input
        System.out.print("Enter the number of vertices in the graphs:");
        int n = sc.nextInt();

        System.out.println("Enter the adjacency matrix for the first graph (separate by space):");
        int[][] graph1 = readGraph(sc, n);

        System.out.println("Enter the adjacency matrix for the second graph (separate by space):");
        int[][] graph2 = readGraph(sc, n);

        boolean isomorphic = areIsomorphic(graph1, graph2);
        System.out.println(isomorphic ? "The graphs are isomorphic." : "The graphs are not isomorphic.");
    }

    // Reads the adjacency matrix of a graph from user and returns it as a 2D array.
    private static int[][] readGraph(Scanner sc, int n) {
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        return graph;
    }
    // Final checker if graph is Isomorphic(checks vertices, edges, degree sequence, and permutation of vertices)
     private static boolean areIsomorphic(int[][] graph1, int[][] graph2) {
        int n = graph1.length;
        if (graph2.length != n) return false;
        if (countEdges(graph1) != countEdges(graph2)) return false;
        if (!Arrays.equals(getDegreeSequence(graph1), getDegreeSequence(graph2))) return false;
        return checkIsomorphism(graph1, graph2, new int[n], new boolean[n], 0);
    }

    // Count number of edges
    private static int countEdges(int[][] graph) {
        int count = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = i + 1; j < graph[i].length; j++) {
                count += graph[i][j];
            }
        }
        return count;
    }

    // Calculate the degree of each vertex and returns the sorted degree sequence of the graph.
    private static int[] getDegreeSequence(int[][] graph) {
        int[] degrees = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                degrees[i] += graph[i][j];
            }
        }
        Arrays.sort(degrees);
        return degrees;
    }

    //Checks all possible permutations of vertices to check if any permutation makes the graphs identical.
    private static boolean checkIsomorphism(int[][] graph1, int[][] graph2, int[] permutation, boolean[] used, int index) {
        if (index == graph1.length) return isValidPermutation(graph1, graph2, permutation);
        for (int i = 0; i < graph1.length; i++) {
            if (!used[i]) {
                used[i] = true;
                permutation[index] = i;
                if (checkIsomorphism(graph1, graph2, permutation, used, index + 1)) return true;
                used[i] = false;
            }
        }
        return false;
    }

    // Checks if the permutations of the vertices are identical between the two graphs
    private static boolean isValidPermutation(int[][] graph1, int[][] graph2, int[] permutation) {
        for (int i = 0; i < graph1.length; i++) {
            for (int j = 0; j < graph1.length; j++) {
                if (graph1[i][j] != graph2[permutation[i]][permutation[j]]) return false;
            }
        }
        return true;
    }
}

/*
Test Case 1:
4
0 1 0 1
1 0 1 0
0 1 0 1
1 0 1 0

0 1 0 1
1 0 1 0
0 1 0 1
1 0 1 0
- The graphs are isomorphic.

Test Case 2:
3
0 1 1
1 0 1
1 1 0

0 1 0
1 0 1
0 1 1
- The graphs are not isomorphic.

Test Case 3:
Vertices: 5
Graph 1 Adjacency Matrix:
0 1 1 0 0
1 0 1 1 0
1 1 0 1 0
0 1 1 0 1
0 0 0 1 0

Graph 2 Adjacency Matrix:
0 1 0 1 0
1 0 1 0 1
0 1 0 1 0
1 0 1 0 1
0 1 0 1 0
Output: The graphs are not isomorphic.


est Case 4:
Vertices: 4
Graph 1 Adjacency Matrix:
0 1 1 1
1 0 0 0
1 0 0 0
1 0 0 0

Graph 2 Adjacency Matrix:
0 1 0 1
1 0 1 0
0 1 0 1
1 0 1 0
Output: The graphs are not isomorphic.

Test Case 5:
4
0 1 1 0
1 0 0 1
1 0 0 1
0 1 1 0

0 1 0 1
1 0 1 0
0 1 0 1
1 0 1 0
- The graphs are isomorphic.
*/

