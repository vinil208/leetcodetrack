// Last updated: 09/07/2026, 10:14:03
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            // Update the lowest price found so far
            if (price < minPrice) {
                minPrice = price;
            } 
            // Calculate potential profit if we sold at current price
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        
        return maxProfit;
    }
}