

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        // Sort intervals by their starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] current : intervals) {
            // No overlap, so add a new interval
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < current[0]) {
                merged.add(new int[] {current[0], current[1]});
            }
            // Overlap exists, so extend the previous interval
            else {
                int[] previous = merged.get(merged.size() - 1);
                previous[1] = Math.max(previous[1], current[1]);
            }
        }

           // Convert List<int[]> → int[][]
        int[][] result = new int[merged.size()][];

        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }

        return result;
    }
}