package Tree.SegmentTree;

public class RangeU_RangeQ {

    static class SegmentTree {

        int n;
        long[] tree;
        long[] lazy;

        SegmentTree(int n) {
            this.n = n;
            tree = new long[4 * n];
            lazy = new long[4 * n];
        }

        void build(int node, int st, int end, int[] arr) {

            if (st == end) {
                tree[node] = arr[st];
                return;
            }

            int mid = (st + end) / 2;

            build(node * 2, st, mid, arr);
            build(node * 2 + 1, mid + 1, end, arr);

            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        void push(int node, int st, int end) {

            if (lazy[node] != 0) {

                tree[node] += (end - st + 1) * lazy[node];

                if (st != end) {
                    lazy[node * 2] += lazy[node];
                    lazy[node * 2 + 1] += lazy[node];
                }

                lazy[node] = 0;
            }
        }

        void update(int node, int st, int end, int L, int R, int val) {

            push(node, st, end);

            if (R < st || end < L)
                return;

            if (L <= st && end <= R) {

                lazy[node] += val;
                push(node, st, end);
                return;
            }

            int mid = (st + end) / 2;

            update(node * 2, st, mid, L, R, val);
            update(node * 2 + 1, mid + 1, end, L, R, val);

            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        long query(int node, int st, int end, int L, int R) {

            push(node, st, end);

            if (R < st || end < L)
                return 0;

            if (L <= st && end <= R)
                return tree[node];

            int mid = (st + end) / 2;

            return query(node * 2, st, mid, L, R)
                    + query(node * 2 + 1, mid + 1, end, L, R);
        }
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8};

        int n = arr.length;

        SegmentTree st = new SegmentTree(n);

        st.build(1,0,n-1,arr);

        // add +10 to range [2,5]
        st.update(1,0,n-1,2,5,10);

        // query sum [3,4]
        long ans = st.query(1,0,n-1,3,4);

        System.out.println(ans); // should print 29
    }
}