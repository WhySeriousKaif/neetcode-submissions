class Solution {

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int maxArea = 0;

        // starting index
        for (int i = 0; i < n; i++) {

            int minHeight = heights[i];

            // ending index
            for (int j = i; j < n; j++) {

                // minimum height in current range
                minHeight = Math.min(minHeight,
                                     heights[j]);

                int width = j - i + 1;

                int area = minHeight * width;

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}