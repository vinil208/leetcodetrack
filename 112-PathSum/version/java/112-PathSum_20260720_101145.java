// Last updated: 20/07/2026, 10:11:45
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
17    public boolean hasPathSum(TreeNode root, int targetSum) {
18        // Base case: If the tree or branch is empty, no path can exist
19        if (root == null) {
20            return false;
21        }
22
23        // Check if the current node is a leaf node
24        if (root.left == null && root.right == null) {
25            // If it's a leaf, the remaining targetSum must match the leaf's value
26            return root.val == targetSum;
27        }
28
29        // Recursively check the left and right subtrees with the updated targetSum
30        int remainingSum = targetSum - root.val;
31        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
32    }
33}