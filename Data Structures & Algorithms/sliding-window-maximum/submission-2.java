

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        // edge case
        if (n == 0) {
            return new int[0];
        }

        int[] ans = new int[n - k + 1];

        // stores indices
        Deque<Integer> deque = new LinkedList<>();

        int index = 0;

        for (int i = 0; i < n; i++) {

            // remove indices outside current window
            while (!deque.isEmpty() &&
                   deque.peekFirst() <= i - k) {

                deque.pollFirst();
            }

            // maintain decreasing order
            while (!deque.isEmpty() &&
                   nums[deque.peekLast()] < nums[i]) {

                deque.pollLast();
            }

            // insert current index
            deque.offerLast(i);

            // first window formed
            if (i >= k - 1) {

                ans[index++] = nums[deque.peekFirst()];
            }
        }

        return ans;
    }
}