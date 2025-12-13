package DynamicPrograming;

// File: LongestIncreasingSubsequenceNLogN.java
import java.util.*;

public class LIS{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(lengthOfLIS(arr));
        sc.close();
    }
    private static int lengthOfLIS(int[] nums) {
        ArrayList<Integer> tails = new ArrayList<>();
        for (int x : nums) {
            int pos = Collections.binarySearch(tails, x);
            if (pos < 0) pos = -pos - 1;
            if (pos == tails.size()) tails.add(x);
            else tails.set(pos, x);
        }
        return tails.size();
    }
}

