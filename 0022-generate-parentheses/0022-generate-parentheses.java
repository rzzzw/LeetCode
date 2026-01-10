/**
Edge case:
n = 1 -> ["()"]
n = 0 -> [""]

backtracking with constrains
 */

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(int n, int openUsed, int closeUsed, StringBuilder path, List<String> res) {
        if (path.length() == 2 * n) {
            res.add(path.toString());
            return;
        }
        if (openUsed < n) {
            path.append('(');
            backtrack(n, openUsed + 1, closeUsed, path, res);
            path.deleteCharAt(path.length() - 1);
        }

        if (closeUsed < n && closeUsed < openUsed) {
            path.append(')');
            backtrack(n, openUsed, closeUsed + 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}