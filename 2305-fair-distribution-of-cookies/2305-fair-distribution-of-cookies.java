class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int[] distribution = new int[k]; 
        int[] minimumMax = new int[]{Integer.MAX_VALUE};
        dfs(cookies, k, 0, distribution, minimumMax);
        return minimumMax[0];
    }

    private void dfs(int[] cookies, int k, int curCookieIdx, int[] distribution, int[] minimumMax) {
        if (curCookieIdx == cookies.length) {
            int max = 0;
            for (int i : distribution) {
                max = Math.max(max, i);
            }
            minimumMax[0] = Math.min(minimumMax[0], max);
            return;
        }
        
        for (int i = 0; i < k; i++) {
            distribution[i] += cookies[curCookieIdx];
            dfs(cookies, k, curCookieIdx + 1, distribution, minimumMax);
            distribution[i] -= cookies[curCookieIdx];
        }
    }
}



// class Solution {
//     public int distributeCookies(int[] cookies, int k) {
//         int[] distribute = new int[k];
//         return dfs(0, distribute, cookies, k, k);
//     }

//     private int dfs(int i, int[] distribute, int[] cookies, int k, int zeroCount) {
//         if (cookies.length - i < zeroCount) {
//             return Integer.MAX_VALUE;
//         }

//         if (i == cookies.length) {
//             int unfairness = Integer.MIN_VALUE;
//             for (int value : distribute) {
//                 unfairness = Math.max(unfairness, value);
//             }
//             return unfairness;
//         }

//         int answer = Integer.MAX_VALUE;
//         for (int j = 0; j < k; j++) {
//             zeroCount -= distribute[j] == 0 ? 1 : 0;
//             distribute[j] += cookies[i];

//             answer = Math.min(answer, dfs(i + 1, distribute, cookies, k, zeroCount));

//             distribute[j] -=cookies[i];
//             zeroCount += distribute[j] == 0 ? 1 : 0;
//         }
//         return answer;
//     }
// }