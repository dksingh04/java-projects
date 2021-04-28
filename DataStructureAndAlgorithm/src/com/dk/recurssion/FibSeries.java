package com.dk.recurssion;

import java.awt.desktop.SystemEventListener;

public class FibSeries {
    public static void main(String ...args){
        System.out.println(fib(4));
        System.out.println(fibC(4));
        System.out.println(fibSeriesTailRecursion(4, 0, 1));
    }
    // Compute the nth Fibonacci number
    public static int fib(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        int n1 = fib(n-1);
        int n2 = fib(n-2);
        return n1+n2;
    }

    public static int fibC(int n){
        if(n < 2){
            return n;
        }
        int [] cache = new int[n+1];
        for(int i = 0; i < cache.length; i++){
            cache[i] = -1;
        }
        cache[0] = 0;
        cache[1] = 1;
        return fibCaching(n, cache);
    }
    // Compute the nth Fibonacci number recursively. // Optimized by caching subproblem results
    public static int fibCaching(int n, int []cache){
        if(cache[n] >= 0) return cache[n];
        cache[n] = fibCaching(n-1, cache) + fibCaching(n-2, cache);
        return cache[n];
    }
    //Use of tail recurssion
    public static int fibSeriesTailRecursion(int n, int a, int b){
        if(n == 0){
            return a;
        }
        if(n == 1){
            return b;
        }

        return fibSeriesTailRecursion(n -1, b, a+b);

    }
}
