// Last updated: 20/07/2026, 10:12:50
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // Base Case 1: Both subtrees are empty
        if (t1 == null && t2 == null) return true;
        
        // Base Case 2: Only one subtree is empty, or values don't match
        if (t1 == null || t2 == null || t1.val != t2.val) return false;

        // Recursive Step: Compare outer children and inner children crosswise
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}