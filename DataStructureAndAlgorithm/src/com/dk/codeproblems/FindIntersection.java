package com.dk.codeproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindIntersection {
    public static void main(String ...args){
        int[] a = {1, 1, 1, 2, 2, 2, 2, 3, 4, 4, 4, 5, 1, 1, 6};
        int[] b = {1, 1, 2, 3, 3, 3, 6, 6, 6, 7, 8};
        List<Integer> result = getIntersection(b, a);

        result.forEach(System.out::print);
    }

    public static List<Integer> getIntersection(int [] a, int b []){
        Map<Integer, Integer> map = new HashMap<>();

        for(int v: a){
            map.put(v, map.getOrDefault(v, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for(int v: b){
            if(map.get(v)!=null && map.get(v) > 0){
                result.add(v);
            }
            map.put(v, map.get(v) != null? map.get(v) - 1: 0);
        }

        return result;
    }
}
