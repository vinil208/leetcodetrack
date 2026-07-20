// Last updated: 20/07/2026, 08:56:38
1import java.util.Stack;
2
3class Solution {
4    public int maximalRectangle(char[][] matrix) {
5        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
6            return 0;
7        }
8        
9        int cols = matrix[0].length;
10        int[] heights = new int[cols];
11        int maxArea = 0;
12        
13        for (int i = 0; i < matrix.length; i++) {
14            for (int j = 0; j < cols; j++) {
15                // If it's '1', add to the current column height; otherwise, reset to 0
16                if (matrix[i][j] == '1') {
17                    heights[j] += 1;
18                } else {
19                    heights[j] = 0;
20                }
21            }
22            // Calculate the largest rectangle for the histogram built up to the current row
23            maxArea = Math.max(maxArea, leapToHistogram(heights));
24        }
25        
26        return maxArea;
27    }
28    
29    // Standard Monotonic Stack helper from Largest Rectangle in Histogram
30    private int leapToHistogram(int[] heights) {
31        Stack<Integer> stack = new Stack<>();
32        int maxArea = 0;
33        int n = heights.length;
34        
35        for (int i = 0; i <= n; i++) {
36            int currentHeight = (i == n) ? 0 : heights[i];
37            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
38                int height = heights[stack.pop()];
39                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
40                maxArea = Math.max(maxArea, height * width);
41            }
42            stack.push(i);
43        }
44        return maxArea;
45    }
46}