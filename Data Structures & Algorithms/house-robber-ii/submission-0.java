class Solution {
    int[] dp;

    public int rob(int[] nums) {
        int n = nums.length;

        // Edge case
        if (n == 1) return nums[0];

        dp = new int[n];
        Arrays.fill(dp, -1);
        
        int take_0th_index = solve(0, n - 2, nums);

        Arrays.fill(dp, -1);
        int take_1st_index = solve(1, n - 1, nums);

        return Math.max(take_0th_index, take_1st_index);
    }

    int solve(int i, int end, int[] nums) {
        if (i > end) return 0;

        if (dp[i] != -1) return dp[i];

        int rob = nums[i] + solve(i + 2, end, nums);
        int skip = solve(i + 1, end, nums);

        return dp[i] = Math.max(rob, skip);
    }
}