package Tree.BinaryLifting;

import java.util.*;
/*
 LCA using Binary Lifting
 Time:
   Preprocessing -> O(N log N)
   Each Query    -> O(log N)
*/

public class LCA {

    static int N;                 // Number of nodes
    static int LOG;               // Max power of 2 needed
    static List<Integer>[] tree;  // Adjacency list for tree
    static int[][] up;            // up[v][j] = 2^j-th ancestor of v
    static int[] depth;           // depth[v] = depth of node v from root

    // ---------------- DFS ----------------
    // This function:
    // 1. Sets depth of each node
    // 2. Stores immediate parent (up[v][0])
    static void dfs(int node, int parent) {

        // 2^0-th ancestor (direct parent)
        up[node][0] = parent;

        // Traverse all children
        for (int child : tree[node]) {
            if (child != parent) {
                depth[child] = depth[node] + 1;
                dfs(child, node);
            }
        }
    }

    // ---------------- LCA FUNCTION ----------------
    static int lca(int a, int b) {

        // Step 1: Make sure 'a' is the deeper node
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // Step 2: Lift node 'a' up to the same depth as 'b'
        for (int i = LOG; i >= 0; i--) {
            // If lifting by 2^i keeps us above or equal to b's depth
            if (up[a][i] != -1 && depth[a] - (1 << i) >= depth[b]) {
                a = up[a][i];
            }
        }

        // If after lifting they are equal, this is LCA
        if (a == b) return a;

        // Step 3: Lift both nodes up together
        // Move them until their parents are different
        for (int i = LOG; i >= 0; i--) {
            if (up[a][i] != -1 && up[a][i] != up[b][i]) {
                a = up[a][i];
                b = up[b][i];
            }
        }

        // Step 4: Parent of either node is LCA
        return up[a][0];
    }

    // ---------------- MAIN FUNCTION ----------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of nodes
        N = sc.nextInt();

        // Calculate maximum LOG such that 2^LOG >= N
        LOG = 0;
        while ((1 << LOG) <= N) LOG++;

        // Initialize tree
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // Read edges
        for (int i = 0; i < N - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        // Initialize arrays
        up = new int[N + 1][LOG + 1];
        depth = new int[N + 1];

        // Fill ancestors with -1 initially
        for (int i = 1; i <= N; i++) {
            Arrays.fill(up[i], -1);
        }

        // Root is node 1
        depth[1] = 0;
        dfs(1, -1);

        // Build binary lifting table
        for (int j = 1; j <= LOG; j++) {
            for (int i = 1; i <= N; i++) {
                if (up[i][j - 1] != -1) {
                    up[i][j] = up[ up[i][j - 1] ][j - 1];
                }
            }
        }
        /*
        2^j = 2^(j-1) + 2^(j-1)
        So: 4th ancestor = 2nd ancestor of 2nd ancestor
        */

        // Read number of queries
        int Q = sc.nextInt();

        StringBuilder sb=new StringBuilder();
        // Process queries
        while (Q-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            sb.append(lca(u, v));
            sb.append('\n');
        }
        System.out.println(sb);
        
        sc.close();
    }
}
/*
Input:- 
12
1 2
1 3
3 4
3 5
4 6
4 7
5 8
5 9
5 10
8 11
9 12
3
2 7
7 11
8 12

Ouput:- 
1
3
5
UP Array:- 
0 [0, 0, 0, 0, 0]
1 [-1, -1, -1, -1, -1]
2 [1, -1, -1, -1, -1]
3 [1, -1, -1, -1, -1]
4 [3, 1, -1, -1, -1]
5 [3, 1, -1, -1, -1]
6 [4, 3, -1, -1, -1]
7 [4, 3, -1, -1, -1]
8 [5, 3, -1, -1, -1]
9 [5, 3, -1, -1, -1]
10 [5, 3, -1, -1, -1]
11 [8, 5, 1, -1, -1]
12 [9, 5, 1, -1, -1]
*/