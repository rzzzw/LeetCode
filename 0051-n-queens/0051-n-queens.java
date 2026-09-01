class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();

        backtrack(0, n, board, cols, diag1, diag2, result);
        return result;
    }

    private void backtrack(int row, int n, char[][] board, Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2, List<List<String>> result){
        // Base case: all rows filled
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) {
                solution.add(new String(r));
            }
            result.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) {
                continue;
            }

            // choose
            board[row][col] = 'Q';
            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);

            // explore
            backtrack(row + 1, n, board, cols, diag1, diag2, result);

            board[row][col] = '.';
            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
    }
}



// class Solution {

//     public List<List<String>> solveNQueens(int n) {
//         List<List<String>> result = new ArrayList<>();

//         char[][] board = new char[n][n];
//         for (int i = 0; i < n; i++) {
//             Arrays.fill(board[i], '.');
//         }

//         boolean[] cols = new boolean[n];
//         boolean[] diag1 = new boolean[2 * n]; // row - col + n
//         boolean[] diag2 = new boolean[2 * n]; // row + col

//         backtrack(0, n, board, cols, diag1, diag2, result);
//         return result;
//     }

//     private void backtrack(int row, int n,
//                            char[][] board,
//                            boolean[] cols,
//                            boolean[] diag1,
//                            boolean[] diag2,
//                            List<List<String>> result) {

//         // Base case: all rows filled
//         if (row == n) {
//             result.add(constructBoard(board));
//             return;
//         }

//         for (int col = 0; col < n; col++) {
//             int d1 = row - col + n;
//             int d2 = row + col;

//             if (cols[col] || diag1[d1] || diag2[d2]) {
//                 continue;
//             }

//             // Place queen
//             board[row][col] = 'Q';
//             cols[col] = diag1[d1] = diag2[d2] = true;

//             backtrack(row + 1, n, board, cols, diag1, diag2, result);

//             // Backtrack
//             board[row][col] = '.';
//             cols[col] = diag1[d1] = diag2[d2] = false;
//         }
//     }

//     private List<String> constructBoard(char[][] board) {
//         List<String> res = new ArrayList<>();
//         for (char[] row : board) {
//             res.add(new String(row));
//         }
//         return res;
//     }
// }