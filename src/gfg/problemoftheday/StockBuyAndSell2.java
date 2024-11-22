package gfg.problemoftheday;

public class StockBuyAndSell2 {
    public static void main(String[] args) {

        int[] prices = {61, 44, 77, 78, 73, 95, 27, 1};
        int result = maximumProfit(prices);
        System.out.println("Result: " + result);
    }

    public static int maximumProfit(int[] prices) {
        int min = prices[0];
        int max;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= min) {
                min = prices[i];
            }
            max = prices[i];
            maxProfit = Math.max(max - min, maxProfit);
        }
        return maxProfit;

    }
}
