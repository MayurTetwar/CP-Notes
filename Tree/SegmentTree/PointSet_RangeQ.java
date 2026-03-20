package Tree.SegmentTree;

public class PointSet_RangeQ {
    private static long[] tree;
    private static int n;

    public PointSet_RangeQ(int[] arr) {
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
    /*
    build(arr, 1, 0, n - 1);
    1. node = 1 → root of the tree
    2. 0, n-1 → the root represents full range of the array
    */
    /*
    Case A: Leaf node
        When start == end → the range has only 1 element
        Example:
        range = [3,3] → this covers element arr[3]
    Case B: Internal node
        Split range into two halves
        Build left child
        Build right child
        Node value = sum of both children
    */
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
    /*
    To update arr[idx] = val:
        1. Go down the tree to the leaf node representing idx
        2. Update its value
        3. On the way back up, recalc parent nodes as sum of children
    */

    // Example usage
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        PointSet_RangeQ st = new PointSet_RangeQ(arr);

        System.out.println(st.query(1, 3)); // sum from index 1 to 3
        st.update(1, 10);               // update arr[1] = 10
        System.out.println(st.query(1, 3)); // sum from index 1 to 3 after update
    }
    /*
                         (0,5)=36
                        /        \
                 (0,2)=9          (3,5)=27
                /      \           /      \
          (0,1)=4     (2,2)=5   (3,4)=16  (5,5)=11
         /      \               /      \
    (0,0)=1     (1,1)=3      (3,3)=7   (4,4)=9
    */
}
