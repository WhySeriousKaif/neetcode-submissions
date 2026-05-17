class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int idx = Arrays.binarySearch(row, target);
            if (idx >= 0) {
                return true; // Found it! Exit immediately.
            }
        }
        return false; // Traversed all rows and didn't find it.
    }
}