// Last updated: 20/07/2026, 09:10:24
1import java.util.ArrayList;
2import java.util.LinkedList;
3import java.util.List;
4import java.util.Queue;
5
6/**
7 * Definition for a binary tree node.
8 * public class TreeNode {
9 *     int val;
10 *     TreeNode left;
11 *     TreeNode right;
12 *     TreeNode() {}
13 *     TreeNode(int val) { this.val = val; }
14 *     TreeNode(int val, TreeNode left, TreeNode right) {
15 *         this.val = val;
16 *         this.left = left;
17 *         this.right = right;
18 *     }
19 * }
20 */
21class Solution {
22    public List<List<Integer>> levelOrderBottom(TreeNode root) {
23        // Use LinkedList to support efficient O(1) addFirst() operations
24        LinkedList<List<Integer>> result = new LinkedList<>();
25        
26        if (root == null) {
27            return result;
28        }
29        
30        Queue<TreeNode> queue = new LinkedList<>();
31        queue.add(root);
32        
33        while (!queue.isEmpty()) {
34            int levelSize = queue.size();
35            List<Integer> currentLevel = new ArrayList<>();
36            
37            // Process all nodes belonging strictly to the current level
38            for (int i = 0; i < levelSize; i++) {
39                TreeNode currentNode = queue.poll();
40                currentLevel.add(currentNode.val);
41                
42                // Add child nodes from left to right for the next layer iteration
43                if (currentNode.left != null) {
44                    queue.add(currentNode.left);
45                }
46                if (currentNode.right != null) {
47                    queue.add(currentNode.right);
48                }
49            }
50            
51            // Push the current level to the FRONT of the list
52            result.addFirst(currentLevel);
53        }
54        
55        return result;
56    }
57}