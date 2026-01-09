/**
- backtracking/DFS problem
- 1 digit = 1 decision level
- At each level:
    Try all letters mapped to that digit
    Recurse to the next digit
- Stop when all digits processed

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

        backtrack(digits, 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(String digits, int idx, StringBuilder path, List<String> res) {
        // base case
        if (idx == digits.length()) {
            res.add(path.toString());
            return;
        }

        String letters = PHONE_MAP[digits.charAt(idx) - '0'];

        for (char c : letters.toCharArray()) {
            path.append(c);
            backtrack(digits, idx + 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
 }