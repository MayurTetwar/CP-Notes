package DynamicPrograming.DigitDP;

class DigitDP_Palindrome {
    private int[] digits;
    private int[][][][] dp;
    
    public int countPalindromes(int n) {
        if (n < 0) return 0;
        
        // Convert n to digits array
        String numStr = String.valueOf(n);
        digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        
        int len = digits.length;
        // dp[pos][tight][started][built]
        // built represents how many digits we've placed (for matching later)
        dp = new int[len][2][2][len + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l <= len; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        
        return solve(0, 1, 0, new int[len], 0);
    }
    
    private int solve(int pos, int tight, int started, int[] built, int builtLen) {
        // Base case: we've placed all digits
        if (pos == digits.length) {
            if (started == 0) return 0; // Number was all zeros
            return isPalindrome(built, builtLen) ? 1 : 0;
        }
        
        // Check memoization (simplified - using builtLen as approximation)
        if (dp[pos][tight][started][builtLen] != -1) {
            return dp[pos][tight][started][builtLen];
        }
        
        int limit = (tight == 1) ? digits[pos] : 9;
        int result = 0;
        
        for (int digit = 0; digit <= limit; digit++) {
            int newTight = (tight == 1 && digit == limit) ? 1 : 0;
            
            if (started == 0 && digit == 0) {
                result += solve(pos + 1, newTight, 0, built, builtLen);
            } else {
                built[builtLen] = digit;
                result += solve(pos + 1, newTight, 1, built, builtLen + 1);
                built[builtLen] = 0;
            }
        }
        
        dp[pos][tight][started][builtLen] = result;
        return result;
    }
    
    private boolean isPalindrome(int[] arr, int len) {
        for (int i = 0; i < len / 2; i++) {
            if (arr[i] != arr[len - 1 - i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        DigitDP_Palindrome counter = new DigitDP_Palindrome();
        
        // Test cases
        System.out.println("Palindromes from 0 to 10: " + counter.countPalindromes(10));
        System.out.println("Palindromes from 0 to 100: " + counter.countPalindromes(100));
        System.out.println("Palindromes from 0 to 1000: " + counter.countPalindromes(1000));
        System.out.println("Palindromes from 0 to 9999: " + counter.countPalindromes(9999));
        System.out.println("Palindromes from 0 to 100000: " + counter.countPalindromes(100000));
        System.out.println("Palindromes from 0 to 1000000: " + counter.countPalindromes(1000000));
        System.out.println("Palindromes from 0 to 1000000000: " + counter.countPalindromes(1000000000));
    }
}