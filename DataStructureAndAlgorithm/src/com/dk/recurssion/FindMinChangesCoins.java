package com.dk.recurssion;

import java.util.Arrays;

public class FindMinChangesCoins {

    public static void main(String ...args){
        int[] coins = new int[]{10,5};
        System.out.println(makeChange(15, coins));
        int c = 12;
        int[] coins1 = new int[]{10,6, 1};
        int[] cache = new int[c+1];
        for (int i = 1; i < c + 1; i++)
            cache[i] = -1;
        System.out.println(makeChangeWithCache(c, coins1, cache));
        System.out.println(makeChangeIterative(c, coins1));
    }
    //Brute-force way of calculating the minimum number of coins.
    public static int makeChange(int c, int [] coins){
        if(c < 0) {
            return -1;
        }
        if(c == 0){
            return 0;
        }

        int minCoins = Integer.MAX_VALUE;
        for(int coin: coins){
            if(c - coin >= 0){
                int currMinCoins = makeChange(c - coin, coins);
                if(currMinCoins < minCoins){
                    minCoins = currMinCoins;
                }
            }
        }

        return minCoins + 1;
    }

    //recursive by caching value
    public static int makeChangeWithCache(int c, int [] coins, int [] cache){
        // Return value if it is in the cache
        if(cache[c] >= 0){
            return cache[c];
        }
        int minCoins = Integer.MAX_VALUE;
        for(int coin: coins){
            if(c - coin >= 0){
                int currentMinCoins = makeChangeWithCache(c - coin, coins, cache);
                if(currentMinCoins < minCoins){
                    minCoins = currentMinCoins;
                }
            }
        }

        cache[c] = minCoins + 1;

        Arrays.stream(cache).forEach(System.out::print);
        System.out.println();
        return cache[c];
    }
    //Iterative approach to solve the problem

    public static int makeChangeIterative(int c, int [] coins){
        int [] cache = new int[c + 1];
        for(int i = 1; i <= c; i++){
            int minCoins = Integer.MAX_VALUE;
            for(int coin : coins){
                if(i - coin >= 0){
                    int currentCoin = cache[i - coin] + 1;
                    if(currentCoin < minCoins){
                        minCoins = currentCoin;
                    }
                }
            }
            cache[i] = minCoins;
        }

        return cache[c];
    }
}
