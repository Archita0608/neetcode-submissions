class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[] dp = new int[n + 1];

        for (int j = 0; j <= n; j++) dp[j] = j;

        for (int i = 1; i <= m; i++) {
        int prev = dp[0]; // Stores dp[i-1][j-1]
        dp[0] = i;        // Base case: transforming prefix to empty is i deletions
        
        for (int j = 1; j <= n; j++) {
            int temp = dp[j]; // Store current dp[j] before updating (for next iteration's prev)
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                dp[j] = prev; // No operation needed
            } else {
                // Min of Insert (dp[j-1]), Delete (dp[j]), Replace (prev)
                dp[j] = 1 + Math.min(prev, Math.min(dp[j], dp[j - 1]));
            }
            prev = temp;
        }
    }
    return dp[n];
    }
}
