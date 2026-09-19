package Graph;
import java.util.*;

// Tarjan's Algorithum


class ArticulationPoints {
    int timer = 0;

    List<Integer> findAP(int V, List<List<Integer>> adj) {
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] isAP = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, adj, disc, low, visited, isAP);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) if (isAP[i]) result.add(i);
        return result;
    }

    void dfs(int u, int parent, List<List<Integer>> adj,
             int[] disc, int[] low, boolean[] visited, boolean[] isAP) {
        visited[u] = true;
        disc[u] = low[u] = ++timer;
        int children = 0;

        for (int v : adj.get(u)) {
            if (v == parent) continue;

            if (visited[v]) {
                // back edge
                low[u] = Math.min(low[u], disc[v]);
            } else {
                children++;
                dfs(v, u, adj, disc, low, visited, isAP);
                low[u] = Math.min(low[u], low[v]);

                // non-root case
                // > is for bridges, >= is for articulation points
                if (parent != -1 && low[v] >= disc[u]) {
                    isAP[u] = true;
                }
            }
        }

        // root case
        if (parent == -1 && children > 1) {
            isAP[u] = true;
        }
    }
}