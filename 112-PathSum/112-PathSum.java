// Last updated: 20/07/2026, 10:12:37
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: If the tree or branch is empty, no path can exist
        if (root == null) {
            return false;
        }

        // Check if the current node is a leaf node
        if (root.left == null && root.right == null) {
            // If it's a leaf, the remaining targetSum must match the leaf's value
            return root.val == targetSum;
        }

        // Recursively check the left and right subtrees with the updated targetSum
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}