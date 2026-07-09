// Last updated: 09/07/2026, 10:13:24
import java.util.Arrays;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Sort the array first
        Arrays.sort(nums);
        
        // Loop through and check if any two adjacent elements are the same
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        
        return false;
    }
}