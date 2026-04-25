class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int min = prices[0];

        for(int sell : prices){
            maxP = Math.max(maxP, sell - min);
            min = Math.min(min, sell);
        }

        return maxP;
    }
}
