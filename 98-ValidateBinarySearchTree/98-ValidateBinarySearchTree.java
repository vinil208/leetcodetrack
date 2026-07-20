// Last updated: 20/07/2026, 10:12:54
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        // Use Long objects to handle the edge cases where node values equal Integer.MIN_VALUE or MAX_VALUE
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer min, Integer max) {
        // An empty tree/branch is a valid BST
        if (node == null) {
            return true;
        }

        // If the current node's value violates the min/max boundaries, it's invalid
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        // Recursively check subtrees:
        // For the left subtree, the current node's value becomes the new upper bound (max).
        // For the right subtree, the current node's value becomes the new lower bound (min).
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}