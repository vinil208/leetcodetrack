// Last updated: 20/07/2026, 09:02:43
1import java.util.ArrayList;
2import java.util.List;
3import java.util.Stack;
4
5class Solution {
6    public List<Integer> inorderTraversal(TreeNode root) {
7        List<Integer> result = new ArrayList<>();
8        Stack<TreeNode> stack = new Stack<>();
9        TreeNode current = root;
10        
11        while (current != null || !stack.isEmpty()) {
12            // 1. Reach the leftmost node of the current node
13            while (current != null) {
14                stack.push(current);
15                current = current.left;
16            }
17            
18            // 2. Current must be null at this point, so pop from the stack
19            current = stack.pop();
20            result.add(current.val); // Process the root/parent node
21            
22            // 3. We have visited the node and its left subtree. Now, it's the right subtree's turn
23            current = current.right;
24        }
25        
26        return result;
27    }
28}