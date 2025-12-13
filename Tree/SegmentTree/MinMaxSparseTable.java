package Tree.SegmentTree;

import java.util.*;

public class MinMaxSparseTable {

    static int[][] minST;   // sparse table for min
    static int[][] maxST;   // sparse table for max
    static int[] log;       // log values

    // Build sparse table
    static void build(int[] arr) {
        int n = arr.length;
        int K = (int)(Math.log(n) / Math.log(2)) + 1;

        minST = new int[n][K];
        maxST = new int[n][K];
        log = new int[n + 1];

        // Precompute logs
        log[1] = 0;
        for (int i = 2; i <= n; i++)
            log[i] = log[i / 2] + 1;

        // Initialize ST for interval length 1
        for (int i = 0; i < n; i++) {
            minST[i][0] = arr[i];
            maxST[i][0] = arr[i];
        }

        // Build table for all 2^j intervals
        for (int j = 1; j < K; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                minST[i][j] = Math.min(minST[i][j - 1], minST[i + (1 << (j - 1))][j - 1]);
                maxST[i][j] = Math.max(maxST[i][j - 1], maxST[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    // Query min in range [L, R]
    static int queryMin(int L, int R) {
        int j = log[R - L + 1];
        return Math.min(minST[L][j], minST[R - (1 << j) + 1][j]);
    }

    // Query max in range [L, R]
    static int queryMax(int L, int R) {
        int j = log[R - L + 1];
        return Math.max(maxST[L][j], maxST[R - (1 << j) + 1][j]);
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 9, 3};

        build(arr);

        System.out.println("Min(1,4): " + queryMin(1, 4)); // 1
        System.out.println("Max(1,4): " + queryMax(1, 4)); // 9
    }
}

