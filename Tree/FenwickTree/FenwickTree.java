package Tree.FenwickTree;

public class FenwickTree {
    int n;
    long[] bit;

    FenwickTree(int n) {
        this.n = n;
        bit = new long[n + 1];   // 1-based indexing
    }

    // Add +val to index i
    void update(int i, long val) {
        while (i <= n) {
            bit[i] += val;
            // Move to parent
            i += (i & -i);
        }
    }

    // Sum from 1 to i
    long query(int i) {
        long sum = 0;
        while (i > 0) {
            sum += bit[i];
            // Move to child
            i -= (i & -i);
        }
        return sum;
    }

    // Range sum l..r
    long rangeSum(int l, int r) {
        return query(r) - query(l - 1);
    }

    public static void main(String[] args) {
        FenwickTree ft = new FenwickTree(8);
        int[] arr = {0, 3, 2, -1, 6, 5, 4, -3, 3}; // 1-based

        for (int i = 1; i < arr.length; i++) {
            ft.update(i, arr[i]);
        }

        System.out.println("Sum of first 5 elements: " + ft.query(5)); // Output: 15
        System.out.println("Sum from 3 to 7: " + ft.rangeSum(3, 7));   // Output: 11
    }
}
