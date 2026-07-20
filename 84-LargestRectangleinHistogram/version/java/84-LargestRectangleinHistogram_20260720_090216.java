// Last updated: 20/07/2026, 09:02:16
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<String> restoreIpAddresses(String s) {
6        List<String> result = new ArrayList<>();
7        // An IP address cannot be less than 4 digits or more than 12 digits
8        if (s == null || s.length() < 4 || s.length() > 12) {
9            return result;
10        }
11        backtrack(result, s, new StringBuilder(), 0, 0);
12        return result;
13    }
14
15    private void backtrack(List<String> result, String s, StringBuilder currentIp, int startIndex, int dotsCount) {
16        // Base Case: If we have placed 3 dots, check if the remaining string forms a valid 4th segment
17        if (dotsCount == 3) {
18            String remainingSegment = s.substring(startIndex);
19            if (isValidSegment(remainingSegment)) {
20                int originalLength = currentIp.length();
21                currentIp.append(remainingSegment);
22                result.add(currentIp.toString());
23                currentIp.setLength(originalLength); // Backtrack
24            }
25            return;
26        }
27
28        // Try to form a segment of length 1, 2, or 3 digits
29        for (int length = 1; length <= 3 && startIndex + length < s.length(); length++) {
30            String segment = s.substring(startIndex, startIndex + length);
31            
32            if (isValidSegment(segment)) {
33                int originalLength = currentIp.length();
34                // Append the valid segment and a dot separator
35                currentIp.append(segment).append(".");
36                
37                // Move deeper into recursion
38                backtrack(result, s, currentIp, startIndex + length, dotsCount + 1);
39                
40                // Backtrack: Restore StringBuilder to its previous state
41                currentIp.setLength(originalLength);
42            }
43        }
44    }
45
46    private boolean isValidSegment(String segment) {
47        if (segment.length() == 0 || segment.length() > 3) return false;
48        // Check for leading zeros: "0" is valid, but "01" or "00" are not
49        if (segment.length() > 1 && segment.charAt(0) == '0') return false;
50        
51        int val = Integer.parseInt(segment);
52        return val >= 0 && val <= 255;
53    }
54}