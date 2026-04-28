class Solution {

    int[][] dp;

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(s, t, 0, 0);
    }

    int solve(String s, String t, int i, int j) {

        // If we formed t completely
        if (j == t.length()) {
            return 1;
        }

        // If s is exhausted but t is not
        if (i == s.length()) {
            return 0;
        }

        // Memo check
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int count = 0;

        // If characters match → take + skip
        if (s.charAt(i) == t.charAt(j)) {
            count = solve(s, t, i + 1, j + 1)   // take
                  + solve(s, t, i + 1, j);     // skip
        }
        // If characters don't match → only skip
        else {
            count = solve(s, t, i + 1, j);
        }

        return dp[i][j] = count;
    }
}