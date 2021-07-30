package com.dk.dp;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {
    /*
       Given a grid what are the different ways to reach to the end of the grid.
       Input : [3, 3]
       Op: 4

     */

     public static void main(String ...args){
         System.out.println(gridTraveller(2, 3));
         long startTime = System.currentTimeMillis();
         System.out.println(gridTraveller(18, 18));
         System.out.println(String.format("ResponseTime of DP without Memoization of grid 17x17 grid %d ms",System.currentTimeMillis() - startTime));
         Map<String, Long> cache = new HashMap<>();
         System.out.println(gridTravellerMemo(2, 3, cache));
         cache = new HashMap<>();
         startTime = System.currentTimeMillis();
         System.out.println(gridTravellerMemo(18, 18, cache));
         System.out.println(String.format("ResponseTime of DP with Memoization of grid 18x18 grid %d ms",System.currentTimeMillis() - startTime));
     }
     //Brute-Force technique.
     public static long gridTraveller(int r, int c){
         if(r == 0 || c == 0){
             return 0;
         }
         if(r == 1 && c == 1){
             return 1;
         }

         return gridTraveller(r - 1, c) + gridTraveller(r, c - 1);
     }

     //Using Memoization
     public static long gridTravellerMemo(int r, int c, Map<String, Long> cache){
         if(r == 0 || c == 0){
             return 0;
         }
         if(r == 1 && c == 1){
             return 1;
         }
         String key = r+","+c;
         if(cache.get(key)!=null){
             return cache.get(key);
         }

         cache.put(key, gridTravellerMemo(r - 1, c, cache) + gridTravellerMemo(r, c-1, cache));

         return cache.get(key);
     }

}
