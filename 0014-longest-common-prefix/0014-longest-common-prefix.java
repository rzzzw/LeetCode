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

// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         if (strs == null || strs.length == 0) {
//             return null;
//         }
//         String base = strs[0];
//         int idx = 0;
//         while (idx < base.length()){
//             for (int i = 1; i < strs.length; i++) {
//                 String cur = strs[i];
//                 if (idx >= base.length() || idx >= cur.length() || cur.charAt(idx) != base.charAt(idx)) {
//                     return base.substring(0, idx);
//                 }             
//             }
//             idx++;
//         }
//         return base;
//     }
// }