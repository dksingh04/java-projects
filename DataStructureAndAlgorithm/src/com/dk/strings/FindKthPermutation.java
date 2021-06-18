package com.dk.strings;

import java.util.ArrayList;
import java.util.List;

public class FindKthPermutation {

    public static void main(String ...args){
        System.out.println(getKthPermuatation(4, 8));
    }

    private static int factorial(int n){
        if(n == 0){
            return 1;
        }
        int fact = 1;
        while(n >= 1){
            fact = fact*n;
            n--;
        }

        return fact;
    }

    public static void getKthPermuation(List<Integer> v, int k, StringBuilder result){
        if(v.isEmpty()){
            return;
        }

        int n = v.size();

        int pCount = factorial(n - 1);
        int selected = (k - 1)/pCount;
        result.append(v.get(selected));
        v.remove(selected);
        k = k - (selected * pCount);
        getKthPermuation(v, k, result);
    }

    public static String getKthPermuatation(int n, int k){
        List<Integer> v = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            v.add(i);
        }
        StringBuilder result = new StringBuilder();
        getKthPermuation(v, k, result);
        return result.toString();
    }
}
