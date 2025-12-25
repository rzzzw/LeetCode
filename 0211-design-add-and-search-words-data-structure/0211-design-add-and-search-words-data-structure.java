class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;  // why don't "TrieNode = new TrieNode()"?
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        if (node == null) {
            return false;
        }

        if (index == word.length()) {
            return node.isWord;
        }
        
        char c = word.charAt(index);

        // case1: normal character
        if (c != '.') {
            return dfs(word, index + 1, node.children[c - 'a']);
        }

        // case2: wildcard '.'
        for (TrieNode child : node.children) {
            if (child != null && dfs(word, index + 1, child)) {
                return true;
            }
/**  common error if write as below: returning too early inside wildcard loop

    . means:
    “This character can match any one letter — try all possibilities until one works.”

    That implies:
    You must explore every valid child
    You can only return false after all options fail

            if (child != null) {
                return dfs(word, index + 1, child);
            }

    This means:
        It tries only the first non-null child
        If it returns false, immediately give up
        It never try the other children
    That breaks the definition of ..

 */
        }

        return false;
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */