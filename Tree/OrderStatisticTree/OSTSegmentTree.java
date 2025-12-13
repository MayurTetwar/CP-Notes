package Tree.OrderStatisticTree;

import java.util.*;

public class OSTSegmentTree {

    static class SegTree {
        int n;
        int[] tree;

        SegTree(int n) {
            this.n = n;
            tree = new int[4 * n];
            build(1, 1, n);
        }

        // Build: initially all alive = 1
        void build(int node, int l, int r) {
            if (l == r) {
                tree[node] = 1;
                return;
            }
            int mid = (l + r) >> 1;
            build(node << 1, l, mid);
            build(node << 1 | 1, mid + 1, r);
            tree[node] = tree[node << 1] + tree[node << 1 | 1];
        }

        // Remove element at index idx (set to 0)
        void update(int node, int l, int r, int idx) {
            if (l == r) {
                tree[node] = 0;
                return;
            }
            int mid = (l + r) >> 1;
            if (idx <= mid) update(node << 1, l, mid, idx);
            else update(node << 1 | 1, mid + 1, r, idx);
            tree[node] = tree[node << 1] + tree[node << 1 | 1];
        }

        // Find k-th alive element
        int kth(int node, int l, int r, int k) {
            if (l == r) return l;
            int mid = (l + r) >> 1;
            if (tree[node << 1] >= k) return kth(node << 1, l, mid, k);
            else return kth(node << 1 | 1, mid + 1, r, k - tree[node << 1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n + 1];      // 1-based indexing
        for (int i = 1; i <= n; i++) arr[i] = sc.nextInt();

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) pos[i] = sc.nextInt();

        SegTree st = new SegTree(n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int k = pos[i];                   // p_i-th alive
            int idx = st.kth(1, 1, n, k);     // find actual index
            sb.append(arr[idx]).append(" ");  // output
            st.update(1, 1, n, idx);          // remove from tree
        }

        System.out.println(sb.toString());
    }
}

