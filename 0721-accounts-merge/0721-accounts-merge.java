class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        // Step 1: Build Graph
        for (List<String> acc : accounts) {
            String name = acc.get(0);
            String firstEmail = acc.get(1);

            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);

                graph.putIfAbsent(email, new ArrayList<>());
                emailToName.put(email, name);

                if (i == 1) continue;
                
                // connect firstEmail <-> current email
                graph.get(firstEmail).add(email);
                graph.get(email).add(firstEmail);
            }
        }
        // Step 2: DFS traversal
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new ArrayList<>();

        for (String email : graph.keySet()) {
            if (visited.contains(email)) continue;

            List<String> component = new ArrayList<>();
            dfs(email, graph, visited, component);

            Collections.sort(component);

            // add name at front
            component.add(0, emailToName.get(email));
            res.add(component);
        }
        return res;
    }

    private void dfs(String email, Map<String, List<String>> graph, Set<String> visited, List<String> component) {
        visited.add(email);
        component.add(email);

        for (String nei : graph.get(email)) {
            if (!visited.contains(nei)) {
                dfs(nei, graph, visited, component);
            }
        }
    }
}

// // Union-find
// class Solution {
//     public List<List<String>> accountsMerge(List<List<String>> accounts) {
//         Map<String, String> parent = new HashMap<>();
//         Map<String, String> emailToName = new HashMap<>();

//         // Step 1: Initialize
//         for (List<String> acc : accounts) {
//             String name = acc.get(0);
//             for (int i = 1; i < acc.size(); i++) {
//                 String email = acc.get(i);
//                 parent.putIfAbsent(email, email);
//                 emailToName.put(email, name);
//             }
//         }

//         // Step 2: Union
//         for (List<String> acc : accounts) {
//             String firstEmail = acc.get(1);
//             for (int i = 2; i < acc.size(); i++) {
//                 union(parent, firstEmail, acc.get(i));
//             }
//         }

//         // Step 3: Group by root
//         Map<String, TreeSet<String>> map = new HashMap<>();

//         for (String email : parent.keySet()) {
//             String root = find(parent, email);
//             map.putIfAbsent(root, new TreeSet<>());
//             map.get(root).add(email);
//         }

//         // Step 4: Build result
//         List<List<String>> res = new ArrayList<>();

//         for (String root : map.keySet()) {
//             List<String> list = new ArrayList<>();
//             list.add(emailToName.get(root));
//             list.addAll(map.get(root));
//             res.add(list);
//         }
//         return res;
//     }

//     private String find(Map<String, String> parent, String x) {
//         if (!parent.get(x).equals(x)) {
//             parent.put(x, find(parent, parent.get(x))); // recursive until reach the k-v pair which k = v, that's the root element
//         }
//         return parent.get(x);
//     }

//     private void union(Map<String, String> parent, String a, String b) {
//         String rootA = find(parent, a);
//         String rootB = find(parent, b);
//         if (!rootA.equals(rootB)) {
//             parent.put(rootA, rootB);
//         }
//     }
// }



/**
private String find(Map<String, String> parent, String x) {
    if (!parent.get(x).equals(x)) {
        parent.put(x, find(parent, parent.get(x)));
    }
    return parent.get(x);
}

What find() do?  
    private String find(Map<String, String> parent, String x) -> the "root" (representative) of x

Why do we need a root?
    In Union-Find, each group has a leader (root).

    Example:
        a → b → c → c
        
        c is the root
        a, b, c are all in the same group

        so: 
            find(a) = c
            find(b) = c
            find(c) = c

"find()" Step-by-step logic:
    ✅ Case 1: x is root -> parent.get(x).equals(x)
        c -> c  => return c

    🔁 Case 2: x is NOT root 
        
        example: a → b → c → c
        
        Calling: find(a)
            step 1: parent.get(a) = b ≠ a  ->   So: parent.put(a, find(parent, b));
            step 2: Now compute: find(b)
            step 3: parent.get(b) = c ≠ b  ->   So: parent.put(b, find(parent, c));
            step 4: compute: find(c) <=   c is root, return c
            🔙 Backtracking (IMPORTANT)
                => parent.put(b, c) 
                => find(b) = c 
                => parent.put(a, c)

        ✅ Final structure becomes:
            a → c
            b → c
            c → c
    
        This Is Called "Path Comppression"
            parent.put(x, find(parent, parent.get(x)));  👉 does TWO things at once:
                1️⃣ Finds the root
                2️⃣ Flattens the tree

            without path compression, each find() takes O(n); With path compression, after one call: find() ≈ O(1)

Visual Analogy:
    Imagine a company: Employee → Manager → Director → CEO
    To get "Who is the CEO?" by calling: find(Employee), with Path Compression, update it to: Employee -> CEO, next time can get intant answer
 */