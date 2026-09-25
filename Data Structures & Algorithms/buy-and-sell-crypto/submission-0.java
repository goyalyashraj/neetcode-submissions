class Solution {
    public int maxProfit(int[] prices) {
        int min_price = Integer.MAX_VALUE;      
        int profit =0;
        for(int price:prices){
            min_price=Math.min(min_price,price);
            profit =Math.max(profit,price-min_price);
        }
        return profit;
    }
}
