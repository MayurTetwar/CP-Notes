package DynamicPrograming.DigitDP;

// File: DigitDPNoAdjacentSame.java
import java.util.Arrays;

public class DigitDP_NoAdjacentSame {

    static int[][][][] dp;
    static int[] digits;

    public static long countNumbers(long n) {
        digits = Long.toString(n).chars().map(c -> c - '0').toArray();
        int len = digits.length;
        dp = new int[len + 1][2][11][2];
        for (int[][][] a : dp)
            for (int[][] b : a)
                for (int[] c : b)
                    Arrays.fill(c, -1);
        return dfs(0, 1, 10, 0);
    }

    public static long dfs(int pos, int tight, int prev, int started) {
        if (pos == digits.length) return 1;

        if (dp[pos][tight][prev][started] != -1)
            return dp[pos][tight][prev][started];

        long res = 0;
        int limit = (tight == 1) ? digits[pos] : 9;

        for (int d = 0; d <= limit; d++) {
            if (started == 1 && d == prev) continue;

            int newTight = (tight == 1 && d == limit) ? 1 : 0;
            int newStarted = (started == 1 || d != 0) ? 1 : 0;

            res += dfs(pos + 1, newTight, newStarted == 1 ? d : 10, newStarted);
        }

        dp[pos][tight][prev][started] = (int) res;
        return res;
    }

    public static void main(String[] args) {
        long n = 1000L;
        System.out.println("Count = " + countNumbers(n));
    }
}

