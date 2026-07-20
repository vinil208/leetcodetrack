// Last updated: 20/07/2026, 10:13:07
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 1. Sort the array to group duplicate elements together
        Arrays.sort(nums);
        // 2. Begin backtracking from index 0
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {
        // Add a copy of the current combination to our final output list
        result.add(new ArrayList<>(currentSubset));

        for (int i = start; i < nums.length; i++) {
            // If the current element is a duplicate of the previous element 
            // AND we're within the same recursive loop level, skip it to avoid duplicate sets
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Include the element
            currentSubset.add(nums[i]);
            // Move deeper into the decision tree
            backtrack(result, currentSubset, nums, i + 1);
            // Backtrack: remove the element before moving to the next choice
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}