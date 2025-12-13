package DynamicPrograming.DigitDP;

import java.util.*;

/* Count numbers ≤ num that contain at least one zero digit. */
public class DigitDP_ZeroCount {

    static String num;
    static long[][][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        num = String.valueOf(n);

        int len = num.length();
        dp = new long[len + 1][2][2][2];
        for (long[][][] a : dp)
            for (long[][] b : a)
                for (long[] c : b)
                    Arrays.fill(c, -1);

        long ans = count(0, 1, 0, 0);
        System.out.println(ans);
    }
    /*
    We define:  dp[pos][tight][zero_found][started]
    Meaning:
        1. pos → current digit index (0-based)
        2. tight → 1 if we are restricted by prefix of n
        3. zero_found → 1 if we already placed a '0'
        4. started → 1 if we have placed a non-zero digit yet (to handle leading zeros)
    */
    // pos: index, tight: bound flag, zero_found: found zero, started: number started
    static long count(int pos, int tight, int zero_found, int started) {
        if (pos == num.length()) return zero_found == 1 ? 1 : 0;

        if (dp[pos][tight][zero_found][started] != -1)
            return dp[pos][tight][zero_found][started];

        int limit = tight == 1 ? num.charAt(pos) - '0' : 9;
        long res = 0;

        for (int dig = 0; dig <= limit; dig++) {
            int newTight = (tight == 1 && dig == limit) ? 1 : 0;
            int newStarted = (started == 1 || dig != 0) ? 1 : 0;
            int newZeroFound = (zero_found == 1 || (newStarted == 1 && dig == 0)) ? 1 : 0;

            res += count(pos + 1, newTight, newZeroFound, newStarted);
        }

        return dp[pos][tight][zero_found][started] = res;
    }
}
