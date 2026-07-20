// Last updated: 20/07/2026, 10:13:05
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        int n = s.length();
        // represents dp[i-2]
        int twoBack = 1; 
        // represents dp[i-1]
        int oneBack = 1; 
        
        for (int i = 1; i < n; i++) {
            int current = 0;
            int singleDigit = s.charAt(i) - '0';
            int doubleDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            
            // Check if single digit validation is possible
            if (singleDigit >= 1 && singleDigit <= 9) {
                current += oneBack;
            }
            
            // Check if two-digit validation is possible
            if (doubleDigit >= 10 && doubleDigit <= 26) {
                current += twoBack;
            }
            
            // Shift our state pointers forward
            twoBack = oneBack;
            oneBack = current;
        }
        
        return oneBack;
    }
}