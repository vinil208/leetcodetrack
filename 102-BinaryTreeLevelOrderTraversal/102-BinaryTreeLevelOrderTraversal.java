// Last updated: 20/07/2026, 10:12:49
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Base case: if the tree is empty, return an empty list
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            // The number of elements in the queue at this moment is exactly the number of nodes on the current level
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                
                // Add left child to queue if it exists
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                // Add right child to queue if it exists
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            
            // Append the fully explored level to our final result matrix
            result.add(currentLevel);
        }
        
        return result;
    }
}