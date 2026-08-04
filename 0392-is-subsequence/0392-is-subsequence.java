class Solution {
    public boolean isSubsequence(String s, String t) {
        // assume s != null && t != null
        if (s.length() == 0) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {

            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }            
            j++;    
        }
        return i == s.length();
    }
}

// class Solution {
//     public boolean isSubsequence(String s, String t) {
//         // assume s != null && t != null
//         if (s.length() == 0) {
//             return true;
//         }
//         if (s.length() > t.length()) {
//             return false;
//         }
//         int i = 0, j = 0;
//         int count = 0;
//         while (i < s.length() && j < t.length()) {

//             while (j < t.length() && t.charAt(j) != s.charAt(i)) {
//                 j++;
//             }
//             if (j < t.length() && s.charAt(i) == t.charAt(j)) {
//                 count++;
//             }            
//             i++;
//             j++;        
//             if (i == s.length() && count == s.length()) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }