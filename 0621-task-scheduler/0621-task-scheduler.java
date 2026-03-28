class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        Arrays.sort(freq);
        int maxFreq = freq[25];
        int countMax = 1;

        for (int i = 24; i >= 0; i--) {
            if (freq[i] == maxFreq) {
                countMax++;
            } else {
                break;
            }
        }

        int part = (maxFreq - 1) * (n + 1) + countMax; // The minimum number of time slots needed to arrange tasks based on the most frequent ones
        return Math.max(tasks.length, part);
    }
}

/**

• maxFreq = maximum frequency of any task
• countMax = how many tasks have that max frequency

🎯 Formula
    The minimum time is:
        (maxFreq - 1) * (n + 1) + countMax

    But we must also consider:
        max(total_tasks, above_formula)

Example 1:
A A A   (maxFreq = 3)
n = 2

    A _ _ A _ _ A

    • maxFreq - 1 gaps
    • Each gap has size n
    (maxFreq - 1) * (n + 1) + 1

Example 2 - When multiple max tasks exist
A A A   (maxFreq = 3)
B B B
n = 2

    A B _ A B _ A B
    • maxFreq - 1 gaps
    • Each gap has size n
    (maxFreq - 1) * (n + 1) + countMax

Example 3
A A A   (maxFreq = 3)
B B B
C D E F
n = 2

    A B C A B D A B E F
    • maxFreq - 1 gaps
    • Each gap has size n
    (maxFreq - 1) * (n + 1) + countMax
    max(total_tasks, above_formula)
 */