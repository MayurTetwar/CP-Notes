package Concepts;

/*
   2017. Grid Game 
 */
public class PrefixRobo {
    public long gridGame(int[][] arr) {
        int n = arr[0].length;
        if (n == 1)
            return 0;
        long[][] prefix = new long[2][n];
        prefix[0][n - 1] = arr[0][n - 1];
        prefix[1][n - 1] = arr[1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            prefix[0][i] = prefix[0][i + 1] + arr[0][i];
            prefix[1][i] = prefix[1][i + 1] + arr[1][i];
        }
        long ans = prefix[0][1];
        for (int i = 1; i < n - 1; i++) {
            ans = Math.min(ans, Math.max(prefix[1][0] - prefix[1][i], prefix[0][i + 1]));
        }
        return Math.min(ans, prefix[1][0] - prefix[1][n - 1]);
    }
}
