/**
Optimized method: character frequency count
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;                
            }
            StringBuilder keyBuilder = new StringBuilder();
            for (int num : count) {
                keyBuilder.append(num).append('#');
            }
            String key = keyBuilder.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}








/**
Method 1:

1. Signature for anagram
    If two words are anagrams, when you sort their letters they become the same string.
    So you can use the sorted word as a key (or “canonical form”) to group anagrams.

2. Use a hashmap for grouping
    Use a Map<String, List<String>> where:
        Key = sorted letters of a word
        Value = list of words that map to that key
            For each word in strs, sort its characters → build key → add word to map.

3. Complexity
    Sorting a word of length k takes O(k log k). If there are n words, worst-case time = O(n × k log k). 
    Space complexity = O(n × k) for storing the grouped words.

 */


// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         if (strs == null || strs.length == 0) {
//             return new ArrayList<>();
//         }
//         Map<String, List<String>> map = new HashMap<>();
//         for (String s : strs) {
//             char[] cs = s.toCharArray();
//             Arrays.sort(cs);
//             String key = new String(cs);

//             map.computeIfAbsent(key, k -> new ArrayList<>()).add(s); // ensures the key exists with a list, then add(s)
//         }
//         return new ArrayList<>(map.values()); // gives a collection of all groups; wrap in new ArrayList<>(...)
//     }
// }

