/**
- backtracking/DFS problem
- 1 digit = 1 decision level
- At each level:
    Try all letters mapped to that digit
    Recurse to the next digit
- Stop when all digits processed

Time: 4^n
Space: n
 */

 class Solution {
    private static final String[] PHONE_MAP = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>(); 
        if (digits == null || digits.length() == 0) {
            return res;
        }
        dfs(digits, 0, new StringBuilder(), res);
        return res;
    }

    private void dfs(String digits, int idx, StringBuilder path, List<String> res) {
        if (idx == digits.length()) {
            res.add(path.toString());
            return;
        }

        int num = digits.charAt(idx) - '0';
        String letters = PHONE_MAP[num];
        for (char ch : letters.toCharArray()) {
            path.append(ch);
            dfs(digits, idx + 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
 }



 /**
This is a backtracking problem.
Each digit corresponds to a set of letters, and we want to generate all combinations by choosing one letter per digit.

I use DFS where each recursion level handles one digit.
At each level, I iterate over the letters mapped to the current digit, append one letter to the current path, recurse, and then backtrack.

When I’ve processed all digits, I add the built string to the result list.
  */