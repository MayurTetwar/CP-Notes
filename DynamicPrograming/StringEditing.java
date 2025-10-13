package DynamicPrograming;

import java.util.Arrays;

// minimum opertion required convert str to str2 
// Opretion are insert, delete and replace

public class StringEditing {

    public static void main(String[] args) {
        
        System.out.println(minDistance("Nishtha", "Mayur"));
        System.out.println(editDistance("Somya", "Mayur"));

    }
    
    // Using Bottom-Up DP (Tabulation)-O(m*n) time and O(m*n) space
    // use only when youu know about base case values

    public static int minDistance(String str, String str2) {
        int n=str.length();
        int m=str2.length();
        
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++)
            dp[i][0]=i;
        for(int j=0;j<=m;j++)
            dp[0][j]=j;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                }
            }
        }
        return dp[n][m];
    }



    // Recursive function to find minimum number of operations 
    // needed to convert s1 into s2.
    // Using Top-Down DP (Memoization) – O(m*n) time and O(m*n) space
    public static int editDistRec(String s1, String s2, int m, int n, int[][] memo) {

        if (m == 0) return n;
        if (n == 0) return m;

        if (memo[m][n] != -1) return memo[m][n];

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) 
            return memo[m][n] = editDistRec(s1, s2, m - 1, n - 1, memo);

        return memo[m][n] = 1 + Math.min(
            editDistRec(s1, s2, m, n - 1, memo),  
            Math.min(editDistRec(s1, s2, m - 1, n, memo),   
                     editDistRec(s1, s2, m - 1, n - 1, memo))
        );
    }

    public static int editDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return editDistRec(s1, s2, m, n, memo);
    }
    
}