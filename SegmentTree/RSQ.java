package SegmentTree;

public class RSQ {
    private static long[] tree;
    private static int n;

    public RSQ(int[] arr) {
        n = arr.length;
        tree = new long[4 * n];
        build(arr, 1, 0, n - 1);
    }

    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(arr, 2 * node, start, mid);
            build(arr, 2 * node + 1, mid + 1, end);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    public long query(int L, int R) {
        return query(1, 0, n - 1, L, R);
    }

    private long query(int node, int start, int end, int L, int R) {
        if (R < start || end < L) { // no overlap
            return 0;
        }
        if (L <= start && end <= R) { // total overlap
            return tree[node];
        }
        int mid = (start + end) / 2; // partial overlap
        long leftSum = query(2 * node, start, mid, L, R);
        long rightSum = query(2 * node + 1, mid + 1, end, L, R);
        return leftSum + rightSum;
    }

    public void update(int idx, int val) {
        update(1, 0, n - 1, idx, val);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
        } else {
            int mid = (start + end) / 2;
            if (idx <= mid) {
                update(2 * node, start, mid, idx, val);
            } else {
                update(2 * node + 1, mid + 1, end, idx, val);
            }
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        RSQ st = new RSQ(arr);

        System.out.println(st.query(1, 3)); // sum from index 1 to 3
        st.update(1, 10);               // update arr[1] = 10
        System.out.println(st.query(1, 3)); // sum from index 1 to 3 after update
        
    }
}
