// Last updated: 20/07/2026, 09:04:59
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
17    public boolean isValidBST(TreeNode root) {
18        // Use Long objects to handle the edge cases where node values equal Integer.MIN_VALUE or MAX_VALUE
19        return validate(root, null, null);
20    }
21
22    private boolean validate(TreeNode node, Integer min, Integer max) {
23        // An empty tree/branch is a valid BST
24        if (node == null) {
25            return true;
26        }
27
28        // If the current node's value violates the min/max boundaries, it's invalid
29        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
30            return false;
31        }
32
33        // Recursively check subtrees:
34        // For the left subtree, the current node's value becomes the new upper bound (max).
35        // For the right subtree, the current node's value becomes the new lower bound (min).
36        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
37    }
38}