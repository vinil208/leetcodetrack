// Last updated: 20/07/2026, 09:00:38
1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<List<Integer>> subsetsWithDup(int[] nums) {
7        List<List<Integer>> result = new ArrayList<>();
8        // 1. Sort the array to group duplicate elements together
9        Arrays.sort(nums);
10        // 2. Begin backtracking from index 0
11        backtrack(result, new ArrayList<>(), nums, 0);
12        return result;
13    }
14
15    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {
16        // Add a copy of the current combination to our final output list
17        result.add(new ArrayList<>(currentSubset));
18
19        for (int i = start; i < nums.length; i++) {
20            // If the current element is a duplicate of the previous element 
21            // AND we're within the same recursive loop level, skip it to avoid duplicate sets
22            if (i > start && nums[i] == nums[i - 1]) {
23                continue;
24            }
25
26            // Include the element
27            currentSubset.add(nums[i]);
28            // Move deeper into the decision tree
29            backtrack(result, currentSubset, nums, i + 1);
30            // Backtrack: remove the element before moving to the next choice
31            currentSubset.remove(currentSubset.size() - 1);
32        }
33    }
34}