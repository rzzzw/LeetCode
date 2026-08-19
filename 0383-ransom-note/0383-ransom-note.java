class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.length() == 0) {
            return true;
        }
        if (magazine == null || magazine.length() == 0) {
            return false;
        }
        int[] map = new int[26];
        for (char c : magazine.toCharArray()) {
            map[c -'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            map[c - 'a']--;

            // Not enough copies available
            if (map[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}