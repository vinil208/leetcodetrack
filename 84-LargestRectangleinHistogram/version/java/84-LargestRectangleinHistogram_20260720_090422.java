// Last updated: 20/07/2026, 09:04:22
1class Solution {
2    public boolean isInterleave(String s1, String s2, String s3) {
3        // Quick length check validation
4        if (s1.length() + s2.length() != s3.length()) {
5            return false;
6        }
7        
8        // Ensure s2 is shorter to guarantee minimum O(min(len1, len2)) space optimization
9        if (s1.length() < s2.length()) {
10            return isInterleave(s2, s1, s3);
11        }
12        
13        int len1 = s1.length();
14        int len2 = s2.length();
15        
16        // dp[j] will store values for the current row's j-th column iteration
17        boolean[] dp = new boolean[len2 + 1];
18        
19        // Base case: empty s1 and empty s2 matches empty s3
20        dp[0] = true;
21        
22        // Initialize the first row (matching s2 completely against s3 without using s1)
23        for (int j = 1; j <= len2; j++) {
24            dp[j] = dp[j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
25        }
26        
27        // Fill the DP table row by row
28        for (int i = 1; i <= len1; i++) {
29            // Update the column 0 entry for the current row (matching s1 completely against s3)
30            dp[0] = dp[0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
31            
32            for (int j = 1; j <= len2; j++) {
33                // Two possibilities to form s3[i + j - 1]:
34                // 1. Match s1's current character (takes value from the previous row's same column: dp[j])
35                // 2. Match s2's current character (takes value from the current row's previous column: dp[j - 1])
36                boolean matchS1 = dp[j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1));
37                boolean matchS2 = dp[j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
38                
39                dp[j] = matchS1 || matchS2;
40            }
41        }
42        
43        return dp[len2];
44    }
45}