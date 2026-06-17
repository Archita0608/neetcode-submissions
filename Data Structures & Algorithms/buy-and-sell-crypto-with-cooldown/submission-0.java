class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

    // Initial states:
    // held: cost of buying stock (negative because we spend money)
    // sold: profit after selling
    // reset: profit of doing nothing
    int held = -prices[0];
    int sold = 0;
    int reset = 0;



        for (int i = 1; i < prices.length; i++) {
        int prevSold = sold;
        
        // We sold today: must have held a stock yesterday
        sold = held + prices[i];
        
        // We held today: either held it yesterday or bought it after a reset
        held = Math.max(held, reset - prices[i]);
        
        // We reset today: either was reset yesterday or sold yesterday
        reset = Math.max(reset, prevSold);
    }

    // The max profit will be either having sold or being in a reset state
    return Math.max(sold, reset);
    }
}
