// Last updated: 20/07/2026, 10:11:15
1import java.util.LinkedList;
2import java.util.Queue;
3
4/**
5 * Definition for a binary tree node.
6 * public class TreeNode {
7 *     int val;
8 *     TreeNode left;
9 *     TreeNode right;
10 *     TreeNode() {}
11 *     TreeNode(int val) { this.val = val; }
12 *     TreeNode(int val, TreeNode left, TreeNode right) {
13 *         this.val = val;
14 *         this.left = left;
15 *         this.right = right;
16 *     }
17 * }
18 */
19class Solution {
20    public int minDepth(TreeNode root) {
21        // Base case: An empty tree has a depth of 0
22        if (root == null) {
23            return 0;
24        }
25
26        Queue<TreeNode> queue = new LinkedList<>();
27        queue.add(root);
28        int depth = 1; // The root node itself is level 1
29
30        while (!queue.isEmpty()) {
31            int levelSize = queue.size();
32
33            // Process all nodes at the current depth level
34            for (int i = 0; i < levelSize; i++) {
35                TreeNode current = queue.poll();
36
37                // If we hit a leaf node (no children), this is the shortest path!
38                if (current.left == null && current.right == null) {
39                    return depth;
40                }
41
42                // Otherwise, keep pushing valid children to the queue
43                if (current.left != null) {
44                    queue.add(current.left);
45                }
46                if (current.right != null) {
47                    queue.add(current.right);
48                }
49            }
50            // Move to the next depth layer
51            depth++;
52        }
53
54        return depth;
55    }
56}