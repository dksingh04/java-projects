package com.dk.dp;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleNumbersForTargetSum {

    public static void main(String ...args){
        List<List<Integer>> output = new ArrayList<>();
        constructTargetSumList(4, 1, 4, output);
        System.out.println(output);
        output = new ArrayList<>();
        ArrayList<Integer> sublist = new ArrayList<>();
        printAllSumArr(4, 0, 1, output, sublist);
        System.out.println(output);
    }


    public static List<Integer> constructTargetSumList(int target, int start, int finalTarget, List<List<Integer>> output){

        if(target == 0){
            return new ArrayList<>();
        }
        if(target < 0){
            return null;
        }
        List<Integer> combinedList = null;
        for(int i = start; i < finalTarget; i++){
            List<Integer> sublist =  constructTargetSumList(target - i, i, finalTarget, output);
            if(sublist != null){
                combinedList = new ArrayList<>(sublist);

                if(target <= finalTarget) {
                    combinedList.add(i);
                }
                if(target == finalTarget){
                    output.add(combinedList);
                }
            }
        }

        return combinedList;
    }

    public static void printAllSumArr(int target, int currentSum, int start, List<List<Integer>> output, ArrayList<Integer> sublist){

        if(target == currentSum){
            output.add((ArrayList)sublist.clone());
        }
        for(int i = start; i < target; i++){
            int tempSum = currentSum + i;
            if(tempSum <= target){
                sublist.add(i);
                printAllSumArr(target, tempSum, i, output, sublist);
                sublist.remove(sublist.size() - 1);
            }else{
                return;
            }
        }
    }
}
