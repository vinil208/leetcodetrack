// Last updated: 20/07/2026, 10:13:02
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        // An IP address cannot be less than 4 digits or more than 12 digits
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(result, s, new StringBuilder(), 0, 0);
        return result;
    }

    private void backtrack(List<String> result, String s, StringBuilder currentIp, int startIndex, int dotsCount) {
        // Base Case: If we have placed 3 dots, check if the remaining string forms a valid 4th segment
        if (dotsCount == 3) {
            String remainingSegment = s.substring(startIndex);
            if (isValidSegment(remainingSegment)) {
                int originalLength = currentIp.length();
                currentIp.append(remainingSegment);
                result.add(currentIp.toString());
                currentIp.setLength(originalLength); // Backtrack
            }
            return;
        }

        // Try to form a segment of length 1, 2, or 3 digits
        for (int length = 1; length <= 3 && startIndex + length < s.length(); length++) {
            String segment = s.substring(startIndex, startIndex + length);
            
            if (isValidSegment(segment)) {
                int originalLength = currentIp.length();
                // Append the valid segment and a dot separator
                currentIp.append(segment).append(".");
                
                // Move deeper into recursion
                backtrack(result, s, currentIp, startIndex + length, dotsCount + 1);
                
                // Backtrack: Restore StringBuilder to its previous state
                currentIp.setLength(originalLength);
            }
        }
    }

    private boolean isValidSegment(String segment) {
        if (segment.length() == 0 || segment.length() > 3) return false;
        // Check for leading zeros: "0" is valid, but "01" or "00" are not
        if (segment.length() > 1 && segment.charAt(0) == '0') return false;
        
        int val = Integer.parseInt(segment);
        return val >= 0 && val <= 255;
    }
}