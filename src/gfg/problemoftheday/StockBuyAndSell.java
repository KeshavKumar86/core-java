package gfg.problemoftheday;

public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] prices = {4,3,2,1};
        System.out.println("Maximum Profit: " + maximumProfit(prices));
    }

    public static int maximumProfit(int[] prices) {
        // code here
        //Solution using pure local minima and pure local maxima approach
        // //buy at local minima and sell at local maxima
        int i = 0, buy , sale , profit = 0;
        int n = prices.length;
        while (i < n - 1) {
            //find next local minima
            while (i < n - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            buy = i;
            i = i+1;
            if(i == n) break;
            //find next local maxima
            while (i < n - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            sale = i;
            profit += prices[sale] - prices[buy];
        }
        return profit;
    }
}
