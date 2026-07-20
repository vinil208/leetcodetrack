// Last updated: 20/07/2026, 09:07:53
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
22    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
23        List<List<Integer>> result = new ArrayList<>();
24        if (root == null) {
25            return result;
26        }
27
28        Queue<TreeNode> queue = new LinkedList<>();
29        queue.add(root);
30        boolean reverseOrder = false;
31
32        while (!queue.isEmpty()) {
33            int levelSize = queue.size();
34            // Use LinkedList to support efficient O(1) addFirst() operations
35            LinkedList<Integer> currentLevel = new LinkedList<>();
36
37            for (int i = 0; i < levelSize; i++) {
38                TreeNode currentNode = queue.poll();
39
40                // Insert into the level list based on the zigzag direction flag
41                if (reverseOrder) {
42                    currentLevel.addFirst(currentNode.val); // Right-to-Left
43                } else {
44                    currentLevel.addLast(currentNode.val);  // Left-to-Right
45                }
46
47                if (currentNode.left != null) {
48                    queue.add(currentNode.left);
49                }
50                if (currentNode.right != null) {
51                    queue.add(currentNode.right);
52                }
53            }
54
55            result.add(currentLevel);
56            // Flip the direction for the next layer
57            reverseOrder = !reverseOrder;
58        }
59
60        return result;
61    }
62}