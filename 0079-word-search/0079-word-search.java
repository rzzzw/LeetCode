/**

Time Complexity: O(N × 3^L)
    N = number of cells
    L = length of word
    Each step has up to 3 choices (not 4, because you never go backward into visited cell).

Space Complexity: O(L)
    Max recursion depth is the length of the word
    We modify the board in-place, so no extra matrix

*/
class Solution {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int r, int c, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return false;
        }

        if (board[r][c] !=  word.charAt(idx)) {
            return false;
        }

        char origin = board[r][c];
        board[r][c] = '#';
        for (int[] d : DIRS) {
            if (dfs(board, r + d[0], c + d[1], word, idx + 1)) {
                board[r][c] = origin;
                return true;
            }
        }
        board[r][c] = origin;
        return false;
    }
}