class Solution {
    int[] dp;
    public int climbStairs(int n) {
        // if we are given 3 stairs we have two options 1 or 2
        // if we take 1 as an option then we have n-1 steps to cover 
        // if we take 2 steps as an option we have n-2 steps to cover
        dp=new int[n+1];
        Arrays.fill(dp,-1);


        return solve(n);

        
    }

    int solve(int n){
        if(n<=1) return 1;

        if(dp[n]!=-1) return dp[n];


        int one_step=solve(n-1);
        int two_step=solve(n-2);

        return dp[n]=one_step+two_step;

    }


}
