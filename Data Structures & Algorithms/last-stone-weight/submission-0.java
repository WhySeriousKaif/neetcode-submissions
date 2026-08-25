class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to max heap
        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {
            int a = pq.poll(); // heaviest
            int b = pq.poll(); // second heaviest

            if (a != b) {
                pq.add(a - b);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}