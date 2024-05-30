import java.util.*;

/*
MORDEN, Jhouvann S.
BSCS - A121
CS100-2: Discrete Structures 2
9:30AM - 10:45AM (MWF)
Week 7 (May 13-17, 2024)
Plate #6: Representing Graphs, Graph Isomorphism and Connectivity
Question 5:
Write a java program that receives a list of edges of a simple graph and
determine whether the graph is bipartite.
 */

public class BipartiteChecker {

    public static boolean isBipartiteGraph(List<List<Integer>> graph, int vertices) {
        int[] colors = new int[vertices];
        Arrays.fill(colors, -1); // Initialize all vertices as uncolored

        for (int i = 0; i < vertices; i++) {
            if (colors[i] == -1 && !bfsCheck(graph, i, colors)) {
                return false;
            }
        }
        return true;
    }

    public static boolean bfsCheck(List<List<Integer>> graph, int start, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        colors[start] = 0; // Start coloring with color 0

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph.get(u)) {
                if (colors[v] == -1) { // If not colored, color with opposite color
                    colors[v] = 1 - colors[u];
                    queue.offer(v);
                } else if (colors[v] == colors[u]) { // If same color as adjacent
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices and edges
        System.out.print("Enter the number of vertices: ");
        int vertices = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int edges = sc.nextInt();

        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Input edges
        System.out.println("Enter the edges (u v) where u and v are vertices (0-indexed):");
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Check if the graph is bipartite
        boolean isBipartite = isBipartiteGraph(graph, vertices);
        System.out.println("The graph is " + (isBipartite ? "bipartite" : "not bipartite"));

        sc.close();
    }
}

/*
Test Case 1:
4
4
0 1
0 3
1 2
2 3
- bipartite

Test Case 2:
3
3
0 1
1 2
2 0
- not bipartite

Test Case 3:
6
5
0 1
0 2
0 5
3 4
3 5
- bipartite

Test Case 4:
6
6
0 1
1 2
2 0
3 4
4 5
5 3
- not bipartite

Test Case 5:
8
8
0 1
0 3
1 2
2 3
4 5
4 7
5 6
6 7
- bipartite
 */
