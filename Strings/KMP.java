package Strings;

import java.util.*;

/* To find all starting positions of P in T efficiently. */
public class KMP {
    // Build LPS array
    private static int[] buildLPS(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0, i = 1;
        
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = ++len;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
        return lps;
    }

    // KMP search
    public static List<Integer> search(String txt, String pat) {
        int n = txt.length(), m = pat.length();
        List<Integer> res = new ArrayList<>();
        int[] lps = buildLPS(pat);
        
        int i = 0, j = 0;
        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++; j++;
                if (j == m) {
                    res.add(i - j);  // found occurrence
                    j = lps[j - 1]; // continue search
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String text = "ababcababcac";
        String pattern = "ababc";
        List<Integer> matches = search(text, pattern);
        System.out.println(matches); // prints starting indices
    }
}

