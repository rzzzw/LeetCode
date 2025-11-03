class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List> res = new HashMap<String, List>();
        for (String s : strs) {
            char[] cur = s.toCharArray();
            Arrays.sort(cur);
            String key = String.valueOf(cur);
            if (!res.containsKey(key)) {
                res.put(key, new ArrayList<>());
            }
            res.get(key).add(s);
        }
        return new ArrayList(res.values());
    }
}

/**
e:0 1   3
a:0 1 2 3 4 5
t:0 1 2 3 4 5
n:    2   4
b:          5

 */