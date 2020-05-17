class Solution {
    public int maxProfit(int[] prices) {
        int i=0;
        int min = 0;
        int max = 0;
        int profit = 0;
        while(i < prices.length - 1) {
           while(i < prices.length - 1 && prices[i] >= prices[i+1]){
              i++;
           }

           min = prices[i];

           while(i < prices.length - 1 && prices[i] <= prices[i+1]){
              i++;
           }

           max = prices[i];

           profit += (max - min);
        }

        return profit;
    }
}