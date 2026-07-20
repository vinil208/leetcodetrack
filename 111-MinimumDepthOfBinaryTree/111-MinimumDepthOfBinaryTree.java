// Last updated: 20/07/2026, 10:12:35
import java.util.LinkedList;
import java.util.Queue;

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
    public int minDepth(TreeNode root) {
        // Base case: An empty tree has a depth of 0
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1; // The root node itself is level 1

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Process all nodes at the current depth level
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                // If we hit a leaf node (no children), this is the shortest path!
                if (current.left == null && current.right == null) {
                    return depth;
                }

                // Otherwise, keep pushing valid children to the queue
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            // Move to the next depth layer
            depth++;
        }

        return depth;
    }
}