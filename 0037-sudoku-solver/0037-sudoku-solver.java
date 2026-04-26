class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }
    private boolean dfs(char[][] board, int x, int y) {
        if (x == 9) return true;
        if (y == 9) {
           return dfs(board, x + 1, 0);
        }
        if (board[x][y] != '.') {
            return dfs(board, x, y + 1);
        }
        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, x, y, c)) {
                board[x][y] = c;
                if (dfs(board, x, y + 1)) {
                    return true;
                }
                board[x][y] = '.';
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int x, int y, char c){
        for (int row = 0; row < 9; row++) {
            if (board[row][y] == c) return false;
        }
        for (int col = 0; col < 9; col++) {
            if (board[x][col] == c) return false;
        }
        int smallRow = x / 3 * 3;
        int smallCol = y / 3 * 3;
        for (int i = smallRow; i < smallRow + 3; i++) {
            for (int j = smallCol; j < smallCol + 3; j++) {
                if (board[i][j] == c) return false;
            }
        }
        return true;
    }
}

