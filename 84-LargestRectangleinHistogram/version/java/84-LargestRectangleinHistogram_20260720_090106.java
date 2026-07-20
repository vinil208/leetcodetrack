// Last updated: 20/07/2026, 09:01:06
1class Solution {
2    public int numDecodings(String s) {
3        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
4            return 0;
5        }
6        
7        int n = s.length();
8        // represents dp[i-2]
9        int twoBack = 1; 
10        // represents dp[i-1]
11        int oneBack = 1; 
12        
13        for (int i = 1; i < n; i++) {
14            int current = 0;
15            int singleDigit = s.charAt(i) - '0';
16            int doubleDigit = Integer.parseInt(s.substring(i - 1, i + 1));
17            
18            // Check if single digit validation is possible
19            if (singleDigit >= 1 && singleDigit <= 9) {
20                current += oneBack;
21            }
22            
23            // Check if two-digit validation is possible
24            if (doubleDigit >= 10 && doubleDigit <= 26) {
25                current += twoBack;
26            }
27            
28            // Shift our state pointers forward
29            twoBack = oneBack;
30            oneBack = current;
31        }
32        
33        return oneBack;
34    }
35}