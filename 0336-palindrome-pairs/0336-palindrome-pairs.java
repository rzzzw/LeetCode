class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        // build map
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for(int j = 0; j <= word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);

                // Case 1: left is palindrome
                if (isPalindrome(left)) {
                    String revRight = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(revRight) && map.get(revRight) != i) {
                        res.add(Arrays.asList(map.get(revRight), i));
                    }                    
                }
                // Case 2: right is palindrome
                // avoid duplicate when j == word.length()
                if (j != word.length() && isPalindrome(right)) {
                    String revLeft = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(revLeft) && map.get(revLeft) != i) {
                        res.add(Arrays.asList(i, map.get(revLeft)));
                    }
                }                
            }
        }
        return res;
    }


    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}

/**
We want: A + B = palindrome
👉 That means:
        A = left + right
        B = reverse(left) OR reverse(right)
✅ Case 1:
    If:
        left is palindrome
    Then we need:
        reverse(right) exists in map
    👉 pair:
        reverse(right) + word

✅ Case 2:
    If:
        right is palindrome
    Then we need:
        reverse(left) exists in map
    👉 pair:
        word + reverse(left)

abcd -> dcba    
    A:    _｜abcd 
        l   r
    B:   dcba       
lls -> sll
    A: _ | lls      l | ls      ll | s        lls | _
    B:  sll         sl          s (or) ll       sll


 */