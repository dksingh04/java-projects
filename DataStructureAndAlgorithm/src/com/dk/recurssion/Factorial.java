package com.dk.recurssion;

public class Factorial {

    public static void main(String ...args){
        System.out.println(factorial(5));
        System.out.println(factorialCache(5, 1));
        int [] cache = new int[5];
        cache[0] = 1;
        //cache[1] = 1;
        System.out.println(factorialCache2(5, cache));
    }

    public static int factorial(int n){
        if (n < 0) {
            return -1;
        }
        if (n <= 1){
            return 1;
        }
        return n * factorial(n-1);
    }
    //Tail recursion
    public static int factorialCache(int n, int cache){
        if (n < 0) {
            return -1;
        }
        if (n <= 1){
            return cache;
        }

        return factorialCache(n-1, n * cache);
    }

    //Save factorial of each series and use the
    public static int factorialCache2(int n, int [] cache){
        if (n < 0) {
            return -1;
        }

        if(n == 1){
            return cache[cache.length - 1];
        }

        cache[cache.length - (n-1)] = n * cache[cache.length - (n)];

        return factorialCache2(n-1, cache);
    }
}
