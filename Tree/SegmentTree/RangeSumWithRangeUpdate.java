package Tree.SegmentTree;

public class RangeSumWithRangeUpdate {
    private final long[] tree;
    private final long[] lazyAdd;
    private final int n;

    public RangeSumWithRangeUpdate(int size) {
        this.n = size;
        this.tree = new long[4 * n];
        this.lazyAdd = new long[4 * n];
    }

    public void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(arr, 2 * node, start, mid);
            build(arr, 2 * node + 1, mid + 1, end);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    private void pushDown(int node, int start, int end) {
        if (lazyAdd[node] != 0) {
            tree[node] += (end - start + 1) * lazyAdd[node];
            if (start != end) {
                lazyAdd[node * 2] += lazyAdd[node];
                lazyAdd[node * 2 + 1] += lazyAdd[node];
            }
            lazyAdd[node] = 0;
        }
    }

    public void update(int node, int start, int end, int l, int r, int val) {
        pushDown(node, start, end);

        if (start > r || end < l) return;

        if (l <= start && end <= r) {
            lazyAdd[node] += val;
            pushDown(node, start, end);
            return;
        }

        int mid = (start + end) / 2;
        update(node * 2, start, mid, l, r, val);
        update(node * 2 + 1, mid + 1, end, l, r, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public long query(int node, int start, int end, int l, int r) {
        if (start > r || end < l) return 0;

        pushDown(node, start, end);

        if (l <= start && end <= r) return tree[node];

        int mid = (start + end) / 2;
        long leftSum = query(node * 2, start, mid, l, r);
        long rightSum = query(node * 2 + 1, mid + 1, end, l, r);
        return leftSum + rightSum;
    }

    public void updateRange(int l, int r, int val) {
        update(1, 0, n - 1, l, r, val);
    }

    public long queryRange(int l, int r) {
        return query(1, 0, n - 1, l, r);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        RangeSumWithRangeUpdate st = new RangeSumWithRangeUpdate(arr.length);
        st.build(arr, 1, 0, arr.length - 1);

        System.out.println(st.queryRange(0, 4)); // 15
        st.updateRange(1, 3, 2); // add 2 to [1,3]
        System.out.println(st.queryRange(0, 4)); // 21
        System.out.println(st.queryRange(2, 2)); // 5 (3+2)
    }
}
