class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String cur = strs[i];
            int idx = 0;
            while (idx < prefix.length() && idx < cur.length()) {
                if (prefix.charAt(idx) == cur.charAt(idx)) {
                    idx++;
                } else {
                    break;
                }
            }
            prefix = prefix.substring(0, idx);
        }
        return prefix;
    }
}