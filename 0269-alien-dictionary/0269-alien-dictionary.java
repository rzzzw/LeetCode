class Solution {
    public String alienOrder(String[] words) {
        // step 0: Create data structures and find all unique letters;
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        for(String word : words) {
            for (char c : word.toCharArray()) {
                counts.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }

        // step 1: Find all edges
        // scan all the adjacent words: words[i], words[i+1]
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            // Check that word2 is not a prefix of word1;
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }

        // step 2: Breadth-first search
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for (Character c : counts.keySet()) {
            if (counts.get(c).equals(0)) {
                q.offer(c);
            }
        }
        while(!q.isEmpty()) {
            Character c = q.poll();
            sb.append(c);
            for (Character next : adjList.get(c)) {
                counts.put(next, counts.get(next) - 1);
                if (counts.get(next).equals(0)) {
                    q.offer(next);
                }
            }
        }

        if (sb.length() < counts.size()){
            return "";
        }
        return sb.toString();
    }
}