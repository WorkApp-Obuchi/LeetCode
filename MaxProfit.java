package LeetCode;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        // case prices = [7,1,5,3,6,4]
        // 1日目 minPrice: 7, profit: 0, maxProfit: 0
        // 2日目 minPrice: 1, profit: 1-1=0, maxProfit: 0
        // 3日目 minPrice: 1, profit: 5-1=4, maxProfit: 4
        // 4日目 minPrice: 1, profit: 3-1=2, maxProfit: 4
        // 5日目 minPrice: 1, profit: 6-1=5, maxProfit: 5
        // 6日目 minPrice: 1, profit: 4-1=3, maxProfit: 5
        for(int price : prices) {
            // 利益の計算
            int profit = price - minPrice;

            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);

        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7,1,5,3,6,4}; // output : 5
        int[] prices2 = {7,6,4,3,1}; // output : 0

        MaxProfit solution = new MaxProfit();
        System.out.println("prices1 : " + solution.maxProfit(prices1));
        System.out.println("prices2 : " + solution.maxProfit(prices2));
    }
}
