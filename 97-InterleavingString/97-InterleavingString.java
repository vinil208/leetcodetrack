// Last updated: 20/07/2026, 10:12:56
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Quick length check validation
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        // Ensure s2 is shorter to guarantee minimum O(min(len1, len2)) space optimization
        if (s1.length() < s2.length()) {
            return isInterleave(s2, s1, s3);
        }
        
        int len1 = s1.length();
        int len2 = s2.length();
        
        // dp[j] will store values for the current row's j-th column iteration
        boolean[] dp = new boolean[len2 + 1];
        
        // Base case: empty s1 and empty s2 matches empty s3
        dp[0] = true;
        
        // Initialize the first row (matching s2 completely against s3 without using s1)
        for (int j = 1; j <= len2; j++) {
            dp[j] = dp[j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
        }
        
        // Fill the DP table row by row
        for (int i = 1; i <= len1; i++) {
            // Update the column 0 entry for the current row (matching s1 completely against s3)
            dp[0] = dp[0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
            
            for (int j = 1; j <= len2; j++) {
                // Two possibilities to form s3[i + j - 1]:
                // 1. Match s1's current character (takes value from the previous row's same column: dp[j])
                // 2. Match s2's current character (takes value from the current row's previous column: dp[j - 1])
                boolean matchS1 = dp[j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1));
                boolean matchS2 = dp[j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
                
                dp[j] = matchS1 || matchS2;
            }
        }
        
        return dp[len2];
    }
}