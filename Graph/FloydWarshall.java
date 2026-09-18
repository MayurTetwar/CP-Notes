package Graph;

import java.util.Arrays;

/*
To find all-pairs shortest paths (every node to every other node)
Graph is dense or small (V ≤ ~400–500 typically, since V³ grows fast)

Rule of thumb:
Single source → Dijkstra (non-negative weights) or Bellman-Ford (negative weights allowed).
All pairs, small dense graph → Floyd–Warshall.
All pairs, large sparse graph → run Dijkstra from every vertex (O(V·E log V)), often cheaper than O(V³).
*/
public class FloydWarshall {
    static final int INF = (int) 1e9;

    public static int[][] floydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];
        for (int[] row : graph) row.clone();
        for (int i = 0; i < n; i++)
            dist[i] = graph[i].clone();

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (dist[i][k] == INF) continue;       // small optimization
                for (int j = 0; j < n; j++) {
                    if (dist[k][j] == INF) continue;
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Negative cycle check: if dist[i][i] < 0, a negative cycle exists
        for (int i = 0; i < n; i++) {
            if (dist[i][i] < 0) {
                throw new RuntimeException("Negative cycle detected");
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] graph = new int[n][n];
        for (int[] row : graph) Arrays.fill(row, INF);
        for (int i = 0; i < n; i++) graph[i][i] = 0;

        // edges: u, v, weight
        graph[0][1] = 5;
        graph[0][3] = 10;
        graph[1][2] = 3;
        graph[2][3] = 1;

        int[][] dist = floydWarshall(graph);

        for (int[] row : dist) System.out.println(Arrays.toString(row));
    }
}