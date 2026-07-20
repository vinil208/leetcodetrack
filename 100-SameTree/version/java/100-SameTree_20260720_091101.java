// Last updated: 20/07/2026, 09:11:01
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public TreeNode sortedArrayToBST(int[] nums) {
18        // Kick off the recursive tree construction using the full array boundaries
19        return constructBST(nums, 0, nums.length - 1);
20    }
21
22    private TreeNode constructBST(int[] nums, int left, int right) {
23        // Base case: If the left pointer crosses the right pointer, the subtree segment is empty
24        if (left > right) {
25            return null;
26        }
27
28        // Find the middle element to serve as the root. 
29        // Using (left + right) / 2 could cause integer overflow for large indices.
30        int mid = left + (right - left) / 2;
31        
32        // Create the root node with the middle value
33        TreeNode root = new TreeNode(nums[mid]);
34
35        // Recursively construct the left subtree using the elements to the left of 'mid'
36        root.left = constructBST(nums, left, mid - 1);
37
38        // Recursively construct the right subtree using the elements to the right of 'mid'
39        root.right = constructBST(nums, mid + 1, right);
40
41        return root;
42    }
43}