

class Solution {
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word; 
    } 

    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = buildTrie(words);

        List<String> res = new ArrayList<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root, res);
            }
        }

        return res;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> res) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return;
        }

        char ch = board[r][c];

        if (ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }

        node = node.children[ch - 'a'];
        
        if (node.word != null) {
            res.add(node.word);
            node.word = null; // ?
        }

        board[r][c] = '#'; // ?

        for (int[] d : DIRS) {
            int nr = r + d[0];
            int nc = c + d[1];
            dfs(board, nr, nc, node, res);
        }

        board[r][c] = ch;        
    }
    

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = word;
        }
        return root;
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