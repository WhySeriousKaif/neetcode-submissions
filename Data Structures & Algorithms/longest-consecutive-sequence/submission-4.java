

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        // Step 1: add all elements to set
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;

        // Step 2: iterate through set
        for (int num : set) {

            // check if it's a starting point
            if (!set.contains(num - 1)) {

                int curr = num;
                int len = 1;

                // build sequence
                while (set.contains(curr + 1)) {
                    curr++;
                    len++;
                }

                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}