package Tree.SegmentTree;
import java.util.Scanner;

public class STwithSetRangeSetQuery {

    static long[] tree;
    static long[] lazy;
    static boolean[] marked; // True if there is a pending "Set" update
    static int n;

    // 1. Build the Segment Tree using the initial array
    public static void build(int node, int start, int end, long[] arr) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(2 * node, start, mid, arr);
        build(2 * node + 1, mid + 1, end, arr);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    // 2. Push pending lazy "Set" updates down to children
    private static void push(int node, int start, int end) {
        if (marked[node]) {
            // Apply the pending update to the current node's sum
            // Sum = value * number of elements
            tree[node] = lazy[node] * (end - start + 1);

            // If it's not a leaf node, pass the lazy value to its children
            if (start != end) {
                lazy[2 * node] = lazy[node];
                marked[2 * node] = true;     // Mark left child as needing an update
                
                lazy[2 * node + 1] = lazy[node];
                marked[2 * node + 1] = true; // Mark right child as needing an update
            }
            
            // Clear the pending status for the current node
            marked[node] = false;
        }
    }

    // QUERY TYPE 1: Set all elements in range [l, r] to 'val'
    public static void updateRangeSet(int node, int start, int end, int l, int r, long val) {
        push(node, start, end); // Resolve any pending updates first

        // Condition 1: Out of bounds
        if (start > end || start > r || end < l) {
            return;
        }

        // Condition 2: Current segment is fully inside the update range
        if (start >= l && end <= r) {
            lazy[node] = val;    // Overwrite with the new set value
            marked[node] = true; // Mark as having a pending update
            push(node, start, end); // Resolve it immediately for this node
            return;
        }

        // Condition 3: Partial overlap, recurse down
        int mid = (start + end) / 2;
        updateRangeSet(2 * node, start, mid, l, r, val);
        updateRangeSet(2 * node + 1, mid + 1, end, l, r, val);
        
        // Update current node sum based on updated children
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    // QUERY TYPE 2: Find the sum in range [l, r]
    public static long queryRangeSum(int node, int start, int end, int l, int r) {
        push(node, start, end); // Ensure we apply any lazy updates before reading

        // Condition 1: Out of bounds
        if (start > end || start > r || end < l) {
            return 0; // Return 0 because it doesn't affect the sum
        }

        // Condition 2: Current segment is fully inside the query range
        if (start >= l && end <= r) {
            return tree[node];
        }

        // Condition 3: Partial overlap, get sum from both halves
        int mid = (start + end) / 2;
        long leftSum = queryRangeSum(2 * node, start, mid, l, r);
        long rightSum = queryRangeSum(2 * node + 1, mid + 1, end, l, r);
        
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = 100000; // Array size of 10^5
        
        // Segment tree arrays (4 * N)
        tree = new long[4 * n + 1];
        lazy = new long[4 * n + 1];
        marked = new boolean[4 * n + 1];

        // Initialize array with 0s (or any other starting values)
        long[] originalArray = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            originalArray[i] = 0; 
        }

        build(1, 1, n, originalArray);

        // --- Let's test it ---
        
        // 1. Set elements in range [1, 5] to 10
        // Array becomes: [10, 10, 10, 10, 10, 0, 0...]
        updateRangeSet(1, 1, n, 1, 5, 10);

        // 2. Set elements in range [4, 7] to 5
        // Array becomes: [10, 10, 10, 5, 5, 5, 5, 0...]
        updateRangeSet(1, 1, n, 4, 7, 5);

        // 3. Query sum of range [1, 7]
        // Expected: 10+10+10 + 5+5+5+5 = 30 + 20 = 50
        System.out.println("Sum of range [1, 7]: " + queryRangeSum(1, 1, n, 1, 7)); // Outputs 50

        // 4. Query sum of range [3, 4]
        // Expected: 10 + 5 = 15
        System.out.println("Sum of range [3, 4]: " + queryRangeSum(1, 1, n, 3, 4)); // Outputs 15

        scanner.close();
    }
}
