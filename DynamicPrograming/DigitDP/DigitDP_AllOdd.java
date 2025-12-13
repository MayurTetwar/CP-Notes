package DynamicPrograming.DigitDP;

import java.util.*;

public class DigitDP_AllOdd {
    static String num;
    static long[][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        num = String.valueOf(n);
        dp = new long[num.length() + 1][2][2];

        for (long[][] a : dp)
            for (long[] b : a)
                Arrays.fill(b, -1);

        System.out.println(count(0, 1, 0));
    }

    static long count(int pos, int tight, int started) {
        if (pos == num.length()) return started == 1 ? 1 : 0;

        if (dp[pos][tight][started] != -1) return dp[pos][tight][started];

        int limit = (tight == 1) ? num.charAt(pos) - '0' : 9;
        long res = 0;

        for (int dig=0;dig<=limit;dig++) {
            int newTight = (tight == 1 && dig == limit) ? 1 : 0;
            int newStarted = (started == 0 && dig==0) ? 0 : 1;
            if (newStarted == 1 && dig % 2 == 0) continue;  
            res += count(pos + 1, newTight, newStarted);
        }

        return dp[pos][tight][started] = res;
    }
}
