package Concepts;

import java.util.HashMap;
import java.util.Scanner;

public class SumOfDigits {

    // static long[] a = new long[100000];
    // static void calculate_sum(int d) {
    //     a[0] = 0;
    //     a[1] = 45;
    //     for (int i = 2; i <= d; i++) {
    //         a[i] = a[i - 1] * 10 + 45 * (long) Math.pow(10, i - 1);
    //     }
    // }
    // static long sumDigits(long N) {
    //     if (N < 10)return N * (N + 1L) / 2;

    //     int d = (int) Math.log10(N);
    //     calculate_sum(d);
    //     long lmd = (long)(N / Math.pow(10, d));
    //     long t = (long)Math.ceil(Math.pow(10, d));
    //     return lmd * a[d] + (lmd * (lmd - 1L) / 2) * t + lmd * (1 + N % t) + sumDigits(N % t);
    // }
    static HashMap<Long,Long> map=new HashMap<>();
    public static long sumDigits(long n) {
        if (n < 10) return n * (n + 1) / 2; // base case
        if(map.containsKey(n))return map.get(n);

        long d = (long) Math.log10(n);
        long p = (long) Math.pow(10, d);
        long msd = n / p;

        long ans=msd * sumDigits(p - 1)
                + (msd * (msd - 1) / 2) * p
                + msd * (n % p + 1)
                + sumDigits(n % p);
        map.put(n,ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(sumDigits(new Scanner(System.in).nextLong())); // Output: 55
    }
}
/*

*/