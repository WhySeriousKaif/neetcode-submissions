class KthLargest {
    int K;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        K = k;
        minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);

            if (minHeap.size() > K) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);

        if (minHeap.size() > K) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}