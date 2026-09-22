
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int n = intervals.length;

        int count = 0;
        int i = 1;

        int[] L = intervals[0];

        while (i < n) {

            int currEnd = intervals[i][1];
            int currStart = intervals[i][0];

            int lastEnd = L[1];

            if (currStart >= lastEnd) {
                // No overlap
                L = intervals[i];
                i++;
            }
            else if (currEnd >= lastEnd) {
                // Overlap
                count++;
                i++;
            }
            else if (currEnd < lastEnd) {
                // Overlap, current interval ends earlier
                L = intervals[i];
                i++;
                count++;
            }
        }

        return count;
    }
}