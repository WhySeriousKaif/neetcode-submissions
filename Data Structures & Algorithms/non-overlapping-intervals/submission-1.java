

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        // Sort intervals by starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        int i = 0;
        int j = 1;

        while (j < intervals.length) {

            int[] currInterval = intervals[i];
            int[] nextInterval = intervals[j];

            int cs = currInterval[0];
            int ce = currInterval[1];

            int ns = nextInterval[0];
            int ne = nextInterval[1];

            if (ce <= ns) {
                // No overlapping
                i = j;
                j++;
            }
            else if (ce <= ne) {
                // Overlapping
                j++;
                count++;
            }
            else if (ce > ne) {
                // Overlapping
                // Keep the interval that ends earlier
                i = j;
                j++;
                count++;
            }
        }

        return count;
    }
}