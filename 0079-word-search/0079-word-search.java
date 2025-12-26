class Solution {
    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, word, 0, r, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int idx, int r, int c) {
        if (idx == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return false;
        }
        if (board[r][c] != word.charAt(idx)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';

        for (int[] d : DIRS) {
            if (dfs(board, word, idx + 1, r + d[0], c + d[1])) {
                board[r][c] = temp;
                return true;
            }
        }

        board[r][c] = temp;
        return false;
    }

}
/**

Time Complexity: O(N × 3^L)
    N = number of cells
    L = length of word
    Each step has up to 3 choices (not 4, because you never go backward into visited cell).

Space Complexity: O(L)
    Max recursion depth is the length of the word
    We modify the board in-place, so no extra matrix

 */