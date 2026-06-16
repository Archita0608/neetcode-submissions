class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            // Check every possible split point before index i
            for (int j = 0; j < i; j++) {
                // If s[0...j] is valid AND s[j...i] is a word in the dictionary
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // Found a valid segmentation for index i, move to next i
                }
            }
        }

        return dp[n];
    }
}
