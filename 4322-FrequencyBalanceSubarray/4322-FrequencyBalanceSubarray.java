// Last updated: 09/07/2026, 10:13:28
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int getLength(int[] nums) {
        int n = nums.length;
        int maxLength = 1; // Any single-element subarray is always valid

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> freq = new HashMap<>();
            Map<Integer, Integer> freqCount = new HashMap<>();
            int maxFreq = 0;

            for (int j = i; j < n; j++) {
                int currentNum = nums[j];
                int currentFreq = freq.getOrDefault(currentNum, 0);

                // Decrement old frequency count if it exists
                if (currentFreq > 0) {
                    freqCount.put(currentFreq, freqCount.get(currentFreq) - 1);
                    if (freqCount.get(currentFreq) == 0) {
                        freqCount.remove(currentFreq);
                    }
                }

                // Update with new frequency
                currentFreq++;
                freq.put(currentNum, currentFreq);
                freqCount.put(currentFreq, freqCount.getOrDefault(currentFreq, 0) + 1);

                if (currentFreq > maxFreq) {
                    maxFreq = currentFreq;
                }

                // FIXED VALIDATION:
                // Case 1: Only 1 frequency level exists AND only 1 unique element exists (e.g., [2,2,2])
                if (freqCount.size() == 1 && freq.size() == 1) {
                    maxLength = Math.max(maxLength, j - i + 1);
                } 
                // Case 2: Exactly 2 frequency levels exist, and the lower one is exactly half of maxFreq
                else if (freqCount.size() == 2 && maxFreq % 2 == 0 && freqCount.containsKey(maxFreq / 2)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }
}