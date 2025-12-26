class Solution {

    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);

        List<String> result = new ArrayList<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> res) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return;
        }
        
        char ch = board[r][c];
        // visited / prefix pruning
        if (ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }

        node = node.children[ch - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null; // avoid duplicate
            /**
            What does node.word = null actually do?

            It means:
                “This word has already been found once. Don’t report it again.”
            
            It does NOT:
                Delete the path from the Trie
                Break prefix checking
                Affect finding other words that share this prefix

            It ONLY prevents the same word from being added again.
             */
        }

        board[r][c] = '#';

        for (int[] d : DIRS) {
            int nr = d[0] + r;
            int nc = d[1] + c;
            dfs(board, nr, nc, node, res);
        }

        board[r][c] = ch;

    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }
        return root;
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
}

/**
79 → search one word
212 → search word list

String[] words = {"oath", "pea", "eat", "rain"};

(root)
 ├── o
 │    └── a
 │         └── t
 │              └── h   (word = "oath")
 │
 ├── p
 │    └── e
 │         └── a        (word = "pea")
 │
 ├── e
 │    └── a
 │         └── t        (word = "eat")
 │
 └── r
      └── a
           └── i
                └── n  (word = "rain")

 */