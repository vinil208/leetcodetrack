// Last updated: 20/07/2026, 10:13:00
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            // 1. Reach the leftmost node of the current node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            // 2. Current must be null at this point, so pop from the stack
            current = stack.pop();
            result.add(current.val); // Process the root/parent node
            
            // 3. We have visited the node and its left subtree. Now, it's the right subtree's turn
            current = current.right;
        }
        
        return result;
    }
}