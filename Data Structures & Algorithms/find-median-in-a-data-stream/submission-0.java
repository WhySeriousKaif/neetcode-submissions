class MedianFinder {

    PriorityQueue<Integer> left_max_heap =
        new PriorityQueue<>(Collections.reverseOrder());

    PriorityQueue<Integer> right_min_heap =
        new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {

        // Step 1: Add to appropriate heap
        if (left_max_heap.isEmpty() || num < left_max_heap.peek()) {
            left_max_heap.offer(num);
        } else {
            right_min_heap.offer(num);
        }

        // Step 2: Balance the heaps

        // left can have at most 1 extra element
        if (left_max_heap.size() > right_min_heap.size() + 1) {
            right_min_heap.offer(left_max_heap.poll());
        }

        // right should never have more elements than left
        else if (right_min_heap.size() > left_max_heap.size()) {
            left_max_heap.offer(right_min_heap.poll());
        }
    }

    public double findMedian() {

        // Odd number of elements
        if (left_max_heap.size() > right_min_heap.size()) {
            return left_max_heap.peek();
        }

        // Even number of elements
        return (left_max_heap.peek() + right_min_heap.peek()) / 2.0;
    }
}