class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] expanded = new int[n + 2];
        expanded[0] = 1;
        expanded[n + 1] = 1;

        for (int i = 0; i < n; i++) expanded[i + 1] = nums[i];
        int[][] memo = new int[n + 2][n + 2];
        return dp(memo, expanded, 1, n);
    }

    private int dp(int[][] memo, int[] nums, int left, int right) {
        if (left > right) return 0;
        if (memo[left][right] != 0) return memo[left][right];
        int max = 0;
        for (int k = left; k <= right; k++) {
            int coins = nums[left - 1] * nums[k] * nums[right + 1];
            int remaining = dp(memo, nums, left, k - 1) + dp(memo, nums, k + 1, right);
            max = Math.max(max, coins + remaining);
        }
        memo[left][right] = max;
        return max;
    }
}
