class Solution {
    public List<Integer> spiralOrder(int[][] A) {
        
        List<Integer> ans = new ArrayList<>();

        int rowBegin = 0;
        int rowEnd = A.length - 1;
        int colBegin = 0;
        int colEnd = A[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {

            // Traverse Right
            for (int j = colBegin; j <= colEnd; j++) {
                ans.add(A[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int i = rowBegin; i <= rowEnd; i++) {
                ans.add(A[i][colEnd]);
            }
            colEnd--;

            // Traverse Left
            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    ans.add(A[rowEnd][j]);
                }
                rowEnd--;
            }

            // Traverse Up
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    ans.add(A[i][colBegin]);
                }
                colBegin++;
            }
        }

        return ans;
    }
}