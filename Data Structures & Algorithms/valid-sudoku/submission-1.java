class Solution {
    public boolean isValidSudoku(char[][] grid) {
        // for each row
        for (int row = 0; row < 9; row++) {
            HashSet<Character> set = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == '.')
                    continue;
                if (set.contains(grid[row][col]))
                    return false;
                set.add(grid[row][col]);
            }
        }
        for (int col = 0; col < 9; col++) {
            HashSet<Character> set = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                if (grid[row][col] == '.')
                    continue;
                if (set.contains(grid[row][col]))
                    return false;
                set.add(grid[row][col]);
            }
        }
        // checking in 3X3 boxes
        for (int sr = 0; sr < 9; sr += 3) {
            int er = sr + 2;
            for (int sc = 0; sc < 9; sc += 3) {
                int ec = sc + 2;
                if(!Traversal(grid, sr, er, sc, ec)) return false;
            }
        }
        return true;
    }
    boolean Traversal(char[][] grid, int sr, int er, int sc, int ec) {
        HashSet<Character> set = new HashSet<>();
        for (int i = sr; i <= er; i++) {
            for (int j = sc; j <= ec; j++) {
                if(grid[i][j]=='.') continue;
                if(set.contains(grid[i][j])) return false;
                set.add(grid[i][j]);
            }
        }
        return true;
    }
}
