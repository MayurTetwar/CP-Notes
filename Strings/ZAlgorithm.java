package Strings;
import java.util.*;

/* Z-array Z[i] = length of the longest substring starting at i that matches the prefix of string. */
public class ZAlgorithm {
    
    // Compute Z-array
    public static int[] computeZArray(String s) {
        int n = s.length();
        int[] Z = new int[n];
        int L = 0, R = 0;

        for (int i = 1; i < n; i++) {
            if (i <= R) {
                Z[i] = Math.min(R - i + 1, Z[i - L]);
            }
            while (i + Z[i] < n && s.charAt(Z[i]) == s.charAt(i + Z[i])) {
                Z[i]++;
            }
            if (i + Z[i] - 1 > R) {
                L = i;
                R = i + Z[i] - 1;
            }
            // System.out.println(L+" "+R+" "+i+" "+Z[i]);
        }
        return Z;
    }

    // Pattern search using Z (Matching)
    public static List<Integer> searchPattern(String text, String pattern) {
        String combined = pattern + "$" + text;
        int[] Z = computeZArray(combined);
        List<Integer> result = new ArrayList<>();
        int patternLength = pattern.length();

        for (int i = 0; i < Z.length; i++) {
            if (Z[i] == patternLength) {
                result.add(i - patternLength - 1); // index in text
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String text = "aabxaayaab";
        String pattern = "aab";

        List<Integer> matches = searchPattern(text,pattern);

        System.out.println("Pattern found at indices: " + matches);
    }
}
