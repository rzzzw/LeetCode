// class Solution {
//     public int numJewelsInStones(String jewels, String stones) {
//         if (jewels == null || jewels.length() == 0 || stones == null || stones.length() == 0) {
//             return 0;
//         }
//         Set<Character> set = new HashSet<>();
//         for (char c : jewels.toCharArray()) {
//             set.add(c);
//         }
//         int count = 0;
//         for (char c : stones.toCharArray()) {
//             if (set.contains(c)) {
//                 count++;
//             }
//         }
//         return count;
//     }
// }

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        if (jewels == null || jewels.length() == 0 || stones == null || stones.length() == 0) {
            return 0;
        }   
        int count = 0;    
        for (char c : stones.toCharArray()) {
            if (jewels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
}