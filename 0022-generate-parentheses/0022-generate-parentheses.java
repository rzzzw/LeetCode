/**
Edge case:
n = 1 -> ["()"]
n = 0 -> [""]

backtracking with constrains
 */

// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> res = new ArrayList<>();
//         helper(n, 0, 0, new StringBuilder(), res);
//         return res;
//     }

//     private void helper(int n, int leftUsed, int rightUsed, StringBuilder path, List<String> res) {
//         if (path.length() == 2 * n) {
//             res.add(path.toString());
//             return;
//         }

//         if (leftUsed < n) {
//             path.append('(');
//             helper(n, leftUsed+1, rightUsed, path, res);
//             path.deleteCharAt(path.length() - 1);
//         }

//         if (rightUsed < n && rightUsed < leftUsed) {
//             path.append(')');
//             helper(n, leftUsed, rightUsed+1, path, res);
//             path.deleteCharAt(path.length() - 1);
//         }
//     }
// }


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        backtracking(n, n, n, new StringBuilder(), res);
        return res;
    }

    private void backtracking(int n, int leftHas, int rightHas, StringBuilder sb, List<String> res) {
        if (sb.length() == n * 2) { //leftHas == 0 && rightHas == 0
            res.add(sb.toString());
            return;
        }
        if (leftHas > 0) {
            sb.append('(');
            backtracking(n, leftHas - 1, rightHas, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightHas > 0 && rightHas > leftHas) {
            sb.append(')');
            backtracking(n, leftHas, rightHas - 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}