// Last updated: 20/07/2026, 10:12:58
class Solution {
    public int numTrees(int n) {
        // dp[i] will store the number of unique BSTs with i nodes
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 1; // An empty tree is 1 valid structure
        dp[1] = 1; // A tree with 1 node is 1 valid structure
        
        // Fill the dp array from 2 up to n
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // j represents the root node chosen
                // left subtree has (j - 1) nodes, right subtree has (i - j) nodes
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        
        return dp[n];
    }
}