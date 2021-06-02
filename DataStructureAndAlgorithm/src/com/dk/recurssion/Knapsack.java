package com.dk.recurssion;

public class Knapsack {

    public static void main(String ...args){
        Item [] items = new Item[]{new Item(2, 6), new Item(2, 10), new Item(3, 12)};
        System.out.println(knapsack(items, 5));
    }

    public static int knapsack(Item [] items, int W){
        int [][] cache = new int[items.length + 1][W + 1];
        for(int i = 1; i <= items.length; i++){
            for(int j = 0; j<=W; j++){
                if(items[i-1].w > j){
                    cache[i][j] = cache[i-1][j];
                }else{
                    cache[i][j] = Math.max(cache[i-1][j], cache[i-1][j-items[i-1].w] + items[i-1].v);
                }
            }
        }
        for(int i = 0; i < cache.length; i++){
            for(int j = 0; j <cache[i].length; j++){
                System.out.print(cache[i][j]+" ");
            }
            System.out.println();
        }
        return cache[items.length][W];
    }
}

class Item{
    int w;
    int v;

    Item(int w, int v){
        this.w = w;
        this.v = v;
    }
}
