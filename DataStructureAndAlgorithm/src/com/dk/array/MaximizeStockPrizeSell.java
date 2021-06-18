package com.dk.array;

public class MaximizeStockPrizeSell {

    public static  StockSellResult findBuySellStockPrices(int []stocks){
        int current_profit = Integer.MIN_VALUE;
        int current_buy = stocks[0];
        int global_sell = stocks[1];
        int global_profit = global_sell - current_buy;

        for(int i = 1; i < stocks.length; i++){
            current_profit = stocks[i] - current_buy;
            if(current_profit > global_profit){
                global_profit = current_profit;
                global_sell = stocks[i];
            }
            if(stocks[i] < current_buy){
                current_buy = stocks[i];
            }
        }
        StockSellResult result = new StockSellResult(global_sell - global_profit, global_sell);

        return result;
    }
    public static void main(String[] args) {
        int[] array = {8,5,12,9,19,1};
        StockSellResult result = null;
        result = findBuySellStockPrices(array);
        System.out.println(String.format("Buy Price: %d, Sell Price: %d", result.buyPrice, result.sellPrice));

        int[] array2 = {8, 6, 5, 4, 3, 2, 1};
        result = findBuySellStockPrices(array2);
        System.out.println(String.format("Buy Price: %d, Sell Price: %d", result.buyPrice, result.sellPrice));

    }
}

class StockSellResult {
    int buyPrice;
    int sellPrice;

    public StockSellResult(int buyPrice, int sellPrice){
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }
}
