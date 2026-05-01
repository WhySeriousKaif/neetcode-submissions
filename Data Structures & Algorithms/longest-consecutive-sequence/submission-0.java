class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            int len = 1;

            // keep checking next elements
            while (contains(nums, curr + 1)) {
                curr = curr + 1;
                len++;
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }

    // linear search
    private boolean contains(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) return true;
        }
        return false;
    }
}