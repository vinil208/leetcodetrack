// Last updated: 20/07/2026, 08:57:58
1import java.util.HashMap;
2import java.util.Map;
3
4class Solution {
5    // Memoization map to store results of already evaluated string pairs
6    private Map<String, Boolean> memo = new HashMap<>();
7
8    public boolean isScramble(String s1, String s2) {
9        // Base Case 1: If strings are equal, they are scrambles of each other
10        if (s1.equals(s2)) return true;
11        
12        // Base Case 2: If lengths don't match, they cannot be scrambles
13        if (s1.length() != s2.length()) return false;
14        
15        // Check the memoization map
16        String key = s1 + "_" + s2;
17        if (memo.containsKey(key)) return memo.get(key);
18        
19        // Pruning: If the character frequencies don't match, they can't be scrambles
20        if (!hasSameLetters(s1, s2)) {
21            memo.put(key, false);
22            return false;
23        }
24        
25        int n = s1.length();
26        
27        // Try splitting the string at every possible index `i`
28        for (int i = 1; i < n; i++) {
29            // Case 1: No swap at this level
30            // Compare s1's left with s2's left, and s1's right with s2's right
31            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && 
32                isScramble(s1.substring(i), s2.substring(i))) {
33                memo.put(key, true);
34                return true;
35            }
36            
37            // Case 2: Swapped at this level
38            // Compare s1's left with s2's right, and s1's right with s2's left
39            if (isScramble(s1.substring(0, i), s2.substring(n - i)) && 
40                isScramble(s1.substring(i), s2.substring(0, n - i))) {
41                memo.put(key, true);
42                return true;
43            }
44        }
45        
46        memo.put(key, false);
47        return false;
48    }
49    
50    // Helper function to check if two strings have the exact same character counts
51    private boolean hasSameLetters(String s1, String s2) {
52        int[] count = new int[26];
53        for (int i = 0; i < s1.length(); i++) {
54            count[s1.charAt(i) - 'a']++;
55            count[s2.charAt(i) - 'a']--;
56        }
57        for (int c : count) {
58            if (c != 0) return false;
59        }
60        return true;
61    }
62}