package Maths;

import java.util.Map;
import java.util.TreeMap;

public class KthPermutationWithDuplicates {

    // TC :- O(n^2*(unique count))
    public static void main(String[] args) {
        // Example: digits 1, 2, 2, 3 and k = 7
        int[] digits = {1, 2, 2, 3};
        int k = 7;

        String result = getKthPermutation(digits, k);
        System.out.println("The " + k + "th unique permutation is: " + result);
    }

    public static String getKthPermutation(int[] digits, int k) {
        // Step 1: Count frequency of each digit using TreeMap (keeps keys sorted)
        Map<Integer, Integer> freqMap = new TreeMap<>();
        for (int digit : digits) {
            freqMap.put(digit, freqMap.getOrDefault(digit, 0) + 1);
        }

        // Step 2: Convert k to 0-indexed
        long targetK = k - 1;
        int totalDigits = digits.length;

        StringBuilder sb = new StringBuilder();

        // Step 3: Determine digits one by one
        for (int i = 0; i < totalDigits; i++) {
            for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
                int digit = entry.getKey();
                int count = entry.getValue();

                if (count == 0) continue; // Skip if no instances left

                // Pick 'digit' temporarily and compute number of unique ways for remaining slots
                freqMap.put(digit, count - 1);
                long uniquePerms = countUniquePermutations(freqMap);

                if (targetK >= uniquePerms) {
                    // Skip these permutations and reduce targetK
                    targetK -= uniquePerms;
                    freqMap.put(digit, count); // Backtrack option
                } else {
                    // Current digit is part of our answer
                    sb.append(digit);
                    break;
                }
            }
        }

        return sb.toString();
    }

    // Helper method to compute multiset permutations: N! / (c1! * c2! * ... * cm!)
    private static long countUniquePermutations(Map<Integer, Integer> freqMap) {
        int totalRemaining = 0;
        for (int count : freqMap.values()) {
            totalRemaining += count;
        }

        long count = factorial(totalRemaining);
        for (int c : freqMap.values()) {
            if (c > 1) {
                count /= factorial(c);
            }
        }
        return count;
    }

    private static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}