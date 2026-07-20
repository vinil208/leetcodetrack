// Last updated: 20/07/2026, 10:12:45
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
    public int maxDepth(TreeNode root) {
        // Base case: if the current node is null, the depth is 0
        if (root == null) {
            return 0;
        }
        
        // Recursively find the height/depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        // The total depth is 1 (current root) plus the maximum depth between both branches
        return Math.max(leftDepth, rightDepth) + 1;
    }
}