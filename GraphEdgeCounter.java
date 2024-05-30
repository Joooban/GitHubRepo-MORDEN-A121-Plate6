import java.util.*;

/*
MORDEN, Jhouvann S.
BSCS - A121
CS100-2: Discrete Structures 2
9:30AM - 10:45AM (MWF)
Week 7 (May 13-17, 2024)
Plate #6: Representing Graphs, Graph Isomorphism and Connectivity

Question 2:
Write a java program that accepts an adjacency matrix of a graph. The program should list the edges of this graph and give
the number of times each edge appears
 */


public class GraphEdgeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the size of the matrix (number of vertices)
        System.out.print("Enter the number of vertices: ");
        int vertex = sc.nextInt();

        // Input the adjacency matrix
        int[][] adjacencyMatrix = new int[vertex][vertex];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                adjacencyMatrix[i][j] = sc.nextInt();
            }
        }

        // Count edges
        Map<String, Integer> edgeCountMap = new HashMap<>();
        for (int i = 0; i < vertex; i++) {
            for (int j = i + 1; j < vertex; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    edgeCountMap.put(i + "-" + j, adjacencyMatrix[i][j]);
                }
            }
        }

        // Output the edges and their counts
        System.out.println("Edges and their counts:");
        edgeCountMap.forEach((edge, count) -> System.out.println("Edge " + edge + ": " + count + " times"));

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
Output:
Edge 0-1: 1 times
Edge 0-2: 1 times
Edge 1-2: 1 times

Test Case 2:
Input:
4
0 1 0 1
1 0 1 0
0 1 0 1
1 0 1 0
Output:
Edge 0-1: 1 times
Edge 0-3: 1 times
Edge 1-2: 1 times
Edge 2-3: 1 times

Test Case 3:
Input:
2
0 2
2 0
Output:
Edge 0-1: 2 times

Test Case 4:
Input:
5
0 1 0 0 1
1 0 1 0 0
0 1 0 1 0
0 0 1 0 1
1 0 0 1 0
Output:
Edge 0-1: 1 times
Edge 0-4: 1 times
Edge 1-2: 1 times
Edge 2-3: 1 times
Edge 3-4: 1 times

Test Case 5:
Input:
3
0 3 0
3 0 1
0 1 0
Output:
Edge 0-1: 3 times
Edge 1-2: 1 times
*/
