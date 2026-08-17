class Trie {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord; 
    }

    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if(cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            } 
            cur = cur.children[idx];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }
        return true;
    }

    // public TrieNode findStr(String str) {
    //     TrieNode cur = root;
    //     for (char c : str.toCharArray()) {
    //         int idx = c - 'a';
    //         if (cur.children[idx] == null) {
    //             return null;
    //         }
    //         cur = cur.children[idx];
    //     }
    //     return cur;        
    // }
}

/**
Complexity Analysis

Operation           Time        Space
1. insert           O(L)        O(L)
2. search           O(L)        O(1)
3. startsWith       O(L)        O(1)

A Trie stores characters level by level, where each node represents a prefix. Insert, search, and prefix queries all run in O(L) time, independent of the number of words.


 */

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */