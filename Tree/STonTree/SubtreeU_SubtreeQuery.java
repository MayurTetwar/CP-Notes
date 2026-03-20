package Tree.STonTree;

import java.util.*;

public class SubtreeU_SubtreeQuery {

    static int n;
    static List<Integer>[] tree;
    static int[] values;

    static int[] flat, in, out;
    static int timer = 0;

    static int[] seg, lazy;

    static void dfs(int node, int parent) {
        in[node] = timer;
        flat[timer] = values[node];
        timer++;

        for (int child : tree[node]) {
            if (child == parent) continue;
            dfs(child, node);
        }

        out[node] = timer - 1;
    }

    static void build(int node, int l, int r) {
        if (l == r) {
            seg[node] = flat[l];
            return;
        }

        int mid = (l + r) / 2;
        build(2 * node + 1, l, mid);
        build(2 * node + 2, mid + 1, r);

        seg[node] = seg[2 * node + 1] + seg[2 * node + 2];
    }

    static void push(int node, int l, int r) {
        if (lazy[node] != 0) {
            seg[node] += (r - l + 1) * lazy[node];

            if (l != r) {
                lazy[2 * node + 1] += lazy[node];
                lazy[2 * node + 2] += lazy[node];
            }

            lazy[node] = 0;
        }
    }

    static void updateRange(int node, int l, int r, int ql, int qr, int val) {
        push(node, l, r);

        if (qr < l || r < ql) return;

        if (ql <= l && r <= qr) {
            lazy[node] += val;
            push(node, l, r);
            return;
        }

        int mid = (l + r) / 2;

        updateRange(2 * node + 1, l, mid, ql, qr, val);
        updateRange(2 * node + 2, mid + 1, r, ql, qr, val);

        seg[node] = seg[2 * node + 1] + seg[2 * node + 2];
    }

    static int queryRange(int node, int l, int r, int ql, int qr) {
        push(node, l, r);

        if (qr < l || r < ql) return 0;

        if (ql <= l && r <= qr) return seg[node];

        int mid = (l + r) / 2;

        return queryRange(2 * node + 1, l, mid, ql, qr) +
               queryRange(2 * node + 2, mid + 1, r, ql, qr);
    }

    static void addEdge(int u, int v) {
        tree[u].add(v);
        tree[v].add(u);
    }

    public static void main(String[] args) {

        n = 5;

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();

        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(1, 4);

        values = new int[]{1, 2, 3, 4, 5};

        flat = new int[n];
        in = new int[n];
        out = new int[n];

        dfs(0, -1);

        seg = new int[4 * n];
        lazy = new int[4 * n];

        build(0, 0, n - 1);

        // subtree query node 1
        System.out.println(queryRange(0, 0, n - 1, in[1], out[1]));

        // add +10 to subtree of node 1
        updateRange(0, 0, n - 1, in[1], out[1], 10);

        System.out.println(queryRange(0, 0, n - 1, in[1], out[1]));
    }
}
