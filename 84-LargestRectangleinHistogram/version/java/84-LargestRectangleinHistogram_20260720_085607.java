// Last updated: 20/07/2026, 08:56:07
1import java.util.Stack;
2
3class Solution {
4    public int largestRectangleArea(int[] heights) {
5        Stack<Integer> stack = new Stack<>();
6        int maxArea = 0;
7        int n = heights.length;
8        
9        for (int i = 0; i <= n; i++) {
10            // Use a dummy height of 0 at the end to clear out the remaining elements in the stack
11            int currentHeight = (i == n) ? 0 : heights[i];
12            
13            // Maintain a strictly increasing stack
14            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
15                int height = heights[stack.pop()];
16                // If stack is empty, it means the popped bar was the shortest so far
17                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
18                maxArea = Math.max(maxArea, height * width);
19            }
20            stack.push(i);
21        }
22        
23        return maxArea;
24    }
25}