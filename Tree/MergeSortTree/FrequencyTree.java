package Tree.MergeSortTree;

import java.util.*;

// Merge Sort Tree (for Frequency / Count ≤ X / K-th in range)

public class FrequencyTree {

    static ArrayList<Integer>[] tree;
    static int n;

    // Build merge sort tree
    static void build(int node, int st, int end, int[] arr) {
        tree[node] = new ArrayList<>();

        if (st == end) {
            tree[node].add(arr[st]);
            return;
        }

        int mid = (st + end) / 2;
        build(node * 2, st, mid, arr);
        build(node * 2 + 1, mid + 1, end, arr);

        merge(tree[node * 2], tree[node * 2 + 1], tree[node]);
    }

    // Merge two sorted lists
    static void merge(List<Integer> a, List<Integer> b, List<Integer> res) {
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i) <= b.get(j)) res.add(a.get(i++));
            else res.add(b.get(j++));
        }
        while (i < a.size()) res.add(a.get(i++));
        while (j < b.size()) res.add(b.get(j++));
    }

    // Query: count numbers ≤ X in range [L, R]
    static int query(int node, int st, int end, int L, int R, int X) {
        if (end < L || R < st) return 0;
        if (L <= st && end <= R) {
            // upper_bound (X)
            int pos = Collections.binarySearch(tree[node], X);
            if (pos < 0) pos = -pos - 1;
            else {
                while (pos < tree[node].size() && tree[node].get(pos) == X) pos++;
            }
            return pos;
        }

        int mid = (st + end) / 2;
        return query(node * 2, st, mid, L, R, X)
             + query(node * 2 + 1, mid + 1, end, L, R, X);
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        n = arr.length;
        tree = new ArrayList[4 * n];

        build(1, 0, n - 1, arr);

        // Query examples
        System.out.println("Count <= 4 in [1,5]: " + query(1, 0, n - 1, 1, 5, 4)); // elements: [5,2,6,3,7] → <=4 are {2,3} → 2
        System.out.println("Count <= 6 in [0,6]: " + query(1, 0, n - 1, 0, 6, 6)); // 1,5,2,6,3,4 → 6 elements <= 6
    }
}
