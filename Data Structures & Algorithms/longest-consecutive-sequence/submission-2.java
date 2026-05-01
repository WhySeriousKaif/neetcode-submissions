

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        int prev = nums[0];
        int len = 1;
        int maxLen = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == prev + 1) {
                len++; // consecutive
            } 
            else if (nums[i] == prev) {
                continue; // duplicate, ignore
            } 
            else {
                len = 1; // reset
            }

            prev = nums[i];
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}