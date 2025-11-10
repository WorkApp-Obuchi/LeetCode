class Solution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE; //最安値(初期値は大きい)
        int maxprofit = 0; //利益

        for(int price : prices){
            if(minprice > price){ 
                minprice = price; //最安値更新
            }else if(price - minprice > maxprofit){
                maxprofit = price - minprice; //最大値の更新
            }
        }
        return maxprofit;
    }
}