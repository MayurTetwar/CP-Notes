package Tree.MergeSortTree;
/*
-----------------------------------------------
        MEDIAN FINDER (Merge Sort Tree)
-----------------------------------------------
Time Complexity:
Build Tree:      O(n log n)
One Query Total: O(log^2 n)
Space Complexity: O(n log n)
-----------------------------------------------
Example:- 
For array:
    arr = [5, 1, 7, 3]

Each node stores:
    1.the segment range [st,end]
    2.a sorted list of the values in that range
Example structure:
            [0,3] -> {1,3,5,7}
            /                 \
    [0,1] -> {1,5}             [2,3] -> {3,7}
     /        \               /     \
[0,0]->{5} [1,1]->{1}   [2,2]->{7}   [3,3]->{3}
-----------------------------------------------
*/
import java.util.*;

public class MedianFinder {

    // Merge Sort Tree structure
    static class MergeSortTree {
        int n;
        ArrayList<Integer>[] tree; // Each node stores a sorted list

        MergeSortTree(int[] a) {
            n = a.length;
            tree = new ArrayList[4 * n];
            build(1, 0, n - 1, a);
        }

        // Build the merge sort tree
        void build(int node, int st, int end, int[] a) {
            tree[node] = new ArrayList<>();

            // Leaf node → single element
            if (st == end) {
                tree[node].add(a[st]);
                return;
            }

            int mid = (st + end) >> 1;

            // Build left + right child
            build(node << 1, st, mid, a);
            build(node << 1 | 1, mid + 1, end, a);

            // Merge two sorted child arrays
            merge(tree[node * 2], tree[node * 2 + 1], tree[node]);
        }
        static void merge(List<Integer> a, List<Integer> b, List<Integer> res) {
            int i = 0, j = 0;
            while (i < a.size() && j < b.size()) {
                if (a.get(i) <= b.get(j)) res.add(a.get(i++));
                else res.add(b.get(j++));
            }
            while (i < a.size()) res.add(a.get(i++));
            while (j < b.size()) res.add(b.get(j++));
        }

        // Count how many numbers ≤ x in range [l, r] (count Less than or Equal)
        int countLE(int node, int st, int end, int l, int r, int x) {

            // No overlap
            if (r < st || end < l) return 0;

            // Fully inside range
            if (l <= st && end <= r) {
                return upperBound(tree[node], x);
            }

            // Partial overlap → go down both children
            int mid = (st + end) >> 1;
            return countLE(node << 1, st, mid, l, r, x)
                 + countLE(node << 1 | 1, mid + 1, end, l, r, x);
        }

        // upperBound: first index > x
        int upperBound(ArrayList<Integer> arr, int x) {
            int st = 0, end = arr.size();
            while (st < end) {
                int m = (st + end) >> 1;
                if (arr.get(m) <= x) st = m + 1;
                else end = m;
            }
            return st;  // count of <= x
        }

        // ------------------------------
        // Find median in range [st, end]
        // ------------------------------
        int findMedian(int st, int end) {

            int len = end - st + 1;
            int k = (len + 1) / 2;   // median index

            int low = 1, high = (int) 1e9, ans = -1;

            // Binary search on value space
            while (low <= high) {
                int mid = (low + high) >> 1;

                // Count numbers ≤ mid in this range
                int cnt = countLE(1, 0, n - 1, st, end, mid);

                if (cnt >= k) {
                    // mid might be the median → try smaller value
                    ans = mid;
                    high = mid - 1;
                } else {
                    // Need bigger value
                    low = mid + 1;
                }
            }
            return ans;
        }
    }

    // ---------------------- MAIN ----------------------
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 9, 4};

        MergeSortTree mst = new MergeSortTree(nums);

        int[][] queries = {
            {0, 2},  // [1,7,3] → median = 3
            {1, 4},  // [7,3,9,4] → median = 4
            {0, 4}   // whole array → median = 4
        };

        for (int[] q : queries) {
            int st = q[0], end = q[1];
            System.out.println("Median of [" + st + "," + end + "] = " 
                               + mst.findMedian(st, end));
        }
    }
}
