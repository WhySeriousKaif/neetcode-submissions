

class Solution {

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] leftSmall = new int[n];

        int[] rightSmall = new int[n];

        Stack<Integer> stack = new Stack<>();

        // ---------- Left Smaller Nearest ----------
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   heights[stack.peek()] >= heights[i]) {

                stack.pop();
            }

            // no smaller element on left
            if (stack.isEmpty()) {

                leftSmall[i] = -1;
            }

            else {

                leftSmall[i] = stack.peek();
            }

            stack.push(i);
        }

        // clear stack
        stack.clear();

        // ---------- Right Smaller Nearest ----------
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                   heights[stack.peek()] >= heights[i]) {

                stack.pop();
            }

            // no smaller element on right
            if (stack.isEmpty()) {

                rightSmall[i] = n;
            }

            else {

                rightSmall[i] = stack.peek();
            }

            stack.push(i);
        }

        int maxArea = 0;

        // calculate area
        for (int i = 0; i < n; i++) {

            int width =
                    rightSmall[i] - leftSmall[i] - 1;

            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}