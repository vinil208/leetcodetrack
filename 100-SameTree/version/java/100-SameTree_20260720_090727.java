// Last updated: 20/07/2026, 09:07:27
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
22    public List<List<Integer>> levelOrder(TreeNode root) {
23        List<List<Integer>> result = new ArrayList<>();
24        
25        // Base case: if the tree is empty, return an empty list
26        if (root == null) {
27            return result;
28        }
29        
30        Queue<TreeNode> queue = new LinkedList<>();
31        queue.add(root);
32        
33        while (!queue.isEmpty()) {
34            // The number of elements in the queue at this moment is exactly the number of nodes on the current level
35            int levelSize = queue.size();
36            List<Integer> currentLevel = new ArrayList<>();
37            
38            for (int i = 0; i < levelSize; i++) {
39                TreeNode currentNode = queue.poll();
40                currentLevel.add(currentNode.val);
41                
42                // Add left child to queue if it exists
43                if (currentNode.left != null) {
44                    queue.add(currentNode.left);
45                }
46                // Add right child to queue if it exists
47                if (currentNode.right != null) {
48                    queue.add(currentNode.right);
49                }
50            }
51            
52            // Append the fully explored level to our final result matrix
53            result.add(currentLevel);
54        }
55        
56        return result;
57    }
58}