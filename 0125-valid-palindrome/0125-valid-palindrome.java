class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {  // why not 'l <= r'? take 'aba' as an example
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {  // only skip spaces/punchuation. letters and digits are all counted for palindrome judgement, so using"Character.isLetter()" is wrong.
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

