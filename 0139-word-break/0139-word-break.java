/**
        applepenapple       ["apple","pen"]

M[i] represent 长度为i的string能不能切成每一份都在字典里
M[i] = true if s[0..i-1] can be segmented
M[0] = T

M[i] = true if there exists j such that:
    M[j] == true
    AND s[j..i-1] ∈ wordDict

len = 1 -- 'a' : M[1] = F
len = 2 -- 'ap':
    0': 
        |ap
        M[0] && 'ap'is not in the dict - F
    1':
        a|p
        M[1] && "p" is not in the dict - F
    M[2] = (F || F) = F
len = 3 -- 'app':
    0': |app => M[0] && 'app'is not in the dict - F
    1': a|pp => M[1] && 'pp'is not in the dict - F
    2': ap|p => M[2] && 'p'is not in the dict - F     
    M[3] = (F||F||F) = F 


 */

class Solution{
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = toSet(wordDict);
        boolean[] M = new boolean[s.length() + 1];
        M[0] = true;
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i < len; i++) {
                if (M[i] && set.contains(s.substring(i, len))) {
                    M[len] = true;
                    break;
                }
            }
        }
        return M[s.length()];
    }

    private Set<String> toSet(List<String> list) {
        Set<String> set = new HashSet<>();
        for (String s : list) {
            set.add(s);
        }
        return set;
    }
}