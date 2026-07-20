// Last updated: 20/07/2026, 09:03:15
1import java.util.ArrayList;
2import java.util.List;
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
20    public List<TreeNode> generateTrees(int n) {
21        if (n == 0) {
22            return new ArrayList<>();
23        }
24        return buildTrees(1, n);
25    }
26
27    private List<TreeNode> buildTrees(int start, int end) {
28        List<TreeNode> allTrees = new ArrayList<>();
29        
30        // Base case: If start exceeds end, no nodes can be formed, so we return a list containing null.
31        if (start > end) {
32            allTrees.add(null);
33            return allTrees;
34        }
35
36        // Try every number i as the root in the range [start, end]
37        for (int i = start; i <= end; i++) {
38            // Generate all possible left and right subtrees recursively
39            List<TreeNode> leftSubtrees = buildTrees(start, i - 1);
40            List<TreeNode> rightSubtrees = buildTrees(i + 1, end);
41
42            // Connect each left and right subtree combination to the root node i
43            for (TreeNode left : leftSubtrees) {
44                for (TreeNode right : rightSubtrees) {
45                    TreeNode root = new TreeNode(i);
46                    root.left = left;
47                    root.right = right;
48                    allTrees.add(root);
49                }
50            }
51        }
52        
53        return allTrees;
54    }
55}