package Concepts;

import java.util.Scanner;

// Code to genrate all polindrome numbers upto n
public class PoliGenrater {
    class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nEnter number: ");
            primePalindrome(sc.nextInt());
            sc.close();
        }

        public static void primePalindrome(int n) {
            for (int L = 1; L <= 5; ++L) {
                // For Odd length numbers genration
                for (int i = (int) Math.pow(10, L - 1); i < (int) Math.pow(10, L); ++i) {
                    StringBuilder sb = new StringBuilder(Integer.toString(i));
                    for (int k = L - 2; k >= 0; --k) {
                        sb.append(sb.charAt(k));
                    }
                    int val = Integer.valueOf(sb.toString());
                    if (val > n)
                        return;
                    System.out.println(val);
                }
                // For Even length numbers genration
                for (int i = (int) Math.pow(10, L - 1); i < Math.pow(10, L); i++) {
                    StringBuilder sb = new StringBuilder(Integer.toString(i));
                    for (int k = L - 1; k >= 0; k--) {
                        sb.append(sb.charAt(k));
                    }
                    int val = Integer.valueOf(sb.toString());
                    if (val > n)
                        return;
                    System.out.println(val);
                }
            }
        }
    }
}
