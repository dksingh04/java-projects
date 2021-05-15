package com.dk.codeproblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJumps {

    public static void main(String ...args){
        int [] stones = new int[]{0,1,3,5,6,8,12,17};
        System.out.println(canCross(stones));
        stones = new int[]{0,1,2,3,4,8,9,11};
        System.out.println(canCross(stones));
    }
    public static boolean canCross(int[] stones) {

        Map<Integer, HashSet<Integer>> map = new HashMap<>(stones.length);
        map.put(0, new HashSet<>());
        map.get(0).add(1);

        for(int i = 1; i < stones.length; i++){
            map.put(stones[i], new HashSet<>());
        }

        for(int i = 0; i < stones.length - 1; i++){
            int stone = stones[i];
            for(int step:map.get(stone)){
                int reach = step + stone;
                if(reach == stones[stones.length - 1]){
                    return true;
                }

                HashSet<Integer> set = map.get(reach);
                if(set != null){
                    set.add(step);
                    if(step - 1 > 0){
                        set.add(step - 1);
                    }
                    set.add(step + 1);
                }
            }
        }
        //This is just for debugging.
        for(int stone:stones){
            System.out.print("["+stone+"]");
            for(int step: map.get(stone)){
                System.out.print(" "+step);
            }
            System.out.println();
        }

        return false;

    }

}