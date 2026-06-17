class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        if (Math.abs(target) > totalSum || (totalSum + target) % 2 != 0) {
        return 0;
        }

        int p = (totalSum + target) / 2;
        int[] dp = new int[p + 1];
        dp[0]=1;

        for (int num : nums) {
        for (int i = p; i >= num; i--) {
            dp[i] += dp[i - num];
        }
    }

    return dp[p];
        
    }
}
