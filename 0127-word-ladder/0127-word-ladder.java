class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int steps = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                if (word.equals(endWord)) {
                    return steps;
                }
                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;
                        String next = new String(arr); // ❌ arr.toString()

                        if (!visited.contains(next) && dict.contains(next)) {
                            q.offer(next);
                            visited.add(next);
                        }
                    }
                    arr[j] = original;
                }
            }
            steps++;
        }
        return 0;
    }
}




/**
Question:
If two different paths reach the same word at different levels, does the set "visited" block a valid shorter/longer path?

Short Answer:
✅ Yes, multiple paths can lead to the same word
❌ But we only need the first time we reach it
👉 Because BFS guarantees that is the shortest path

🔑 Core Idea: BFS = Shortest Path Guarantee
In BFS:
• We explore level by level
• First time we reach a word → shortest number of steps

📦 Example
    beginWord = "hit"
    endWord = "cog"

    Paths:
        hit → hot → dot → dog → cog   (length 5)
        hit → hot → lot → log → cog   (length 5)

    Now imagine:
        hit → hot → dot → dog → log → cog  (longer path)

🔍 What happens with visited?
When we first reach "log":
• It is added to visited
• Any later attempt to reach "log" is ignored

🔥 Important Distinction
In Word Ladder I (this problem): only need the length, So we use visited immediately ✅
In Word Ladder II (LeetCode 126): need ALL shortest paths, so:
    ❌ Cannot mark visited immediately
    ✅ Must allow multiple parents in same level

 */