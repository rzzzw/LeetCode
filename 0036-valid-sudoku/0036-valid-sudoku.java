class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c!= '.') {
                    String rowKey = c + " in row " + i;
                    String colKey = c + " in col " + j;
                    String boxKey = c + " in box " + (i/3) + "-" + (j/3);

                    if (!seen.add(rowKey) ||        // Set.add(x) returns:  ✅ true → if x was NOT in the set (new) ❌ false → if x already exists (duplicate)
                        !seen.add(colKey) ||
                        !seen.add(boxKey)) {
                            return false;
                     }
                }
            }
        }
        return true;
    }
}


// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//         int N = 9;
//         int[][] rows = new int[N][N];
//         int[][] cols = new int[N][N];
//         int[][] boxes = new int[N][N];

//         for (int r = 0; r < N; r++) {
//             for (int c = 0; c < N; c++) {
//                 if (board[r][c] == '.') {
//                     continue;
//                 }
//                 int pos = board[r][c] - '1';
//                 if (rows[r][pos] == 1) {
//                     return false;
//                 }
//                 rows[r][pos] = 1;

//                 if (cols[c][pos] == 1) {
//                     return false;
//                 }
//                 cols[c][pos] = 1;

//                 int idx = (r / 3) * 3 + c / 3;
//                 if (boxes[idx][pos] == 1) {
//                     return false;
//                 }
//                 boxes[idx][pos] = 1;
//             }
//         }
//         return true;
//     }
// }