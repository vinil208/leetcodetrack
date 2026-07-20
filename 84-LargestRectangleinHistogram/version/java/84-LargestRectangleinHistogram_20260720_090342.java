// Last updated: 20/07/2026, 09:03:42
1class Solution {
2    public int numTrees(int n) {
3        // dp[i] will store the number of unique BSTs with i nodes
4        int[] dp = new int[n + 1];
5        
6        // Base cases
7        dp[0] = 1; // An empty tree is 1 valid structure
8        dp[1] = 1; // A tree with 1 node is 1 valid structure
9        
10        // Fill the dp array from 2 up to n
11        for (int i = 2; i <= n; i++) {
12            for (int j = 1; j <= i; j++) {
13                // j represents the root node chosen
14                // left subtree has (j - 1) nodes, right subtree has (i - j) nodes
15                dp[i] += dp[j - 1] * dp[i - j];
16            }
17        }
18        
19        return dp[n];
20    }
21}