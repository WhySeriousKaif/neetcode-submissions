public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Iterate through all 9x9 cells
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Skip empty cells ('.')
                if (board[i][j] == '.') continue;
                
                // Check if current cell is valid
                if (!isValid(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col) {
        char num = board[row][col];
        
        // Check same ROW (exclude current cell)
        for (int j = 0; j < 9; j++) {
            if (j != col && board[row][j] == num) {
                return false;
            }
        }
        
        // Check same COLUMN (exclude current cell)
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == num) {
                return false;
            }
        }
        
        // Check 3x3 SUB-BOX (exclude current cell)
        int startRow = (row / 3) * 3;  // Starting row of 3x3 box
        int startCol = (col / 3) * 3;  // Starting column of 3x3 box
        
        for (int i = 0; i < 9; i++) {
            int boxRow = startRow + (i / 3);  // Row formula: 3*(col/3) + i/3
            int boxCol = startCol + (i % 3);  // Column formula: 3*(row/3) + i%3
            
            if (boxRow != row && boxCol != col && board[boxRow][boxCol] == num) {
                return false;
            }
        }
        
        return true;
    }
}