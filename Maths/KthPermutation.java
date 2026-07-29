package Maths;
import java.util.ArrayList;
import java.util.List;

public class KthPermutation {

    public static void main(String[] args) {
        int n = 4;
        int k = 17;

        String result = getKthPermutation(n, k);
        System.out.println("The " + k + "th permutation of numbers 1 to " + n + " is: " + result);
    }

    public static String getKthPermutation(int n, int k) {
        // Step 1: Precompute factorials up to n-1
        // fact[i] will store i!
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        // Step 2: Create available numbers list [1, 2, ..., n]
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // Step 3: Convert k to 0-indexed
        int targetK = k - 1;

        StringBuilder sb = new StringBuilder();

        // Step 4: Loop through positions from n-1 down to 0
        for (int i = n - 1; i >= 0; i--) {
            // Compute block size: F = i!
            int blockSize = fact[i];

            // Find index in available numbers list
            int index = targetK / blockSize;

            // Append numbers[index] to result and remove it from available list
            sb.append(numbers.get(index));
            numbers.remove(index);

            // Update k
            targetK %= blockSize;
        }

        return sb.toString();
    }
}