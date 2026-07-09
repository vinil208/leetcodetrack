// Last updated: 09/07/2026, 10:13:21
import java.util.Arrays;

class Solution {
    public long maxRatings(int[][] units) {
        int m = units.length;
        int n = units[0].length; // Fixed: change units.length to units[0].length

        long initialSum = 0;
        long sumOfOnes = 0;
        int minOfOnes = Integer.MAX_VALUE;
        int globalMin0 = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            Arrays.sort(units[i]);

            int a0 = units[i][0];
            int a1 = (n > 1) ? units[i][1] : 0; // If n == 1, rating becomes 0

            initialSum += a0;
            globalMin0 = Math.min(globalMin0, a0);
            sumOfOnes += a1;
            minOfOnes = Math.min(minOfOnes, a1);
        }

        // The answer is the maximum between doing 0 operations 
        // vs performing the greedy optimal operations
        long operationalSum = sumOfOnes - minOfOnes + globalMin0;
        return Math.max(initialSum, operationalSum);
    }
}