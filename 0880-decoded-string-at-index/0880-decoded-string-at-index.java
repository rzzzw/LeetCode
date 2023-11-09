class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;
        int N = s.length();
        // calculate the total size of decoded string
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                size *= c - '0';
            } else {
                size++;
            }
        }
        
        // reverse engineering to shorten the size and find the kth character
        for (int i = N - 1; i >= 0; i--) {
            char c = s.charAt(i);
            k %= size; // ?
            if (k == 0 && Character.isLetter(c)){
                return Character.toString(c);
            }
            if (Character.isDigit(c)) {
                size /= c - '0';        
            } else {
                size--;
            }
            
        }
        throw null;
    }
}

/*
leet2code3
leetleetcodeleetleetcodeleetleetcode
1234567890

ha22
hahahaha
12345

*/