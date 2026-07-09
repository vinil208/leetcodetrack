// Last updated: 09/07/2026, 10:14:07
class Solution {
    public int romanToInt(String s) {
        int total = 0;
        int prevValue = 0;
        
        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            int currentValue = getValue(s.charAt(i));
            
            // If current value is greater than the previous, 
            // we have a subtraction case (like IV or IX)
            if (currentValue > prevValue) {
                // Subtract twice because we already added it in the previous step
                total += (currentValue - 2 * prevValue);
            } else {
                total += currentValue;
            }
            prevValue = currentValue;
        }
        return total;
    }
    
    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}