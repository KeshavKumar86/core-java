package gfg.problemoftheday;

public class StockBuyAndSell {
    public static void main(String[] args) {

        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println("Maximum Profit: " + maximumProfit(prices));
    }

    public static int maximumProfit(int[] prices) {
        // code here
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
