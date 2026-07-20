// Last updated: 20/07/2026, 10:12:47
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reverseOrder = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // Use LinkedList to support efficient O(1) addFirst() operations
            LinkedList<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // Insert into the level list based on the zigzag direction flag
                if (reverseOrder) {
                    currentLevel.addFirst(currentNode.val); // Right-to-Left
                } else {
                    currentLevel.addLast(currentNode.val);  // Left-to-Right
                }

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            result.add(currentLevel);
            // Flip the direction for the next layer
            reverseOrder = !reverseOrder;
        }

        return result;
    }
}