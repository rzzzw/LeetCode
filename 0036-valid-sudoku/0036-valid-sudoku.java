class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int num = c - '1'; // 0 - 8
                int boxIdx = (i / 3 * 3) + (j / 3);

                if (rows[i][num] || cols[j][num] || boxes[boxIdx][num]) { 
                    // if the num existed in row i / col j / boxes boxIdx already, repeated
                    return false;
                }
                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxIdx][num] = true;
            }
        }
        return true;
    }
}


// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//         Set<String> seen = new HashSet<>();

//         for (int i = 0; i < 9; i++) {
//             for (int j = 0; j < 9; j++) {
//                 char c = board[i][j];
//                 if (c!= '.') {
//                     String rowKey = c + " in row " + i;
//                     String colKey = c + " in col " + j;
//                     String boxKey = c + " in box " + (i/3) + "-" + (j/3);

//                     if (!seen.add(rowKey) ||        // Set.add(x) returns:  ✅ true → if x was NOT in the set (new) ❌ false → if x already exists (duplicate)
//                         !seen.add(colKey) ||
//                         !seen.add(boxKey)) {
//                             return false;
//                      }
//                 }
//             }
//         }
//         return true;
//     }
// }


