// Last updated: 20/07/2026, 10:12:34
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
    public boolean isBalanced(TreeNode root) {
        // If checkHeight returns -1, it means the tree is unbalanced
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        // Base case: An empty tree has a height of 0 and is balanced
        if (node == null) {
            return 0;
        }

        // Check if the left subtree is balanced
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1; // Propagate the unbalanced signal upward
        }

        // Check if the right subtree is balanced
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1; // Propagate the unbalanced signal upward
        }

        // If the current node violates the balance property, return -1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Otherwise, return the actual height of this subtree to the parent call
        return Math.max(leftHeight, rightHeight) + 1;
    }
}