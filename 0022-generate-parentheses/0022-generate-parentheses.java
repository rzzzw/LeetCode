/**
Edge case:
n = 1 -> ["()"]
n = 0 -> [""]

backtracking with constrains
 */

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void helper(int n, int leftUsed, int rightUsed, StringBuilder path, List<String> res) {
        if (path.length() == 2 * n) {
            res.add(path.toString());
            return;
        }

        if (leftUsed < n) {
            path.append('(');
            helper(n, leftUsed+1, rightUsed, path, res);
            path.deleteCharAt(path.length() - 1);
        }

        if (rightUsed < n && rightUsed < leftUsed) {
            path.append(')');
            helper(n, leftUsed, rightUsed+1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}

